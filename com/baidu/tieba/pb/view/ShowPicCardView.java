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
import b.a.e.e.p.l;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.l3.j0.a;
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
/* loaded from: classes9.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52930e;

    /* renamed from: f  reason: collision with root package name */
    public a f52931f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f52932g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f52933h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f52934i;
    public TextView j;
    public TextView k;
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
            this.l = LayoutInflater.from(this.f52930e).inflate(j.pic_show_cardview_layout, (ViewGroup) this, true);
            this.f52932g = (TbImageView) findViewById(i.pic_img);
            this.f52933h = (LinearLayout) findViewById(i.bottom_ll);
            this.j = (TextView) findViewById(i.title_ll);
            this.k = (TextView) findViewById(i.desc_ll);
            this.f52934i = (ImageView) findViewById(i.show_pic_icon);
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52931f : (a) invokeV.objValue;
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52934i : (ImageView) invokeV.objValue;
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (aVar = this.f52931f) == null) {
            return;
        }
        b.a.q0.m.a.l(this.f52930e, aVar.e());
    }

    public void setData(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || this.f52931f == aVar) {
            return;
        }
        this.f52931f = aVar;
        if (!StringUtils.isNULL(aVar.f())) {
            this.j.setVisibility(0);
            this.j.setText(aVar.f());
        } else {
            this.j.setVisibility(8);
        }
        if (!StringUtils.isNULL(aVar.a())) {
            this.k.setVisibility(0);
            this.k.setText(aVar.a());
        } else {
            this.k.setVisibility(8);
        }
        if (this.m) {
            this.f52932g.setSupportNoImage(true);
        }
        int d2 = aVar.d();
        int b2 = aVar.b();
        if (d2 <= 0 || b2 <= 0) {
            return;
        }
        this.f52932g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f52932g.setOnClickListener(this);
        this.f52932g.setInterceptOnClick(true);
        this.f52932g.setDefaultResource(h.icon_click);
        this.f52932g.startLoad(aVar.c(), 18, false);
        int k = l.k(this.f52930e) - (l.g(this.f52930e, g.ds30) * 2);
        float f2 = b2 / d2;
        this.f52932g.setLayoutParams(new FrameLayout.LayoutParams(k, (int) (f2 > 1.7777778f ? k * 1.7777778f : f2 < 0.75f ? k * 0.75f : k * f2)));
        removeView(this.f52932g);
        addView(this.f52932g);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f52933h.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = l.g(this.f52930e, g.ds110);
        removeView(this.f52933h);
        addView(this.f52933h, layoutParams);
    }

    public void setIconResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setImageResource(this.f52934i, i2);
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
        this.f52930e = context;
        a();
    }
}
