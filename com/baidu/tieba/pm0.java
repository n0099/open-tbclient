package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
public class pm0 extends qm0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public km0 g;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm0 a;

        public a(pm0 pm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference<wm0<?>> weakReference = this.a.e;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.a.e = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public b(pm0 pm0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm0Var, viewGroup, nadLPDownloadAuditView};
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public c(pm0 pm0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm0Var, viewGroup, nadLPDownloadAuditView};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
    public pm0(@NonNull dm0 dm0Var, @NonNull wm0<?> wm0Var) {
        super(dm0Var, wm0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dm0Var, wm0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((dm0) objArr2[0], (wm0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        wm0Var.getRealView().setOnClickListener(this);
    }

    public void A(km0 km0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, km0Var) == null) {
            this.g = km0Var;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            m();
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    @Override // com.baidu.tieba.qm0
    public void t(wm0<?> wm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wm0Var) == null) {
            super.t(wm0Var);
            wm0Var.getRealView().setOnClickListener(this);
        }
    }

    public void C(ViewGroup viewGroup, km0 km0Var, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, km0Var, activity) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            wm0<?> wm0Var = this.e.get();
            if (!(wm0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) wm0Var;
            defaultDownloadViewLP.d(false);
            ln0.c(km0Var, defaultDownloadViewLP, activity, new a(this), null);
        }
    }

    public void D(ViewGroup viewGroup, km0 km0Var, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, viewGroup, km0Var, context) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            wm0<?> wm0Var = this.e.get();
            if (!(wm0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) wm0Var;
            defaultDownloadViewLP.d(false);
            AdDownloadDlgView adDownloadDlgView = new AdDownloadDlgView(context);
            adDownloadDlgView.b(km0Var);
            adDownloadDlgView.setDownloadView(defaultDownloadViewLP);
            NadLPDownloadAuditView nadLPDownloadAuditView = new NadLPDownloadAuditView(context);
            nadLPDownloadAuditView.getDownloadView().addView(adDownloadDlgView);
            adDownloadDlgView.setOnCloseClickListener(new b(this, viewGroup, nadLPDownloadAuditView));
            nadLPDownloadAuditView.getDownloadViewOtherArea().setOnClickListener(new c(this, viewGroup, nadLPDownloadAuditView));
            viewGroup.addView(nadLPDownloadAuditView);
        }
    }

    public km0 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (km0) invokeV.objValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WeakReference<wm0<?>> weakReference = this.e;
            if (weakReference != null && weakReference.get() != null) {
                wm0<?> wm0Var = this.e.get();
                if (wm0Var instanceof View) {
                    return !((View) wm0Var).isAttachedToWindow();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
