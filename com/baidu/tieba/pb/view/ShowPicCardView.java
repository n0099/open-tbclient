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
import c.a.p0.a4.k0.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public a f35290b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f35291c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f35292d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35293e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f35294f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35295g;

    /* renamed from: h  reason: collision with root package name */
    public View f35296h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.f35296h = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06e4, (ViewGroup) this, true);
            this.f35291c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091833);
            this.f35292d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0903cb);
            this.f35294f = (TextView) findViewById(R.id.obfuscated_res_0x7f092049);
            this.f35295g = (TextView) findViewById(R.id.obfuscated_res_0x7f09077f);
            this.f35293e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091cf8);
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35290b : (a) invokeV.objValue;
    }

    public ImageView getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35293e : (ImageView) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (aVar = this.f35290b) == null) {
            return;
        }
        c.a.o0.l.a.m(this.a, aVar.e());
    }

    public void setData(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || this.f35290b == aVar) {
            return;
        }
        this.f35290b = aVar;
        if (!StringUtils.isNULL(aVar.f())) {
            this.f35294f.setVisibility(0);
            this.f35294f.setText(aVar.f());
        } else {
            this.f35294f.setVisibility(8);
        }
        if (!StringUtils.isNULL(aVar.a())) {
            this.f35295g.setVisibility(0);
            this.f35295g.setText(aVar.a());
        } else {
            this.f35295g.setVisibility(8);
        }
        if (this.i) {
            this.f35291c.setSupportNoImage(true);
        }
        int d2 = aVar.d();
        int b2 = aVar.b();
        if (d2 <= 0 || b2 <= 0) {
            return;
        }
        this.f35291c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f35291c.setOnClickListener(this);
        this.f35291c.setInterceptOnClick(true);
        this.f35291c.setDefaultResource(R.drawable.icon_click);
        this.f35291c.J(aVar.c(), 18, false);
        int k = n.k(this.a) - (n.f(this.a, R.dimen.obfuscated_res_0x7f070201) * 2);
        float f2 = b2 / d2;
        this.f35291c.setLayoutParams(new FrameLayout.LayoutParams(k, (int) (f2 > 1.7777778f ? k * 1.7777778f : f2 < 0.75f ? k * 0.75f : k * f2)));
        removeView(this.f35291c);
        addView(this.f35291c);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f35292d.getLayoutParams();
        layoutParams.width = k;
        layoutParams.height = n.f(this.a, R.dimen.obfuscated_res_0x7f07022e);
        removeView(this.f35292d);
        addView(this.f35292d, layoutParams);
    }

    public void setIconResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setImageResource(this.f35293e, i);
        }
    }

    public void setSupportNoImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = true;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = false;
        this.a = context;
        a();
    }
}
