package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.s2.g;
import c.a.t0.s2.h;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.w3.j0.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48832e;

    /* renamed from: f  reason: collision with root package name */
    public a f48833f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f48834g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f48835h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f48836i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f48837j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f48838k;
    public View l;
    public boolean m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = LayoutInflater.from(this.f48832e).inflate(j.pic_show_cardview_layout, (ViewGroup) this, true);
            this.f48834g = (TbImageView) findViewById(i.pic_img);
            this.f48835h = (LinearLayout) findViewById(i.bottom_ll);
            this.f48837j = (TextView) findViewById(i.title_ll);
            this.f48838k = (TextView) findViewById(i.desc_ll);
            this.f48836i = (ImageView) findViewById(i.show_pic_icon);
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48833f : (a) invokeV.objValue;
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f48836i : (ImageView) invokeV.objValue;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            tbPageContext.getLayoutMode().k(i2 == 1);
            tbPageContext.getLayoutMode().j(this.l);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (aVar = this.f48833f) == null) {
            return;
        }
        c.a.s0.m.a.m(this.f48832e, aVar.e());
    }

    public void setData(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || this.f48833f == aVar) {
            return;
        }
        this.f48833f = aVar;
        if (!StringUtils.isNULL(aVar.f())) {
            this.f48837j.setVisibility(0);
            this.f48837j.setText(aVar.f());
        } else {
            this.f48837j.setVisibility(8);
        }
        if (!StringUtils.isNULL(aVar.a())) {
            this.f48838k.setVisibility(0);
            this.f48838k.setText(aVar.a());
        } else {
            this.f48838k.setVisibility(8);
        }
        if (this.m) {
            this.f48834g.setSupportNoImage(true);
        }
        int d2 = aVar.d();
        int b2 = aVar.b();
        if (d2 <= 0 || b2 <= 0) {
            return;
        }
        this.f48834g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f48834g.setOnClickListener(this);
        this.f48834g.setInterceptOnClick(true);
        this.f48834g.setDefaultResource(h.icon_click);
        this.f48834g.startLoad(aVar.c(), 18, false);
        int k2 = n.k(this.f48832e) - (n.f(this.f48832e, g.ds30) * 2);
        float f2 = b2 / d2;
        this.f48834g.setLayoutParams(new FrameLayout.LayoutParams(k2, (int) (f2 > 1.7777778f ? k2 * 1.7777778f : f2 < 0.75f ? k2 * 0.75f : k2 * f2)));
        removeView(this.f48834g);
        addView(this.f48834g);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48835h.getLayoutParams();
        layoutParams.width = k2;
        layoutParams.height = n.f(this.f48832e, g.ds110);
        removeView(this.f48835h);
        addView(this.f48835h, layoutParams);
    }

    public void setIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setImageResource(this.f48836i, i2);
        }
    }

    public void setSupportNoImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.m = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context, AttributeSet attributeSet, int i2) {
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
        this.m = false;
        this.f48832e = context;
        a();
    }
}
