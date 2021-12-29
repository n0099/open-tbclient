package com.baidu.tieba.themeCenter.card.category;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f50370e;

    /* renamed from: f  reason: collision with root package name */
    public View f50371f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f50372g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50373h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f50374i;

    /* renamed from: j  reason: collision with root package name */
    public TbImageView f50375j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f50376k;
    public TextView l;
    public View m;
    public c.a.t0.c4.a n;
    public b o;
    public int p;
    public int q;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalCardItemView f50377e;

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
            this.f50377e = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f50377e.o == null) {
                return;
            }
            this.f50377e.o.a(this.f50377e.n);
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(c.a.t0.c4.a aVar);
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
        this.f50370e = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            int k2 = (n.k(this.f50370e) - n.f(this.f50370e, R.dimen.ds88)) / 3;
            this.p = k2;
            this.q = (int) (k2 * 0.57d);
            View inflate = LayoutInflater.from(this.f50370e).inflate(R.layout.personal_card_item_layout, this);
            this.f50371f = inflate;
            this.f50372g = (TbImageView) inflate.findViewById(R.id.image_bg);
            TbImageView tbImageView = (TbImageView) this.f50371f.findViewById(R.id.permission_icon);
            this.f50374i = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f50374i.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.f50371f.findViewById(R.id.state_icon);
            this.f50375j = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.f50375j.setDefaultBgResource(R.drawable.transparent_bg);
            this.f50376k = (ImageView) this.f50371f.findViewById(R.id.choosed_icon);
            this.f50373h = (TextView) this.f50371f.findViewById(R.id.txt_default);
            this.l = (TextView) this.f50371f.findViewById(R.id.view_card_name);
            this.m = this.f50371f.findViewById(R.id.black_stroke);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f50372g.getLayoutParams();
            layoutParams.height = this.q;
            layoutParams.width = this.p;
            this.f50372g.setLayoutParams(layoutParams);
            this.m.setLayoutParams(layoutParams);
            this.f50372g.setOnClickListener(new a(this));
        }
    }

    public void fillData(c.a.t0.c4.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.n = aVar;
        if (aVar.a() == c.a.t0.c4.a.f15868k) {
            this.f50372g.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.f50372g, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f50372g, R.drawable.icon_bubble_choose_no);
            this.f50373h.setVisibility(0);
            this.f50375j.setVisibility(8);
            this.f50374i.setVisibility(8);
        } else {
            this.f50373h.setVisibility(8);
            this.f50375j.setVisibility(0);
            this.f50374i.setVisibility(0);
            this.f50372g.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f50372g.setImageBitmap(null);
            this.f50372g.setDefaultResource(R.drawable.img_default_100);
            this.f50372g.startLoad(aVar.e(), 10, false);
        }
        if (aVar.g() == 1) {
            this.f50376k.setVisibility(0);
            SkinManager.setImageResource(this.f50376k, R.drawable.icon_choose_photo);
        } else {
            this.f50376k.setVisibility(8);
        }
        this.f50374i.startLoad(aVar.i(), 10, false);
        this.f50375j.startLoad(aVar.b(), 10, false);
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f50370e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f50371f);
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
        this.f50370e = context;
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
        this.f50370e = context;
        c();
    }
}
