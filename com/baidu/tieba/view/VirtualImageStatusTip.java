package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.dba;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes8.dex */
public class VirtualImageStatusTip extends AbsTbHorizontalSpreadView {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static float n;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView d;
    public String e;
    public String f;
    public LinearLayout g;
    public ImageView h;
    public boolean i;

    @Override // com.baidu.tieba.view.AbsTbHorizontalSpreadView
    public int getAnimateDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 400;
        }
        return invokeV.intValue;
    }

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
        j = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        k = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        l = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
        m = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
        n = 0.3f;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            n = 0.3f;
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.icon_virtual_image_tip);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, dba.a(dba.f(str), n));
                this.g.setBackground(drawable);
                this.g.setPadding(j, 0, k, 0);
            }
        }
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
        this.i = false;
    }

    @Override // com.baidu.tieba.view.AbsTbHorizontalSpreadView
    public View getChildView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h();
            i();
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && !this.i) {
            d85.d(this.d).x(R.color.CAM_X0105);
        }
    }

    @Override // com.baidu.tieba.view.AbsTbHorizontalSpreadView
    public int getChildWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g.getVisibility() == 0) {
                int i = j + k;
                if (this.h.getVisibility() == 0) {
                    i += l;
                }
                String str = (String) this.d.getText();
                if (!TextUtils.isEmpty(str)) {
                    return i + ((int) this.d.getPaint().measureText(str));
                }
                return i;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.setVisibility(0);
            this.d.setText(R.string.set_virtual_mood_state);
            d85.d(this.d).C(R.dimen.T_X07);
            WebPManager.setPureDrawable(this.h, R.drawable.icon_pure_virtual_add, R.color.CAM_X0605, WebPManager.ResourceStateType.NORMAL);
            k("#FFFFFF", l, true);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g = new LinearLayout(getContext());
            this.g.setLayoutParams(new LinearLayout.LayoutParams(-2, m));
            this.g.setOrientation(0);
            this.g.setGravity(16);
            this.g.setPadding(j, 0, k, 0);
            this.h = new ImageView(getContext());
            int i = l;
            this.h.setLayoutParams(new LinearLayout.LayoutParams(i, i));
            this.h.setVisibility(8);
            this.g.addView(this.h);
            this.d = new TextView(getContext());
            this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.d.setSingleLine();
            this.d.setGravity(17);
            this.g.addView(this.d);
        }
    }

    public String j(VirtualImageCustomState virtualImageCustomState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, virtualImageCustomState)) == null) {
            if (virtualImageCustomState == null) {
                return "";
            }
            String icon = virtualImageCustomState.getIcon();
            String content = virtualImageCustomState.getContent();
            if (virtualImageCustomState.isEmojiState()) {
                String g = g(icon);
                if (!TextUtils.isEmpty(content)) {
                    String format = String.format(getContext().getString(R.string.virtual_image_tip_state), content);
                    return g + format;
                }
                return g;
            } else if (!virtualImageCustomState.isCustomState()) {
                return "";
            } else {
                if (!TextUtils.isEmpty(content)) {
                    return icon + content;
                }
                return icon;
            }
        }
        return (String) invokeL.objValue;
    }

    public final void k(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            if (z) {
                layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            }
            this.h.setLayoutParams(layoutParams);
            this.g.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilHelper.getDimenPixelSize(R.dimen.tbds99)));
            n = 0.8f;
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.icon_virtual_image_tip_right);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, dba.a(dba.f(str), n));
                this.g.setBackground(drawable);
                this.g.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X009), 0);
            }
            d85.d(this.d).x(R.color.CAM_X0611);
        }
    }

    public void setData(VirtualImageCustomState virtualImageCustomState, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{virtualImageCustomState, Boolean.valueOf(z), str}) == null) {
            if (virtualImageCustomState == null) {
                if (this.i) {
                    l();
                    return;
                }
                return;
            }
            String icon = virtualImageCustomState.getIcon();
            String content = virtualImageCustomState.getContent();
            if (TextUtils.isEmpty(icon)) {
                if (this.i) {
                    l();
                    return;
                } else {
                    setVisibility(8);
                    return;
                }
            }
            String str2 = "";
            if (virtualImageCustomState.isEmojiState()) {
                this.h.setVisibility(8);
                String g = g(icon);
                this.e = g;
                this.f = g;
                if (z && !TextUtils.isEmpty(content)) {
                    str2 = String.format(getContext().getString(R.string.virtual_image_tip_state), content);
                    if (!TextUtils.isEmpty(this.e)) {
                        str2 = " " + str2;
                    }
                }
                content = this.e + str2;
            } else {
                if (virtualImageCustomState.isCustomState()) {
                    if (TextUtils.isEmpty(icon)) {
                        this.h.setVisibility(8);
                    } else {
                        this.h.setVisibility(0);
                    }
                    this.f = icon;
                    Glide.with(getContext()).load(icon).into(this.h);
                    if (z && !TextUtils.isEmpty(content)) {
                        if (!TextUtils.isEmpty(icon)) {
                            content = " " + content;
                        }
                    }
                }
                content = "";
            }
            this.d.setText(content);
            if (this.i) {
                d85.d(this.d).C(R.dimen.T_X07);
                k(str, UtilHelper.getDimenPixelSize(R.dimen.tbds60), false);
            } else {
                d85.d(this.d).C(R.dimen.T_X08);
                setBackground(str);
            }
            i();
        }
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && getLayoutParams() != null) {
            getLayoutParams().height = UtilHelper.getDimenPixelSize(i);
            setLayoutParams(getLayoutParams());
        }
    }

    public void setIsPersonalLocate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.i = z;
        }
    }
}
