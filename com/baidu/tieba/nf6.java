package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.wr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BawuThrones;
/* loaded from: classes5.dex */
public class nf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wr4 a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public boolean f;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf6 a;

        public a(nf6 nf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nf6 nf6Var = this.a;
                nf6Var.f = !nf6Var.f;
                this.a.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ nf6 c;

        public b(nf6 nf6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nf6Var;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                tu4.k().u("key_frs_recommend_tip", !this.c.f);
                ue6.c().d(this.a, this.b);
                this.c.a.dismiss();
                this.c.a = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf6 a;

        public c(nf6 nf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf6Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.f = false;
                this.a.a.dismiss();
                this.a.a = null;
            }
        }
    }

    public nf6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView textView = this.b;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.c;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
            }
            h();
            TextView textView3 = this.e;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public final void h() {
        ImageView imageView;
        Drawable maskDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.d) == null) {
            return;
        }
        if (this.f) {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805e3, null);
        } else {
            maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805e2, null);
        }
        imageView.setImageDrawable(maskDrawable);
    }

    public void i(TbPageContext tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, str, str2) == null) {
            wr4 wr4Var = this.a;
            if (wr4Var == null || !wr4Var.isShowing()) {
                wr4 wr4Var2 = new wr4(tbPageContext.getPageActivity());
                this.a = wr4Var2;
                wr4Var2.setContentViewSize(1);
                this.a.setNegativeTextColor(R.color.CAM_X0105);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d016c, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921c3);
                this.b = textView;
                textView.setText(R.string.obfuscated_res_0x7f0f0748);
                this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090480);
                BawuThrones b2 = ue6.c().b();
                if (b2 != null) {
                    TextView textView2 = this.c;
                    String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f0747);
                    Integer num = b2.total_recommend_num;
                    textView2.setText(String.format(string, b2.bazhu_level, num, Integer.valueOf(num.intValue() - b2.used_recommend_num.intValue())));
                } else {
                    this.c.setText(String.format(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0747), "D", 2, 2));
                }
                this.d = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0905fe);
                this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0916b1);
                inflate.findViewById(R.id.obfuscated_res_0x7f0916b0).setOnClickListener(new a(this));
                f();
                this.a.setContentView(inflate);
                this.a.setPositiveButton(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0746), new b(this, str, str2));
                this.a.setNegativeButton(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0c4c), new c(this));
                this.a.create(tbPageContext).show();
            }
        }
    }
}
