package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.ns8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public TextView d;
    public TbImageView e;
    public TbImageView f;
    public ImageView g;
    public TextView h;
    public View i;
    public ns8 j;
    public b k;
    public int l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardItemView a;

        public a(PersonalCardItemView personalCardItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.a.k == null) {
                return;
            }
            this.a.k.a(this.a.j);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(ns8 ns8Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context) {
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
        this.a = context;
        d();
    }

    public void c(ns8 ns8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ns8Var) == null) || ns8Var == null) {
            return;
        }
        this.j = ns8Var;
        if (ns8Var.a() == ns8.k) {
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
            SkinManager.setImageResource(this.c, R.drawable.icon_bubble_choose_no);
            this.d.setVisibility(0);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
        } else {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setImageBitmap(null);
            this.c.setDefaultResource(R.drawable.obfuscated_res_0x7f080be2);
            this.c.K(ns8Var.e(), 10, false);
        }
        if (ns8Var.g() == 1) {
            this.g.setVisibility(0);
            SkinManager.setImageResource(this.g, R.drawable.icon_choose_photo);
        } else {
            this.g.setVisibility(8);
        }
        this.e.K(ns8Var.i(), 10, false);
        this.f.K(ns8Var.b(), 10, false);
        this.h.setText(ns8Var.j());
        setVisibility(0);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            int k = (ej.k(this.a) - ej.f(this.a, R.dimen.obfuscated_res_0x7f070306)) / 3;
            this.l = k;
            this.m = (int) (k * 0.57d);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0730, this);
            this.b = inflate;
            this.c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e97);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918d1);
            this.e = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081240);
            this.e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081240);
            TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f7c);
            this.f = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f081240);
            this.f.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081240);
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090620);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092438);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0925ab);
            this.i = this.b.findViewById(R.id.obfuscated_res_0x7f0903a5);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = this.m;
            layoutParams.width = this.l;
            this.c.setLayoutParams(layoutParams);
            this.i.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new a(this));
        }
    }

    public b getCardViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (b) invokeV.objValue;
    }

    public void setCardViewController(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet) {
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
        this.a = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = context;
        d();
    }
}
