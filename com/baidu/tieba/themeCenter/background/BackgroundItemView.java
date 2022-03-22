package com.baidu.tieba.themeCenter.background;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.f4.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BackgroundItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f36316b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f36317c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f36318d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f36319e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36320f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f36321g;

    /* renamed from: h  reason: collision with root package name */
    public SkinProgressView f36322h;
    public DressItemData i;
    public int j;
    public int k;
    public d l;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.a.i == null || this.a.l == null) {
                return;
            }
            if (view == this.a.f36322h) {
                TiebaStatic.log(new StatisticItem("c10280").param("obj_id", this.a.i.getPropsId()));
                this.a.l.e(this.a.i, false);
            } else if (view == this.a.f36317c) {
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
            SkinManager.setImageResource(this.f36317c, R.drawable.pic_bg_moren);
        } else {
            this.f36317c.setImageBitmap(null);
            this.f36317c.J(dressItemData.getExampleImgUrl(), 10, false);
        }
        this.f36321g.setText(dressItemData.getTitle());
        if (valueOf.booleanValue()) {
            this.f36320f.setVisibility(0);
            SkinManager.setImageResource(this.f36320f, R.drawable.icon_choose_photo);
        } else {
            this.f36320f.setVisibility(8);
        }
        this.f36318d.J(dressItemData.getPermissionImgUrl(), 10, false);
        this.f36319e.J(dressItemData.getPropsStateImg(), 10, false);
        if (valueOf.booleanValue()) {
            this.f36322h.c(0, 0.0f);
        } else {
            this.f36322h.c(4, 0.0f);
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
            int k = (n.k(this.a) - n.f(this.a, R.dimen.obfuscated_res_0x7f0702ff)) / 3;
            this.j = k;
            this.k = (int) (k / 0.66d);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d012f, this);
            this.f36316b = inflate;
            this.f36317c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09035d);
            TbImageView tbImageView = (TbImageView) this.f36316b.findViewById(R.id.obfuscated_res_0x7f09176d);
            this.f36318d = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36318d.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            TbImageView tbImageView2 = (TbImageView) this.f36316b.findViewById(R.id.obfuscated_res_0x7f091da2);
            this.f36319e = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36319e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36320f = (ImageView) this.f36316b.findViewById(R.id.obfuscated_res_0x7f090615);
            this.f36321g = (TextView) this.f36316b.findViewById(R.id.obfuscated_res_0x7f091f29);
            SkinProgressView skinProgressView = (SkinProgressView) this.f36316b.findViewById(R.id.obfuscated_res_0x7f0923b0);
            this.f36322h = skinProgressView;
            skinProgressView.setOnClickListener(this.m);
            this.f36317c.setOnClickListener(this.m);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36317c.getLayoutParams();
            layoutParams.height = this.k;
            layoutParams.width = this.j;
            this.f36317c.setLayoutParams(layoutParams);
        }
    }

    public void setController(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.l = dVar;
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
