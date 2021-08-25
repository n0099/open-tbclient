package com.baidu.tieba.themeCenter.background;

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
import c.a.q0.o3.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
/* loaded from: classes7.dex */
public class BackgroundItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57263e;

    /* renamed from: f  reason: collision with root package name */
    public View f57264f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f57265g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f57266h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f57267i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f57268j;
    public TextView k;
    public SkinProgressView l;
    public DressItemData m;
    public int n;
    public int o;
    public d p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BackgroundItemView f57269e;

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
            this.f57269e = backgroundItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f57269e.m == null || this.f57269e.p == null) {
                return;
            }
            if (view == this.f57269e.l) {
                TiebaStatic.log(new StatisticItem("c10280").param("obj_id", this.f57269e.m.getPropsId()));
                this.f57269e.p.e(this.f57269e.m, false);
            } else if (view == this.f57269e.f57265g) {
                TiebaStatic.log(new StatisticItem("c10279").param("obj_id", this.f57269e.m.getPropsId()));
                this.f57269e.p.b(this.f57269e.m);
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
        this.f57263e = context;
        e();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int k = (l.k(this.f57263e) - l.g(this.f57263e, R.dimen.ds88)) / 3;
            this.n = k;
            this.o = (int) (k / 0.66d);
            View inflate = LayoutInflater.from(this.f57263e).inflate(R.layout.background_item, this);
            this.f57264f = inflate;
            this.f57265g = (TbImageView) inflate.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f57264f.findViewById(R.id.permission_icon);
            this.f57266h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f57266h.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f57264f.findViewById(R.id.state_icon);
            this.f57267i = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.f57267i.setDefaultBgResource(R.drawable.transparent_bg);
            this.f57268j = (ImageView) this.f57264f.findViewById(R.id.choosed_icon);
            this.k = (TextView) this.f57264f.findViewById(R.id.text_bg_name);
            SkinProgressView skinProgressView = (SkinProgressView) this.f57264f.findViewById(R.id.view_bg_use);
            this.l = skinProgressView;
            skinProgressView.setOnClickListener(this.q);
            this.f57265g.setOnClickListener(this.q);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f57265g.getLayoutParams();
            layoutParams.height = this.o;
            layoutParams.width = this.n;
            this.f57265g.setLayoutParams(layoutParams);
        }
    }

    public void fillView(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.m = dressItemData;
        Boolean valueOf = Boolean.valueOf(dressItemData.getInUse());
        if (dressItemData.getPropsId() == 0) {
            SkinManager.setImageResource(this.f57265g, R.drawable.pic_bg_moren);
        } else {
            this.f57265g.setImageBitmap(null);
            this.f57265g.startLoad(dressItemData.getExampleImgUrl(), 10, false);
        }
        this.k.setText(dressItemData.getTitle());
        if (valueOf.booleanValue()) {
            this.f57268j.setVisibility(0);
            SkinManager.setImageResource(this.f57268j, R.drawable.icon_choose_photo);
        } else {
            this.f57268j.setVisibility(8);
        }
        this.f57266h.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
        this.f57267i.startLoad(dressItemData.getPropsStateImg(), 10, false);
        if (valueOf.booleanValue()) {
            this.l.updateStatus(0, 0.0f);
        } else {
            this.l.updateStatus(4, 0.0f);
        }
        setVisibility(0);
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f57263e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f57264f);
    }

    public void setController(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
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
        this.f57263e = context;
        e();
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
        this.f57263e = context;
        e();
    }
}
