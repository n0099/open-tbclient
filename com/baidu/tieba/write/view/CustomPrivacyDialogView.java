package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.q0.s.g0.n.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class CustomPrivacyDialogView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f55896e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f55897f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f55898g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPrivacyDialogView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            setOrientation(1);
            setGravity(1);
            setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0211));
            setBackgroundDrawable(gradientDrawable);
            LinearLayout.inflate(context, R.layout.custom_privacy_dialog_view, this);
            this.f55896e = (EMTextView) findViewById(R.id.privacy_message);
            this.f55897f = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
            this.f55898g = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
            this.f55897f.setTextSize(R.dimen.tbds34);
            c cVar = new c();
            cVar.r(R.color.CAM_X0105);
            this.f55897f.setConfig(cVar);
            this.f55898g.setTextSize(R.dimen.tbds34);
            c cVar2 = new c();
            cVar2.p(R.color.CAM_X0302);
            this.f55898g.setConfig(cVar2);
        }
    }

    public void setMessageTextViewColor(int i2) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (eMTextView = this.f55896e) == null) {
            return;
        }
        eMTextView.setTextColor(i2);
    }

    public void setMessageTextViewMessage(String str) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (eMTextView = this.f55896e) == null) {
            return;
        }
        eMTextView.setText(str);
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) || (tBSpecificationBtn = this.f55897f) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (tBSpecificationBtn = this.f55897f) == null) {
            return;
        }
        tBSpecificationBtn.setText(str);
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) || (tBSpecificationBtn = this.f55898g) == null) {
            return;
        }
        tBSpecificationBtn.setOnClickListener(onClickListener);
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (tBSpecificationBtn = this.f55898g) == null) {
            return;
        }
        tBSpecificationBtn.setText(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
