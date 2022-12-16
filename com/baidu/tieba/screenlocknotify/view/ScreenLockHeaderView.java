package com.baidu.tieba.screenlocknotify.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.dl8;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ScreenLockHeaderView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public View b;
    public View c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public dl8 h;
    public TextView i;
    public EditText j;
    public RelativeLayout k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenLockHeaderView(Context context) {
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
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07bc, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090b15);
        this.b = findViewById(R.id.obfuscated_res_0x7f090b14);
        this.c = findViewById(R.id.obfuscated_res_0x7f091619);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0912eb);
        this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0917dd);
        this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092534);
        this.g = findViewById(R.id.obfuscated_res_0x7f09139e);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.obfuscated_res_0x7f08110f);
        setOrientation(1);
        this.k = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091e86);
        this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091e87);
        this.j = (EditText) findViewById(R.id.obfuscated_res_0x7f091e85);
        this.k.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenLockHeaderView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenLockHeaderView(Context context, AttributeSet attributeSet, int i) {
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
    }

    public String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(j));
        }
        return (String) invokeJ.objValue;
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 100) {
                return "" + i;
            }
            return "99+";
        }
        return (String) invokeI.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.k.setVisibility(0);
                this.g.setVisibility(8);
                return;
            }
            this.k.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void d(dl8 dl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dl8Var) == null) {
            this.h = dl8Var;
            this.a.setText(dl8Var.a);
            this.d.setText(a(dl8Var.l));
            this.e.setText(dl8Var.e);
            this.f.setText(b(dl8Var.i));
        }
    }

    public dl8 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (dl8) invokeV.objValue;
    }

    public View getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public String getInputMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EditText editText = this.j;
            if (editText == null) {
                return null;
            }
            return xi.charSequence2String(editText.getText(), null);
        }
        return (String) invokeV.objValue;
    }

    public void setUIClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, onClickListener, onClickListener2) == null) {
            this.i.setOnClickListener(onClickListener);
            this.b.setOnClickListener(onClickListener2);
            this.c.setOnClickListener(onClickListener2);
        }
    }
}
