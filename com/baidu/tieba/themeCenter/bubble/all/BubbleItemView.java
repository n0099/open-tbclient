package com.baidu.tieba.themeCenter.bubble.all;

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
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes4.dex */
public class BubbleItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21572e;

    /* renamed from: f  reason: collision with root package name */
    public View f21573f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f21574g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21575h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21576i;
    public TbImageView j;
    public TbImageView k;
    public ImageView l;
    public DressItemData m;
    public d.a.q0.n3.f.a.a n;
    public boolean o;
    public View.OnClickListener p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BubbleItemView f21577e;

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
            this.f21577e = bubbleItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f21577e.m == null || this.f21577e.n == null || view != this.f21577e.f21575h) {
                return;
            }
            this.f21577e.n.b(this.f21577e.m, this.f21577e.o);
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
        this.f21572e = context;
        f();
    }

    public void d(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.m = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isDefault()) {
            this.f21575h.setDefaultResource(R.drawable.icon_choose_no);
            this.f21575h.M("", 10, false);
            this.f21576i.setText(R.string.default_bubble);
            this.f21576i.setGravity(17);
            this.f21576i.setTextSize(0, l.g(this.f21572e, R.dimen.ds28));
            this.f21576i.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f21576i.setLayoutParams(layoutParams);
            this.f21576i.setVisibility(0);
            this.f21574g.removeView(this.f21576i);
            this.f21574g.addView(this.f21576i);
        } else {
            this.f21574g.removeView(this.f21576i);
            this.f21575h.setDefaultResource(R.drawable.img_default_100);
            this.f21575h.M(dressItemData.getExampleImgUrl(), 10, false);
        }
        if (inUse) {
            this.l.setVisibility(0);
            SkinManager.setImageResource(this.l, R.drawable.icon_choose_photo);
        } else {
            this.l.setVisibility(8);
        }
        this.j.M(dressItemData.getPermissionImgUrl(), 10, false);
        this.k.M(dressItemData.getPropsStateImg(), 10, false);
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
            View inflate = LayoutInflater.from(this.f21572e).inflate(R.layout.bubble_item, this);
            this.f21573f = inflate;
            this.f21574g = (FrameLayout) inflate.findViewById(R.id.ly_bubble);
            this.f21575h = (TbImageView) this.f21573f.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f21573f.findViewById(R.id.permission_icon);
            this.j = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.j.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f21573f.findViewById(R.id.state_icon);
            this.k = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.k.setDefaultBgResource(R.drawable.transparent_bg);
            this.l = (ImageView) this.f21573f.findViewById(R.id.choosed_icon);
            this.f21576i = new TextView(this.f21572e);
            this.f21575h.setOnClickListener(this.p);
        }
    }

    public void setController(d.a.q0.n3.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public void setFromBubbleGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
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
        this.f21572e = context;
        f();
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
        this.f21572e = context;
        f();
    }
}
