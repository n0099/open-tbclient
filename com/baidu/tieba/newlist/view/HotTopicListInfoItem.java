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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.tbadk.switchs.NewWebHotTopicPageSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.fj5;
import com.baidu.tieba.kq4;
import com.baidu.tieba.sv7;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicListInfoItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public View h;
    public sv7 i;
    public kq4<sv7> j;

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

    public void d(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.a != i) {
            TBSelector.setViewBackgroundColorWithPressedState(this.h, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            b();
            this.a = i;
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

    public void a(sv7 sv7Var) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sv7Var) == null) && sv7Var != null) {
            this.i = sv7Var;
            this.b.K(sv7Var.f, 10, false);
            if (sv7Var.b()) {
                drawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a68, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL);
            } else {
                drawable = null;
            }
            this.d.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.d.setText(sv7Var.c);
            this.g.setText(sv7Var.d);
            String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.e.getContext(), sv7Var.g);
            if (TextUtils.isEmpty(hotTopicTagStr)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(hotTopicTagStr);
            }
            b();
            if (sv7Var.e > 0) {
                this.f.setVisibility(0);
                String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(sv7Var.e);
                TextView textView = this.f;
                textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f08b9, numberUniformFormatExtraWithRoundInt));
            } else {
                this.f.setVisibility(4);
            }
            this.c.setText("" + sv7Var.b);
        }
    }

    public final void b() {
        sv7 sv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (sv7Var = this.i) != null) {
            int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(sv7Var.g);
            Drawable background = this.e.getBackground();
            DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
            this.e.setBackgroundDrawable(background);
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.i.b);
            Drawable background2 = this.c.getBackground();
            DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
            this.c.setBackgroundDrawable(background2);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03ae, (ViewGroup) this, true);
            this.h = findViewById(R.id.obfuscated_res_0x7f091cbe);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09072d);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090f53);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092269);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09208b);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f091753);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0907b2);
            this.b.setPlaceHolder(1);
            this.b.setRadius(yi.g(getContext(), R.dimen.tbds10));
            this.b.setConrers(15);
            findViewById(R.id.obfuscated_res_0x7f091cbe).setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        sv7 sv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (sv7Var = this.i) != null) {
            long j = sv7Var.a;
            if (j > 0) {
                kq4<sv7> kq4Var = this.j;
                if (kq4Var != null) {
                    kq4Var.c(view2, sv7Var, sv7Var.b, j);
                }
                String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.i.a));
                String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.i.c);
                HotTopicStat.Locate locate = HotTopicStat.Locate.TOPIC_RANK;
                if (this.i.b()) {
                    HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
                }
                if (!this.i.b() && NewWebHotTopicPageSwitch.isOn()) {
                    if (getContext() instanceof BaseActivity) {
                        fj5.e(((BaseActivity) getContext()).getPageContext(), tryFixDefaultValue, tryFixDefaultValue2);
                        return;
                    }
                    return;
                }
                new HotTopicActivityConfig(getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.i.a()), "5", locate).start();
            }
        }
    }

    public void setOnItemCoverListener(kq4<sv7> kq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kq4Var) == null) {
            this.j = kq4Var;
        }
    }
}
