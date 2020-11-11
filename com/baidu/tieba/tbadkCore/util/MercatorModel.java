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
    private final a.InterfaceC0020a gsz;
    private boolean mZN;

    private MercatorModel() {
        this.mZN = false;
        this.gsz = new a.InterfaceC0020a() { // from class: com.baidu.tieba.tbadkCore.util.MercatorModel.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
            public void onLocationGeted(int i, String str, Address address) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i == 0 && address != null && inst != null && !MercatorModel.this.mZN) {
                    MercatorModel.this.mZN = true;
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    String locString = BDLocManager.getInstance(inst).getLocString();
                    String version = TbConfig.getVersion();
                    String cuid = TbadkCoreApplication.getInst().getCuid();
                    String clientIP = UtilHelper.getClientIP();
                    com.baidu.tieba.recapp.d.a.dBc().Mo(valueOf);
                    com.baidu.tieba.recapp.d.a.dBc().Mn(valueOf2);
                    com.baidu.tieba.recapp.d.a.dBc().gT(System.currentTimeMillis());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
                    httpMessage.addParam("cuid", cuid);
                    httpMessage.addParam("cip", clientIP);
                    httpMessage.addParam("ver", version);
                    httpMessage.addParam("apinfo", locString);
                    httpMessage.addParam("longitude", valueOf2);
                    httpMessage.addParam("latitude", valueOf);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    MercatorModel.this.mZN = false;
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void startLoad() {
        com.baidu.adp.lib.c.a.mk().a(true, this.gsz);
    }

    public static MercatorModel dKU() {
        return a.mZU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final MercatorModel mZU = new MercatorModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(MercatorData mercatorData) {
        TbSingleton.getInstance().setMercatorData(mercatorData);
        com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_mercator_location", MercatorData.jsonStrWithObject(mercatorData));
    }

    public MercatorData getMercatorData() {
        MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
        if (mercatorData == null) {
            return (MercatorData) MercatorData.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_mercator_location", null), MercatorData.class);
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
        String mZP;
        String mZQ;
        String mZR;
        int mZS;
        long mZT;

        public MercatorData() {
        }

        public MercatorData(String str, String str2, String str3, int i, long j) {
            this.mZP = str;
            this.mZQ = str2;
            this.mZR = str3;
            this.mZS = i;
            this.mZT = j;
        }

        public String dKV() {
            return this.mZP;
        }

        public String dKW() {
            return this.mZQ;
        }

        public String dKX() {
            return this.mZR;
        }

        public int dKY() {
            return this.mZS;
        }

        public long dKZ() {
            return this.mZT;
        }
    }
}
