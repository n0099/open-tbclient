package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.uw8;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public uw8 b;
    public TbImageView c;
    public LinearLayout d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public View h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
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
        this.i = false;
        this.a = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d075c, (ViewGroup) this, true);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091a8d);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090401);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09231a);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0907d3);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fb1);
        }
    }

    public uw8 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (uw8) invokeV.objValue;
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (ImageView) invokeV.objValue;
    }

    public void setSupportNoImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        uw8 uw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (uw8Var = this.b) != null) {
            BrowserHelper.p(this.a, uw8Var.e());
        }
    }

    public void setIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setImageResource(this.e, i);
        }
    }

    public void setData(uw8 uw8Var) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, uw8Var) == null) && uw8Var != null && this.b != uw8Var) {
            this.b = uw8Var;
            if (!StringUtils.isNULL(uw8Var.f())) {
                this.f.setVisibility(0);
                this.f.setText(uw8Var.f());
            } else {
                this.f.setVisibility(8);
            }
            if (!StringUtils.isNULL(uw8Var.a())) {
                this.g.setVisibility(0);
                this.g.setText(uw8Var.a());
            } else {
                this.g.setVisibility(8);
            }
            if (this.i) {
                this.c.setSupportNoImage(true);
            }
            int d = uw8Var.d();
            int b = uw8Var.b();
            if (d > 0 && b > 0) {
                this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.c.setOnClickListener(this);
                this.c.setInterceptOnClick(true);
                this.c.setDefaultResource(R.drawable.icon_click);
                this.c.K(uw8Var.c(), 18, false);
                int l = zi.l(this.a) - (zi.g(this.a, R.dimen.obfuscated_res_0x7f070201) * 2);
                float f2 = b / d;
                if (f2 > 1.7777778f) {
                    f = l * 1.7777778f;
                } else if (f2 < 0.75f) {
                    f = l * 0.75f;
                } else {
                    f = l * f2;
                }
                this.c.setLayoutParams(new FrameLayout.LayoutParams(l, (int) f));
                removeView(this.c);
                addView(this.c);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
                layoutParams.width = l;
                layoutParams.height = zi.g(this.a, R.dimen.obfuscated_res_0x7f070236);
                removeView(this.d);
                addView(this.d, layoutParams);
            }
        }
    }
}
