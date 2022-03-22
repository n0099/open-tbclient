package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f36359b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f36360c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36361d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f36362e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f36363f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f36364g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f36365h;
    public View i;
    public c.a.p0.f4.a j;
    public b k;
    public int l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardItemView a;

        public a(PersonalCardItemView personalCardItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.a.k == null) {
                return;
            }
            this.a.k.a(this.a.j);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(c.a.p0.f4.a aVar);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        d();
    }

    public void c(c.a.p0.f4.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.j = aVar;
        if (aVar.a() == c.a.p0.f4.a.k) {
            this.f36360c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.f36360c, R.color.CAM_X0204);
            SkinManager.setImageResource(this.f36360c, R.drawable.icon_bubble_choose_no);
            this.f36361d.setVisibility(0);
            this.f36363f.setVisibility(8);
            this.f36362e.setVisibility(8);
        } else {
            this.f36361d.setVisibility(8);
            this.f36363f.setVisibility(0);
            this.f36362e.setVisibility(0);
            this.f36360c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f36360c.setImageBitmap(null);
            this.f36360c.setDefaultResource(R.drawable.obfuscated_res_0x7f080b75);
            this.f36360c.J(aVar.e(), 10, false);
        }
        if (aVar.g() == 1) {
            this.f36364g.setVisibility(0);
            SkinManager.setImageResource(this.f36364g, R.drawable.icon_choose_photo);
        } else {
            this.f36364g.setVisibility(8);
        }
        this.f36362e.J(aVar.i(), 10, false);
        this.f36363f.J(aVar.b(), 10, false);
        this.f36365h.setText(aVar.j());
        setVisibility(0);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            int k = (n.k(this.a) - n.f(this.a, R.dimen.obfuscated_res_0x7f0702ff)) / 3;
            this.l = k;
            this.m = (int) (k * 0.57d);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06df, this);
            this.f36359b = inflate;
            this.f36360c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e6c);
            TbImageView tbImageView = (TbImageView) this.f36359b.findViewById(R.id.obfuscated_res_0x7f09176d);
            this.f36362e = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36362e.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            TbImageView tbImageView2 = (TbImageView) this.f36359b.findViewById(R.id.obfuscated_res_0x7f091da2);
            this.f36363f = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36363f.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36364g = (ImageView) this.f36359b.findViewById(R.id.obfuscated_res_0x7f090615);
            this.f36361d = (TextView) this.f36359b.findViewById(R.id.obfuscated_res_0x7f09223c);
            this.f36365h = (TextView) this.f36359b.findViewById(R.id.obfuscated_res_0x7f0923b5);
            this.i = this.f36359b.findViewById(R.id.obfuscated_res_0x7f090385);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36360c.getLayoutParams();
            layoutParams.height = this.m;
            layoutParams.width = this.l;
            this.f36360c.setLayoutParams(layoutParams);
            this.i.setLayoutParams(layoutParams);
            this.f36360c.setOnClickListener(new a(this));
        }
    }

    public b getCardViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (b) invokeV.objValue;
    }

    public void setCardViewController(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k = bVar;
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
        this.a = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = context;
        d();
    }
}
