package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.m.g;
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
/* loaded from: classes6.dex */
public class DefaultNavigationBarCoverTip extends NavigationBarCoverTip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public Activity f36829h;
    public View i;
    public String j;
    public View.OnClickListener k;
    public final g l;
    public NavigationBarCoverTip.e m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultNavigationBarCoverTip a;

        public a(DefaultNavigationBarCoverTip defaultNavigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultNavigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultNavigationBarCoverTip;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.e();
                if (this.a.f36829h == null || TextUtils.isEmpty(this.a.j) || (tbPageContext = UtilHelper.getTbPageContext(this.a.f36829h)) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.a.j});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DefaultNavigationBarCoverTip a;

        public b(DefaultNavigationBarCoverTip defaultNavigationBarCoverTip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultNavigationBarCoverTip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = defaultNavigationBarCoverTip;
        }

        @Override // c.a.o0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.a.f36829h) {
                this.a.setCoverTipListener(null);
                this.a.r();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.r();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.f36829h = activity;
        t();
        setCoverTipListener(this.m);
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
            this.j = str2;
            View inflate = View.inflate(context, R.layout.obfuscated_res_0x7f0d08e8, null);
            this.i = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924ab);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091cbd);
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            c.a.o0.r.l0.n.c cVar = new c.a.o0.r.l0.n.c();
            cVar.s();
            tBSpecificationBtn.setConfig(cVar);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setText(str);
            tBSpecificationBtn.setOnClickListener(this.k);
            if (TextUtils.isEmpty(str2)) {
                tBSpecificationBtn.setVisibility(8);
            } else {
                tBSpecificationBtn.setVisibility(0);
                tBSpecificationBtn.setText(context.getString(R.string.obfuscated_res_0x7f0f0981));
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
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
            TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this.l);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(this.l);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void u() {
        Activity activity;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (activity = this.f36829h) == null || this.i == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null) {
            return;
        }
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -2));
        l(this.f36829h, this.i);
    }
}
