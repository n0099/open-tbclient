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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mqa;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class BubbleItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public FrameLayout c;
    public TbImageView d;
    public TextView e;
    public TbImageView f;
    public TbImageView g;
    public ImageView h;
    public TbImageView i;
    public DressItemData j;
    public mqa k;
    public boolean l;
    public View.OnClickListener m;

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.j != null && this.a.k != null && view2 == this.a.d) {
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
        f();
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
        f();
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
        f();
    }

    public void setController(mqa mqaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mqaVar) == null) {
            this.k = mqaVar;
        }
    }

    public void setFromBubbleGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    public void d(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dressItemData) != null) || dressItemData == null) {
            return;
        }
        this.j = dressItemData;
        boolean inUse = dressItemData.getInUse();
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(dressItemData.getDynamicUrl());
        if (dressItemData.isDefault()) {
            this.d.setDefaultResource(R.drawable.obfuscated_res_0x7f08087c);
            this.d.startLoad("", 10, false);
            this.e.setText(R.string.obfuscated_res_0x7f0f0531);
            this.e.setGravity(17);
            this.e.setTextSize(0, BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f0701f9));
            this.e.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.e.setLayoutParams(layoutParams);
            this.e.setVisibility(0);
            this.c.removeView(this.e);
            this.c.addView(this.e);
        } else {
            this.c.removeView(this.e);
            if (z2) {
                this.i.setVisibility(0);
                SkinManager.setImageResource(this.i, R.drawable.icon_mask_vip_dynamic);
            } else {
                this.i.setVisibility(8);
            }
            this.d.setVisibility(0);
            this.d.setDefaultResource(R.drawable.img_default_100);
            this.d.startLoad(dressItemData.getExampleImgUrl(), 10, false);
        }
        if (inUse) {
            this.h.setVisibility(0);
            SkinManager.setImageResource(this.h, R.drawable.icon_choose_photo);
        } else {
            this.h.setVisibility(8);
        }
        if (dressItemData.getFreeUserLevel() != 1) {
            z = false;
        }
        if (z) {
            if (!z2) {
                SkinManager.setImageResource(this.i, R.drawable.icon_mask_vip);
                this.i.setVisibility(0);
            }
        } else {
            this.i.setVisibility(8);
        }
        this.g.startLoad(dressItemData.getPropsStateImg(), 10, false);
        setVisibility(0);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(4);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0191, this);
            this.b = inflate;
            this.c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09169a);
            this.d = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0903dc);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b95);
            this.f = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0922e2);
            this.g = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.g.setDefaultBgResource(R.drawable.transparent_bg);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0906e8);
            this.e = new TextView(this.a);
            this.d.setOnClickListener(this.m);
            this.i = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090fff);
        }
    }
}
