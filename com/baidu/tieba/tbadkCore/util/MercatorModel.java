package com.baidu.tieba.tbadkCore.util;

import android.location.Address;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.loc.str.BDLocManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.c.e.i.a;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MercatorModel {

    /* renamed from: a  reason: collision with root package name */
    public boolean f21016a;

    /* renamed from: b  reason: collision with root package name */
    public final a.c f21017b;

    /* loaded from: classes5.dex */
    public static class MercatorData extends OrmObject {

        /* renamed from: e  reason: collision with root package name */
        public String f21018e;

        /* renamed from: f  reason: collision with root package name */
        public String f21019f;

        /* renamed from: g  reason: collision with root package name */
        public String f21020g;

        /* renamed from: h  reason: collision with root package name */
        public int f21021h;

        /* renamed from: i  reason: collision with root package name */
        public long f21022i;

        public MercatorData() {
        }

        public long A() {
            return this.f21022i;
        }

        public int w() {
            return this.f21021h;
        }

        public String x() {
            return this.f21019f;
        }

        public String y() {
            return this.f21018e;
        }

        public String z() {
            return this.f21020g;
        }

        public MercatorData(String str, String str2, String str3, int i2, long j) {
            this.f21018e = str;
            this.f21019f = str2;
            this.f21020g = str3;
            this.f21021h = i2;
            this.f21022i = j;
        }
    }

    /* loaded from: classes5.dex */
    public static class MercatorLocationResponseMessage extends JsonHttpResponsedMessage {
        public MercatorLocationResponseMessage(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject == null) {
                return;
            }
            MercatorModel.g(new MercatorData(jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LON), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LAT), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_RADIUS), jSONObject.optInt(SearchJsBridge.COOKIE_MERCATOR_CITY), jSONObject.optLong(SearchJsBridge.COOKIE_MERCATOR_TIME)));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // d.a.c.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            if (i2 != 0 || address == null || inst == null || MercatorModel.this.f21016a) {
                return;
            }
            MercatorModel.this.f21016a = true;
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            String locString = BDLocManager.getInstance(inst).getLocString();
            String version = TbConfig.getVersion();
            String cuid = TbadkCoreApplication.getInst().getCuid();
            String clientIP = UtilHelper.getClientIP();
            d.a.o0.t2.g0.a.e().i(valueOf);
            d.a.o0.t2.g0.a.e().j(valueOf2);
            d.a.o0.t2.g0.a.e().k(System.currentTimeMillis());
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
            httpMessage.addParam("cuid", cuid);
            httpMessage.addParam("cip", clientIP);
            httpMessage.addParam("ver", version);
            httpMessage.addParam(IAdRequestParam.APINFO, locString);
            httpMessage.addParam("longitude", valueOf2);
            httpMessage.addParam("latitude", valueOf);
            MessageManager.getInstance().sendMessage(httpMessage);
            MercatorModel.this.f21016a = false;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final MercatorModel f21024a = new MercatorModel(null);
    }

    public /* synthetic */ MercatorModel(a aVar) {
        this();
    }

    public static MercatorModel d() {
        return b.f21024a;
    }

    public static void g(MercatorData mercatorData) {
        TbSingleton.getInstance().setMercatorData(mercatorData);
        d.a.n0.r.d0.b.j().x("key_mercator_location", OrmObject.jsonStrWithObject(mercatorData));
    }

    public MercatorData e() {
        MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
        return mercatorData == null ? (MercatorData) OrmObject.objectWithJsonStr(d.a.n0.r.d0.b.j().p("key_mercator_location", null), MercatorData.class) : mercatorData;
    }

    public void f() {
        d.a.c.e.i.a.k().h(true, this.f21017b);
    }

    public MercatorModel() {
        this.f21016a = false;
        this.f21017b = new a();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
