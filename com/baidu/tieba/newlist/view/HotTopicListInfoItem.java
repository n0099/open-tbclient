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
import com.repackage.bn4;
import com.repackage.jr7;
import com.repackage.qi;
/* loaded from: classes3.dex */
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
    public jr7 i;
    public bn4<jr7> j;

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

    public void a(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        this.i = jr7Var;
        this.b.K(jr7Var.f, 10, false);
        this.d.setCompoundDrawablesWithIntrinsicBounds(jr7Var.b() ? WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a28, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.d.setText(jr7Var.c);
        this.g.setText(jr7Var.d);
        String hotTopicTagStr = TagTextHelper.getHotTopicTagStr(this.e.getContext(), jr7Var.g);
        if (TextUtils.isEmpty(hotTopicTagStr)) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            this.e.setText(hotTopicTagStr);
        }
        b();
        if (jr7Var.e > 0) {
            this.f.setVisibility(0);
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(jr7Var.e);
            TextView textView = this.f;
            textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f088c, numberUniformFormatExtraWithRoundInt));
        } else {
            this.f.setVisibility(4);
        }
        TextView textView2 = this.c;
        textView2.setText("" + jr7Var.b);
    }

    public final void b() {
        jr7 jr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jr7Var = this.i) == null) {
            return;
        }
        int hotTopicTagColorRes = TagTextHelper.getHotTopicTagColorRes(jr7Var.g);
        Drawable background = this.e.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(hotTopicTagColorRes));
        this.e.setBackgroundDrawable(background);
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(this.i.b);
        Drawable background2 = this.c.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.c.setBackgroundDrawable(background2);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03a3, (ViewGroup) this, true);
            this.h = findViewById(R.id.obfuscated_res_0x7f091c1b);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0906ff);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090f06);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c0);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f091fdf);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f0916e2);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090782);
            this.b.setPlaceHolder(1);
            this.b.setRadius(qi.f(getContext(), R.dimen.tbds10));
            this.b.setConrers(15);
            findViewById(R.id.obfuscated_res_0x7f091c1b).setOnClickListener(this);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a == i) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.h, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
        b();
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        jr7 jr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view2) == null) || (jr7Var = this.i) == null) {
            return;
        }
        long j = jr7Var.a;
        if (j <= 0) {
            return;
        }
        bn4<jr7> bn4Var = this.j;
        if (bn4Var != null) {
            bn4Var.c(view2, jr7Var, jr7Var.b, j);
        }
        String tryFixDefaultValue = StringUtils.tryFixDefaultValue(String.valueOf(this.i.a));
        String tryFixDefaultValue2 = StringUtils.tryFixDefaultValue(this.i.c);
        HotTopicStat.Locate locate = HotTopicStat.Locate.TOPIC_RANK;
        if (this.i.b()) {
            HotTopicStat.a(tryFixDefaultValue, tryFixDefaultValue2, locate, null, null);
        }
        new HotTopicActivityConfig(getContext()).createNormalConfig(tryFixDefaultValue, null, String.valueOf(this.i.a()), "5", locate).start();
    }

    public void setOnItemCoverListener(bn4<jr7> bn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bn4Var) == null) {
            this.j = bn4Var;
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
