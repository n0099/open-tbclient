package com.baidu.tieba.themeCenter.card.category;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57537e;

    /* renamed from: f  reason: collision with root package name */
    public View f57538f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f57539g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57540h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f57541i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f57542j;
    public ImageView k;
    public TextView l;
    public View m;
    public c.a.r0.q3.a n;
    public b o;
    public int p;
    public int q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCardItemView f57543e;

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
            this.f57543e = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f57543e.o == null) {
                return;
            }
            this.f57543e.o.a(this.f57543e.n);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(c.a.r0.q3.a aVar);
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
        this.f57537e = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            int k = (l.k(this.f57537e) - l.g(this.f57537e, R.dimen.ds88)) / 3;
            this.p = k;
            this.q = (int) (k * 0.57d);
            View inflate = LayoutInflater.from(this.f57537e).inflate(R.layout.personal_card_item_layout, this);
            this.f57538f = inflate;
            this.f57539g = (TbImageView) inflate.findViewById(R.id.image_bg);
            TbImageView tbImageView = (TbImageView) this.f57538f.findViewById(R.id.permission_icon);
            this.f57541i = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f57541i.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f57538f.findViewById(R.id.state_icon);
            this.f57542j = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.f57542j.setDefaultBgResource(R.drawable.transparent_bg);
            this.k = (ImageView) this.f57538f.findViewById(R.id.choosed_icon);
            this.f57540h = (TextView) this.f57538f.findViewById(R.id.txt_default);
            this.l = (TextView) this.f57538f.findViewById(R.id.view_card_name);
            this.m = this.f57538f.findViewById(R.id.black_stroke);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f57539g.getLayoutParams();
            layoutParams.height = this.q;
            layoutParams.width = this.p;
            this.f57539g.setLayoutParams(layoutParams);
            this.m.setLayoutParams(layoutParams);
            this.f57539g.setOnClickListener(new a(this));
        }
    }

    public void fillData(c.a.r0.q3.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.n = aVar;
        if (aVar.a() == c.a.r0.q3.a.k) {
            this.f57539g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.f57539g, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f57539g, R.drawable.icon_bubble_choose_no);
            this.f57540h.setVisibility(0);
            this.f57542j.setVisibility(8);
            this.f57541i.setVisibility(8);
        } else {
            this.f57540h.setVisibility(8);
            this.f57542j.setVisibility(0);
            this.f57541i.setVisibility(0);
            this.f57539g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f57539g.setImageBitmap(null);
            this.f57539g.setDefaultResource(R.drawable.img_default_100);
            this.f57539g.startLoad(aVar.e(), 10, false);
        }
        if (aVar.g() == 1) {
            this.k.setVisibility(0);
            SkinManager.setImageResource(this.k, R.drawable.icon_choose_photo);
        } else {
            this.k.setVisibility(8);
        }
        this.f57541i.startLoad(aVar.i(), 10, false);
        this.f57542j.startLoad(aVar.b(), 10, false);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f57537e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f57538f);
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
        this.f57537e = context;
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
        this.f57537e = context;
        c();
    }
}
