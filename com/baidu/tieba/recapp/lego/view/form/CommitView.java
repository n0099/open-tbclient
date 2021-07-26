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
/* loaded from: classes4.dex */
public class CommitView extends FormItemBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public CheckBox x;
    public Button y;
    public int z;

    /* loaded from: classes4.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CommitView f20689e;

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
            this.f20689e = commitView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.f20689e.y.setClickable(true);
                    this.f20689e.y.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                this.f20689e.y.setClickable(false);
                this.f20689e.y.setBackgroundResource(R.color.form_button_bg_color_unenable);
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
        this.x = null;
        this.y = null;
        this.z = 1;
        this.A = "";
        j();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (super.g(bVar)) {
                FormCard.c cVar = (FormCard.c) bVar;
                if (TextUtils.isEmpty(cVar.f20622d)) {
                    this.x.setVisibility(8);
                } else {
                    this.x.setVisibility(0);
                    this.x.setTextSize(0, this.o);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
                    marginLayoutParams.bottomMargin = this.f20702i;
                    marginLayoutParams.height = i(this.x.getPaint(), cVar.f20622d);
                    Drawable drawable = this.f20699f.getDrawable(R.drawable.form_checkbox_selector);
                    int i2 = this.f20700g;
                    drawable.setBounds(0, 0, i2, i2);
                    this.x.setCompoundDrawables(drawable, null, null, null);
                    this.x.setCompoundDrawablePadding(this.f20700g);
                    this.x.setText(cVar.f20622d);
                }
                String str = cVar.f20620b;
                if (TextUtils.isEmpty(str)) {
                    str = this.f20699f.getString(R.string.push_commit);
                }
                this.y.getLayoutParams().height = this.j;
                this.y.setPadding(0, 0, 0, 0);
                this.y.setTextSize(0, this.n);
                this.y.setText(str);
                this.A = cVar.f20623e;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Button getCommitButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.y : (Button) invokeV.objValue;
    }

    public String getPostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "NEGLIGIBLE" : (String) invokeV.objValue;
    }

    public final int i(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, paint, str)) == null) {
            paint.getTextBounds(str, 0, str.length(), new Rect());
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            return fontMetricsInt.bottom - fontMetricsInt.top;
        }
        return invokeLL.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k();
            l();
            setBackgroundColor(0);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            CheckBox checkBox = new CheckBox(this.f20698e, null, R.style.form_check_box_style);
            this.x = checkBox;
            checkBox.setId(this.z);
            this.x.setTextSize(0, (int) this.f20699f.getDimension(R.dimen.fontsize20));
            this.x.setTextColor(this.m);
            this.x.setGravity(19);
            this.x.setChecked(true);
            this.x.setButtonDrawable((Drawable) null);
            this.x.setOnCheckedChangeListener(new a(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.f20702i;
            addView(this.x, layoutParams);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Button button = new Button(this.f20698e);
            this.y = button;
            button.setGravity(17);
            this.y.setTextColor(this.q);
            this.y.setTextSize(0, this.n);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.j);
            layoutParams.addRule(3, this.x.getId());
            this.y.setBackgroundDrawable(this.f20699f.getDrawable(R.drawable.form_commit_button_selector));
            addView(this.y, layoutParams);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.y.setClickable(z);
            this.x.setClickable(z);
        }
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
        this.x = null;
        this.y = null;
        this.z = 1;
        this.A = "";
        j();
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
        this.x = null;
        this.y = null;
        this.z = 1;
        this.A = "";
        j();
    }
}
