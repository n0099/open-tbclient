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
/* loaded from: classes2.dex */
public class MercatorModel {
    private final a.InterfaceC0018a fMY;
    private boolean mhI;

    private MercatorModel() {
        this.mhI = false;
        this.fMY = new a.InterfaceC0018a() { // from class: com.baidu.tieba.tbadkCore.util.MercatorModel.1
            @Override // com.baidu.adp.lib.c.a.InterfaceC0018a
            public void onLocationGeted(int i, String str, Address address) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i == 0 && address != null && inst != null && !MercatorModel.this.mhI) {
                    MercatorModel.this.mhI = true;
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    String locString = BDLocManager.getInstance(inst).getLocString();
                    String version = TbConfig.getVersion();
                    String cuid = TbadkCoreApplication.getInst().getCuid();
                    String clientIP = UtilHelper.getClientIP();
                    com.baidu.tieba.recapp.d.a.dnW().Kh(valueOf);
                    com.baidu.tieba.recapp.d.a.dnW().Kg(valueOf2);
                    com.baidu.tieba.recapp.d.a.dnW().fO(System.currentTimeMillis());
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
                    httpMessage.addParam("cuid", cuid);
                    httpMessage.addParam("cip", clientIP);
                    httpMessage.addParam("ver", version);
                    httpMessage.addParam("apinfo", locString);
                    httpMessage.addParam("longitude", valueOf2);
                    httpMessage.addParam("latitude", valueOf);
                    MessageManager.getInstance().sendMessage(httpMessage);
                    MercatorModel.this.mhI = false;
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void startLoad() {
        com.baidu.adp.lib.c.a.mf().a(true, this.fMY);
    }

    public static MercatorModel dxA() {
        return a.mhP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final MercatorModel mhP = new MercatorModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(MercatorData mercatorData) {
        TbSingleton.getInstance().setMercatorData(mercatorData);
        com.baidu.tbadk.core.sharedPref.b.bik().putString("key_mercator_location", MercatorData.jsonStrWithObject(mercatorData));
    }

    public MercatorData getMercatorData() {
        MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
        if (mercatorData == null) {
            return (MercatorData) MercatorData.objectWithJsonStr(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_mercator_location", null), MercatorData.class);
        }
        return mercatorData;
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class MercatorData extends OrmObject {
        String mhK;
        String mhL;
        String mhM;
        int mhN;
        long mhO;

        public MercatorData() {
        }

        public MercatorData(String str, String str2, String str3, int i, long j) {
            this.mhK = str;
            this.mhL = str2;
            this.mhM = str3;
            this.mhN = i;
            this.mhO = j;
        }

        public String dxB() {
            return this.mhK;
        }

        public String dxC() {
            return this.mhL;
        }

        public String dxD() {
            return this.mhM;
        }

        public int dxE() {
            return this.mhN;
        }

        public long dxF() {
            return this.mhO;
        }
    }
}
