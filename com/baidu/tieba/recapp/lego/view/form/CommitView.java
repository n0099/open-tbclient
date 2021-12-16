package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class CommitView extends FormItemBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public CheckBox f49219e;

    /* renamed from: f  reason: collision with root package name */
    public Button f49220f;

    /* renamed from: g  reason: collision with root package name */
    public int f49221g;

    /* renamed from: h  reason: collision with root package name */
    public String f49222h;

    /* loaded from: classes12.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommitView f49223e;

        public a(CommitView commitView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commitView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49223e = commitView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.f49223e.f49220f.setClickable(true);
                    this.f49223e.f49220f.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                this.f49223e.f49220f.setClickable(false);
                this.f49223e.f49220f.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitView(Context context) {
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
        this.f49219e = null;
        this.f49220f = null;
        this.f49221g = 1;
        this.f49222h = "";
        d();
    }

    public final int c(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, paint, str)) == null) {
            paint.getTextBounds(str, 0, str.length(), new Rect());
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            return fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return invokeLL.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            f();
            setBackgroundColor(0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CheckBox checkBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
            this.f49219e = checkBox;
            checkBox.setId(this.f49221g);
            this.f49219e.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
            this.f49219e.setTextColor(this.mHintFontColor);
            this.f49219e.setGravity(19);
            this.f49219e.setChecked(true);
            this.f49219e.setButtonDrawable((Drawable) null);
            this.f49219e.setOnCheckedChangeListener(new a(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.mSize50;
            addView(this.f49219e, layoutParams);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Button button = new Button(this.mContext);
            this.f49220f = button;
            button.setGravity(17);
            this.f49220f.setTextColor(this.mButtonFontColor);
            this.f49220f.setTextSize(0, this.mFontSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mSize80);
            layoutParams.addRule(3, this.f49219e.getId());
            this.f49220f.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
            addView(this.f49220f, layoutParams);
        }
    }

    public Button getCommitButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49220f : (Button) invokeV.objValue;
    }

    public String getPostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49222h : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? FormItemBaseView.defaultContent : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView, com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean isPrepareToCommit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f49220f.setClickable(z);
            this.f49219e.setClickable(z);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean updateView(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bVar)) == null) {
            if (super.updateView(bVar)) {
                FormCard.c cVar = (FormCard.c) bVar;
                if (TextUtils.isEmpty(cVar.f49147d)) {
                    this.f49219e.setVisibility(8);
                } else {
                    this.f49219e.setVisibility(0);
                    this.f49219e.setTextSize(0, this.mFontSize26);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f49219e.getLayoutParams();
                    marginLayoutParams.bottomMargin = this.mSize50;
                    marginLayoutParams.height = c(this.f49219e.getPaint(), cVar.f49147d);
                    Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                    int i2 = this.mSize20;
                    drawable.setBounds(0, 0, i2, i2);
                    this.f49219e.setCompoundDrawables(drawable, null, null, null);
                    this.f49219e.setCompoundDrawablePadding(this.mSize20);
                    this.f49219e.setText(cVar.f49147d);
                }
                String str = cVar.f49145b;
                if (TextUtils.isEmpty(str)) {
                    str = this.mResources.getString(R.string.push_commit);
                }
                this.f49220f.getLayoutParams().height = this.mSize80;
                this.f49220f.setPadding(0, 0, 0, 0);
                this.f49220f.setTextSize(0, this.mFontSize);
                this.f49220f.setText(str);
                this.f49222h = cVar.f49148e;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitView(Context context, AttributeSet attributeSet) {
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
        this.f49219e = null;
        this.f49220f = null;
        this.f49221g = 1;
        this.f49222h = "";
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f49219e = null;
        this.f49220f = null;
        this.f49221g = 1;
        this.f49222h = "";
        d();
    }
}
