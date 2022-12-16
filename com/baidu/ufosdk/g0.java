package com.baidu.ufosdk;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.CustomCheckBox;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
/* loaded from: classes7.dex */
public class g0 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ CustomCheckBox a;
    public final /* synthetic */ h0 b;

    public g0(h0 h0Var, CustomCheckBox customCheckBox) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h0Var, customCheckBox};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = h0Var;
        this.a = customCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            CustomCheckBox customCheckBox = this.a;
            boolean z = !customCheckBox.c;
            customCheckBox.c = z;
            customCheckBox.a(z, this.b.f);
            CustomCheckBox customCheckBox2 = this.a;
            if (customCheckBox2.c) {
                this.b.d.add(customCheckBox2.getText());
            } else {
                this.b.d.remove(customCheckBox2.getText());
            }
            for (int i = 0; i < this.b.d.size(); i++) {
                String str = "选中的原因：" + this.b.d.get(i);
            }
            if (!this.b.d.contains("抄袭") && !this.b.d.contains("疑似抄袭") && !this.b.d.contains("恶意抄袭")) {
                if (this.b.d.contains("虚假欺诈")) {
                    this.b.g = 2;
                } else if (!this.b.d.contains("违法违规") && !this.b.d.contains("广告侵权") && !this.b.d.contains("体验不好")) {
                    if (!this.b.d.contains("色情") && !this.b.d.contains("违法犯罪") && !this.b.d.contains("欺诈") && !this.b.d.contains("骚扰") && !this.b.d.contains("虚假信息")) {
                        this.b.g = 0;
                    } else {
                        this.b.g = 4;
                    }
                } else {
                    this.b.g = 3;
                }
            } else {
                this.b.g = 1;
            }
            if (this.b.d.contains("侵权")) {
                this.b.g = 5;
            }
            h0 h0Var = this.b;
            i0 i0Var = h0Var.e;
            if (i0Var != null) {
                ((FeedbackReportActivity.d) i0Var).a(h0Var.d, h0Var.g);
            }
        }
    }
}
