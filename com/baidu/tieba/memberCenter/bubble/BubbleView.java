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
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ln4;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BubbleView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public TbImageView c;
    public TbAlphaVideo d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public View k;
    public ViewGroup l;
    public ViewGroup m;
    public TbImageView n;
    public TextView o;
    public TextView p;
    public boolean q;

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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            tbPageContext.getLayoutMode().l(skinType == 1);
            tbPageContext.getLayoutMode().k(this);
            if (this.d.getVisibility() == 0) {
                this.d.g(skinType);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(getXmlLayoutResId(), this);
            this.b = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090476);
            this.c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090474);
            this.d = (TbAlphaVideo) inflate.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090473);
            this.f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ad6);
            this.g = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09077f);
            this.h = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090478);
            this.i = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09047c);
            this.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09047b);
            this.k = inflate.findViewById(R.id.obfuscated_res_0x7f090471);
            this.l = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09046f);
            this.m = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f090d23);
            this.n = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e2a);
            this.o = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090477);
            this.p = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916d2);
        }
    }

    public int getXmlLayoutResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d016b : invokeV.intValue;
    }

    public void setCurrentNotUse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setVisibility(8);
            this.h.setVisibility(0);
            this.f.setVisibility(8);
            if (!this.q) {
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.i.setVisibility(8);
                this.j.setVisibility(0);
                return;
            }
            this.k.setVisibility(0);
            this.l.setVisibility(0);
            this.i.setVisibility(0);
            this.j.setVisibility(8);
            this.m.setVisibility(8);
            this.p.setVisibility(0);
            this.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0357));
        }
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, bubbleData, z) == null) || bubbleData == null) {
            return;
        }
        if (bubbleData.getBcode() == 0) {
            setCurrentNotUse();
            this.g.setVisibility(z ? 0 : 8);
            this.e.setVisibility(z ? 0 : 8);
            return;
        }
        this.b.setVisibility(0);
        this.h.setVisibility(8);
        if (bubbleData.isDef()) {
            this.e.setVisibility(0);
            this.g.setVisibility(0);
        } else {
            this.e.setVisibility(8);
            this.g.setVisibility(8);
        }
        if (bubbleData.isFree()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bubbleData.getDynamicUrlSmall())) {
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            this.d.k(ln4.a(bubbleData.getDynamicUrlSmall()));
        } else if (!TextUtils.isEmpty(bubbleData.getB_url())) {
            this.c.setVisibility(0);
            this.d.setVisibility(8);
            this.c.setTag(bubbleData.getB_url());
            this.c.K(bubbleData.getB_url(), 10, false);
        }
        if (!this.q) {
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            return;
        }
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(8);
        if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
            this.m.setVisibility(0);
            this.p.setVisibility(8);
            this.o.setText(bubbleData.getBname());
            this.n.setTag(bubbleData.getIcon_url());
            this.n.K(bubbleData.getIcon_url(), 10, false);
            return;
        }
        this.m.setVisibility(8);
        this.p.setVisibility(0);
        this.p.setText(bubbleData.getBname());
    }

    public void setShowName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.q = z;
        }
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
}
