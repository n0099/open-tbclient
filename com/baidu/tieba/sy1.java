package com.baidu.tieba;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class sy1 extends xy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy1(Context context, ty1 ty1Var) {
        super(context, ty1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ty1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (yy1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void f0(SwanEditText swanEditText, ty1 ty1Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, swanEditText, ty1Var) == null) {
            if (bz1.h) {
                Log.d("Component-EditText", "renderSelection");
            }
            Editable text = swanEditText.getText();
            int i2 = 0;
            if (text != null) {
                i2 = text.length();
            }
            int i3 = ty1Var.H;
            if (i3 <= i2 && (i = ty1Var.G) >= 0 && i <= i3) {
                swanEditText.setSelection(i, i3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zy1
    /* renamed from: b0 */
    public void Q(SwanEditText swanEditText, ty1 ty1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanEditText, ty1Var) == null) {
            if (bz1.h) {
                Log.d("Component-EditText", "renderBackground");
            }
            swanEditText.setBackgroundColor(0);
        }
    }

    public void d0(SwanEditText swanEditText, ty1 ty1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, swanEditText, ty1Var) == null) {
            if (bz1.h) {
                Log.d("Component-EditText", "renderCursor");
            }
            Editable text = swanEditText.getText();
            int i = 0;
            if (text != null) {
                i = text.length();
            }
            int i2 = ty1Var.F;
            if (i2 <= i && i2 >= 0) {
                swanEditText.setSelection(i2);
            }
        }
    }

    public final void e0(SwanEditText swanEditText, ty1 ty1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, swanEditText, ty1Var) == null) {
            if (bz1.h) {
                Log.d("Component-EditText", "renderMaxLength");
            }
            if (ty1Var.D >= 0) {
                swanEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(ty1Var.D)});
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xy1, com.baidu.tieba.zy1, com.baidu.tieba.bz1
    /* renamed from: Z */
    public e02 k(ty1 ty1Var, ty1 ty1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, ty1Var, ty1Var2)) == null) {
            e02 k = super.k(ty1Var, ty1Var2);
            if (q() != null && !TextUtils.equals(((SwanEditText) q()).getText().toString(), ty1Var2.t)) {
                k.b(6);
            }
            if (ty1Var.D != ty1Var2.D) {
                k.b(10);
            }
            if (ty1Var.F != ty1Var2.F) {
                k.b(11);
            }
            if (ty1Var.G != ty1Var2.G || ty1Var.H != ty1Var2.H) {
                k.b(12);
            }
            if (!TextUtils.equals(ty1Var.I, ty1Var2.I)) {
                k.b(13);
            }
            return k;
        }
        return (e02) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xy1
    /* renamed from: a0 */
    public void T(SwanEditText swanEditText, ty1 ty1Var, e02 e02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, swanEditText, ty1Var, e02Var) == null) {
            super.O(swanEditText, ty1Var, e02Var);
            if (e02Var.a(11)) {
                d0(swanEditText, ty1Var);
            }
            if (e02Var.a(12)) {
                f0(swanEditText, ty1Var);
            }
            if (e02Var.a(10)) {
                e0(swanEditText, ty1Var);
            }
            if (e02Var.a(13)) {
                c0(swanEditText, ty1Var);
            }
        }
    }

    public boolean c0(SwanEditText swanEditText, ty1 ty1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, swanEditText, ty1Var)) == null) {
            if (bz1.h) {
                Log.d("Component-EditText", "renderConfirmType:" + ty1Var.I);
            }
            String str = ty1Var.I;
            char c = 65535;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals("search")) {
                        c = 1;
                        break;
                    }
                    break;
                case SpeedStatsStampTable.AD_LOAD_BEAR_END_STAMP_KEY /* 3304 */:
                    if (str.equals("go")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                return false;
                            }
                            swanEditText.setImeOptions(6);
                        } else {
                            swanEditText.setImeOptions(2);
                        }
                    } else {
                        swanEditText.setImeOptions(5);
                    }
                } else {
                    swanEditText.setImeOptions(3);
                }
            } else {
                swanEditText.setImeOptions(4);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
