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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BubbleView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int BCODE_NONE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51442e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f51443f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f51444g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f51445h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f51446i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public View n;
    public ViewGroup o;
    public ViewGroup p;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public boolean t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51442e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f51442e).inflate(getXmlLayoutResId(), this);
            this.f51443f = (ViewGroup) inflate.findViewById(R.id.bubble_layout);
            this.f51444g = (TbImageView) inflate.findViewById(R.id.bubble_image);
            this.f51445h = (ImageView) inflate.findViewById(R.id.bubble_iamge_bg);
            this.f51446i = (ImageView) inflate.findViewById(R.id.free_tip);
            this.j = (ImageView) inflate.findViewById(R.id.defualt_tip);
            this.k = (ImageView) inflate.findViewById(R.id.bubble_notuse_iamge);
            this.l = (ImageView) inflate.findViewById(R.id.bubble_round_up);
            this.m = (ImageView) inflate.findViewById(R.id.bubble_round_full);
            this.n = inflate.findViewById(R.id.bubble_center_line);
            this.o = (ViewGroup) inflate.findViewById(R.id.bubble_bottom_layout);
            this.p = (ViewGroup) inflate.findViewById(R.id.has_icon_name);
            this.q = (TbImageView) inflate.findViewById(R.id.icon_iamge);
            this.r = (TextView) inflate.findViewById(R.id.bubble_name);
            this.s = (TextView) inflate.findViewById(R.id.no_icon_name);
        }
    }

    public void changeSkinType(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            tbPageContext.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            tbPageContext.getLayoutMode().j(this);
        }
    }

    public void changeState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f51445h.setVisibility(0);
                this.j.setVisibility(0);
                return;
            }
            this.f51445h.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public int getXmlLayoutResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.bubbleview : invokeV.intValue;
    }

    public boolean isShowName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public void setCurrentNotUse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f51443f.setVisibility(8);
            this.k.setVisibility(0);
            this.f51446i.setVisibility(8);
            if (!this.t) {
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.l.setVisibility(8);
                this.m.setVisibility(0);
                return;
            }
            this.n.setVisibility(0);
            this.o.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.p.setVisibility(8);
            this.s.setVisibility(0);
            this.s.setText(this.f51442e.getString(R.string.bubble_notuse_text));
        }
    }

    public void setData(BubbleListData.BubbleData bubbleData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, bubbleData, z) == null) || bubbleData == null) {
            return;
        }
        if (bubbleData.getBcode() == 0) {
            setCurrentNotUse();
            this.j.setVisibility(z ? 0 : 8);
            this.f51445h.setVisibility(z ? 0 : 8);
            return;
        }
        this.f51443f.setVisibility(0);
        this.k.setVisibility(8);
        if (bubbleData.isDef()) {
            this.f51445h.setVisibility(0);
            this.j.setVisibility(0);
        } else {
            this.f51445h.setVisibility(8);
            this.j.setVisibility(8);
        }
        if (bubbleData.isFree()) {
            this.f51446i.setVisibility(0);
        } else {
            this.f51446i.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bubbleData.getB_url())) {
            this.f51444g.setTag(bubbleData.getB_url());
            this.f51444g.startLoad(bubbleData.getB_url(), 10, false);
        }
        if (!this.t) {
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setVisibility(8);
        if (!TextUtils.isEmpty(bubbleData.getIcon_url())) {
            this.p.setVisibility(0);
            this.s.setVisibility(8);
            this.r.setText(bubbleData.getBname());
            this.q.setTag(bubbleData.getIcon_url());
            this.q.startLoad(bubbleData.getIcon_url(), 10, false);
            return;
        }
        this.p.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(bubbleData.getBname());
    }

    public void setShowName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.t = z;
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
        this.f51442e = context;
        a();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51442e = context;
        a();
    }
}
