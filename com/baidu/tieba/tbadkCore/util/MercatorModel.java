package com.baidu.tieba.tbadkCore.util;

import android.location.Address;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.loc.str.BDLocManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.b.b.e.i.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MercatorModel {

    /* renamed from: a  reason: collision with root package name */
    public boolean f21411a;

    /* renamed from: b  reason: collision with root package name */
    public final a.c f21412b;

    /* loaded from: classes5.dex */
    public static class MercatorData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f21413e;

        /* renamed from: f  reason: collision with root package name */
        public String f21414f;

        /* renamed from: g  reason: collision with root package name */
        public String f21415g;

        /* renamed from: h  reason: collision with root package name */
        public int f21416h;
        public long i;

        public MercatorData() {
        }

        public int s() {
            return this.f21416h;
        }

        public String t() {
            return this.f21414f;
        }

        public String u() {
            return this.f21413e;
        }

        public String v() {
            return this.f21415g;
        }

        public long w() {
            return this.i;
        }

        public MercatorData(String str, String str2, String str3, int i, long j) {
            this.f21413e = str;
            this.f21414f = str2;
            this.f21415g = str3;
            this.f21416h = i;
            this.i = j;
        }
    }

    /* loaded from: classes5.dex */
    public static class MercatorLocationResponseMessage extends JsonHttpResponsedMessage {
        public MercatorLocationResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject == null) {
                return;
            }
            MercatorModel.g(new MercatorData(jSONObject.optString("mercator_lon"), jSONObject.optString("mercator_lat"), jSONObject.optString("mercator_radius"), jSONObject.optInt("mercator_city"), jSONObject.optLong("mercator_time")));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.b.b.e.i.a.c
        public void onLocationGeted(int i, String str, Address address) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (i != 0 || address == null || inst == null || MercatorModel.this.f21411a) {
                return;
            }
            MercatorModel.this.f21411a = true;
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            String locString = BDLocManager.getInstance(inst).getLocString();
            String version = TbConfig.getVersion();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String clientIP = UtilHelper.getClientIP();
            d.b.i0.r2.a0.a.e().i(valueOf);
            d.b.i0.r2.a0.a.e().j(valueOf2);
            d.b.i0.r2.a0.a.e().k(System.currentTimeMillis());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
            httpMessage.addParam("cuid", cuid);
            httpMessage.addParam("cip", clientIP);
            httpMessage.addParam("ver", version);
            httpMessage.addParam("apinfo", locString);
            httpMessage.addParam("longitude", valueOf2);
            httpMessage.addParam("latitude", valueOf);
            MessageManager.getInstance().sendMessage(httpMessage);
            MercatorModel.this.f21411a = false;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final MercatorModel f21418a = new MercatorModel(null);
    }

    public /* synthetic */ MercatorModel(a aVar) {
        this();
    }

    public static MercatorModel d() {
        return b.f21418a;
    }

    public static void g(MercatorData mercatorData) {
        TbSingleton.getInstance().setMercatorData(mercatorData);
        d.b.h0.r.d0.b.i().w("key_mercator_location", OrmObject.jsonStrWithObject(mercatorData));
    }

    public MercatorData e() {
        MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
        return mercatorData == null ? (MercatorData) OrmObject.objectWithJsonStr(d.b.h0.r.d0.b.i().o("key_mercator_location", null), MercatorData.class) : mercatorData;
    }

    public void f() {
        d.b.b.e.i.a.l().i(true, this.f21412b);
    }

    public MercatorModel() {
        this.f21411a = false;
        this.f21412b = new a();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
