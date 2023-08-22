package com.baidu.tieba.memberCenter.bubble;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public TbImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public View j;
    public ViewGroup k;
    public ViewGroup l;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public boolean p;

    public int getXmlLayoutResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0191 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleView(Context context) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleView(Context context, AttributeSet attributeSet) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleView(Context context, AttributeSet attributeSet, int i) {
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
        b();
    }

    public void a(TbPageContext<?> tbPageContext) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            tbPageContext.getLayoutMode().onModeChanged(this);
        }
    }

    public void setShowName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.p = z;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(getXmlLayoutResId(), this);
            this.b = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090514);
            this.c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090511);
            this.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090510);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09100d);
            this.f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09086e);
            this.g = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090516);
            this.h = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09051a);
            this.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090519);
            this.j = inflate.findViewById(R.id.obfuscated_res_0x7f09050b);
            this.k = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090509);
            this.l = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090ef4);
            this.m = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091009);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090515);
            this.o = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09197b);
        }
    }

    public void setCurrentNotUse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setVisibility(8);
            this.g.setVisibility(0);
            this.e.setVisibility(8);
            if (!this.p) {
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.o.setVisibility(0);
            this.o.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03ae));
        }
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, bubbleData, z) != null) || bubbleData == null) {
            return;
        }
        int i3 = 8;
        if (bubbleData.getBcode() == 0) {
            setCurrentNotUse();
            ImageView imageView = this.f;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            ImageView imageView2 = this.d;
            if (z) {
                i3 = 0;
            }
            imageView2.setVisibility(i3);
            return;
        }
        this.b.setVisibility(0);
        this.g.setVisibility(8);
        if (bubbleData.isDef()) {
            this.d.setVisibility(0);
            this.f.setVisibility(0);
        } else {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
        }
        if (TextUtils.isEmpty(bubbleData.getDynamicUrl()) && bubbleData.isFree()) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            ImageView imageView3 = this.e;
            if (!TextUtils.isEmpty(bubbleData.getDynamicUrl())) {
                i = R.drawable.icon_mask_vip_dynamic;
            } else {
                i = R.drawable.icon_mask_vip;
            }
            imageView3.setBackgroundResource(i);
        }
        this.c.setTag(bubbleData.getB_url());
        this.c.startLoad(bubbleData.getB_url(), 10, false);
        if (!this.p) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.h.setVisibility(0);
        this.i.setVisibility(8);
        if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
            this.l.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setText(bubbleData.getBname());
            this.m.setTag(bubbleData.getIcon_url());
            this.m.startLoad(bubbleData.getIcon_url(), 10, false);
            return;
        }
        this.l.setVisibility(8);
        this.o.setVisibility(0);
        this.o.setText(bubbleData.getBname());
    }
}
