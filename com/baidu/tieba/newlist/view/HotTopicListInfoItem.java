package com.baidu.tieba.newlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import c.a.d.f.p.n;
import c.a.o0.m.f;
import c.a.p0.t2.d.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f34807b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34808c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34809d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34810e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34811f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34812g;

    /* renamed from: h  reason: collision with root package name */
    public View f34813h;
    public b i;
    public f<b> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListInfoItem(Context context) {
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
        this.a = 3;
        c();
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        this.i = bVar;
        this.f34807b.J(bVar.f18612f, 10, false);
        this.f34809d.setCompoundDrawablesWithIntrinsicBounds(bVar.b() ? WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.f34809d.setText(bVar.f18609c);
        this.f34812g.setText(bVar.f18610d);
        String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.f34810e.getContext(), bVar.f18613g);
        if (TextUtils.isEmpty(hotTopicTagStr)) {
            this.f34810e.setVisibility(8);
        } else {
            this.f34810e.setVisibility(0);
            this.f34810e.setText(hotTopicTagStr);
        }
        b();
        if (bVar.f18611e > 0) {
            this.f34811f.setVisibility(0);
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f18611e);
            TextView textView = this.f34811f;
            textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0877, numberUniformFormatExtraWithRoundInt));
        } else {
            this.f34811f.setVisibility(4);
        }
        TextView textView2 = this.f34808c;
        textView2.setText("" + bVar.f18608b);
    }

    public final void b() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bVar = this.i) == null) {
            return;
        }
        int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(bVar.f18613g);
        Drawable background = this.f34810e.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
        this.f34810e.setBackgroundDrawable(background);
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.i.f18608b);
        Drawable background2 = this.f34808c.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f34808c.setBackgroundDrawable(background2);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b6, (ViewGroup) this, true);
            this.f34813h = findViewById(R.id.obfuscated_res_0x7f091ad8);
            this.f34807b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090707);
            this.f34808c = (TextView) findViewById(R.id.obfuscated_res_0x7f090ef0);
            this.f34809d = (TextView) findViewById(R.id.obfuscated_res_0x7f092032);
            this.f34810e = (TextView) findViewById(R.id.obfuscated_res_0x7f091e60);
            this.f34811f = (TextView) findViewById(R.id.obfuscated_res_0x7f0915de);
            this.f34812g = (TextView) findViewById(R.id.obfuscated_res_0x7f09077a);
            this.f34807b.setPlaceHolder(1);
            this.f34807b.setRadius(n.f(getContext(), R.dimen.tbds10));
            this.f34807b.setConrers(15);
            findViewById(R.id.obfuscated_res_0x7f091ad8).setOnClickListener(this);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a == i) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.f34813h, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f34810e, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f34808c, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f34812g, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f34811f, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f34809d, (int) R.color.CAM_X0105);
        b();
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || (bVar = this.i) == null) {
            return;
        }
        long j = bVar.a;
        if (j <= 0) {
            return;
        }
        f<b> fVar = this.j;
        if (fVar != null) {
            fVar.a(view, bVar, bVar.f18608b, j);
        }
        String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.i.a));
        String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.i.f18609c);
        HotTopicStat.Locate locate = HotTopicStat.Locate.TOPIC_RANK;
        if (this.i.b()) {
            HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
        }
        new HotTopicActivityConfig(getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.i.a()), "5", locate).start();
    }

    public void setOnItemCoverListener(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.j = fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = 3;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListInfoItem(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        c();
    }
}
