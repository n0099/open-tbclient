package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
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
import com.baidu.tieba.s32;
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
/* loaded from: classes5.dex */
public class l32 extends k32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String F0;
    public String G0;
    public ForbiddenInfo H0;
    public int I0;
    public int J0;
    public String K0;
    public String L0;
    public String M0;
    public int N0;

    @Override // com.baidu.tieba.k32
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gb3 a;

            public a(gb3 gb3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gb3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gb3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    la3.i("934", "85", this.a.f());
                }
            }
        }

        public static void a(String str, bp2 bp2Var, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65536, null, str, bp2Var, forbiddenInfo) == null) {
                gb3 gb3Var = new gb3();
                gb3Var.f = forbiddenInfo.appId;
                gb3Var.g = "errormenu";
                gb3Var.b = "click";
                gb3Var.e = str;
                gb3Var.c = forbiddenInfo.launchSource;
                gb3Var.b(xa3.k(bp2Var.W()));
                gb3Var.d(bp2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                yg3.j(new a(gb3Var), "SwanAppFuncClickUBC");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l32 a;

        public a(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l32Var;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ l32 b;

        public b(l32 l32Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l32Var;
            this.a = bp2Var;
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ l32 b;

        public c(l32 l32Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l32Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.H0 != null && !TextUtils.isEmpty(this.b.H0.forbiddenDetail)) {
                ln2.u().b(this.b.getActivity(), this.a, this.b.H0.appTitle, this.b.H0.forbiddenDetail);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ l32 b;

        public d(l32 l32Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l32Var;
            this.a = bp2Var;
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

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l32 a;

        public e(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l32Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.L0)) {
                Activity activity = this.a.c0;
                if (activity instanceof FragmentActivity) {
                    ai4 l = ((FragmentActivity) activity).l();
                    s32.d b3 = s32.b3(this.a.L0);
                    b3.a(false);
                    b3.c(l);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l32 a;

        public f(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l32Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FragmentActivity activity = this.a.getActivity();
                if (!(activity instanceof SwanAppClearCacheErrorActivity)) {
                    if (!k32.E0) {
                        return;
                    }
                    throw new IllegalStateException("非SwanAppClearCacheErrorActivity");
                }
                ((SwanAppClearCacheErrorActivity) activity).E();
                try {
                    this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("baiduboxapp://v16/ucenter/cleanCache")));
                } catch (Exception e) {
                    e12.l("SwanAppErrorFragment", "打开清理缓存界面失败", e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l32 a;

        public g(l32 l32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l32Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.P1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bp2 a;
        public final /* synthetic */ l32 b;

        public h(l32 l32Var, bp2 bp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var, bp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l32Var;
            this.a = bp2Var;
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

    /* loaded from: classes5.dex */
    public class i implements ja4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ l32 b;

        public i(l32 l32Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l32Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l32Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.ja4
        public boolean b(View view2, ma4 ma4Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, ma4Var)) == null) {
                int c = ma4Var.c();
                if (c != 5) {
                    if (c != 9) {
                        if (c != 39) {
                            if (c != 46) {
                                if (c == 47) {
                                    this.b.i3(ma4Var, this.a);
                                }
                            } else {
                                this.b.h3(ma4Var, this.a);
                            }
                        } else {
                            this.b.k3(this.a);
                        }
                    } else {
                        this.b.g3(this.a);
                        return true;
                    }
                } else {
                    this.b.j3(this.a);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public l32() {
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

    public final boolean W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null) {
                return false;
            }
            return forbiddenInfo.enableSliding();
        }
        return invokeV.booleanValue;
    }

    public final bp2 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getActivity() != null && (getActivity() instanceof SwanAppErrorActivity)) {
                return ((SwanAppErrorActivity) getActivity()).x();
            }
            return null;
        }
        return (bp2) invokeV.objValue;
    }

    public final boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> a2 = mg4.b().a();
            if (a2 != null && a2.contains(this.G0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null && yh3.I(forbiddenInfo.launchPath)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b3();
            n3();
            q3();
            o3();
        }
    }

    public final void n3() {
        la4 la4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (la4Var = this.g0) != null) {
            la4Var.s(ln2.M().a());
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            j.a(SupportMenuInflater.XML_MENU, Z2(), this.H0);
        }
    }

    public void g3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            ln2.K().h(activity, Y2(activity));
            j.a("feedback", Z2(), this.H0);
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            return W2();
        }
        return invokeL.booleanValue;
    }

    public void j3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, activity) == null) {
            ut2.j(activity);
            j.a("daynightmode", Z2(), this.H0);
        }
    }

    public void k3(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ut2.t(activity);
            }
            j.a("refresh", Z2(), this.H0);
        }
    }

    public static l32 f3(String str, String str2, String str3, int i2, ForbiddenInfo forbiddenInfo, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i2), forbiddenInfo, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            l32 l32Var = new l32();
            Bundle bundle = new Bundle();
            bundle.putString("swan_error_type", str2);
            bundle.putString("swan_error_code", str);
            bundle.putString(DeepLinkItem.DEEPLINK_WEBURL_KEY, str3);
            bundle.putInt("webPermit", i2);
            bundle.putParcelable("key_forbidden_info", forbiddenInfo);
            bundle.putInt("key_show_menu_notice", i3);
            bundle.putInt("key_show_menu_privacy", i4);
            l32Var.j1(bundle);
            return l32Var;
        }
        return (l32) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.k32
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.U1(view2);
            V1(view2);
            t2(-1);
            C2(-16777216);
            x2(false);
            J2(true);
            this.f0.setRightExitOnClickListener(new a(this));
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.appTitle)) {
                v2(this.H0.appTitle);
            }
        }
    }

    public final CharSequence X2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            Map<String, String> g2 = gg4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str2 = forbiddenInfo.forbiddenDetail;
                if (str2.length() > 4) {
                    String m = gg4.m(g2, str2.substring(str2.length() - 4));
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
                                String m2 = gg4.m(g2, "2205");
                                if (TextUtils.isEmpty(m2)) {
                                    return S(R.string.obfuscated_res_0x7f0f1340);
                                }
                                return m2;
                            }
                            String m3 = gg4.m(g2, "0049");
                            if (TextUtils.isEmpty(m3)) {
                                return S(R.string.obfuscated_res_0x7f0f1342);
                            }
                            return m3;
                        }
                        String m4 = gg4.m(g2, "app_page_banned");
                        if (TextUtils.isEmpty(m4)) {
                            return S(R.string.obfuscated_res_0x7f0f1341);
                        }
                        return m4;
                    }
                    String m5 = gg4.m(g2, "app_need_upgrade");
                    if (TextUtils.isEmpty(m5)) {
                        return S(R.string.obfuscated_res_0x7f0f1342);
                    }
                    return m5;
                }
                String m6 = gg4.m(g2, "app_open_failed");
                if (TextUtils.isEmpty(m6)) {
                    return S(R.string.obfuscated_res_0x7f0f1342);
                }
                return m6;
            }
            String m7 = gg4.m(g2, "net_conn_failed");
            if (TextUtils.isEmpty(m7)) {
                return S(R.string.obfuscated_res_0x7f0f1342);
            }
            return m7;
        }
        return (CharSequence) invokeL.objValue;
    }

    public final JSONObject Y2(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof SwanAppErrorActivity) {
                ForbiddenInfo w = ((SwanAppErrorActivity) activity).w();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("title", w.appTitle);
                    jSONObject.put("url", w.launchPath);
                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, w.appId);
                    jSONObject.put("errorPath", w.launchPath);
                    jSONObject.put("errorDes", w.forbiddenReason);
                } catch (JSONException e2) {
                    if (k32.E0) {
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
    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            super.u0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.F0 = p.getString("swan_error_type");
            this.G0 = p.getString("swan_error_code");
            this.M0 = p.getString(DeepLinkItem.DEEPLINK_WEBURL_KEY);
            this.N0 = p.getInt("webPermit");
            this.H0 = (ForbiddenInfo) p.getParcelable("key_forbidden_info");
            this.I0 = p.getInt("key_show_menu_notice");
            this.J0 = p.getInt("key_show_menu_privacy");
        }
    }

    public final String a3(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
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
                                        str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1343);
                                    }
                                } else {
                                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1346);
                                }
                            } else {
                                str3 = getContext().getString(R.string.obfuscated_res_0x7f0f134a);
                            }
                        } else {
                            str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1347);
                        }
                    } else {
                        str3 = getContext().getString(R.string.obfuscated_res_0x7f0f1349);
                    }
                } else {
                    str3 = getContext().getString(R.string.obfuscated_res_0x7f0f139f);
                }
                Map<String, String> g2 = gg4.f().g();
                if (g2 != null) {
                    ForbiddenInfo forbiddenInfo = this.H0;
                    if (forbiddenInfo != null) {
                        String str4 = forbiddenInfo.forbiddenDetail;
                        if (str4.length() > 4) {
                            String o = gg4.o(g2, str4.substring(str4.length() - 4));
                            if (!TextUtils.isEmpty(o)) {
                                return o;
                            }
                        }
                    }
                    String o2 = gg4.o(g2, str2);
                    if (!TextUtils.isEmpty(o2)) {
                        return o2;
                    }
                }
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public void b3() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (activity = getActivity()) != null && this.g0 == null) {
            la4 la4Var = new la4(activity, this.f0, 19, ln2.K(), new nj3());
            this.g0 = la4Var;
            la4Var.n(new i(this, activity));
            q3();
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            la4 la4Var = this.g0;
            if (la4Var != null && la4Var.i()) {
                this.g0.B(ln2.M().a());
            }
            SwanAppActionBar swanAppActionBar = this.f0;
            if (swanAppActionBar != null) {
                cu2.o(swanAppActionBar, this.J0 + this.I0);
            }
        }
    }

    public final String p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String string = getContext().getString(R.string.obfuscated_res_0x7f0f133e);
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo == null) {
                return string;
            }
            String str = forbiddenInfo.appId;
            if (TextUtils.isEmpty(str)) {
                return string;
            }
            PMSAppInfo u = bc4.i().u(str);
            if (u != null && !TextUtils.isEmpty(u.statusDesc)) {
                return u.statusDesc;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void q3() {
        la4 la4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048602, this) != null) || (la4Var = this.g0) == null) {
            return;
        }
        ma4 h2 = la4Var.h(46);
        ma4 h3 = this.g0.h(47);
        if (h2 != null && this.I0 > 0) {
            h3.o(1);
            h3.n(this.I0);
        }
        if (h3 != null && this.J0 > 0) {
            h3.o(1);
            h3.n(this.J0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x027c  */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c3(View view2) {
        String str;
        Activity activity;
        bp2 bp2Var;
        String str2;
        ForbiddenInfo forbiddenInfo;
        String p3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || view2 == null) {
            return;
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090180);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017d);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09018b);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090183);
        TextView textView4 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017f);
        TextView textView5 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09017e);
        String str3 = this.F0;
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
                    xa3.w(this.H0, "offline");
                    p3 = p3();
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f08120a));
                    textView.setVisibility(8);
                    str = p3;
                    break;
                case 1:
                    xa3.w(this.H0, "pageblock");
                    if (TextUtils.isEmpty(this.H0.forbiddenInformation)) {
                        p3 = getContext().getString(R.string.obfuscated_res_0x7f0f134a);
                    } else {
                        p3 = this.H0.forbiddenInformation;
                    }
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081207));
                    if (m3(this.F0, "app_page_banned")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (e3()) {
                        textView.setVisibility(8);
                    }
                    str = p3;
                    break;
                case 2:
                    xa3.w(this.H0, "neterror");
                    p3 = a3(this.F0, "net_conn_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081209));
                    if (m3(this.F0, "net_conn_failed")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    textView3.setVisibility(8);
                    str = p3;
                    break;
                case 3:
                    xa3.w(this.H0, "commonerror");
                    p3 = a3(this.F0, "app_open_failed");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081208));
                    if (m3(this.F0, "app_open_failed")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = p3;
                    break;
                case 4:
                    xa3.w(this.H0, StickerDataChangeType.UPDATE);
                    str = a3(this.F0, "app_need_upgrade");
                    if (m3(this.F0, "app_need_upgrade")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                        break;
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                case 5:
                    xa3.w(this.H0, "lackresources");
                    String a3 = a3(this.F0, "0049");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081206));
                    if (m3(this.F0, "0049")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = a3;
                    break;
                case 6:
                    xa3.w(this.H0, "outdisk");
                    String a32 = a3(this.F0, "2205");
                    imageView.setImageDrawable(getContext().getDrawable(R.drawable.obfuscated_res_0x7f081206));
                    if (yh3.G()) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    if (m3(this.F0, "2205")) {
                        textView.setVisibility(0);
                        textView.setText(X2(this.F0));
                    } else {
                        textView.setVisibility(8);
                    }
                    str = a32;
                    break;
                case 7:
                    str = getContext().getString(R.string.obfuscated_res_0x7f0f0182);
                    textView.setVisibility(8);
                    break;
            }
            TextView textView6 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090182);
            if (TextUtils.isEmpty(str)) {
                str = getContext().getString(R.string.obfuscated_res_0x7f0f1349);
            }
            textView6.setText(str);
            activity = this.c0;
            if (!(activity instanceof SwanAppErrorActivity)) {
                bp2Var = ((SwanAppErrorActivity) activity).x();
            } else {
                bp2Var = null;
            }
            e43 b0 = e43.b0();
            if (bp2Var == null) {
                str2 = bp2Var.H();
            } else if (b0 != null) {
                str2 = b0.O();
            } else {
                str2 = null;
            }
            forbiddenInfo = this.H0;
            if (forbiddenInfo != null && !TextUtils.isEmpty(forbiddenInfo.forbiddenDetail)) {
                textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
                textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603bc));
            }
            l3(textView, bp2Var);
            textView2.setOnClickListener(new b(this, bp2Var));
            if (yh3.G() && !TextUtils.equals(this.F0, "type_network_error")) {
                textView4.setVisibility(0);
                textView4.setOnClickListener(new c(this, str2));
            }
            z = (this.N0 == 1 || TextUtils.isEmpty(this.M0)) ? false : false;
            if (!d3() && z && mg4.d()) {
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
        TextView textView62 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090182);
        if (TextUtils.isEmpty(str)) {
        }
        textView62.setText(str);
        activity = this.c0;
        if (!(activity instanceof SwanAppErrorActivity)) {
        }
        e43 b02 = e43.b0();
        if (bp2Var == null) {
        }
        forbiddenInfo = this.H0;
        if (forbiddenInfo != null) {
            textView3.setText("(" + this.H0.forbiddenDetail + SmallTailInfo.EMOTION_SUFFIX);
            textView3.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0603bc));
        }
        l3(textView, bp2Var);
        textView2.setOnClickListener(new b(this, bp2Var));
        if (yh3.G()) {
            textView4.setVisibility(0);
            textView4.setOnClickListener(new c(this, str2));
        }
        if (this.N0 == 1) {
        }
        if (!d3()) {
        }
        textView5.setVisibility(8);
        textView2.setVisibility(8);
        textView4.setVisibility(0);
    }

    public void h3(ma4 ma4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, ma4Var, activity) == null) {
            ln2.K().g(activity, ma4Var);
            j.a("notice", Z2(), this.H0);
        }
    }

    public void i3(ma4 ma4Var, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, ma4Var, activity) == null) {
            ln2.K().b(activity, ma4Var);
            j.a("notice", Z2(), this.H0);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void l3(TextView textView, bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, textView, bp2Var) == null) {
            if (TextUtils.equals(this.K0, "1")) {
                textView.setOnClickListener(new d(this, bp2Var));
            } else if (TextUtils.equals(this.K0, "2")) {
                textView.setOnClickListener(new e(this));
            } else if (TextUtils.equals(this.K0, "3")) {
                textView.setOnClickListener(new f(this));
            } else if (TextUtils.equals(this.K0, "4")) {
                if (e3()) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new g(this));
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f1342);
                textView.setOnClickListener(new h(this, bp2Var));
            }
        }
    }

    public final boolean m3(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Map<String, String> g2 = gg4.f().g();
            ForbiddenInfo forbiddenInfo = this.H0;
            if (forbiddenInfo != null) {
                String str3 = forbiddenInfo.forbiddenDetail;
                if (str3.length() > 4) {
                    String substring = str3.substring(str3.length() - 4);
                    if (!TextUtils.isEmpty(gg4.l(g2, substring))) {
                        this.K0 = gg4.l(g2, substring);
                        this.L0 = gg4.n(g2, substring);
                        return !TextUtils.equals(this.K0, "0");
                    }
                }
            }
            String l = gg4.l(g2, str2);
            this.K0 = l;
            if (TextUtils.isEmpty(l)) {
                if (TextUtils.equals(str, "type_path_forbidden")) {
                    this.K0 = "4";
                } else if (TextUtils.equals(str, "type_2205")) {
                    this.K0 = "3";
                } else if (TextUtils.equals(str, "type_app_forbidden")) {
                    this.K0 = "0";
                } else if (TextUtils.equals(str, "type_load_v8_failed")) {
                    this.K0 = "0";
                } else {
                    this.K0 = "1";
                }
            }
            this.L0 = gg4.n(g2, str2);
            return !TextUtils.equals(this.K0, "0");
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048604, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00a3, viewGroup, false);
            c3(inflate);
            U1(inflate);
            if (T1()) {
                return W1(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
