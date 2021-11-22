package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55507e;

    /* renamed from: f  reason: collision with root package name */
    public View f55508f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f55509g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55510h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f55511i;
    public TbImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public b.a.r0.s3.a n;
    public b o;
    public int p;
    public int q;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCardItemView f55512e;

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
            this.f55512e = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f55512e.o == null) {
                return;
            }
            this.f55512e.o.a(this.f55512e.n);
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(b.a.r0.s3.a aVar);
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
        this.f55507e = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            int k = (l.k(this.f55507e) - l.g(this.f55507e, R.dimen.ds88)) / 3;
            this.p = k;
            this.q = (int) (k * 0.57d);
            View inflate = LayoutInflater.from(this.f55507e).inflate(R.layout.personal_card_item_layout, this);
            this.f55508f = inflate;
            this.f55509g = (TbImageView) inflate.findViewById(R.id.image_bg);
            TbImageView tbImageView = (TbImageView) this.f55508f.findViewById(R.id.permission_icon);
            this.f55511i = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f55511i.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f55508f.findViewById(R.id.state_icon);
            this.j = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.j.setDefaultBgResource(R.drawable.transparent_bg);
            this.k = (ImageView) this.f55508f.findViewById(R.id.choosed_icon);
            this.f55510h = (TextView) this.f55508f.findViewById(R.id.txt_default);
            this.l = (TextView) this.f55508f.findViewById(R.id.view_card_name);
            this.m = this.f55508f.findViewById(R.id.black_stroke);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f55509g.getLayoutParams();
            layoutParams.height = this.q;
            layoutParams.width = this.p;
            this.f55509g.setLayoutParams(layoutParams);
            this.m.setLayoutParams(layoutParams);
            this.f55509g.setOnClickListener(new a(this));
        }
    }

    public void fillData(b.a.r0.s3.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.n = aVar;
        if (aVar.a() == b.a.r0.s3.a.k) {
            this.f55509g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.f55509g, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f55509g, R.drawable.icon_bubble_choose_no);
            this.f55510h.setVisibility(0);
            this.j.setVisibility(8);
            this.f55511i.setVisibility(8);
        } else {
            this.f55510h.setVisibility(8);
            this.j.setVisibility(0);
            this.f55511i.setVisibility(0);
            this.f55509g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f55509g.setImageBitmap(null);
            this.f55509g.setDefaultResource(R.drawable.img_default_100);
            this.f55509g.startLoad(aVar.e(), 10, false);
        }
        if (aVar.g() == 1) {
            this.k.setVisibility(0);
            SkinManager.setImageResource(this.k, R.drawable.icon_choose_photo);
        } else {
            this.k.setVisibility(8);
        }
        this.f55511i.startLoad(aVar.i(), 10, false);
        this.j.startLoad(aVar.b(), 10, false);
        this.l.setText(aVar.j());
        setVisibility(0);
    }

    public b getCardViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (b) invokeV.objValue;
    }

    public void onChangeSkinType() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f55507e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f55508f);
    }

    public void setCardViewController(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
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
        this.f55507e = context;
        c();
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
        this.f55507e = context;
        c();
    }
}
