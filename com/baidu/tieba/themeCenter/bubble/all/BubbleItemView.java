package com.baidu.tieba.themeCenter.bubble.all;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.ln4;
import com.baidu.tieba.ps8;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BubbleItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public FrameLayout c;
    public TbImageView d;
    public TbAlphaVideo e;
    public TextView f;
    public TbImageView g;
    public TbImageView h;
    public ImageView i;
    public DressItemData j;
    public ps8 k;
    public boolean l;
    public View.OnClickListener m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleItemView a;

        public a(BubbleItemView bubbleItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bubbleItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.a.j == null || this.a.k == null) {
                return;
            }
            if (view2 == this.a.d || view2 == this.a.e) {
                this.a.k.b(this.a.j, this.a.l);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleItemView(Context context) {
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
        this.j = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isDefault()) {
            this.d.setDefaultResource(R.drawable.obfuscated_res_0x7f0806d1);
            this.d.K("", 10, false);
            this.f.setText(R.string.obfuscated_res_0x7f0f0498);
            this.f.setGravity(17);
            this.f.setTextSize(0, ej.f(this.a, R.dimen.obfuscated_res_0x7f0701f9));
            this.f.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f.setLayoutParams(layoutParams);
            this.f.setVisibility(0);
            this.c.removeView(this.f);
            this.c.addView(this.f);
        } else {
            this.c.removeView(this.f);
            if (!TextUtils.isEmpty(dressItemData.getDynamicUrlSmall())) {
                this.e.setVisibility(0);
                this.d.setVisibility(8);
                this.e.k(ln4.a(dressItemData.getDynamicUrlSmall()));
            } else {
                this.e.setVisibility(8);
                this.d.setVisibility(0);
                this.d.setDefaultResource(R.drawable.obfuscated_res_0x7f080be0);
                this.d.K(dressItemData.getExampleImgUrl(), 10, false);
            }
        }
        if (inUse) {
            this.i.setVisibility(0);
            SkinManager.setImageResource(this.i, R.drawable.icon_choose_photo);
        } else {
            this.i.setVisibility(8);
        }
        this.g.K(dressItemData.getPermissionImgUrl(), 10, false);
        this.h.K(dressItemData.getPropsStateImg(), 10, false);
        setVisibility(0);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(4);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0168, this);
            this.b = inflate;
            this.c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091472);
            this.d = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090385);
            this.e = (TbAlphaVideo) this.b.findViewById(R.id.obfuscated_res_0x7f09014e);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918cf);
            this.g = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f08123c);
            this.g.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08123c);
            TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f7a);
            this.h = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f08123c);
            this.h.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08123c);
            this.i = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090620);
            this.f = new TextView(this.a);
            this.d.setOnClickListener(this.m);
            this.e.setOnClickListener(this.m);
        }
    }

    public void setController(ps8 ps8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ps8Var) == null) {
            this.k = ps8Var;
        }
    }

    public void setFromBubbleGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleItemView(Context context, AttributeSet attributeSet) {
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
    public BubbleItemView(Context context, AttributeSet attributeSet, int i) {
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
