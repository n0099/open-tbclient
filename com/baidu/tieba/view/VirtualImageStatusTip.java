package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.uu4;
import com.baidu.tieba.zk8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes6.dex */
public class VirtualImageStatusTip extends AbsTbHorizontalSpreadView {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView d;
    public String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1126492030, "Lcom/baidu/tieba/view/VirtualImageStatusTip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1126492030, "Lcom/baidu/tieba/view/VirtualImageStatusTip;");
                return;
            }
        }
        f = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        g = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualImageStatusTip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setBackground(String str) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || (drawable = ContextCompat.getDrawable(getContext(), R.drawable.obfuscated_res_0x7f080b3a)) == null) {
            return;
        }
        DrawableCompat.setTint(drawable, zk8.a(zk8.f(str), 0.3f));
        this.d.setBackground(drawable);
        this.d.setPadding(f, 0, g, 0);
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str.length() > 2) {
                try {
                    return new String(Character.toChars(Integer.parseInt(str.substring(2).replace(ParamableElem.DIVIDE_PARAM, ""))));
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.view.AbsTbHorizontalSpreadView
    public int getAnimateDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 400;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.view.AbsTbHorizontalSpreadView
    public View getChildView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h();
            i();
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.view.AbsTbHorizontalSpreadView
    public int getChildWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = (String) this.d.getText();
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return ((int) this.d.getPaint().measureText(str)) + f + g;
        }
        return invokeV.intValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = new TextView(getContext());
            this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds60)));
            this.d.setSingleLine();
            this.d.setGravity(17);
            this.d.setPadding(f, 0, g, 0);
            uu4.d(this.d).z(R.dimen.T_X08);
        }
    }

    public void i() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.d) == null) {
            return;
        }
        uu4.d(textView).v(R.color.CAM_X0105);
    }

    public void setData(String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3) == null) {
            this.e = g(str);
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
            } else {
                str4 = String.format(getContext().getString(R.string.obfuscated_res_0x7f0f157b), str2);
                if (!TextUtils.isEmpty(this.e)) {
                    str4 = " " + str4;
                }
            }
            this.d.setText(this.e + str4);
            setBackground(str3);
            i();
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || getLayoutParams() == null) {
            return;
        }
        getLayoutParams().height = UtilHelper.getDimenPixelSize(i);
        setLayoutParams(getLayoutParams());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VirtualImageStatusTip(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageStatusTip(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public void setData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.e = g(str);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.e += String.format(getContext().getString(R.string.obfuscated_res_0x7f0f157b), str2);
        }
    }
}
