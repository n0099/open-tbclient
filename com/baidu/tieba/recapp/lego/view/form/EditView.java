package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
import com.baidu.tieba.recapp.lego.view.form.VerificationCodeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class EditView extends FormItemBaseView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_EDIT_MULTI_LINE_INFO = 4;
    public static final int TYPE_EDIT_PHONE_INFO = 5;
    public static final int TYPE_EDIT_SINGLE_LINE_INFO = 3;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f53588e;

    /* renamed from: f  reason: collision with root package name */
    public VerificationCodeView f53589f;

    /* renamed from: g  reason: collision with root package name */
    public String f53590g;

    /* renamed from: h  reason: collision with root package name */
    public String f53591h;

    /* loaded from: classes9.dex */
    public class a implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditView f53592e;

        public a(EditView editView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53592e = editView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z && !this.f53592e.isPrepareToCommit()) {
                    EditView editView = this.f53592e;
                    editView.drawBackgroundFrame(editView.f53588e, FormItemBaseView.DrawableType.ERROR_FRAME);
                    return;
                }
                EditView editView2 = this.f53592e;
                editView2.drawBackgroundFrame(editView2.f53588e, FormItemBaseView.DrawableType.ORDINARY_FRAME);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements VerificationCodeView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditView f53593a;

        public b(EditView editView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53593a = editView;
        }

        @Override // com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53593a.f53589f.setVerificationInfo(((Object) this.f53593a.f53588e.getText()) + "");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f53594e;

        /* renamed from: f  reason: collision with root package name */
        public String f53595f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditView f53596g;

        public c(EditView editView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53596g = editView;
            this.f53595f = "[\\u4e00-\\u9fa5]";
            this.f53594e = i2;
        }

        public final int a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Matcher matcher = Pattern.compile(this.f53595f).matcher(str);
                int i2 = 0;
                while (matcher.find()) {
                    for (int i3 = 0; i3 <= matcher.groupCount(); i3++) {
                        i2++;
                    }
                }
                return i2;
            }
            return invokeL.intValue;
        }

        public final boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? Pattern.matches(this.f53595f, str) : invokeL.booleanValue;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                int length = spanned.toString().length() + a(spanned.toString());
                int length2 = charSequence.toString().length() + a(charSequence.toString());
                int i6 = length + length2;
                int i7 = this.f53594e;
                if (i6 > i7) {
                    int i8 = i7 - length;
                    int i9 = 0;
                    String str = "";
                    while (i8 > 0) {
                        char charAt = charSequence.charAt(i9);
                        if (b(charAt + "")) {
                            if (length2 >= 2) {
                                str = str + charAt;
                            }
                            i8 -= 2;
                        } else {
                            str = str + charAt;
                            i8--;
                        }
                        i9++;
                    }
                    return str;
                }
                return charSequence;
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditView(Context context) {
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
        this.f53588e = null;
        this.f53589f = null;
        this.f53590g = "";
        this.f53591h = "";
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
            EditText editText = new EditText(this.mContext);
            this.f53588e = editText;
            editText.setId(1);
            this.f53588e.setTextSize(0, this.mFontSize);
            this.f53588e.setTextColor(this.mFontColor);
            this.f53588e.setHintTextColor(this.mHintFontColor);
            this.f53588e.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.f53588e.setOnFocusChangeListener(new a(this));
            drawBackgroundFrame(this.f53588e, FormItemBaseView.DrawableType.ORDINARY_FRAME);
            addView(this.f53588e, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f53589f = new VerificationCodeView(this.mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mSize80);
            layoutParams.topMargin = this.mSize40;
            layoutParams.addRule(3, this.f53588e.getId());
            addView(this.f53589f, layoutParams);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f53591h : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView, com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean isPrepareToCommit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(this.f53590g)) {
                return true;
            }
            Editable text = this.f53588e.getText();
            if (text != null) {
                this.f53591h = text.toString().trim();
            }
            return Pattern.matches(this.f53590g, this.f53591h);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f53588e.setPadding(this.mSize20, 0, 0, 0);
            this.f53588e.setText("");
            this.f53588e.setGravity(19);
            this.f53588e.setSingleLine(true);
            this.f53588e.setHorizontallyScrolling(true);
            this.f53588e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            this.f53589f.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean updateView(FormCard.b bVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            if (super.updateView(bVar)) {
                FormCard.d dVar = (FormCard.d) bVar;
                this.f53588e.setTextSize(0, this.mFontSize);
                int i3 = dVar.f53500a;
                if (i3 == 3) {
                    i2 = this.mSize80;
                    this.f53588e.setInputType(1);
                    this.f53588e.setFilters(new InputFilter[]{new c(this, 20)});
                } else if (i3 == 4) {
                    i2 = this.mSize240;
                    this.f53588e.setInputType(131072);
                    this.f53588e.setFilters(new InputFilter[]{new c(this, 100)});
                    this.f53588e.setSingleLine(false);
                    this.f53588e.setHorizontallyScrolling(false);
                    this.f53588e.setGravity(51);
                    EditText editText = this.f53588e;
                    int i4 = this.mSize20;
                    editText.setPadding(i4, i4, i4, i4);
                } else if (i3 != 5) {
                    return false;
                } else {
                    i2 = this.mSize80;
                    this.f53588e.setInputType(2);
                    this.f53588e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
                    if (dVar.f53506e != null) {
                        this.f53589f.setVisibility(0);
                        this.f53589f.scaleMargin(this.mScaleRatio);
                        this.f53589f.updateView(dVar.f53506e);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f53589f.getLayoutParams();
                        marginLayoutParams.topMargin = this.mSize40;
                        marginLayoutParams.height = this.mSize80;
                        this.f53589f.setListener(new b(this));
                    }
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53588e.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = i2;
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.height = i2;
                    this.f53588e.setLayoutParams(layoutParams2);
                }
                this.f53588e.setHint(dVar.f53501b);
                this.f53590g = dVar.f53505d;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditView(Context context, AttributeSet attributeSet) {
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
        this.f53588e = null;
        this.f53589f = null;
        this.f53590g = "";
        this.f53591h = "";
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f53588e = null;
        this.f53589f = null;
        this.f53590g = "";
        this.f53591h = "";
        d();
    }
}
