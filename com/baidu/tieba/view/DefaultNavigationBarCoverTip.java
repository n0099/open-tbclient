package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.n.g;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class DefaultNavigationBarCoverTip extends NavigationBarCoverTip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity l;
    public View m;
    public String n;
    public View.OnClickListener o;
    public final g p;
    public NavigationBarCoverTip.e q;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultNavigationBarCoverTip f49228e;

        public a(DefaultNavigationBarCoverTip defaultNavigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultNavigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49228e = defaultNavigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49228e.hideTip();
                if (this.f49228e.l == null || TextUtils.isEmpty(this.f49228e.n) || (tbPageContext = UtilHelper.getTbPageContext(this.f49228e.l)) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f49228e.n});
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultNavigationBarCoverTip f49229e;

        public b(DefaultNavigationBarCoverTip defaultNavigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultNavigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49229e = defaultNavigationBarCoverTip;
        }

        @Override // c.a.t0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.f49229e.l) {
                this.f49229e.setCoverTipListener(null);
                this.f49229e.l();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements NavigationBarCoverTip.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultNavigationBarCoverTip a;

        public c(DefaultNavigationBarCoverTip defaultNavigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultNavigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultNavigationBarCoverTip;
        }

        @Override // com.baidu.tieba.view.NavigationBarCoverTip.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }

        @Override // com.baidu.tieba.view.NavigationBarCoverTip.e
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultNavigationBarCoverTip(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.l = activity;
        m();
        setCoverTipListener(this.q);
    }

    public static DefaultNavigationBarCoverTip makeText(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            DefaultNavigationBarCoverTip defaultNavigationBarCoverTip = new DefaultNavigationBarCoverTip(TbadkCoreApplication.getInst().getCurrentActivity());
            defaultNavigationBarCoverTip.k(str, str2);
            return defaultNavigationBarCoverTip;
        }
        return (DefaultNavigationBarCoverTip) invokeLL.objValue;
    }

    public static void showTip(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, activity, str, str2) == null) {
            makeText(activity, str, str2).show();
        }
    }

    public final DefaultNavigationBarCoverTip k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            Context context = getContext();
            this.n = str2;
            View inflate = View.inflate(context, h.write_thread_share_guide, null);
            this.m = inflate;
            TextView textView = (TextView) inflate.findViewById(c.a.u0.a4.g.write_thread_success_tips);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.m.findViewById(c.a.u0.a4.g.share_icon);
            tBSpecificationBtn.setTextSize(e.tbds34);
            c.a.t0.s.l0.n.c cVar = new c.a.t0.s.l0.n.c();
            cVar.s();
            tBSpecificationBtn.setConfig(cVar);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            tBSpecificationBtn.setOnClickListener(this.o);
            if (TextUtils.isEmpty(str2)) {
                tBSpecificationBtn.setVisibility(8);
            } else {
                tBSpecificationBtn.setVisibility(0);
                tBSpecificationBtn.setText(context.getString(j.jump_link));
            }
            SkinManager.setViewTextColor(textView, d.CAM_X0101);
            tBSpecificationBtn.changeSkinType();
            SkinManager.setBackgroundColor(this, d.CAM_X0302);
            return this;
        }
        return (DefaultNavigationBarCoverTip) invokeLL.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onDestroy();
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.p);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.p);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void show() {
        Activity activity;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (activity = this.l) == null || this.m == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null) {
            return;
        }
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
        showTip(this.l, this.m);
    }

    public static DefaultNavigationBarCoverTip makeText(Activity activity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str, str2)) == null) {
            if (activity == null) {
                activity = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            DefaultNavigationBarCoverTip defaultNavigationBarCoverTip = new DefaultNavigationBarCoverTip(activity);
            defaultNavigationBarCoverTip.k(str, str2);
            return defaultNavigationBarCoverTip;
        }
        return (DefaultNavigationBarCoverTip) invokeLLL.objValue;
    }
}
