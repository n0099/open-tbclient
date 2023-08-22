package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o37 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public SpannableString c;
    public TextView d;
    public TextView e;
    public int f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o37 a;

        public a(o37 o37Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o37Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o37Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                o37 o37Var = this.a;
                jg.b(o37Var, o37Var.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o37(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public final void b() {
        TbPageContext tbPageContext;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tbPageContext = this.a) != null) {
            BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
            if (this.f == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.b);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02c9, (ViewGroup) null);
            this.f = TbadkApplication.getInst().getSkinType();
            String string = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f11b5);
            this.c = new SpannableString(string);
            this.c.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.common_color_10159)), 5, string.length(), 33);
            setContentView(this.b, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703f3), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c9)));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092479);
            this.d = textView;
            textView.setText(this.c);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0907a7);
            this.e = textView2;
            textView2.setOnClickListener(new a(this));
            setCancelable(true);
            b();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02ca, (ViewGroup) null);
            this.f = TbadkApplication.getInst().getSkinType();
            setContentView(this.b, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703f3), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b1)));
            setCancelable(false);
            b();
        }
    }
}
