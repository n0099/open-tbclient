package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
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
/* loaded from: classes5.dex */
public class q44 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public lw1 a;

    public static /* synthetic */ String f(String str) {
        return str;
    }

    /* loaded from: classes5.dex */
    public class a implements qk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s44 a;
        public final /* synthetic */ q44 b;

        public a(q44 q44Var, s44 s44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q44Var, s44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q44Var;
            this.a = s44Var;
        }

        @Override // com.baidu.tieba.qk1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (q44.b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.b.j("shareVideo: fail, no login in");
                    return;
                }
                if (q44.b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.b.h(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements r44 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q44 a;

        public b(q44 q44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q44Var;
        }

        @Override // com.baidu.tieba.r44
        public void a(s44 s44Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, s44Var, str) == null) {
                if (q44.b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", s44Var, str));
                }
                this.a.j(str);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (q44.b) {
                    iOException.printStackTrace();
                }
                q44.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject == null) {
                        q44.g();
                        return;
                    }
                    String unused = q44.c = jSONObject.optString("community_id");
                    q44.f(jSONObject.optString("url"));
                } catch (JSONException e) {
                    if (q44.b) {
                        e.printStackTrace();
                    }
                    q44.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948041848, "Lcom/baidu/tieba/q44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948041848, "Lcom/baidu/tieba/q44;");
                return;
            }
        }
        b = ok1.a;
        String str = y02.c() + "/webpage";
        c = "";
    }

    public q44(JsObject jsObject) {
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
        this.a = lw1.F(jsObject);
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.a == null) {
            return;
        }
        ny3 ny3Var = new ny3();
        ny3Var.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        q64.call(this.a, false, ny3Var);
        i();
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
            gb3 gb3Var = new gb3();
            gb3Var.b = "shareVideo";
            gb3Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            xa3.h(gb3Var);
        }
    }

    public final void h(s44 s44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s44Var) == null) {
            v04.i().a(s44Var, new b(this));
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            l24 l24Var = (l24) e43.M().i0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put("app_key", e43.g0());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            l24Var.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final s44 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (e43.M() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = og2.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                s44 s44Var = new s44();
                s44Var.a = B2;
                s44Var.c = this.a.B("title");
                s44Var.b = this.a.B("query");
                t44 t44Var = new t44();
                t44Var.a = this.a.y("clipMaxDuration", 30L);
                t44Var.b = this.a.y("clipMinDuration", 3L);
                t44Var.c = this.a.B("topicSource");
                t44Var.d = this.a.C("publishTitle", ln2.c().getResources().getString(R.string.obfuscated_res_0x7f0f13cb));
                t44Var.e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                t44Var.i = this.a.r("sourceType", 1);
                t44Var.j = this.a.C("sourceFrom", "tiny");
                t44Var.g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                t44Var.f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                t44Var.h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                t44Var.k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("app_key", e43.g0());
                    jSONObject.put("frame_type", d43.K().k());
                    jSONObject.put("query", s44Var.b);
                    if (e43.M() != null && e43.M().Y() != null) {
                        jSONObject.put("title", e43.M().Y().K());
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
                        if (e43.M() != null && e43.M().Y() != null) {
                            jSONObject2.put("name", e43.M().Y().K());
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
                    t44Var.l = jSONObject3.toString();
                    t44Var.m = -1;
                } else {
                    t44Var.m = 0;
                }
                s44Var.e = t44Var;
                return s44Var;
            }
        }
        return (s44) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gb3 gb3Var = new gb3();
            gb3Var.b = "shareVideo";
            xa3.h(gb3Var);
            s44 k = k();
            if (k == null) {
                return;
            }
            rk1 N = e43.M().N();
            if (N.e(ln2.c())) {
                h(k);
                return;
            }
            SwanAppActivity activity = rp2.U().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                N.f(activity, null, new a(this, k));
            }
        }
    }
}
