package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class TitleView extends FormItemBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f49474e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49475f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f49476g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f49477h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f49478i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49474e = null;
        this.f49475f = null;
        this.f49476g = null;
        this.f49477h = null;
        this.f49478i = null;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f49474e = new TextView(this.mContext);
            this.f49475f = new ImageView(this.mContext);
            this.f49476g = new ImageView(this.mContext);
            this.f49477h = new ImageView(this.mContext);
            this.f49478i = new ImageView(this.mContext);
            e();
            c(this.f49477h, true, 2);
            c(this.f49478i, false, 3);
            d(this.f49475f, true);
            d(this.f49476g, false);
        }
    }

    public final void c(ImageView imageView, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageView, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            imageView.setId(i2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            if (z) {
                imageView.setImageResource(R.drawable.form_title_icon_left);
                layoutParams.addRule(0, this.f49474e.getId());
            } else {
                imageView.setImageResource(R.drawable.form_title_icon_right);
                layoutParams.addRule(1, this.f49474e.getId());
            }
            int i3 = this.mSize20;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
            addView(imageView, layoutParams);
        }
    }

    public final void d(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, imageView, z) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
            layoutParams.addRule(15);
            if (z) {
                layoutParams.addRule(0, this.f49477h.getId());
            } else {
                layoutParams.addRule(1, this.f49478i.getId());
            }
            addView(imageView, layoutParams);
            imageView.setBackgroundColor(this.mFrameColor);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f49474e.setTextSize(0, this.mFontSize36);
            this.f49474e.setTextColor(-1);
            this.f49474e.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.f49474e, layoutParams);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? FormItemBaseView.defaultContent : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView, com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean isPrepareToCommit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean updateView(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            if (super.updateView(bVar)) {
                this.f49474e.setTextSize(0, this.mFontSize36);
                this.f49474e.setText(bVar.f49371b);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f49477h.getLayoutParams();
                int i2 = this.mSize20;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f49478i.getLayoutParams();
                int i3 = this.mSize20;
                marginLayoutParams2.leftMargin = i3;
                marginLayoutParams2.rightMargin = i3;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49474e = null;
        this.f49475f = null;
        this.f49476g = null;
        this.f49477h = null;
        this.f49478i = null;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f49474e = null;
        this.f49475f = null;
        this.f49476g = null;
        this.f49477h = null;
        this.f49478i = null;
        b();
    }
}
