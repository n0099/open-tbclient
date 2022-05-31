package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DressupItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public TbImageView d;
    public TextView e;
    public TextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupItemView(Context context) {
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03d2, this);
            this.b = inflate;
            this.c = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09035d);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091748);
            this.d = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081233);
            this.d.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081233);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092227);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092220);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupItemView(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        a();
    }
}
