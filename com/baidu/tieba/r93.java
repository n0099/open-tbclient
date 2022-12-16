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
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cp2;
import com.baidu.tieba.i33;
import com.baidu.tieba.y72;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class r93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface f {
        void a(int i);
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* loaded from: classes6.dex */
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
                i33.a aVar = new i33.a(this.a);
                aVar.n(new mj3());
                i33 c = aVar.c();
                aVar.U(R.string.obfuscated_res_0x7f0f0107);
                aVar.w(r93.p(this.a, c));
                aVar.y();
                aVar.H(R.string.obfuscated_res_0x7f0f011f, new a(this));
                aVar.J(ln2.M().a());
                aVar.a();
                c.setCancelable(false);
                c.show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements y72.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ cp2.a b;
        public final /* synthetic */ int c;
        public final /* synthetic */ f d;

        public a(bp2 bp2Var, cp2.a aVar, int i, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp2Var, aVar, Integer.valueOf(i), fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bp2Var;
            this.b = aVar;
            this.c = i;
            this.d = fVar;
        }

        @Override // com.baidu.tieba.y72.b
        public void a(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) && e43.M() != null) {
                SwanAppActivity w = d43.K().w();
                r93.q(w, this.a, this.b, bitmap, this.c);
                r93.r(w, this.a, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ bp2 d;
        public final /* synthetic */ Bitmap e;
        public final /* synthetic */ cp2 f;

        public b(bp2 bp2Var, Context context, int i, bp2 bp2Var2, Bitmap bitmap, cp2 cp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp2Var, context, Integer.valueOf(i), bp2Var2, bitmap, cp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bp2Var;
            this.b = context;
            this.c = i;
            this.d = bp2Var2;
            this.e = bitmap;
            this.f = cp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                do1 X = ln2.X();
                String q1 = this.a.q1();
                if (!TextUtils.isEmpty(q1) && X.b(this.b, q1)) {
                    r93.n("click");
                    if (X.a(this.b, q1)) {
                        if (this.c == 1) {
                            return;
                        }
                        r93.u(this.b);
                        return;
                    } else if (X.c(this.b, q1)) {
                        r93.n("show");
                        if (this.c == 1) {
                            return;
                        }
                        r93.u(this.b);
                        return;
                    }
                }
                if (lg3.j()) {
                    r93.t(this.b, this.d.H(), this.d.K(), this.e, cp2.g1(this.b, this.f));
                } else {
                    try {
                        this.b.sendBroadcast(r93.m(this.d.K(), this.e, cp2.g1(this.b, this.f)));
                    } catch (Throwable th) {
                        if (r93.a) {
                            th.printStackTrace();
                        }
                        try {
                            this.b.sendBroadcast(r93.m(this.d.K(), ch3.a(this.e, ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT, true), cp2.g1(this.b, this.f)));
                        } catch (Throwable th2) {
                            if (r93.a) {
                                th2.printStackTrace();
                            }
                            w33.f(this.b, R.string.obfuscated_res_0x7f0f01cb).G();
                        }
                    }
                }
                if (this.c == 1) {
                    return;
                }
                r93.u(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i33 a;
        public final /* synthetic */ Context b;

        public d(i33 i33Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i33Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i33Var;
            this.b = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                ih3.g(this.b);
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

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ bp2 c;

        public e(f fVar, Context context, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, bp2Var};
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
            this.c = bp2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(r93.s(this.b, this.c.K(), this.c.H()));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076413, "Lcom/baidu/tieba/r93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076413, "Lcom/baidu/tieba/r93;");
                return;
            }
        }
        a = ok1.a;
    }

    public static void k(Context context, bp2 bp2Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, bp2Var, fVar) == null) {
            j(context, bp2Var, 0, fVar);
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

    public static void r(Context context, bp2 bp2Var, f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65554, null, context, bp2Var, fVar) != null) || fVar == null) {
            return;
        }
        if (context == null) {
            fVar.a(-1);
        } else {
            yg3.d(new e(fVar, context, bp2Var), "SwanAppShortcutHelper", 1000L, TimeUnit.MILLISECONDS);
        }
    }

    public static void l(bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, bp2Var) == null) {
            bp2Var.R0(null);
            bp2Var.I0("1230000000000000");
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
            yh3.a0(new c(context));
        }
    }

    public static void i(Context context, bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, bp2Var) == null) {
            k(context, bp2Var, null);
        }
    }

    public static void j(Context context, bp2 bp2Var, int i, f fVar) {
        Uri C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, null, context, bp2Var, i, fVar) == null) {
            String Q = bp2Var.Q();
            if (TextUtils.isEmpty(Q) || (C = yh3.C(Q)) == null) {
                return;
            }
            l(bp2Var);
            cp2.a aVar = (cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) ((cp2.a) new cp2.a().v0(bp2Var.H())).I0(bp2Var.T())).P0(bp2Var.c0())).R0(bp2Var.e0())).y0(bp2Var.L())).A0(bp2Var.n0())).L0(bp2Var.p0())).a1(bp2Var.k0())).u0(bp2Var.G())).Q0(bp2Var.d0())).K0(cp2.h1(bp2Var.H(), bp2Var.T(), bp2Var.G()));
            if (bh3.d(C)) {
                q(context, bp2Var, aVar, bh3.c(C, context), i);
                r(context, bp2Var, fVar);
                return;
            }
            y72.c(Q, aVar.G(), new a(bp2Var, aVar, i, fVar));
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            gb3 gb3Var = new gb3();
            gb3Var.f = d43.K().getAppId();
            gb3Var.b = str;
            gb3Var.a = xa3.n(d43.K().k());
            if (e43.b0() != null && e43.b0().W() != null) {
                gb3Var.c = e43.b0().W().T();
            }
            xa3.x("1591", gb3Var);
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
                        for (String str : providerInfo.authority.split(";")) {
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

    public static SpannableStringBuilder p(Context context, i33 i33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, i33Var)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = context.getString(R.string.obfuscated_res_0x7f0f0106);
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0108);
            int indexOf = string.indexOf(string2);
            int length = string2.length() + indexOf;
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new d(i33Var, context), indexOf, length, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.obfuscated_res_0x7f0603c6)), indexOf, length, 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public static void q(Context context, bp2 bp2Var, cp2 cp2Var, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65553, null, new Object[]{context, bp2Var, cp2Var, bitmap, Integer.valueOf(i)}) != null) || context == null) {
            return;
        }
        if (bitmap == null) {
            w33.f(context, R.string.obfuscated_res_0x7f0f139f).G();
        } else if (e43.b0() == null) {
        } else {
            ExecutorUtilsExt.postOnElastic(new b(e43.b0().W(), context, i, bp2Var, bitmap, cp2Var), "add quick app shortcut", 2);
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
            w33.f(context, R.string.obfuscated_res_0x7f0f01cc).G();
        }
    }

    public static int s(@NonNull Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse(String.format("content://%s/favorites?notify=true", o(context))), new String[]{"title", IntentData.KEY}, "title = ?", new String[]{str}, null);
                while (query != null && query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(IntentData.KEY));
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
