package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.bf2;
import com.baidu.tieba.fw2;
import com.baidu.tieba.la3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class ug3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface f {
        void a(int i);
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* loaded from: classes8.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                la3.a aVar = new la3.a(this.a);
                aVar.n(new pq3());
                la3 c = aVar.c();
                aVar.U(R.string.obfuscated_res_0x7f0f0131);
                aVar.w(ug3.p(this.a, c));
                aVar.y();
                aVar.H(R.string.obfuscated_res_0x7f0f0149, new a(this));
                aVar.J(ou2.M().a());
                aVar.a();
                c.setCancelable(false);
                c.show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a implements bf2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ fw2.a b;
        public final /* synthetic */ int c;
        public final /* synthetic */ f d;

        public a(ew2 ew2Var, fw2.a aVar, int i, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew2Var, aVar, Integer.valueOf(i), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ew2Var;
            this.b = aVar;
            this.c = i;
            this.d = fVar;
        }

        @Override // com.baidu.tieba.bf2.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) && hb3.M() != null) {
                SwanAppActivity w = gb3.K().w();
                ug3.q(w, this.a, this.b, bitmap, this.c);
                ug3.r(w, this.a, this.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ew2 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ew2 d;
        public final /* synthetic */ Bitmap e;
        public final /* synthetic */ fw2 f;

        public b(ew2 ew2Var, Context context, int i, ew2 ew2Var2, Bitmap bitmap, fw2 fw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ew2Var, context, Integer.valueOf(i), ew2Var2, bitmap, fw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ew2Var;
            this.b = context;
            this.c = i;
            this.d = ew2Var2;
            this.e = bitmap;
            this.f = fw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gv1 X = ou2.X();
                String q1 = this.a.q1();
                if (!TextUtils.isEmpty(q1) && X.b(this.b, q1)) {
                    ug3.n("click");
                    if (X.a(this.b, q1)) {
                        if (this.c == 1) {
                            return;
                        }
                        ug3.u(this.b);
                        return;
                    } else if (X.c(this.b, q1)) {
                        ug3.n("show");
                        if (this.c == 1) {
                            return;
                        }
                        ug3.u(this.b);
                        return;
                    }
                }
                if (on3.j()) {
                    ug3.t(this.b, this.d.H(), this.d.K(), this.e, fw2.g1(this.b, this.f));
                } else {
                    try {
                        this.b.sendBroadcast(ug3.m(this.d.K(), this.e, fw2.g1(this.b, this.f)));
                    } catch (Throwable th) {
                        if (ug3.a) {
                            th.printStackTrace();
                        }
                        try {
                            this.b.sendBroadcast(ug3.m(this.d.K(), fo3.a(this.e, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), fw2.g1(this.b, this.f)));
                        } catch (Throwable th2) {
                            if (ug3.a) {
                                th2.printStackTrace();
                            }
                            za3.f(this.b, R.string.obfuscated_res_0x7f0f01f5).G();
                        }
                    }
                }
                if (this.c == 1) {
                    return;
                }
                ug3.u(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la3 a;
        public final /* synthetic */ Context b;

        public d(la3 la3Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la3Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la3Var;
            this.b = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                lo3.g(this.b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ ew2 c;

        public e(f fVar, Context context, ew2 ew2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, ew2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.b = context;
            this.c = ew2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(ug3.s(this.b, this.c.K(), this.c.H()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948209992, "Lcom/baidu/tieba/ug3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948209992, "Lcom/baidu/tieba/ug3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void k(Context context, ew2 ew2Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, ew2Var, fVar) == null) {
            j(context, ew2Var, 0, fVar);
        }
    }

    public static Intent m(String str, Bitmap bitmap, Intent intent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, str, bitmap, intent)) == null) {
            Intent intent2 = new Intent(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent2.putExtra("android.intent.extra.shortcut.NAME", str);
            intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent2.putExtra("duplicate", false);
            return intent2;
        }
        return (Intent) invokeLLL.objValue;
    }

    public static void r(Context context, ew2 ew2Var, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65554, null, context, ew2Var, fVar) != null) || fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            bo3.d(new e(fVar, context, ew2Var), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static void l(ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, ew2Var) == null) {
            ew2Var.R0(null);
            ew2Var.I0("1230000000000000");
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, context) == null) {
            if (!(context instanceof Activity)) {
                if (!a) {
                    return;
                }
                throw new IllegalArgumentException("context must be activity.");
            }
            bp3.a0(new c(context));
        }
    }

    public static void i(Context context, ew2 ew2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, ew2Var) == null) {
            k(context, ew2Var, null);
        }
    }

    public static void j(Context context, ew2 ew2Var, int i, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, ew2Var, i, fVar) == null) {
            String Q = ew2Var.Q();
            if (TextUtils.isEmpty(Q) || (C = bp3.C(Q)) == null) {
                return;
            }
            l(ew2Var);
            fw2.a aVar = (fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) ((fw2.a) new fw2.a().v0(ew2Var.H())).I0(ew2Var.T())).P0(ew2Var.c0())).R0(ew2Var.e0())).y0(ew2Var.L())).A0(ew2Var.n0())).L0(ew2Var.p0())).a1(ew2Var.k0())).u0(ew2Var.G())).Q0(ew2Var.d0())).K0(fw2.h1(ew2Var.H(), ew2Var.T(), ew2Var.G()));
            if (eo3.d(C)) {
                q(context, ew2Var, aVar, eo3.c(C, context), i);
                r(context, ew2Var, fVar);
                return;
            }
            bf2.c(Q, aVar.G(), new a(ew2Var, aVar, i, fVar));
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            ji3 ji3Var = new ji3();
            ji3Var.f = gb3.K().getAppId();
            ji3Var.b = str;
            ji3Var.a = ai3.n(gb3.K().k());
            if (hb3.b0() != null && hb3.b0().W() != null) {
                ji3Var.c = hb3.b0().W().T();
            }
            ai3.x("1591", ji3Var);
        }
    }

    @NonNull
    public static String o(Context context) {
        InterceptResult invokeL;
        ActivityInfo activityInfo;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && (activityInfo = resolveActivity.activityInfo) != null && !"android".equals(activityInfo.packageName)) {
                PackageManager packageManager = context.getPackageManager();
                ActivityInfo activityInfo2 = resolveActivity.activityInfo;
                List<ProviderInfo> queryContentProviders = packageManager.queryContentProviders(activityInfo2.processName, activityInfo2.applicationInfo.uid, 65536);
                if (queryContentProviders == null) {
                    return "com.android.launcher3.settings";
                }
                for (ProviderInfo providerInfo : queryContentProviders) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && !TextUtils.isEmpty(providerInfo.readPermission) && Pattern.matches(".*launcher.*permission\\.READ_SETTINGS", providerInfo.readPermission)) {
                        for (String str : providerInfo.authority.split(ParamableElem.DIVIDE_PARAM)) {
                            if (str != null && str.endsWith(".settings")) {
                                return str;
                            }
                        }
                        continue;
                    }
                }
            }
            return "com.android.launcher3.settings";
        }
        return (String) invokeL.objValue;
    }

    public static SpannableStringBuilder p(Context context, la3 la3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, la3Var)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = context.getString(R.string.obfuscated_res_0x7f0f0130);
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0132);
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new d(la3Var, context), indexOf, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.obfuscated_res_0x7f060438)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, ew2 ew2Var, fw2 fw2Var, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65553, null, new Object[]{context, ew2Var, fw2Var, bitmap, Integer.valueOf(i)}) != null) || context == null) {
            return;
        }
        if (bitmap == null) {
            za3.f(context, R.string.obfuscated_res_0x7f0f1599).G();
        } else if (hb3.b0() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(hb3.b0().W(), context, i, ew2Var, bitmap, fw2Var), "add quick app shortcut", 2);
        }
    }

    @TargetApi(26)
    public static void t(Context context, String str, String str2, Bitmap bitmap, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65556, null, context, str, str2, bitmap, intent) == null) {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager.isRequestPinShortcutSupported() && bitmap != null) {
                try {
                    shortcutManager.requestPinShortcut(new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build(), null);
                    return;
                } catch (IllegalStateException e2) {
                    if (a) {
                        throw e2;
                    }
                    return;
                }
            }
            za3.f(context, R.string.obfuscated_res_0x7f0f01f6).G();
        }
    }

    public static int s(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", o(context))), new String[]{"title", "intent"}, "title = ?", new String[]{str}, null);
                while (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("intent"));
                    if (string != null && string.contains(str2)) {
                        if (query != null) {
                            query.close();
                        }
                        return 1;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return 0;
            } catch (Exception e2) {
                if (a) {
                    Log.d("SwanAppShortcutHelper", "fail: " + e2);
                    return -1;
                }
                return -1;
            }
        }
        return invokeLLL.intValue;
    }
}
