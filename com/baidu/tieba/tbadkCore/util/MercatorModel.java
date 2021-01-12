package com.baidu.tieba.tbadkCore.util;

import android.location.Address;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.c.a;
import com.baidu.loc.str.BDLocManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MercatorModel {
    private final a.InterfaceC0015a gGO;
    private boolean npW;

    private MercatorModel() {
        this.npW = false;
        this.gGO = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.util.MercatorModel.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i == 0 && address != null && inst != null && !MercatorModel.this.npW) {
                    MercatorModel.this.npW = true;
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    String locString = BDLocManager.getInstance(inst).getLocString();
                    String version = TbConfig.getVersion();
                    String cuid = TbadkCoreApplication.getInst().getCuid();
                    String clientIP = UtilHelper.getClientIP();
                    com.baidu.tieba.recapp.c.a.dBW().QI(valueOf);
                    com.baidu.tieba.recapp.c.a.dBW().QH(valueOf2);
                    com.baidu.tieba.recapp.c.a.dBW().hw(System.currentTimeMillis());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
                    httpMessage.addParam("cuid", cuid);
                    httpMessage.addParam("cip", clientIP);
                    httpMessage.addParam("ver", version);
                    httpMessage.addParam("apinfo", locString);
                    httpMessage.addParam("longitude", valueOf2);
                    httpMessage.addParam("latitude", valueOf);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    MercatorModel.this.npW = false;
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void startLoad() {
        com.baidu.adp.lib.c.a.lI().a(true, this.gGO);
    }

    public static MercatorModel dMr() {
        return a.nqd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final MercatorModel nqd = new MercatorModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(MercatorData mercatorData) {
        TbSingleton.getInstance().setMercatorData(mercatorData);
        com.baidu.tbadk.core.sharedPref.b.brx().putString("key_mercator_location", MercatorData.jsonStrWithObject(mercatorData));
    }

    public MercatorData getMercatorData() {
        MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
        if (mercatorData == null) {
            return (MercatorData) MercatorData.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brx().getString("key_mercator_location", null), MercatorData.class);
        }
        return mercatorData;
    }

    /* loaded from: classes.dex */
    public static class MercatorLocationResponseMessage extends JsonHttpResponsedMessage {
        public MercatorLocationResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null) {
                MercatorModel.a(new MercatorData(jSONObject.optString("mercator_lon"), jSONObject.optString("mercator_lat"), jSONObject.optString("mercator_radius"), jSONObject.optInt("mercator_city"), jSONObject.optLong("mercator_time")));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MercatorData extends OrmObject {
        String npY;
        String npZ;
        String nqa;
        int nqb;
        long nqc;

        public MercatorData() {
        }

        public MercatorData(String str, String str2, String str3, int i, long j) {
            this.npY = str;
            this.npZ = str2;
            this.nqa = str3;
            this.nqb = i;
            this.nqc = j;
        }

        public String dMs() {
            return this.npY;
        }

        public String dMt() {
            return this.npZ;
        }

        public String dMu() {
            return this.nqa;
        }

        public int dMv() {
            return this.nqb;
        }

        public long dMw() {
            return this.nqc;
        }
    }
}
