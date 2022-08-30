package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ShareDialogItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static int k;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public HeadImageView b;
    public ImageView c;
    public EMTextView d;
    public LinearLayout.LayoutParams e;
    public LinearLayout.LayoutParams f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1632029920, "Lcom/baidu/tieba/sharesdk/view/ShareDialogItemView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1632029920, "Lcom/baidu/tieba/sharesdk/view/ShareDialogItemView;");
                return;
            }
        }
        g = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        h = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        i = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
        j = ri.f(TbadkCoreApplication.getInst(), R.dimen.T_X09);
        k = 1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialogItemView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ShareDialogItemView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            setOrientation(1);
            ImageView imageView = this.c;
            if (imageView == null) {
                addView(this.b, this.e);
            } else {
                addView(imageView, this.e);
            }
            addView(this.d, this.f);
            return this;
        }
        return (ShareDialogItemView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = g;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            this.e = layoutParams;
            layoutParams.topMargin = h;
            layoutParams.bottomMargin = i;
            layoutParams.gravity = 1;
        }
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.c.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
        }
    }

    public void setItemIcon(AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, absSvgType) == null) {
            this.c = new ImageView(this.a);
            setTag(Integer.valueOf(absSvgType.drawableId));
            if (absSvgType instanceof SvgPureType) {
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.c);
            }
            this.c.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setImageDrawable(absSvgType.getDrawable());
            b();
        }
    }

    public void setItemName(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            EMTextView eMTextView = new EMTextView(this.a);
            this.d = eMTextView;
            eMTextView.setTextSize(0, j);
            this.d.setText(i2);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f = layoutParams;
            layoutParams.gravity = 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public void setItemName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            EMTextView eMTextView = new EMTextView(this.a);
            this.d = eMTextView;
            eMTextView.setTextSize(0, j);
            this.d.setText(str);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0107);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f = layoutParams;
            layoutParams.gravity = 1;
        }
    }

    public void setItemIcon(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.c = new ImageView(this.a);
            setTag(Integer.valueOf(i2));
            this.c.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.c);
            this.c.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
            b();
        }
    }

    public void setItemIcon(String str, int i2, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i2, metaData) == null) {
            this.b = new HeadImageView(this.a);
            setTag(Integer.valueOf(i2));
            this.b.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.c);
            this.b.K(str, 12, false);
            this.b.setIsRound(true);
            if (metaData.getItemType() == k) {
                UtilHelper.showHeadImageViewBigVForStranger(this.b, metaData);
            } else {
                UtilHelper.showHeadImageViewFocusBigV(this.b, metaData);
            }
            b();
        }
    }

    public void setItemIcon(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            this.c = new ImageView(this.a);
            setTag(Integer.valueOf(i4));
            this.c.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.c);
            if (i3 == 0) {
                this.c.setImageDrawable(WebPManager.getMaskDrawable(i2, true));
            } else {
                this.c.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
            }
            b();
        }
    }

    public void setItemIcon(AbsSvgType absSvgType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, absSvgType, i2) == null) {
            this.c = new ImageView(this.a);
            setTag(Integer.valueOf(i2));
            if (absSvgType instanceof SvgPureType) {
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.c);
            }
            this.c.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setImageDrawable(absSvgType.getDrawable());
            b();
        }
    }
}
