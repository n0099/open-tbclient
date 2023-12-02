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
import com.baidu.tieba.y52;
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
public class r52 extends q52 {
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

    @Override // com.baidu.tieba.q52
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
            public final /* synthetic */ md3 a;

            public a(md3 md3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {md3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = md3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    rc3.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, hr2 hr2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, hr2Var, forbiddenInfo) == null) {
                md3 md3Var = new md3();
                md3Var.f = forbiddenInfo.appId;
                md3Var.g = "errormenu";
                md3Var.b = "click";
                md3Var.e = str;
                md3Var.c = forbiddenInfo.launchSource;
                md3Var.b(dd3.k(hr2Var.X()));
                md3Var.d(hr2Var.t0().getString("ubc"));
                ej3.j(new a(md3Var), "SwanAppFuncClickUBC");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r52 a;

        public a(r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r52Var;
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
        public final /* synthetic */ hr2 a;
        public final /* synthetic */ r52 b;

        public b(r52 r52Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r52Var;
            this.a = hr2Var;
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
        public final /* synthetic */ r52 b;

        public c(r52 r52Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r52Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.I0 != null && !TextUtils.isEmpty(this.b.I0.forbiddenDetail)) {
                rp2.u().b(this.b.n(), this.a, this.b.I0.appTitle, this.b.I0.forbiddenDetail);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr2 a;
        public final /* synthetic */ r52 b;

        public d(r52 r52Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r52Var;
            this.a = hr2Var;
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
        public final /* synthetic */ r52 a;

        public e(r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.M0)) {
                Activity activity = this.a.c0;
                if (activity instanceof FragmentActivity) {
                    fk4 k = ((FragmentActivity) activity).k();
                    y52.d i3 = y52.i3(this.a.M0);
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
        public final /* synthetic */ r52 a;

        public f(r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity n = this.a.n();
                if (!(n instanceof SwanAppClearCacheErrorActivity)) {
                    if (!q52.F0) {
                        return;
                    }
                    throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                }
                ((SwanAppClearCacheErrorActivity) n).G();
                try {
                    this.a.q1(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    k32.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r52 a;

        public g(r52 r52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hr2 a;
        public final /* synthetic */ r52 b;

        public h(r52 r52Var, hr2 hr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var, hr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r52Var;
            this.a = hr2Var;
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
    public class i implements pc4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ r52 b;

        public i(r52 r52Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r52Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r52Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.pc4
        public boolean b(View view2, sc4 sc4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, sc4Var)) == null) {
                int c = sc4Var.c();
                if (c != 5) {
                    if (c != 9) {
                        if (c != 39) {
                            if (c != 46) {
                                if (c == 47) {
                                    this.b.p3(sc4Var, this.a);
                                }
                            } else {
                                this.b.o3(sc4Var, this.a);
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

    public r52() {
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

    public final hr2 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (n() != null && (n() instanceof SwanAppErrorActivity)) {
                return ((SwanAppErrorActivity) n()).z();
            }
            return null;
        }
        return (hr2) invokeV.objValue;
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList<String> a2 = si4.b().a();
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
            if (forbiddenInfo != null && ek3.I(forbiddenInfo.launchPath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q52
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            i3();
            u3();
            x3();
            v3();
        }
    }

    public final void u3() {
        rc4 rc4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (rc4Var = this.g0) != null) {
            rc4Var.r(rp2.M().a());
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            j.a("menu", g3(), this.I0);
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            return d3();
        }
        return invokeL.booleanValue;
    }

    public void n3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            rp2.K().h(activity, f3(activity));
            j.a("feedback", g3(), this.I0);
        }
    }

    public void q3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, activity) == null) {
            aw2.j(activity);
            j.a("daynightmode", g3(), this.I0);
        }
    }

    public void r3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                aw2.t(activity);
            }
            j.a(Headers.REFRESH, g3(), this.I0);
        }
    }

    public static r52 m3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            r52 r52Var = new r52();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            r52Var.m1(bundle);
            return r52Var;
        }
        return (r52) invokeCommon.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00ab, viewGroup, false);
            j3(inflate);
            a2(inflate);
            if (Z1()) {
                return c2(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.q52
    public void a2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.a2(view2);
            b2(view2);
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
            Map<String, String> g2 = mi4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = mi4.m(g2, str2.substring(str2.length() - 4));
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
                                String m2 = mi4.m(g2, "2205");
                                if (TextUtils.isEmpty(m2)) {
                                    return d0(R.string.obfuscated_res_0x7f0f1576);
                                }
                                return m2;
                            }
                            String m3 = mi4.m(g2, "0049");
                            if (TextUtils.isEmpty(m3)) {
                                return d0(R.string.obfuscated_res_0x7f0f1578);
                            }
                            return m3;
                        }
                        String m4 = mi4.m(g2, "app_page_banned");
                        if (TextUtils.isEmpty(m4)) {
                            return d0(R.string.obfuscated_res_0x7f0f1577);
                        }
                        return m4;
                    }
                    String m5 = mi4.m(g2, "app_need_upgrade");
                    if (TextUtils.isEmpty(m5)) {
                        return d0(R.string.obfuscated_res_0x7f0f1578);
                    }
                    return m5;
                }
                String m6 = mi4.m(g2, "app_open_failed");
                if (TextUtils.isEmpty(m6)) {
                    return d0(R.string.obfuscated_res_0x7f0f1578);
                }
                return m6;
            }
            String m7 = mi4.m(g2, "net_conn_failed");
            if (TextUtils.isEmpty(m7)) {
                return d0(R.string.obfuscated_res_0x7f0f1578);
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
                ForbiddenInfo y = ((SwanAppErrorActivity) activity).y();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", y.appTitle);
                    jSONObject.put("url", y.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, y.appId);
                    jSONObject.put("errorPath", y.launchPath);
                    jSONObject.put("errorDes", y.forbiddenReason);
                } catch (JSONException e2) {
                    if (q52.F0) {
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
    public void x0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.x0(bundle);
            Bundle r = r();
            if (r == null) {
                return;
            }
            this.G0 = r.getString("swan_error_type");
            this.H0 = r.getString("swan_error_code");
            this.N0 = r.getString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
            this.O0 = r.getInt("webPermit");
            this.I0 = (ForbiddenInfo) r.getParcelable("key_forbidden_info");
            this.J0 = r.getInt("key_show_menu_notice");
            this.K0 = r.getInt("key_show_menu_privacy");
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
                                        str3 = z().getString(R.string.obfuscated_res_0x7f0f1579);
                                    }
                                } else {
                                    str3 = z().getString(R.string.obfuscated_res_0x7f0f157c);
                                }
                            } else {
                                str3 = z().getString(R.string.obfuscated_res_0x7f0f1580);
                            }
                        } else {
                            str3 = z().getString(R.string.obfuscated_res_0x7f0f157d);
                        }
                    } else {
                        str3 = z().getString(R.string.obfuscated_res_0x7f0f157f);
                    }
                } else {
                    str3 = z().getString(R.string.obfuscated_res_0x7f0f15d5);
                }
                Map<String, String> g2 = mi4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.I0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = mi4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = mi4.o(g2, str2);
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
        FragmentActivity n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (n = n()) != null && this.g0 == null) {
            rc4 rc4Var = new rc4(n, this.f0, 19, rp2.K(), new tl3());
            this.g0 = rc4Var;
            rc4Var.n(new i(this, n));
            x3();
        }
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            rc4 rc4Var = this.g0;
            if (rc4Var != null && rc4Var.i()) {
                this.g0.A(rp2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                iw2.o(swanAppActionBar, this.K0 + this.J0);
            }
        }
    }

    public final String w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            String string = z().getString(R.string.obfuscated_res_0x7f0f1574);
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            if (TextUtils.isEmpty(str)) {
                return string;
            }
            PMSAppInfo u = he4.i().u(str);
            if (u != null && !TextUtils.isEmpty(u.statusDesc)) {
                return u.statusDesc;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void x3() {
        rc4 rc4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (rc4Var = this.g0) == null) {
            return;
        }
        sc4 h2 = rc4Var.h(46);
        sc4 h3 = this.g0.h(47);
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
        hr2 hr2Var;
        String str2;
        ForbiddenInfo forbiddenInfo;
        String w3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, view2) != null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090199);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090196);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901a4);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09019c);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090198);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090197);
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
                    dd3.w(this.I0, "offline");
                    w3 = w3();
                    imageView.setImageDrawable(z().getDrawable(R.drawable.obfuscated_res_0x7f0814c7));
                    textView.setVisibility(8);
                    str = w3;
                    break;
                case 1:
                    dd3.w(this.I0, "pageblock");
                    if (TextUtils.isEmpty(this.I0.forbiddenInformation)) {
                        w3 = z().getString(R.string.obfuscated_res_0x7f0f1580);
                    } else {
                        w3 = this.I0.forbiddenInformation;
                    }
                    imageView.setImageDrawable(z().getDrawable(R.drawable.obfuscated_res_0x7f0814c4));
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
                    dd3.w(this.I0, "neterror");
                    w3 = h3(this.G0, "net_conn_failed");
                    imageView.setImageDrawable(z().getDrawable(R.drawable.obfuscated_res_0x7f0814c6));
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
                    dd3.w(this.I0, "commonerror");
                    w3 = h3(this.G0, "app_open_failed");
                    imageView.setImageDrawable(z().getDrawable(R.drawable.obfuscated_res_0x7f0814c5));
                    if (t3(this.G0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = w3;
                    break;
                case 4:
                    dd3.w(this.I0, StickerDataChangeType.UPDATE);
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
                    dd3.w(this.I0, "lackresources");
                    String h3 = h3(this.G0, "0049");
                    imageView.setImageDrawable(z().getDrawable(R.drawable.obfuscated_res_0x7f0814c3));
                    if (t3(this.G0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(e3(this.G0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = h3;
                    break;
                case 6:
                    dd3.w(this.I0, "outdisk");
                    String h32 = h3(this.G0, "2205");
                    imageView.setImageDrawable(z().getDrawable(R.drawable.obfuscated_res_0x7f0814c3));
                    if (ek3.G()) {
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
                    str = z().getString(R.string.obfuscated_res_0x7f0f01b6);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09019b);
            if (TextUtils.isEmpty(str)) {
                str = z().getString(R.string.obfuscated_res_0x7f0f157f);
            }
            textView6.setText(str);
            activity = this.c0;
            if (!(activity instanceof SwanAppErrorActivity)) {
                hr2Var = ((SwanAppErrorActivity) activity).z();
            } else {
                hr2Var = null;
            }
            k63 c0 = k63.c0();
            if (hr2Var == null) {
                str2 = hr2Var.I();
            } else if (c0 != null) {
                str2 = c0.P();
            } else {
                str2 = null;
            }
            forbiddenInfo = this.I0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(L().getColor(R.color.obfuscated_res_0x7f060430));
            }
            s3(textView, hr2Var);
            textView2.setOnClickListener(new b(this, hr2Var));
            if (ek3.G() && !TextUtils.equals(this.G0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, str2));
            }
            z = (this.O0 == 1 || TextUtils.isEmpty(this.N0)) ? false : false;
            if (!k3() && z && si4.d()) {
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
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09019b);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        activity = this.c0;
        if (!(activity instanceof SwanAppErrorActivity)) {
        }
        k63 c02 = k63.c0();
        if (hr2Var == null) {
        }
        forbiddenInfo = this.I0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.I0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(L().getColor(R.color.obfuscated_res_0x7f060430));
        }
        s3(textView, hr2Var);
        textView2.setOnClickListener(new b(this, hr2Var));
        if (ek3.G()) {
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

    public void o3(sc4 sc4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, sc4Var, activity) == null) {
            rp2.K().g(activity, sc4Var);
            j.a("notice", g3(), this.I0);
        }
    }

    public void p3(sc4 sc4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, sc4Var, activity) == null) {
            rp2.K().b(activity, sc4Var);
            j.a("notice", g3(), this.I0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void s3(TextView textView, hr2 hr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, textView, hr2Var) == null) {
            if (TextUtils.equals(this.L0, "1")) {
                textView.setOnClickListener(new d(this, hr2Var));
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
                textView.setText(R.string.obfuscated_res_0x7f0f1578);
                textView.setOnClickListener(new h(this, hr2Var));
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
            Map<String, String> g2 = mi4.f().g();
            ForbiddenInfo forbiddenInfo = this.I0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(mi4.l(g2, substring))) {
                        this.L0 = mi4.l(g2, substring);
                        this.M0 = mi4.n(g2, substring);
                        return !TextUtils.equals(this.L0, "0");
                    }
                }
            }
            String l = mi4.l(g2, str2);
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
            this.M0 = mi4.n(g2, str2);
            return !TextUtils.equals(this.L0, "0");
        }
        return invokeLL.booleanValue;
    }
}
