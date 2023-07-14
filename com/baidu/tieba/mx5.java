package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.mutiprocess.backbaidubox.BackBaiduBoxViewEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class mx5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<WeakReference<Activity>> a;
    public ArrayList<WeakReference<Activity>> b;
    public int c;
    public final CustomMessageListener d;
    public final j05 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947988063, "Lcom/baidu/tieba/mx5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947988063, "Lcom/baidu/tieba/mx5;");
        }
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mx5 mx5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int skinType;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304 || !(customResponsedMessage.getData() instanceof Integer) || this.a.c == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                return;
            }
            this.a.c = skinType;
            if (mx5.f) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends j05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx5 a;

        public b(mx5 mx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx5Var;
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && mx5.f) {
                mx5 mx5Var = this.a;
                if (mx5Var.j(mx5Var.l(activity))) {
                    this.a.a.add(new WeakReference(activity));
                }
            }
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                this.a.b.add(new WeakReference(activity));
            }
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference weakReference;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                Iterator it = this.a.b.iterator();
                while (true) {
                    if (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (weakReference.get() != null && weakReference.get() == activity) {
                            break;
                        }
                    } else {
                        weakReference = null;
                        break;
                    }
                }
                if (weakReference != null) {
                    this.a.b.remove(weakReference);
                }
            }
        }

        @Override // com.baidu.tieba.j05, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && mx5.f) {
                mx5 mx5Var = this.a;
                if (mx5Var.t(mx5Var.l(activity))) {
                    WeakReference weakReference = null;
                    Iterator it = this.a.a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WeakReference weakReference2 = (WeakReference) it.next();
                        if (activity != null && activity == weakReference2.get()) {
                            weakReference = weakReference2;
                            break;
                        }
                    }
                    if (weakReference != null) {
                        this.a.a.remove(weakReference);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx5 a;

        public c(mx5 mx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mx5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q(view2.getContext());
                this.a.u(false);
                this.a.k();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final mx5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-589231457, "Lcom/baidu/tieba/mx5$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-589231457, "Lcom/baidu/tieba/mx5$d;");
                    return;
                }
            }
            a = new mx5(null);
        }
    }

    public mx5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.c = TbadkCoreApplication.getInst().getSkinType();
        this.d = new a(this, 2001304);
        this.e = new b(this);
        MessageManager.getInstance().registerListener(this.d);
    }

    public final void r() {
        FrameLayout l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<WeakReference<Activity>> it = this.a.iterator();
            while (it.hasNext()) {
                WeakReference<Activity> next = it.next();
                if (next != null && next.get() != null && !next.get().isFinishing() && (l = l(next.get())) != null) {
                    Object tag = l.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                    if (tag instanceof ViewGroup) {
                        o((ViewGroup) tag, l.getContext());
                    }
                }
            }
        }
    }

    public /* synthetic */ mx5(a aVar) {
        this();
    }

    public final ViewGroup n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_baiduboxapp_back_view, (ViewGroup) null);
            o(viewGroup, context);
            return viewGroup;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public final boolean p(View view2) {
        InterceptResult invokeL;
        IBinder windowToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 != null && (windowToken = view2.getWindowToken()) != null) {
                try {
                    if (windowToken.isBinderAlive()) {
                        if (windowToken.pingBinder()) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void s(Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, application) != null) || application == null) {
            return;
        }
        try {
            application.registerActivityLifecycleCallbacks(this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final mx5 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return d.a;
        }
        return (mx5) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BackBaiduBoxViewEvent backBaiduBoxViewEvent = new BackBaiduBoxViewEvent();
            backBaiduBoxViewEvent.isShow = f;
            wq5.i(backBaiduBoxViewEvent);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            yi.Q(TbadkCoreApplication.getInst(), R.string.not_install_baidu_box_app_tip);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    public final boolean j(FrameLayout frameLayout) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, frameLayout)) == null) {
            if (frameLayout == null) {
                return false;
            }
            try {
                Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                ViewGroup viewGroup2 = 0;
                if (tag instanceof ViewGroup) {
                    viewGroup = (ViewGroup) tag;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null && viewGroup.getParent() != null) {
                    if (viewGroup.getParent() == frameLayout) {
                        return false;
                    }
                    frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                } else {
                    viewGroup2 = viewGroup;
                }
                if (viewGroup2 == null) {
                    viewGroup2 = n(frameLayout.getContext());
                }
                if (viewGroup2 == null) {
                    return false;
                }
                frameLayout.addView(viewGroup2);
                frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, viewGroup2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds339), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds89));
                layoutParams.gravity = 83;
                layoutParams.bottomMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds442) + UtilHelper.getNavigationBarHeight(frameLayout.getContext());
                viewGroup2.setLayoutParams(layoutParams);
                c cVar = new c(this);
                viewGroup2.setClickable(true);
                viewGroup2.setOnClickListener(cVar);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && f != z) {
            f = z;
            if (z) {
                Iterator<WeakReference<Activity>> it = this.b.iterator();
                while (it.hasNext()) {
                    WeakReference<Activity> next = it.next();
                    if (next.get() != null && !next.get().isFinishing()) {
                        Activity activity = next.get();
                        if (j(l(activity))) {
                            this.a.add(new WeakReference<>(activity));
                        }
                    }
                }
                return;
            }
            Iterator<WeakReference<Activity>> it2 = this.b.iterator();
            while (it2.hasNext()) {
                WeakReference<Activity> next2 = it2.next();
                if (next2.get() != null && !next2.get().isFinishing()) {
                    t(l(next2.get()));
                }
            }
            this.a.clear();
        }
    }

    public final FrameLayout l(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity != null) {
                try {
                    if (!activity.isFinishing() && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                        View decorView = activity.getWindow().getDecorView();
                        if (!(decorView instanceof FrameLayout)) {
                            return null;
                        }
                        return (FrameLayout) decorView;
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (FrameLayout) invokeL.objValue;
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("baiduboxapp://donothing"));
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                context.startActivity(intent);
            } else {
                v();
            }
        } catch (Exception unused) {
            v();
        }
    }

    public final void o(ViewGroup viewGroup, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, viewGroup, context) == null) && viewGroup != null && context != null) {
            SkinManager.setViewTextColor((TextView) viewGroup.findViewById(R.id.tv_back_shoubai_text), (int) R.color.CAM_X0101);
            float g = yi.g(context, R.dimen.tbds424);
            TBSelector.makeDrawableSelector().setShape(0).setType(1).trRadius(g).brRadius(g).defaultColor(R.color.topic_disagree_des_color).into(viewGroup);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.shoubai_back_icon), R.drawable.ic_icon_pure_list_arrow16_left_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange((ImageView) viewGroup.findViewById(R.id.shoubai_logo_icon), R.drawable.ic_icon_mask_home_backbtn_logo_n_svg, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final boolean t(FrameLayout frameLayout) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, frameLayout)) == null) {
            if (frameLayout == null) {
                return false;
            }
            try {
                Object tag = frameLayout.getTag(R.id.tag_scheme_baidu_box_app_back_view);
                if (tag instanceof ViewGroup) {
                    viewGroup = (ViewGroup) tag;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null && viewGroup.getParent() != null && viewGroup.getParent() == frameLayout && p(frameLayout) && p(viewGroup)) {
                    frameLayout.removeView(viewGroup);
                    frameLayout.setTag(R.id.tag_scheme_baidu_box_app_back_view, null);
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
