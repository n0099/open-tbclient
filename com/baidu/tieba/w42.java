package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.IntentConstants;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.d52;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w42 extends v42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String G0;
    public String H0;
    public ForbiddenInfo I0;
    public int J0;
    public int K0;
    public String L0;
    public String M0;
    public String N0;
    public int O0;

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rc3 a;

            public a(rc3 rc3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rc3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = rc3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    wb3.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, mq2 mq2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, mq2Var, forbiddenInfo) == null) {
                rc3 rc3Var = new rc3();
                rc3Var.f = forbiddenInfo.appId;
                rc3Var.g = "errormenu";
                rc3Var.b = "click";
                rc3Var.e = str;
                rc3Var.c = forbiddenInfo.launchSource;
                rc3Var.b(ic3.k(mq2Var.X()));
                rc3Var.d(mq2Var.t0().getString("ubc"));
                ji3.j(new a(rc3Var), "SwanAppFuncClickUBC");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w42 a;

        public a(w42 w42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.a.c0) != null) {
                activity.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ w42 b;

        public b(w42 w42Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w42Var;
            this.a = mq2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("property_web_mode_degrade", true);
                SwanLauncher.j().n(this.a, bundle);
                this.b.c0.finishAndRemoveTask();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ w42 b;

        public c(w42 w42Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w42Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.I0 != null && !TextUtils.isEmpty(this.b.I0.forbiddenDetail)) {
                wo2.u().b(this.b.m(), this.a, this.b.I0.appTitle, this.b.I0.forbiddenDetail);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ w42 b;

        public d(w42 w42Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w42Var;
            this.a = mq2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.c0.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w42 a;

        public e(w42 w42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.M0)) {
                Activity activity = this.a.c0;
                if (activity instanceof FragmentActivity) {
                    kj4 k = ((FragmentActivity) activity).k();
                    d52.d i3 = d52.i3(this.a.M0);
                    i3.a(false);
                    i3.c(k);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w42 a;

        public f(w42 w42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity m = this.a.m();
                if (!(m instanceof SwanAppClearCacheErrorActivity)) {
                    if (!v42.F0) {
                        return;
                    }
                    throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                }
                ((SwanAppClearCacheErrorActivity) m).F();
                try {
                    this.a.r1(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    p22.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w42 a;

        public g(w42 w42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w42Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.W1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ w42 b;

        public h(w42 w42Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w42Var;
            this.a = mq2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (activity = this.b.c0) != null && SwanAppNetworkUtils.i(activity)) {
                SwanLauncher.j().n(this.a, null);
                this.b.c0.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ub4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ w42 b;

        public i(w42 w42Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w42Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w42Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.ub4
        public boolean b(View view2, xb4 xb4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, xb4Var)) == null) {
                int c = xb4Var.c();
                if (c != 5) {
                    if (c != 9) {
                        if (c != 39) {
                            if (c != 46) {
                                if (c == 47) {
                                    this.b.p3(xb4Var, this.a);
                                }
                            } else {
                                this.b.o3(xb4Var, this.a);
                            }
                        } else {
                            this.b.r3(this.a);
                        }
                    } else {
                        this.b.n3(this.a);
                        return true;
                    }
                } else {
                    this.b.q3(this.a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public w42() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final mq2 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (m() != null && (m() instanceof SwanAppErrorActivity)) {
                return ((SwanAppErrorActivity) m()).y();
            }
            return null;
        }
        return (mq2) invokeV.objValue;
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<String> a2 = xh4.b().a();
            if (a2 != null && a2.contains(this.H0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null && jj3.I(forbiddenInfo.launchPath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            i3();
            u3();
            x3();
            v3();
        }
    }

    public final void u3() {
        wb4 wb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (wb4Var = this.g0) != null) {
            wb4Var.r(wo2.M().a());
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            j.a("menu", g3(), this.I0);
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            return d3();
        }
        return invokeL.booleanValue;
    }

    public void n3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            wo2.K().h(activity, f3(activity));
            j.a("feedback", g3(), this.I0);
        }
    }

    public void q3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activity) == null) {
            fv2.j(activity);
            j.a("daynightmode", g3(), this.I0);
        }
    }

    public void r3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                fv2.t(activity);
            }
            j.a(Headers.REFRESH, g3(), this.I0);
        }
    }

    public static w42 m3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            w42 w42Var = new w42();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            w42Var.n1(bundle);
            return w42Var;
        }
        return (w42) invokeCommon.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00a8, viewGroup, false);
            j3(inflate);
            b2(inflate);
            if (a2()) {
                return d2(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v42
    public void b2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.b2(view2);
            c2(view2);
            A2(-1);
            J2(-16777216);
            E2(false);
            Q2(true);
            this.f0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                C2(this.I0.appTitle);
            }
        }
    }

    public final CharSequence e3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = rh4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = rh4.m(g2, str2.substring(str2.length() - 4));
                    if (!TextUtils.isEmpty(m)) {
                        return m;
                    }
                }
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1242268664:
                    if (str.equals("type_need_update_sdk")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -429452284:
                    if (str.equals("type_path_forbidden")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 38398066:
                    if (str.equals("type_network_error")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str.equals("type_0049")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 517347882:
                    if (str.equals("type_2205")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 731215244:
                    if (str.equals("type_normal")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                if (c2 != 5) {
                                    return "";
                                }
                                String m2 = rh4.m(g2, "2205");
                                if (TextUtils.isEmpty(m2)) {
                                    return d0(R.string.obfuscated_res_0x7f0f154e);
                                }
                                return m2;
                            }
                            String m3 = rh4.m(g2, "0049");
                            if (TextUtils.isEmpty(m3)) {
                                return d0(R.string.obfuscated_res_0x7f0f1550);
                            }
                            return m3;
                        }
                        String m4 = rh4.m(g2, "app_page_banned");
                        if (TextUtils.isEmpty(m4)) {
                            return d0(R.string.obfuscated_res_0x7f0f154f);
                        }
                        return m4;
                    }
                    String m5 = rh4.m(g2, "app_need_upgrade");
                    if (TextUtils.isEmpty(m5)) {
                        return d0(R.string.obfuscated_res_0x7f0f1550);
                    }
                    return m5;
                }
                String m6 = rh4.m(g2, "app_open_failed");
                if (TextUtils.isEmpty(m6)) {
                    return d0(R.string.obfuscated_res_0x7f0f1550);
                }
                return m6;
            }
            String m7 = rh4.m(g2, "net_conn_failed");
            if (TextUtils.isEmpty(m7)) {
                return d0(R.string.obfuscated_res_0x7f0f1550);
            }
            return m7;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject f3(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo x = ((SwanAppErrorActivity) activity).x();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", x.appTitle);
                    jSONObject.put("url", x.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, x.appId);
                    jSONObject.put("errorPath", x.launchPath);
                    jSONObject.put("errorDes", x.forbiddenReason);
                } catch (JSONException e2) {
                    if (v42.F0) {
                        e2.printStackTrace();
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.y0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.G0 = p.getString("swan_error_type");
            this.H0 = p.getString("swan_error_code");
            this.N0 = p.getString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
            this.O0 = p.getInt("webPermit");
            this.I0 = (ForbiddenInfo) p.getParcelable("key_forbidden_info");
            this.J0 = p.getInt("key_show_menu_notice");
            this.K0 = p.getInt("key_show_menu_privacy");
        }
    }

    public final String h3(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            String str3 = "";
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1242268664:
                        if (str.equals("type_need_update_sdk")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -429452284:
                        if (str.equals("type_path_forbidden")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 38398066:
                        if (str.equals("type_network_error")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 517286506:
                        if (str.equals("type_0049")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 517347882:
                        if (str.equals("type_2205")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 731215244:
                        if (str.equals("type_normal")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                if (c2 != 4) {
                                    if (c2 == 5) {
                                        str3 = s().getString(R.string.obfuscated_res_0x7f0f1551);
                                    }
                                } else {
                                    str3 = s().getString(R.string.obfuscated_res_0x7f0f1554);
                                }
                            } else {
                                str3 = s().getString(R.string.obfuscated_res_0x7f0f1558);
                            }
                        } else {
                            str3 = s().getString(R.string.obfuscated_res_0x7f0f1555);
                        }
                    } else {
                        str3 = s().getString(R.string.obfuscated_res_0x7f0f1557);
                    }
                } else {
                    str3 = s().getString(R.string.obfuscated_res_0x7f0f15ad);
                }
                Map<String, String> g2 = rh4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.I0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = rh4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = rh4.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void i3() {
        FragmentActivity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (m = m()) != null && this.g0 == null) {
            wb4 wb4Var = new wb4(m, this.f0, 19, wo2.K(), new yk3());
            this.g0 = wb4Var;
            wb4Var.n(new i(this, m));
            x3();
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            wb4 wb4Var = this.g0;
            if (wb4Var != null && wb4Var.i()) {
                this.g0.A(wo2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                nv2.o(swanAppActionBar, this.K0 + this.J0);
            }
        }
    }

    public final String w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            String string = s().getString(R.string.obfuscated_res_0x7f0f154c);
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            if (TextUtils.isEmpty(str)) {
                return string;
            }
            PMSAppInfo u = md4.i().u(str);
            if (u != null && !TextUtils.isEmpty(u.statusDesc)) {
                return u.statusDesc;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void x3() {
        wb4 wb4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || (wb4Var = this.g0) == null) {
            return;
        }
        xb4 h2 = wb4Var.h(46);
        xb4 h3 = this.g0.h(47);
        if (h2 != null && this.J0 > 0) {
            h3.o(1);
            h3.n(this.J0);
        }
        if (h3 != null && this.K0 > 0) {
            h3.o(1);
            h3.n(this.K0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0273  */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j3(View view2) {
        String str;
        Activity activity;
        mq2 mq2Var;
        String str2;
        ForbiddenInfo forbiddenInfo;
        String w3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, view2) != null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090186);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090183);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090191);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090189);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090185);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090184);
        String str3 = this.G0;
        boolean z = true;
        if (str3 != null) {
            char c2 = 65535;
            switch (str3.hashCode()) {
                case -1869797338:
                    if (str3.equals("type_load_v8_failed")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1242268664:
                    if (str3.equals("type_need_update_sdk")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -429452284:
                    if (str3.equals("type_path_forbidden")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 38398066:
                    if (str3.equals("type_network_error")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 157273878:
                    if (str3.equals("type_app_forbidden")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 517286506:
                    if (str3.equals("type_0049")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 517347882:
                    if (str3.equals("type_2205")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 731215244:
                    if (str3.equals("type_normal")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ic3.w(this.I0, "offline");
                    w3 = w3();
                    imageView.setImageDrawable(s().getDrawable(R.drawable.obfuscated_res_0x7f08148a));
                    textView.setVisibility(8);
                    str = w3;
                    break;
                case 1:
                    ic3.w(this.I0, "pageblock");
                    if (TextUtils.isEmpty(this.I0.forbiddenInformation)) {
                        w3 = s().getString(R.string.obfuscated_res_0x7f0f1558);
                    } else {
                        w3 = this.I0.forbiddenInformation;
                    }
                    imageView.setImageDrawable(s().getDrawable(R.drawable.obfuscated_res_0x7f081487));
                    if (t3(this.G0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (l3()) {
                        textView.setVisibility(8);
                    }
                    str = w3;
                    break;
                case 2:
                    ic3.w(this.I0, "neterror");
                    w3 = h3(this.G0, "net_conn_failed");
                    imageView.setImageDrawable(s().getDrawable(R.drawable.obfuscated_res_0x7f081489));
                    if (t3(this.G0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = w3;
                    break;
                case 3:
                    ic3.w(this.I0, "commonerror");
                    w3 = h3(this.G0, "app_open_failed");
                    imageView.setImageDrawable(s().getDrawable(R.drawable.obfuscated_res_0x7f081488));
                    if (t3(this.G0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = w3;
                    break;
                case 4:
                    ic3.w(this.I0, StickerDataChangeType.UPDATE);
                    str = h3(this.G0, "app_need_upgrade");
                    if (t3(this.G0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    ic3.w(this.I0, "lackresources");
                    String h3 = h3(this.G0, "0049");
                    imageView.setImageDrawable(s().getDrawable(R.drawable.obfuscated_res_0x7f081486));
                    if (t3(this.G0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = h3;
                    break;
                case 6:
                    ic3.w(this.I0, "outdisk");
                    String h32 = h3(this.G0, "2205");
                    imageView.setImageDrawable(s().getDrawable(R.drawable.obfuscated_res_0x7f081486));
                    if (jj3.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (t3(this.G0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = h32;
                    break;
                case 7:
                    str = s().getString(R.string.obfuscated_res_0x7f0f01ae);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090188);
            if (TextUtils.isEmpty(str)) {
                str = s().getString(R.string.obfuscated_res_0x7f0f1557);
            }
            textView6.setText(str);
            activity = this.c0;
            if (!(activity instanceof SwanAppErrorActivity)) {
                mq2Var = ((SwanAppErrorActivity) activity).y();
            } else {
                mq2Var = null;
            }
            p53 c0 = p53.c0();
            if (mq2Var == null) {
                str2 = mq2Var.I();
            } else if (c0 != null) {
                str2 = c0.P();
            } else {
                str2 = null;
            }
            forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(J().getColor(R.color.obfuscated_res_0x7f06042d));
            }
            s3(textView, mq2Var);
            textView2.setOnClickListener(new b(this, mq2Var));
            if (jj3.G() && !TextUtils.equals(this.G0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, str2));
            }
            z = (this.O0 == 1 || TextUtils.isEmpty(this.N0)) ? false : false;
            if (!k3() && z && xh4.d()) {
                textView5.setVisibility(0);
                textView2.setVisibility(0);
                textView4.setVisibility(8);
                return;
            }
            textView5.setVisibility(8);
            textView2.setVisibility(8);
            textView4.setVisibility(0);
        }
        str = null;
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090188);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        activity = this.c0;
        if (!(activity instanceof SwanAppErrorActivity)) {
        }
        p53 c02 = p53.c0();
        if (mq2Var == null) {
        }
        forbiddenInfo = this.I0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(J().getColor(R.color.obfuscated_res_0x7f06042d));
        }
        s3(textView, mq2Var);
        textView2.setOnClickListener(new b(this, mq2Var));
        if (jj3.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, str2));
        }
        if (this.O0 == 1) {
        }
        if (!k3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public void o3(xb4 xb4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, xb4Var, activity) == null) {
            wo2.K().g(activity, xb4Var);
            j.a("notice", g3(), this.I0);
        }
    }

    public void p3(xb4 xb4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, xb4Var, activity) == null) {
            wo2.K().b(activity, xb4Var);
            j.a("notice", g3(), this.I0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void s3(TextView textView, mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, textView, mq2Var) == null) {
            if (TextUtils.equals(this.L0, "1")) {
                textView.setOnClickListener(new d(this, mq2Var));
            } else if (TextUtils.equals(this.L0, "2")) {
                textView.setOnClickListener(new e(this));
            } else if (TextUtils.equals(this.L0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.L0, "4")) {
                if (l3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f1550);
                textView.setOnClickListener(new h(this, mq2Var));
            }
        }
    }

    public final boolean t3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = rh4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(rh4.l(g2, substring))) {
                        this.L0 = rh4.l(g2, substring);
                        this.M0 = rh4.n(g2, substring);
                        return !TextUtils.equals(this.L0, "0");
                    }
                }
            }
            String l = rh4.l(g2, str2);
            this.L0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, "type_path_forbidden")) {
                    this.L0 = "4";
                } else if (TextUtils.equals(str, "type_2205")) {
                    this.L0 = "3";
                } else if (TextUtils.equals(str, "type_app_forbidden")) {
                    this.L0 = "0";
                } else if (TextUtils.equals(str, "type_load_v8_failed")) {
                    this.L0 = "0";
                } else {
                    this.L0 = "1";
                }
            }
            this.M0 = rh4.n(g2, str2);
            return !TextUtils.equals(this.L0, "0");
        }
        return invokeLL.booleanValue;
    }
}
