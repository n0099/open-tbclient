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
/* loaded from: classes8.dex */
public class tl0 extends ul0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public ol0 h;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl0 a;

        public a(tl0 tl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tl0Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                WeakReference<am0<?>> weakReference = this.a.e;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.a.e = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public b(tl0 tl0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl0Var, viewGroup, nadLPDownloadAuditView};
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

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ NadLPDownloadAuditView b;

        public c(tl0 tl0Var, ViewGroup viewGroup, NadLPDownloadAuditView nadLPDownloadAuditView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl0Var, viewGroup, nadLPDownloadAuditView};
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
    public tl0(@NonNull hl0 hl0Var, @NonNull am0<?> am0Var) {
        super(hl0Var, am0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hl0Var, am0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((hl0) objArr2[0], (am0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        am0Var.getRealView().setOnClickListener(this);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.g = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            l();
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    @Override // com.baidu.tieba.ul0
    public void s(am0<?> am0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, am0Var) == null) {
            super.s(am0Var);
            am0Var.getRealView().setOnClickListener(this);
        }
    }

    public void z(ol0 ol0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ol0Var) == null) {
            this.h = ol0Var;
        }
    }

    public void B(ViewGroup viewGroup, ol0 ol0Var, Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, ol0Var, activity) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            am0<?> am0Var = this.e.get();
            if (!(am0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) am0Var;
            defaultDownloadViewLP.d(false);
            vm0.c(ol0Var, defaultDownloadViewLP, activity, new a(this), null);
        }
    }

    public void C(ViewGroup viewGroup, ol0 ol0Var, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, ol0Var, context) == null) && viewGroup != null && (this.e.get() instanceof DefaultDownloadViewLP)) {
            am0<?> am0Var = this.e.get();
            if (!(am0Var instanceof DefaultDownloadViewLP)) {
                return;
            }
            DefaultDownloadViewLP defaultDownloadViewLP = (DefaultDownloadViewLP) am0Var;
            defaultDownloadViewLP.d(false);
            AdDownloadDlgView adDownloadDlgView = new AdDownloadDlgView(context);
            adDownloadDlgView.b(ol0Var);
            adDownloadDlgView.setDownloadView(defaultDownloadViewLP);
            NadLPDownloadAuditView nadLPDownloadAuditView = new NadLPDownloadAuditView(context);
            nadLPDownloadAuditView.getDownloadView().addView(adDownloadDlgView);
            adDownloadDlgView.setOnCloseClickListener(new b(this, viewGroup, nadLPDownloadAuditView));
            nadLPDownloadAuditView.getDownloadViewOtherArea().setOnClickListener(new c(this, viewGroup, nadLPDownloadAuditView));
            viewGroup.addView(nadLPDownloadAuditView);
        }
    }

    public ol0 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (ol0) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WeakReference<am0<?>> weakReference = this.e;
            if (weakReference != null && weakReference.get() != null) {
                am0<?> am0Var = this.e.get();
                if (am0Var instanceof View) {
                    return !((View) am0Var).isAttachedToWindow();
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
