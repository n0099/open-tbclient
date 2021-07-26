package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class UserDefineConfirmBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21403e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21404f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f21405g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21406h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21407i;
    public TextView j;
    public View.OnClickListener k;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f21403e = context;
            LayoutInflater.from(context).inflate(R.layout.user_define_confirm_bottom_view, (ViewGroup) this, true);
            setOrientation(1);
            this.f21404f = (RelativeLayout) findViewById(R.id.confirm_btn_root);
            this.f21405g = (LinearLayout) findViewById(R.id.big_tbean_root);
            this.f21406h = (TextView) findViewById(R.id.big_tbean_toast_tv);
            this.f21407i = (TextView) findViewById(R.id.big_tbean_jump_tv);
            this.j = (TextView) findViewById(R.id.user_define_confirm_tv);
            this.f21404f.setOnClickListener(null);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f21405g.setVisibility(0);
            } else {
                this.f21405g.setVisibility(4);
            }
        }
    }

    public void setBigTbeanToastText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            String format = String.format(this.f21403e.getString(R.string.big_tbean_toast), StringHelper.numberUniform(i2));
            this.l = format;
            this.f21406h.setText(format);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.k = onClickListener;
            this.f21407i.setOnClickListener(onClickListener);
            this.j.setOnClickListener(this.k);
        }
    }

    public void setPayEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f21406h.setText(this.l);
                this.f21406h.setGravity(3);
                b(true);
                this.j.setEnabled(true);
                this.f21405g.setVisibility(0);
                this.f21407i.setVisibility(0);
                return;
            }
            this.f21406h.setText(R.string.user_define_max_money);
            this.f21406h.setGravity(17);
            this.j.setEnabled(false);
            b(false);
            this.f21405g.setVisibility(0);
            this.f21407i.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
