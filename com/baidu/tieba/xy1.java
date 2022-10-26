package com.baidu.tieba;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class xy1 extends zy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy1(Context context, yy1 yy1Var) {
        super(context, yy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, yy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (az1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zy1
    /* renamed from: T */
    public void O(TextView textView, yy1 yy1Var, e02 e02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, textView, yy1Var, e02Var) == null) {
            super.C(textView, yy1Var, e02Var);
            if (e02Var.a(6)) {
                U(textView, yy1Var);
            }
            if (e02Var.a(4)) {
                V(textView, yy1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zy1, com.baidu.tieba.bz1
    /* renamed from: S */
    public e02 k(yy1 yy1Var, yy1 yy1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, yy1Var, yy1Var2)) == null) {
            e02 k = super.k(yy1Var, yy1Var2);
            if (!TextUtils.equals(yy1Var.t, yy1Var2.t)) {
                k.b(6);
            }
            return k;
        }
        return (e02) invokeLL.objValue;
    }

    public void X(TextView textView, yy1 yy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView, yy1Var) == null) {
            Y(textView, yy1Var, 48);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    public void U(TextView textView, yy1 yy1Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, textView, yy1Var) == null) {
            if (bz1.h) {
                Log.d("Component-TextView", "renderText");
            }
            if (!TextUtils.isEmpty(yy1Var.t) && yy1Var.x >= 0) {
                z = true;
            } else {
                z = false;
            }
            String str = yy1Var.t;
            if (z) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(new wy1(yy1Var.x), 0, str.length(), 33);
                str = spannableStringBuilder;
            }
            textView.setIncludeFontPadding(!z);
            textView.setText(str);
        }
    }

    public final void V(TextView textView, yy1 yy1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, textView, yy1Var) != null) || yy1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-TextView", "renderTextStyle");
        }
        if (yy1Var.v) {
            textView.setTextColor(yy1Var.u);
        }
        float f = (float) yy1Var.w;
        if (f > 0.0f) {
            textView.setTextSize(1, f);
        }
        X(textView, yy1Var);
        W(textView, yy1Var);
        String str = yy1Var.B;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == -1039592053 && str.equals("nowrap")) {
                c = 1;
            }
        } else if (str.equals("normal")) {
            c = 0;
        }
        if (c != 0) {
            if (c == 1) {
                textView.setSingleLine(true);
            }
        } else {
            textView.setSingleLine(false);
        }
        if ("ellipsis".equals(yy1Var.C)) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void W(TextView textView, yy1 yy1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, textView, yy1Var) != null) || yy1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-TextView", "renderTextStyleFontWeight");
        }
        String str = yy1Var.A;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c = 1;
            }
        } else if (str.equals("normal")) {
            c = 0;
        }
        if (c != 0) {
            if (c != 1) {
                m02.o("Component-TextView", "invalid font weight : " + yy1Var.A);
                textView.setTypeface(Typeface.SANS_SERIF, 0);
                return;
            }
            textView.setTypeface(Typeface.SANS_SERIF, 1);
            return;
        }
        textView.setTypeface(Typeface.SANS_SERIF, 0);
    }

    public final void Y(TextView textView, yy1 yy1Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048585, this, textView, yy1Var, i) != null) || yy1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-TextView", "renderTextStyleTextAlign");
        }
        String str = yy1Var.z;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1364013995) {
            if (hashCode != 3317767) {
                if (hashCode == 108511772 && str.equals("right")) {
                    c = 1;
                }
            } else if (str.equals("left")) {
                c = 0;
            }
        } else if (str.equals("center")) {
            c = 2;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    m02.o("Component-TextView", "invalid text align: " + yy1Var.z);
                } else {
                    i2 = i | 1;
                }
            } else {
                i2 = 8388613 | i;
            }
            textView.setGravity(i2);
        }
        i2 = i | GravityCompat.START;
        textView.setGravity(i2);
    }
}
