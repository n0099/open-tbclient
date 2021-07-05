package com.baidu.tieba.themeCenter.card.category;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21442e;

    /* renamed from: f  reason: collision with root package name */
    public View f21443f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21444g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21445h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21446i;
    public TbImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public d.a.s0.n3.a n;
    public b o;
    public int p;
    public int q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCardItemView f21447e;

        public a(PersonalCardItemView personalCardItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21447e = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f21447e.o == null) {
                return;
            }
            this.f21447e.o.a(this.f21447e.n);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(d.a.s0.n3.a aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context) {
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
        this.f21442e = context;
        d();
    }

    public void c(d.a.s0.n3.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.n = aVar;
        if (aVar.a() == d.a.s0.n3.a.k) {
            this.f21444g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.f21444g, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f21444g, R.drawable.icon_bubble_choose_no);
            this.f21445h.setVisibility(0);
            this.j.setVisibility(8);
            this.f21446i.setVisibility(8);
        } else {
            this.f21445h.setVisibility(8);
            this.j.setVisibility(0);
            this.f21446i.setVisibility(0);
            this.f21444g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f21444g.setImageBitmap(null);
            this.f21444g.setDefaultResource(R.drawable.img_default_100);
            this.f21444g.M(aVar.e(), 10, false);
        }
        if (aVar.g() == 1) {
            this.k.setVisibility(0);
            SkinManager.setImageResource(this.k, R.drawable.icon_choose_photo);
        } else {
            this.k.setVisibility(8);
        }
        this.f21446i.M(aVar.i(), 10, false);
        this.j.M(aVar.b(), 10, false);
        this.l.setText(aVar.j());
        setVisibility(0);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            int k = (l.k(this.f21442e) - l.g(this.f21442e, R.dimen.ds88)) / 3;
            this.p = k;
            this.q = (int) (k * 0.57d);
            View inflate = LayoutInflater.from(this.f21442e).inflate(R.layout.personal_card_item_layout, this);
            this.f21443f = inflate;
            this.f21444g = (TbImageView) inflate.findViewById(R.id.image_bg);
            TbImageView tbImageView = (TbImageView) this.f21443f.findViewById(R.id.permission_icon);
            this.f21446i = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f21446i.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f21443f.findViewById(R.id.state_icon);
            this.j = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.j.setDefaultBgResource(R.drawable.transparent_bg);
            this.k = (ImageView) this.f21443f.findViewById(R.id.choosed_icon);
            this.f21445h = (TextView) this.f21443f.findViewById(R.id.txt_default);
            this.l = (TextView) this.f21443f.findViewById(R.id.view_card_name);
            this.m = this.f21443f.findViewById(R.id.black_stroke);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21444g.getLayoutParams();
            layoutParams.height = this.q;
            layoutParams.width = this.p;
            this.f21444g.setLayoutParams(layoutParams);
            this.m.setLayoutParams(layoutParams);
            this.f21444g.setOnClickListener(new a(this));
        }
    }

    public b getCardViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (b) invokeV.objValue;
    }

    public void setCardViewController(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.o = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet) {
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
        this.f21442e = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f21442e = context;
        d();
    }
}
