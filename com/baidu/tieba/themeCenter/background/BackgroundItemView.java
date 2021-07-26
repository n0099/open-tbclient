package com.baidu.tieba.themeCenter.background;

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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.n3.e.d;
/* loaded from: classes4.dex */
public class BackgroundItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21548e;

    /* renamed from: f  reason: collision with root package name */
    public View f21549f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21550g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21551h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21552i;
    public ImageView j;
    public TextView k;
    public SkinProgressView l;
    public DressItemData m;
    public int n;
    public int o;
    public d p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BackgroundItemView f21553e;

        public a(BackgroundItemView backgroundItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {backgroundItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21553e = backgroundItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f21553e.m == null || this.f21553e.p == null) {
                return;
            }
            if (view == this.f21553e.l) {
                TiebaStatic.log(new StatisticItem("c10280").param("obj_id", this.f21553e.m.getPropsId()));
                this.f21553e.p.e(this.f21553e.m, false);
            } else if (view == this.f21553e.f21550g) {
                TiebaStatic.log(new StatisticItem("c10279").param("obj_id", this.f21553e.m.getPropsId()));
                this.f21553e.p.b(this.f21553e.m);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.f21548e = context;
        g();
    }

    public void e(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.m = dressItemData;
        Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
        if (dressItemData.getPropsId() == 0) {
            SkinManager.setImageResource(this.f21550g, R.drawable.pic_bg_moren);
        } else {
            this.f21550g.setImageBitmap(null);
            this.f21550g.M(dressItemData.getExampleImgUrl(), 10, false);
        }
        this.k.setText(dressItemData.getTitle());
        if (valueOf.booleanValue()) {
            this.j.setVisibility(0);
            SkinManager.setImageResource(this.j, R.drawable.icon_choose_photo);
        } else {
            this.j.setVisibility(8);
        }
        this.f21551h.M(dressItemData.getPermissionImgUrl(), 10, false);
        this.f21552i.M(dressItemData.getPropsStateImg(), 10, false);
        if (valueOf.booleanValue()) {
            this.l.c(0, 0.0f);
        } else {
            this.l.c(4, 0.0f);
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
            int k = (l.k(this.f21548e) - l.g(this.f21548e, R.dimen.ds88)) / 3;
            this.n = k;
            this.o = (int) (k / 0.66d);
            View inflate = LayoutInflater.from(this.f21548e).inflate(R.layout.background_item, this);
            this.f21549f = inflate;
            this.f21550g = (TbImageView) inflate.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f21549f.findViewById(R.id.permission_icon);
            this.f21551h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f21551h.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f21549f.findViewById(R.id.state_icon);
            this.f21552i = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.f21552i.setDefaultBgResource(R.drawable.transparent_bg);
            this.j = (ImageView) this.f21549f.findViewById(R.id.choosed_icon);
            this.k = (TextView) this.f21549f.findViewById(R.id.text_bg_name);
            SkinProgressView skinProgressView = (SkinProgressView) this.f21549f.findViewById(R.id.view_bg_use);
            this.l = skinProgressView;
            skinProgressView.setOnClickListener(this.q);
            this.f21550g.setOnClickListener(this.q);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21550g.getLayoutParams();
            layoutParams.height = this.o;
            layoutParams.width = this.n;
            this.f21550g.setLayoutParams(layoutParams);
        }
    }

    public void setController(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.p = dVar;
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
        this.q = new a(this);
        this.f21548e = context;
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.q = new a(this);
        this.f21548e = context;
        g();
    }
}
