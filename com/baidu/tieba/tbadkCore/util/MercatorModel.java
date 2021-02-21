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
    private final a.InterfaceC0015a gJM;
    private boolean nAg;

    private MercatorModel() {
        this.nAg = false;
        this.gJM = new a.InterfaceC0015a() { // from class: com.baidu.tieba.tbadkCore.util.MercatorModel.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0015a
            public void onLocationGeted(int i, String str, Address address) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i == 0 && address != null && inst != null && !MercatorModel.this.nAg) {
                    MercatorModel.this.nAg = true;
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    String locString = BDLocManager.getInstance(inst).getLocString();
                    String version = TbConfig.getVersion();
                    String cuid = TbadkCoreApplication.getInst().getCuid();
                    String clientIP = UtilHelper.getClientIP();
                    com.baidu.tieba.recapp.c.a.dEm().RO(valueOf);
                    com.baidu.tieba.recapp.c.a.dEm().RN(valueOf2);
                    com.baidu.tieba.recapp.c.a.dEm().hB(System.currentTimeMillis());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
                    httpMessage.addParam("cuid", cuid);
                    httpMessage.addParam("cip", clientIP);
                    httpMessage.addParam("ver", version);
                    httpMessage.addParam("apinfo", locString);
                    httpMessage.addParam("longitude", valueOf2);
                    httpMessage.addParam("latitude", valueOf);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    MercatorModel.this.nAg = false;
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void startLoad() {
        com.baidu.adp.lib.c.a.lH().a(true, this.gJM);
    }

    public static MercatorModel dOK() {
        return a.nAn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final MercatorModel nAn = new MercatorModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(MercatorData mercatorData) {
        TbSingleton.getInstance().setMercatorData(mercatorData);
        com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_mercator_location", MercatorData.jsonStrWithObject(mercatorData));
    }

    public MercatorData getMercatorData() {
        MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
        if (mercatorData == null) {
            return (MercatorData) MercatorData.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_mercator_location", null), MercatorData.class);
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
        String nAi;
        String nAj;
        String nAk;
        int nAl;
        long nAm;

        public MercatorData() {
        }

        public MercatorData(String str, String str2, String str3, int i, long j) {
            this.nAi = str;
            this.nAj = str2;
            this.nAk = str3;
            this.nAl = i;
            this.nAm = j;
        }

        public String dOL() {
            return this.nAi;
        }

        public String dOM() {
            return this.nAj;
        }

        public String dON() {
            return this.nAk;
        }

        public int dOO() {
            return this.nAl;
        }

        public long dOP() {
            return this.nAm;
        }
    }
}
