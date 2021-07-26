package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.n.g;
/* loaded from: classes4.dex */
public class DefaultNavigationBarCoverTip extends NavigationBarCoverTip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity l;
    public View m;
    public String n;
    public View.OnClickListener o;
    public final g p;
    public NavigationBarCoverTip.e q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultNavigationBarCoverTip f22195e;

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
            this.f22195e = defaultNavigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22195e.e();
                if (this.f22195e.l == null || TextUtils.isEmpty(this.f22195e.n) || (tbPageContext = UtilHelper.getTbPageContext(this.f22195e.l)) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f22195e.n});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DefaultNavigationBarCoverTip f22196e;

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
            this.f22196e = defaultNavigationBarCoverTip;
        }

        @Override // d.a.p0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.f22196e.l) {
                this.f22196e.setCoverTipListener(null);
                this.f22196e.r();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NavigationBarCoverTip.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DefaultNavigationBarCoverTip f22197a;

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
            this.f22197a = defaultNavigationBarCoverTip;
        }

        @Override // com.baidu.tieba.view.NavigationBarCoverTip.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22197a.r();
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
        t();
        setCoverTipListener(this.q);
    }

    public static DefaultNavigationBarCoverTip s(Activity activity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, str, str2)) == null) {
            if (activity == null) {
                activity = TbadkCoreApplication.getInst().getCurrentActivity();
            }
            DefaultNavigationBarCoverTip defaultNavigationBarCoverTip = new DefaultNavigationBarCoverTip(activity);
            defaultNavigationBarCoverTip.q(str, str2);
            return defaultNavigationBarCoverTip;
        }
        return (DefaultNavigationBarCoverTip) invokeLLL.objValue;
    }

    public final DefaultNavigationBarCoverTip q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            Context context = getContext();
            this.n = str2;
            View inflate = View.inflate(context, R.layout.write_thread_share_guide, null);
            this.m = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.m.findViewById(R.id.share_icon);
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            d.a.p0.s.f0.n.c cVar = new d.a.p0.s.f0.n.c();
            cVar.r();
            tBSpecificationBtn.setConfig(cVar);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            tBSpecificationBtn.setOnClickListener(this.o);
            if (TextUtils.isEmpty(str2)) {
                tBSpecificationBtn.setVisibility(8);
            } else {
                tBSpecificationBtn.setVisibility(0);
                tBSpecificationBtn.setText(context.getString(R.string.jump_link));
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            tBSpecificationBtn.k();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0302);
            return this;
        }
        return (DefaultNavigationBarCoverTip) invokeLL.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i();
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.p);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void u() {
        Activity activity;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (activity = this.l) == null || this.m == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null) {
            return;
        }
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
        l(this.l, this.m);
    }
}
