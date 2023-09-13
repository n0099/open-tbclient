package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tb4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public o32 a;

    public static /* synthetic */ String f(String str) {
        return str;
    }

    /* loaded from: classes8.dex */
    public class a implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vb4 a;
        public final /* synthetic */ tb4 b;

        public a(tb4 tb4Var, vb4 vb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb4Var, vb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tb4Var;
            this.a = vb4Var;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (tb4.b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.b.j("shareVideo: fail, no login in");
                    return;
                }
                if (tb4.b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.b.h(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ub4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tb4 a;

        public b(tb4 tb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tb4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tb4Var;
        }

        @Override // com.baidu.tieba.ub4
        public void a(vb4 vb4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, vb4Var, str) == null) {
                if (tb4.b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", vb4Var, str));
                }
                this.a.j(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (tb4.b) {
                    iOException.printStackTrace();
                }
                tb4.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject == null) {
                        tb4.g();
                        return;
                    }
                    String unused = tb4.c = jSONObject.optString("community_id");
                    tb4.f(jSONObject.optString("url"));
                } catch (JSONException e) {
                    if (tb4.b) {
                        e.printStackTrace();
                    }
                    tb4.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948175427, "Lcom/baidu/tieba/tb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948175427, "Lcom/baidu/tieba/tb4;");
                return;
            }
        }
        b = rr1.a;
        String str = b82.c() + "/webpage";
        c = "";
    }

    public tb4(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = o32.F(jsObject);
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c = "";
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ji3 ji3Var = new ji3();
            ji3Var.b = "shareVideo";
            ji3Var.e = "fail";
            ai3.h(ji3Var);
        }
    }

    public final void h(vb4 vb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vb4Var) == null) {
            y74.i().a(vb4Var, new b(this));
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.a == null) {
            return;
        }
        q54 q54Var = new q54();
        q54Var.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        td4.call(this.a, false, q54Var);
        i();
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            o94 o94Var = (o94) hb3.M().i0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, hb3.g0());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            o94Var.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final vb4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (hb3.M() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = rn2.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                vb4 vb4Var = new vb4();
                vb4Var.a = B2;
                vb4Var.c = this.a.B("title");
                vb4Var.b = this.a.B("query");
                wb4 wb4Var = new wb4();
                wb4Var.a = this.a.y("clipMaxDuration", 30L);
                wb4Var.b = this.a.y("clipMinDuration", 3L);
                wb4Var.c = this.a.B("topicSource");
                wb4Var.d = this.a.C("publishTitle", ou2.c().getResources().getString(R.string.obfuscated_res_0x7f0f15c5));
                wb4Var.e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                wb4Var.i = this.a.r("sourceType", 1);
                wb4Var.j = this.a.C("sourceFrom", "tiny");
                wb4Var.g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                wb4Var.f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                wb4Var.h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                wb4Var.k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, hb3.g0());
                    jSONObject.put("frame_type", gb3.K().k());
                    jSONObject.put("query", vb4Var.b);
                    if (hb3.M() != null && hb3.M().Y() != null) {
                        jSONObject.put("title", hb3.M().Y().K());
                    }
                } catch (JSONException e) {
                    if (b) {
                        Log.d("ShareVideoApi", e.toString());
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", c);
                        if (hb3.M() != null && hb3.M().Y() != null) {
                            jSONObject2.put("name", hb3.M().Y().K());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e2) {
                        if (b) {
                            Log.d("ShareVideoApi", e2.toString());
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e3) {
                        if (b) {
                            Log.d("ShareVideoApi", e3.toString());
                        }
                    }
                    wb4Var.l = jSONObject3.toString();
                    wb4Var.m = -1;
                } else {
                    wb4Var.m = 0;
                }
                vb4Var.e = wb4Var;
                return vb4Var;
            }
        }
        return (vb4) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ji3 ji3Var = new ji3();
            ji3Var.b = "shareVideo";
            ai3.h(ji3Var);
            vb4 k = k();
            if (k == null) {
                return;
            }
            ur1 N = hb3.M().N();
            if (N.e(ou2.c())) {
                h(k);
                return;
            }
            SwanAppActivity activity = uw2.T().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                N.f(activity, null, new a(this, k));
            }
        }
    }
}
