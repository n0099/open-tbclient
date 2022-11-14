package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.DialogFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xh4 extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b0;
    public int c0;
    public boolean d0;
    public boolean e0;
    public int f0;
    public Dialog g0;
    public boolean h0;
    public boolean i0;
    public boolean j0;

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dialogInterface) == null) {
        }
    }

    public xh4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = true;
        this.e0 = true;
        this.f0 = -1;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            Dialog dialog = this.g0;
            if (dialog != null) {
                this.h0 = true;
                dialog.dismiss();
                this.g0 = null;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.B0();
            if (!this.j0 && !this.i0) {
                this.i0 = true;
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.L0();
            Dialog dialog = this.g0;
            if (dialog != null) {
                this.h0 = false;
                dialog.show();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.M0();
            Dialog dialog = this.g0;
            if (dialog != null) {
                dialog.hide();
            }
        }
    }

    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o1(false);
        }
    }

    public Dialog p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g0;
        }
        return (Dialog) invokeV.objValue;
    }

    @StyleRes
    public int q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void K0(Bundle bundle) {
        Bundle onSaveInstanceState;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.K0(bundle);
            Dialog dialog = this.g0;
            if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
                bundle.putBundle(DialogFragment.SAVED_DIALOG_STATE_TAG, onSaveInstanceState);
            }
            int i = this.b0;
            if (i != 0) {
                bundle.putInt(DialogFragment.SAVED_STYLE, i);
            }
            int i2 = this.c0;
            if (i2 != 0) {
                bundle.putInt(DialogFragment.SAVED_THEME, i2);
            }
            boolean z = this.d0;
            if (!z) {
                bundle.putBoolean(DialogFragment.SAVED_CANCELABLE, z);
            }
            boolean z2 = this.e0;
            if (!z2) {
                bundle.putBoolean(DialogFragment.SAVED_SHOWS_DIALOG, z2);
            }
            int i3 = this.f0;
            if (i3 != -1) {
                bundle.putInt(DialogFragment.SAVED_BACK_STACK_ID, i3);
            }
        }
    }

    public void o1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048582, this, z) != null) || this.i0) {
            return;
        }
        this.i0 = true;
        this.j0 = false;
        Dialog dialog = this.g0;
        if (dialog != null) {
            dialog.dismiss();
            this.g0 = null;
        }
        this.h0 = true;
        if (this.f0 >= 0) {
            x().e(this.f0, 1);
            this.f0 = -1;
            return;
        }
        di4 a = x().a();
        a.h(this);
        if (z) {
            a.f();
        } else {
            a.e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void p0(Bundle bundle) {
        Bundle bundle2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.p0(bundle);
            if (!this.e0) {
                return;
            }
            View V = V();
            if (V != null) {
                if (V.getParent() == null) {
                    this.g0.setContentView(V);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            this.g0.setOwnerActivity(getActivity());
            this.g0.setCancelable(this.d0);
            this.g0.setOnCancelListener(this);
            this.g0.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle(DialogFragment.SAVED_DIALOG_STATE_TAG)) != null) {
                this.g0.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(@Nullable Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.u0(bundle);
            if (this.x == 0) {
                z = true;
            } else {
                z = false;
            }
            this.e0 = z;
            if (bundle != null) {
                this.b0 = bundle.getInt(DialogFragment.SAVED_STYLE, 0);
                this.c0 = bundle.getInt(DialogFragment.SAVED_THEME, 0);
                this.d0 = bundle.getBoolean(DialogFragment.SAVED_CANCELABLE, true);
                this.e0 = bundle.getBoolean(DialogFragment.SAVED_SHOWS_DIALOG, this.e0);
                this.f0 = bundle.getInt(DialogFragment.SAVED_BACK_STACK_ID, -1);
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogInterface) == null) && !this.h0) {
            o1(true);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            super.r0(activity);
            if (!this.j0) {
                this.i0 = false;
            }
        }
    }

    @NonNull
    public Dialog r1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) {
            return new Dialog(getActivity(), q1());
        }
        return (Dialog) invokeL.objValue;
    }

    public void s1(Dialog dialog, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, dialog, i) == null) {
            if (i != 1 && i != 2) {
                if (i == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            dialog.requestWindowFeature(1);
        }
    }

    public void t1(bi4 bi4Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bi4Var, str) == null) {
            this.i0 = false;
            this.j0 = true;
            di4 a = bi4Var.a();
            a.c(this, str);
            a.e();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public LayoutInflater y(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundle)) == null) {
            if (!this.e0) {
                return super.y(bundle);
            }
            Dialog r1 = r1(bundle);
            this.g0 = r1;
            if (r1 != null) {
                s1(r1, this.b0);
                return (LayoutInflater) this.g0.getContext().getSystemService("layout_inflater");
            }
            return (LayoutInflater) this.t.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) invokeL.objValue;
    }
}
