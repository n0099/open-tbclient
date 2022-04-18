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
/* loaded from: classes3.dex */
public class CommitView extends FormItemBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CheckBox t;
    public Button u;
    public int v;
    public String w;

    /* loaded from: classes3.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommitView a;

        public a(CommitView commitView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commitView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commitView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (z) {
                    this.a.u.setClickable(true);
                    this.a.u.setBackgroundResource(R.color.obfuscated_res_0x7f060719);
                    return;
                }
                this.a.u.setClickable(false);
                this.a.u.setBackgroundResource(R.color.obfuscated_res_0x7f06071a);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = null;
        this.v = 1;
        this.w = "";
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
                if (TextUtils.isEmpty(cVar.d)) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                    this.t.setTextSize(0, this.k);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.t.getLayoutParams();
                    marginLayoutParams.bottomMargin = this.e;
                    marginLayoutParams.height = i(this.t.getPaint(), cVar.d);
                    Drawable drawable = this.b.getDrawable(R.drawable.obfuscated_res_0x7f080578);
                    int i = this.c;
                    drawable.setBounds(0, 0, i, i);
                    this.t.setCompoundDrawables(drawable, null, null, null);
                    this.t.setCompoundDrawablePadding(this.c);
                    this.t.setText(cVar.d);
                }
                String str = cVar.b;
                if (TextUtils.isEmpty(str)) {
                    str = this.b.getString(R.string.obfuscated_res_0x7f0f0f08);
                }
                this.u.getLayoutParams().height = this.f;
                this.u.setPadding(0, 0, 0, 0);
                this.u.setTextSize(0, this.j);
                this.u.setText(str);
                this.w = cVar.e;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Button getCommitButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.u : (Button) invokeV.objValue;
    }

    public String getPostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.w : (String) invokeV.objValue;
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
            CheckBox checkBox = new CheckBox(this.a, null, R.style.obfuscated_res_0x7f1003ac);
            this.t = checkBox;
            checkBox.setId(this.v);
            this.t.setTextSize(0, (int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07032e));
            this.t.setTextColor(this.i);
            this.t.setGravity(19);
            this.t.setChecked(true);
            this.t.setButtonDrawable((Drawable) null);
            this.t.setOnCheckedChangeListener(new a(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = this.e;
            addView(this.t, layoutParams);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Button button = new Button(this.a);
            this.u = button;
            button.setGravity(17);
            this.u.setTextColor(this.m);
            this.u.setTextSize(0, this.j);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f);
            layoutParams.addRule(3, this.t.getId());
            this.u.setBackgroundDrawable(this.b.getDrawable(R.drawable.obfuscated_res_0x7f08057a));
            addView(this.u, layoutParams);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.u.setClickable(z);
            this.t.setClickable(z);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = null;
        this.v = 1;
        this.w = "";
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = null;
        this.v = 1;
        this.w = "";
        j();
    }
}
