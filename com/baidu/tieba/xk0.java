package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.view.AdDownloadDlgView;
import com.baidu.nadcore.download.view.DefaultDownloadViewLP;
import com.baidu.nadcore.download.view.NadLPDownloadAuditView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class xk0 extends yk0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public sk0 g;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public a(xk0 xk0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk0Var, viewGroup, nadLPDownloadAuditView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = nadLPDownloadAuditView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.removeView(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public b(xk0 xk0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk0Var, viewGroup, nadLPDownloadAuditView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = nadLPDownloadAuditView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.removeView(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xk0 a;

        public c(xk0 xk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xk0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xk0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference<el0<?>> weakReference = this.a.e;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.a.e = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
    public xk0(@NonNull lk0 lk0Var, @NonNull el0<?> el0Var) {
        super(lk0Var, el0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lk0Var, el0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((lk0) objArr2[0], (el0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        el0Var.getRealView().setOnClickListener(this);
    }

    public void A(ViewGroup viewGroup, sk0 sk0Var, Activity activity, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048576, this, viewGroup, sk0Var, activity, i) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            el0<?> el0Var = this.e.get();
            if (!(el0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) el0Var;
            defaultDownloadViewLP.d(false);
            if (i == 1) {
                AdDownloadDlgView adDownloadDlgView = new AdDownloadDlgView(activity);
                adDownloadDlgView.b(sk0Var);
                adDownloadDlgView.setDownloadView(defaultDownloadViewLP);
                NadLPDownloadAuditView nadLPDownloadAuditView = new NadLPDownloadAuditView(activity);
                nadLPDownloadAuditView.getDownloadView().addView(adDownloadDlgView);
                adDownloadDlgView.setOnCloseClickListener(new a(this, viewGroup, nadLPDownloadAuditView));
                nadLPDownloadAuditView.getDownloadViewOtherArea().setOnClickListener(new b(this, viewGroup, nadLPDownloadAuditView));
                viewGroup.addView(nadLPDownloadAuditView);
                return;
            }
            tl0.c(sk0Var, defaultDownloadViewLP, activity, new c(this), null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            m();
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    @Override // com.baidu.tieba.yk0
    public void t(el0<?> el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, el0Var) == null) {
            super.t(el0Var);
            el0Var.getRealView().setOnClickListener(this);
        }
    }

    public void y(sk0 sk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sk0Var) == null) {
            this.g = sk0Var;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
        }
    }

    public sk0 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (sk0) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            WeakReference<el0<?>> weakReference = this.e;
            if (weakReference != null && weakReference.get() != null) {
                el0<?> el0Var = this.e.get();
                if (el0Var instanceof View) {
                    return !((View) el0Var).isAttachedToWindow();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
