package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VerificationCodeView extends FormItemBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f56456e;

    /* renamed from: f  reason: collision with root package name */
    public Button f56457f;

    /* renamed from: g  reason: collision with root package name */
    public c f56458g;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VerificationCodeView f56459e;

        public a(VerificationCodeView verificationCodeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verificationCodeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56459e = verificationCodeView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56459e.f56458g == null) {
                return;
            }
            this.f56459e.f56458g.a();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VerificationCodeView f56460e;

        public b(VerificationCodeView verificationCodeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verificationCodeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56460e = verificationCodeView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z && !this.f56460e.isPrepareToCommit()) {
                    VerificationCodeView verificationCodeView = this.f56460e;
                    verificationCodeView.drawBackgroundFrame(verificationCodeView.f56456e, FormItemBaseView.DrawableType.ERROR_FRAME);
                    return;
                }
                VerificationCodeView verificationCodeView2 = this.f56460e;
                verificationCodeView2.drawBackgroundFrame(verificationCodeView2.f56456e, FormItemBaseView.DrawableType.ORDINARY_FRAME);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeView(Context context) {
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
        this.f56456e = null;
        this.f56457f = null;
        this.f56458g = null;
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            f();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Button button = new Button(this.mContext);
            this.f56457f = button;
            button.setId(1);
            this.f56457f.setTextColor(this.mButtonFontColor);
            this.f56457f.setTextSize(0, this.mFontSize);
            this.f56457f.setBackgroundColor(this.mButtonGreyBgColor);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mSize80);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.f56457f, layoutParams);
            this.f56457f.setOnClickListener(new a(this));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EditText editText = new EditText(this.mContext);
            this.f56456e = editText;
            editText.setTextColor(this.mFontColor);
            this.f56456e.setHintTextColor(this.mHintFontColor);
            this.f56456e.setTextSize(0, this.mFontSize);
            this.f56456e.setGravity(19);
            int paddingBottom = this.f56456e.getPaddingBottom();
            this.f56456e.setPadding(this.mSize20, this.f56456e.getPaddingTop(), this.f56456e.getPaddingRight(), paddingBottom);
            this.f56456e.setOnFocusChangeListener(new b(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mSize80);
            layoutParams.addRule(0, this.f56457f.getId());
            layoutParams.addRule(15);
            drawBackgroundFrame(this.f56456e, FormItemBaseView.DrawableType.ORDINARY_FRAME);
            addView(this.f56456e, layoutParams);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? FormItemBaseView.defaultContent : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView, com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean isPrepareToCommit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f56456e.setText("");
        }
    }

    public void setListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f56458g = cVar;
        }
    }

    public void setVerificationInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean updateView(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            if (super.updateView(bVar)) {
                FormCard.h hVar = (FormCard.h) bVar;
                if (!TextUtils.isEmpty(hVar.f56343d)) {
                    this.f56457f.setText(hVar.f56343d);
                    this.f56457f.setTextSize(0, this.mFontSize);
                    this.f56457f.getLayoutParams().height = this.mSize80;
                    Button button = this.f56457f;
                    int i2 = this.mSize20;
                    button.setPadding(i2, 0, i2, 0);
                }
                if (TextUtils.isEmpty(hVar.f56334b)) {
                    return true;
                }
                this.f56456e.setHint(hVar.f56334b);
                this.f56456e.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f56456e.getLayoutParams();
                marginLayoutParams.height = this.mSize80;
                int i3 = this.mSize20;
                marginLayoutParams.rightMargin = i3;
                this.f56456e.setPadding(i3, 0, 0, 0);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeView(Context context, AttributeSet attributeSet) {
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
        this.f56456e = null;
        this.f56457f = null;
        this.f56458g = null;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationCodeView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f56456e = null;
        this.f56457f = null;
        this.f56458g = null;
        d();
    }
}
