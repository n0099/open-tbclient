package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class ShareDialogItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20834e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20835f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f20836g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f20837h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout.LayoutParams f20838i;

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
        j = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
        k = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
        l = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
        m = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);
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
            addView(this.f20835f, this.f20837h);
            addView(this.f20836g, this.f20838i);
            return this;
        }
        return (ShareDialogItemView) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = j;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            this.f20837h = layoutParams;
            layoutParams.topMargin = k;
            layoutParams.bottomMargin = l;
            layoutParams.gravity = 1;
        }
    }

    public void setItemIcon(AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, absSvgType) == null) {
            this.f20835f = new ImageView(this.f20834e);
            setTag(Integer.valueOf(absSvgType.drawableId));
            if (absSvgType instanceof SvgPureType) {
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f20835f);
            }
            this.f20835f.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f20835f.setImageDrawable(absSvgType.getDrawable());
            b();
        }
    }

    public void setItemName(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            EMTextView eMTextView = new EMTextView(this.f20834e);
            this.f20836g = eMTextView;
            eMTextView.setTextSize(0, m);
            this.f20836g.setText(i2);
            SkinManager.setViewTextColor(this.f20836g, R.color.CAM_X0107);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f20838i = layoutParams;
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
        this.f20834e = context;
    }

    public void setItemIcon(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.f20835f = new ImageView(this.f20834e);
            setTag(Integer.valueOf(i2));
            this.f20835f.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f20835f);
            this.f20835f.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
            b();
        }
    }

    public void setItemIcon(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i2, i3, i4) == null) {
            this.f20835f = new ImageView(this.f20834e);
            setTag(Integer.valueOf(i4));
            this.f20835f.setScaleType(ImageView.ScaleType.FIT_XY);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f20835f);
            this.f20835f.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
            b();
        }
    }

    public void setItemIcon(AbsSvgType absSvgType, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, absSvgType, i2) == null) {
            this.f20835f = new ImageView(this.f20834e);
            setTag(Integer.valueOf(i2));
            if (absSvgType instanceof SvgPureType) {
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f20835f);
            }
            this.f20835f.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f20835f.setImageDrawable(absSvgType.getDrawable());
            b();
        }
    }
}
