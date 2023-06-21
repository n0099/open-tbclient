package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.w71;
import com.baidu.tieba.x91;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class l91 extends j91 implements z91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public RelativeLayout b;
    public String c;
    public final Object d;
    public final n91 e;

    /* loaded from: classes6.dex */
    public static final class a implements w71.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l91 a;

        public a(l91 l91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l91Var;
        }

        @Override // com.baidu.tieba.w71.b
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                AbsNadBrowserView m = this.a.e.m();
                String str2 = this.a.a;
                ra1.a(str2, "js is " + str + " and browserView is " + m);
                if (m != null) {
                    AbsNadBrowserView.B(m, str, null, 2, null);
                }
            }
        }
    }

    public l91(n91 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.e = container;
        AbsNadBrowserView m = container.m();
        if (m != null) {
            m.setDownloadListener(this);
        }
        this.a = "DownloadPlugin";
        this.c = "";
        this.d = new Object();
    }

    @Override // com.baidu.tieba.z91
    public boolean a(Context context, String str, String str2, String str3, String str4, long j, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, Long.valueOf(j), str5})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str6 = this.a;
            ra1.a(str6, "onDownloadStart :: url = " + str + ",ua = " + str2 + ",contentDisposition = " + str3 + ",mimetype = " + str4 + ",contentLength = " + j);
            if (f61.b(f61.c(f61.e(str, str3, str4)), str4) == 3) {
                JSONObject c = z21.c(this.c);
                Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(downloadParams)");
                z21.f(c, "url", str);
                z21.e(c, BreakpointSQLiteKey.CONTENT_LENGTH, j);
                w71 a2 = c81.a();
                if (a2 != null) {
                    a2.b(context, this.b, c.toString());
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.j91
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = this.a;
            ra1.a(str, "context " + this.e.c());
            super.c();
        }
    }

    @Override // com.baidu.tieba.j91
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w71 a2 = c81.a();
            if (a2 != null) {
                a2.release();
            }
            qn0.a().unregister(this.d);
            super.d();
        }
    }

    @Override // com.baidu.tieba.j91
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w71 a2 = c81.a();
            if (a2 != null) {
                a2.a(this.d, new a(this));
            }
            q();
            p();
            super.m();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0051 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:12:0x001e, B:16:0x0026, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:27:0x0043, B:29:0x0051, B:31:0x0057, B:33:0x005e, B:35:0x0064, B:37:0x006b, B:39:0x0071, B:41:0x0078, B:43:0x007e, B:45:0x0085, B:46:0x0089), top: B:55:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p() {
        x91.c cVar;
        String b;
        String str;
        String str2;
        String str3;
        String str4;
        String f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            x91.d l = this.e.l();
            String str5 = null;
            if (l != null) {
                cVar = l.e();
            } else {
                cVar = null;
            }
            JSONObject jSONObject = new JSONObject();
            String str6 = "";
            if (l != null) {
                try {
                    b = l.b();
                } catch (JSONException e) {
                    ra1.d(e);
                }
                if (b != null) {
                    jSONObject.put(LegoListActivityConfig.AD_ID, b);
                    if (l != null || (r6 = l.l()) == null) {
                        String str7 = "";
                    }
                    jSONObject.put("lp_url", str7);
                    if (l != null && (f = l.f()) != null) {
                        str6 = f;
                    }
                    jSONObject.put("log_ext", str6);
                    jSONObject.put("business", "native_ads");
                    if (cVar == null) {
                        str = cVar.e();
                    } else {
                        str = null;
                    }
                    jSONObject.put("key", str);
                    if (cVar == null) {
                        str2 = cVar.d();
                    } else {
                        str2 = null;
                    }
                    jSONObject.put("url", str2);
                    if (cVar == null) {
                        str3 = cVar.c();
                    } else {
                        str3 = null;
                    }
                    jSONObject.put("close_v_dl", str3);
                    if (cVar == null) {
                        str4 = cVar.a();
                    } else {
                        str4 = null;
                    }
                    jSONObject.put("app_icon", str4);
                    if (cVar != null) {
                        str5 = cVar.b();
                    }
                    jSONObject.put("app_name", str5);
                    Intrinsics.checkNotNullExpressionValue(jSONObject.toString(), "paramsJson.apply {\n     …\n            }.toString()");
                    this.c = jSONObject.toString();
                }
            }
            b = "";
            jSONObject.put(LegoListActivityConfig.AD_ID, b);
            if (l != null) {
            }
            String str72 = "";
            jSONObject.put("lp_url", str72);
            if (l != null) {
                str6 = f;
            }
            jSONObject.put("log_ext", str6);
            jSONObject.put("business", "native_ads");
            if (cVar == null) {
            }
            jSONObject.put("key", str);
            if (cVar == null) {
            }
            jSONObject.put("url", str2);
            if (cVar == null) {
            }
            jSONObject.put("close_v_dl", str3);
            if (cVar == null) {
            }
            jSONObject.put("app_icon", str4);
            if (cVar != null) {
            }
            jSONObject.put("app_name", str5);
            Intrinsics.checkNotNullExpressionValue(jSONObject.toString(), "paramsJson.apply {\n     …\n            }.toString()");
            this.c = jSONObject.toString();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e.h() != null && this.e.m() != null) {
            this.b = new RelativeLayout(this.e.c());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            RelativeLayout relativeLayout = this.b;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(0);
            }
            RelativeLayout relativeLayout2 = this.b;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            FrameLayout h = this.e.h();
            if (h != null) {
                h.addView(this.b, layoutParams);
            }
        }
    }
}
