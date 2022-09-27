package com.baidu.tieba.themeCenter.background;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.xs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BackgroundItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public TbImageView d;
    public TbImageView e;
    public ImageView f;
    public TextView g;
    public SkinProgressView h;
    public DressItemData i;
    public int j;
    public int k;
    public xs8 l;
    public View.OnClickListener m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BackgroundItemView a;

        public a(BackgroundItemView backgroundItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = backgroundItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.a.i == null || this.a.l == null) {
                return;
            }
            if (view2 == this.a.h) {
                TiebaStatic.log(new StatisticItem("c10280").param("obj_id", this.a.i.getPropsId()));
                this.a.l.e(this.a.i, false);
            } else if (view2 == this.a.c) {
                TiebaStatic.log(new StatisticItem("c10279").param("obj_id", this.a.i.getPropsId()));
                this.a.l.b(this.a.i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundItemView(Context context) {
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
        this.m = new a(this);
        this.a = context;
        g();
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.i = dressItemData;
        Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
        if (dressItemData.getPropsId() == 0) {
            SkinManager.setImageResource(this.c, R.drawable.pic_bg_moren);
        } else {
            this.c.setImageBitmap(null);
            this.c.K(dressItemData.getExampleImgUrl(), 10, false);
        }
        this.g.setText(dressItemData.getTitle());
        if (valueOf.booleanValue()) {
            this.f.setVisibility(0);
            SkinManager.setImageResource(this.f, R.drawable.icon_choose_photo);
        } else {
            this.f.setVisibility(8);
        }
        this.d.K(dressItemData.getPermissionImgUrl(), 10, false);
        this.e.K(dressItemData.getPropsStateImg(), 10, false);
        if (valueOf.booleanValue()) {
            this.h.c(0, 0.0f);
        } else {
            this.h.c(4, 0.0f);
        }
        setVisibility(0);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int k = (ej.k(this.a) - ej.f(this.a, R.dimen.obfuscated_res_0x7f070306)) / 3;
            this.j = k;
            this.k = (int) (k / 0.66d);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d012e, this);
            this.b = inflate;
            this.c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090385);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918d1);
            this.d = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081240);
            this.d.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081240);
            TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f7c);
            this.e = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f081240);
            this.e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081240);
            this.f = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090620);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09210d);
            SkinProgressView skinProgressView = (SkinProgressView) this.b.findViewById(R.id.obfuscated_res_0x7f0925a7);
            this.h = skinProgressView;
            skinProgressView.setOnClickListener(this.m);
            this.c.setOnClickListener(this.m);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = this.k;
            layoutParams.width = this.j;
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void setController(xs8 xs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xs8Var) == null) {
            this.l = xs8Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundItemView(Context context, AttributeSet attributeSet) {
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
        this.m = new a(this);
        this.a = context;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        this.a = context;
        g();
    }
}
