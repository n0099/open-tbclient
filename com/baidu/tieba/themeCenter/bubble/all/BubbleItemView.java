package com.baidu.tieba.themeCenter.bubble.all;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class BubbleItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57499e;

    /* renamed from: f  reason: collision with root package name */
    public View f57500f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f57501g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f57502h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f57503i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f57504j;
    public TbImageView k;
    public ImageView l;
    public DressItemData m;
    public c.a.r0.q3.f.a.a n;
    public boolean o;
    public View.OnClickListener p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BubbleItemView f57505e;

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
            this.f57505e = bubbleItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f57505e.m == null || this.f57505e.n == null || view != this.f57505e.f57502h) {
                return;
            }
            this.f57505e.n.b(this.f57505e.m, this.f57505e.o);
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
        this.f57499e = context;
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f57499e).inflate(R.layout.bubble_item, this);
            this.f57500f = inflate;
            this.f57501g = (FrameLayout) inflate.findViewById(R.id.ly_bubble);
            this.f57502h = (TbImageView) this.f57500f.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f57500f.findViewById(R.id.permission_icon);
            this.f57504j = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f57504j.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f57500f.findViewById(R.id.state_icon);
            this.k = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.k.setDefaultBgResource(R.drawable.transparent_bg);
            this.l = (ImageView) this.f57500f.findViewById(R.id.choosed_icon);
            this.f57503i = new TextView(this.f57499e);
            this.f57502h.setOnClickListener(this.p);
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
            this.f57502h.setDefaultResource(R.drawable.icon_choose_no);
            this.f57502h.startLoad("", 10, false);
            this.f57503i.setText(R.string.default_bubble);
            this.f57503i.setGravity(17);
            this.f57503i.setTextSize(0, l.g(this.f57499e, R.dimen.ds28));
            this.f57503i.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f57503i.setLayoutParams(layoutParams);
            this.f57503i.setVisibility(0);
            this.f57501g.removeView(this.f57503i);
            this.f57501g.addView(this.f57503i);
        } else {
            this.f57501g.removeView(this.f57503i);
            this.f57502h.setDefaultResource(R.drawable.img_default_100);
            this.f57502h.startLoad(dressItemData.getExampleImgUrl(), 10, false);
        }
        if (inUse) {
            this.l.setVisibility(0);
            SkinManager.setImageResource(this.l, R.drawable.icon_choose_photo);
        } else {
            this.l.setVisibility(8);
        }
        this.f57504j.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f57499e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f57500f);
    }

    public void setController(c.a.r0.q3.f.a.a aVar) {
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
        this.f57499e = context;
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
        this.f57499e = context;
        d();
    }
}
