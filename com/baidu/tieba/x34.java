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
/* loaded from: classes6.dex */
public class x34 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public sv1 a;

    /* loaded from: classes6.dex */
    public class a implements xj1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z34 a;
        public final /* synthetic */ x34 b;

        public a(x34 x34Var, z34 z34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var, z34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x34Var;
            this.a = z34Var;
        }

        @Override // com.baidu.tieba.xj1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (x34.b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.b.j("shareVideo: fail, no login in");
                    return;
                }
                if (x34.b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.b.h(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements y34 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x34 a;

        public b(x34 x34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x34Var;
        }

        @Override // com.baidu.tieba.y34
        public void a(z34 z34Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, z34Var, str) == null) {
                if (x34.b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", z34Var, str));
                }
                this.a.j(str);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                if (x34.b) {
                    iOException.printStackTrace();
                }
                x34.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject != null) {
                        String unused = x34.c = jSONObject.optString("community_id");
                        x34.f(jSONObject.optString("url"));
                        return;
                    }
                    x34.g();
                } catch (JSONException e) {
                    if (x34.b) {
                        e.printStackTrace();
                    }
                    x34.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249424, "Lcom/baidu/tieba/x34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249424, "Lcom/baidu/tieba/x34;");
                return;
            }
        }
        b = vj1.a;
        String str = f02.c() + "/webpage";
        c = "";
    }

    public x34(JsObject jsObject) {
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
        this.a = sv1.F(jsObject);
    }

    public static /* synthetic */ String f(String str) {
        return str;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c = "";
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            s14 s14Var = (s14) l33.M().i0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, l33.g0());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            s14Var.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final void h(z34 z34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z34Var) == null) {
            c04.i().a(z34Var, new b(this));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            na3 na3Var = new na3();
            na3Var.b = "shareVideo";
            na3Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            ea3.h(na3Var);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a == null) {
            return;
        }
        ux3 ux3Var = new ux3();
        ux3Var.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        x54.call(this.a, false, ux3Var);
        i();
    }

    public final z34 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (l33.M() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = vf2.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                z34 z34Var = new z34();
                z34Var.a = B2;
                z34Var.c = this.a.B("title");
                z34Var.b = this.a.B("query");
                a44 a44Var = new a44();
                a44Var.a = this.a.y("clipMaxDuration", 30L);
                a44Var.b = this.a.y("clipMinDuration", 3L);
                a44Var.c = this.a.B("topicSource");
                a44Var.d = this.a.C("publishTitle", sm2.c().getResources().getString(R.string.obfuscated_res_0x7f0f1357));
                a44Var.e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                a44Var.i = this.a.r("sourceType", 1);
                a44Var.j = this.a.C("sourceFrom", "tiny");
                a44Var.g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                a44Var.f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                a44Var.h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                a44Var.k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, l33.g0());
                    jSONObject.put("frame_type", k33.K().k());
                    jSONObject.put("query", z34Var.b);
                    if (l33.M() != null && l33.M().Y() != null) {
                        jSONObject.put("title", l33.M().Y().K());
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
                        if (l33.M() != null && l33.M().Y() != null) {
                            jSONObject2.put("name", l33.M().Y().K());
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
                    a44Var.l = jSONObject3.toString();
                    a44Var.m = -1;
                } else {
                    a44Var.m = 0;
                }
                z34Var.e = a44Var;
                return z34Var;
            }
        }
        return (z34) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            na3 na3Var = new na3();
            na3Var.b = "shareVideo";
            ea3.h(na3Var);
            z34 k = k();
            if (k == null) {
                return;
            }
            yj1 N = l33.M().N();
            if (N.e(sm2.c())) {
                h(k);
                return;
            }
            SwanAppActivity activity = yo2.U().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                N.f(activity, null, new a(this, k));
            }
        }
    }
}
