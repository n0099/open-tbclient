package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.el7;
import com.repackage.kl4;
import com.repackage.li;
/* loaded from: classes3.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ViewGroup b;
    public TbImageView c;
    public View d;
    public View e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public el7 j;
    public kl4<el7> k;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context) {
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
        b();
    }

    public void a(el7 el7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, el7Var) == null) || el7Var == null) {
            return;
        }
        this.j = el7Var;
        if (TextUtils.isEmpty(el7Var.d)) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090765);
            this.i.setLayoutParams(layoutParams);
        } else {
            this.c.K(el7Var.d, 10, false);
            this.c.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f0906f0);
            layoutParams2.addRule(3, 0);
            this.i.setLayoutParams(layoutParams2);
            if (el7Var.e > 0) {
                this.e.setVisibility(0);
                this.d.setVisibility(0);
                this.g.setText(StringUtils.translateSecondsToString(el7Var.e));
            } else {
                this.e.setVisibility(8);
                this.d.setVisibility(8);
            }
        }
        this.h.setText(el7Var.a);
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(el7Var.b);
        String str = "" + this.i.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f088c, numberUniformFormatExtra);
        String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(el7Var.c);
        if (str.length() > 0) {
            str = str + GlideException.IndentedAppendable.INDENT;
        }
        this.i.setText(str + this.i.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f088b, numberUniformFormatExtra2));
        setPadding(0, 0, 0, el7Var.g ? li.f(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d039f, (ViewGroup) this, true);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091ac6);
            this.b = viewGroup;
            viewGroup.setOnClickListener(this);
            this.c = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0906f0);
            this.d = findViewById(R.id.obfuscated_res_0x7f0906ef);
            this.e = findViewById(R.id.obfuscated_res_0x7f0922d7);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922d5);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0922d6);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090765);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091e4b);
            this.c.setPlaceHolder(2);
            this.c.setRadius(li.f(getContext(), R.dimen.tbds10));
            this.c.setConrers(15);
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a == i) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.b, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
        this.f.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        el7 el7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || (el7Var = this.j) == null || el7Var.h == null) {
            return;
        }
        kl4<el7> kl4Var = this.k;
        if (kl4Var != null) {
            kl4Var.a(view2, el7Var, 0, 0L);
        }
        ThreadCardUtils.jumpToPB(this.j.h, view2.getContext(), 17, false, this.l, "1");
    }

    public void setCurrentTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public void setOnItemCoverListener(kl4<el7> kl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kl4Var) == null) {
            this.k = kl4Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        b();
    }
}
