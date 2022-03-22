package com.baidu.tieba.themeCenter.bubble.all;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
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

    /* renamed from: b  reason: collision with root package name */
    public View f36334b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f36335c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f36336d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36337e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f36338f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f36339g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f36340h;
    public DressItemData i;
    public c.a.p0.f4.f.a.a j;
    public boolean k;
    public View.OnClickListener l;

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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.a.i == null || this.a.j == null || view != this.a.f36336d) {
                return;
            }
            this.a.j.b(this.a.i, this.a.k);
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
        this.l = new a(this);
        this.a = context;
        f();
    }

    public void d(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.i = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isDefault()) {
            this.f36336d.setDefaultResource(R.drawable.obfuscated_res_0x7f0806c9);
            this.f36336d.J("", 10, false);
            this.f36337e.setText(R.string.obfuscated_res_0x7f0f0477);
            this.f36337e.setGravity(17);
            this.f36337e.setTextSize(0, n.f(this.a, R.dimen.obfuscated_res_0x7f0701f9));
            this.f36337e.setTextColor(getResources().getColor(R.color.CAM_X0108));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f36337e.setLayoutParams(layoutParams);
            this.f36337e.setVisibility(0);
            this.f36335c.removeView(this.f36337e);
            this.f36335c.addView(this.f36337e);
        } else {
            this.f36335c.removeView(this.f36337e);
            this.f36336d.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
            this.f36336d.J(dressItemData.getExampleImgUrl(), 10, false);
        }
        if (inUse) {
            this.f36340h.setVisibility(0);
            SkinManager.setImageResource(this.f36340h, R.drawable.icon_choose_photo);
        } else {
            this.f36340h.setVisibility(8);
        }
        this.f36338f.J(dressItemData.getPermissionImgUrl(), 10, false);
        this.f36339g.J(dressItemData.getPropsStateImg(), 10, false);
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
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0167, this);
            this.f36334b = inflate;
            this.f36335c = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091361);
            this.f36336d = (TbImageView) this.f36334b.findViewById(R.id.obfuscated_res_0x7f09035d);
            TbImageView tbImageView = (TbImageView) this.f36334b.findViewById(R.id.obfuscated_res_0x7f09176d);
            this.f36338f = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36338f.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            TbImageView tbImageView2 = (TbImageView) this.f36334b.findViewById(R.id.obfuscated_res_0x7f091da2);
            this.f36339g = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36339g.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36340h = (ImageView) this.f36334b.findViewById(R.id.obfuscated_res_0x7f090615);
            this.f36337e = new TextView(this.a);
            this.f36336d.setOnClickListener(this.l);
        }
    }

    public void setController(c.a.p0.f4.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public void setFromBubbleGroup(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k = z;
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
        this.l = new a(this);
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
        this.l = new a(this);
        this.a = context;
        f();
    }
}
