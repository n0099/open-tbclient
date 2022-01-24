package com.baidu.tieba.themeCenter.bubble.all;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class BubbleItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48446e;

    /* renamed from: f  reason: collision with root package name */
    public View f48447f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f48448g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f48449h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48450i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f48451j;
    public TbImageView k;
    public ImageView l;
    public DressItemData m;
    public c.a.t0.c4.f.a.a n;
    public boolean o;
    public View.OnClickListener p;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BubbleItemView f48452e;

        public a(BubbleItemView bubbleItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48452e = bubbleItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f48452e.m == null || this.f48452e.n == null || view != this.f48452e.f48449h) {
                return;
            }
            this.f48452e.n.b(this.f48452e.m, this.f48452e.o);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.f48446e = context;
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f48446e).inflate(R.layout.bubble_item, this);
            this.f48447f = inflate;
            this.f48448g = (FrameLayout) inflate.findViewById(R.id.ly_bubble);
            this.f48449h = (TbImageView) this.f48447f.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f48447f.findViewById(R.id.permission_icon);
            this.f48451j = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f48451j.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f48447f.findViewById(R.id.state_icon);
            this.k = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.k.setDefaultBgResource(R.drawable.transparent_bg);
            this.l = (ImageView) this.f48447f.findViewById(R.id.choosed_icon);
            this.f48450i = new TextView(this.f48446e);
            this.f48449h.setOnClickListener(this.p);
        }
    }

    public void fillView(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.m = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isDefault()) {
            this.f48449h.setDefaultResource(R.drawable.icon_choose_no);
            this.f48449h.startLoad("", 10, false);
            this.f48450i.setText(R.string.default_bubble);
            this.f48450i.setGravity(17);
            this.f48450i.setTextSize(0, n.f(this.f48446e, R.dimen.ds28));
            this.f48450i.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f48450i.setLayoutParams(layoutParams);
            this.f48450i.setVisibility(0);
            this.f48448g.removeView(this.f48450i);
            this.f48448g.addView(this.f48450i);
        } else {
            this.f48448g.removeView(this.f48450i);
            this.f48449h.setDefaultResource(R.drawable.img_default_100);
            this.f48449h.startLoad(dressItemData.getExampleImgUrl(), 10, false);
        }
        if (inUse) {
            this.l.setVisibility(0);
            SkinManager.setImageResource(this.l, R.drawable.icon_choose_photo);
        } else {
            this.l.setVisibility(8);
        }
        this.f48451j.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
        this.k.startLoad(dressItemData.getPropsStateImg(), 10, false);
        setVisibility(0);
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(4);
        }
    }

    public void onChangeSkinType() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f48446e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f48447f);
    }

    public void setController(c.a.t0.c4.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void setFromBubbleGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.o = z;
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
        this.p = new a(this);
        this.f48446e = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.f48446e = context;
        d();
    }
}
