package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.p55;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class iwa extends rwa<jxa> implements twa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LinearLayout g;
    @Nullable
    public ImageView h;
    @Nullable
    public TextView i;
    @Nullable
    public EBusinessProtocolView j;

    @Override // com.baidu.tieba.wwa
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.wwa
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.wwa
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iwa a;

        /* loaded from: classes6.dex */
        public class a implements p55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    da5 p = da5.p();
                    p.A(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    p55Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.iwa$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0357b implements p55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0357b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    da5 p = da5.p();
                    p.A(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    p55Var.dismiss();
                }
            }
        }

        public b(iwa iwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iwaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                if (((jxa) this.a.d).a) {
                    this.a.M();
                } else {
                    this.a.L();
                }
                da5 p = da5.p();
                if (!p.l(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) && ((jxa) this.a.d).a) {
                    p55 p55Var = new p55(this.a.a.getPageActivity());
                    p55Var.setNegativeTextColor(R.color.CAM_X0105);
                    p55Var.setTitle("");
                    p55Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f1160));
                    p55Var.setContentViewSize(1);
                    p55Var.setPositiveButton("同意", new a(this));
                    p55Var.setNegativeButton("取消", new C0357b(this));
                    p55Var.create(this.a.a).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iwa a;

        public a(iwa iwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iwaVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bh.i(this.a.j, this.a.a.getPageActivity());
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iwa a;

        public c(iwa iwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iwaVar;
        }

        @Override // com.baidu.tieba.view.EBusinessProtocolView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.L();
                } else {
                    this.a.M();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iwa(TbPageContext<?> tbPageContext) {
        super(tbPageContext, jxa.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void N(List<r25> list) {
        boolean z;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (r25 r25Var : list) {
                    if (r25Var.b == 2) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z && (linearLayout = this.g) != null) {
                linearLayout.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.twa
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, obj) == null) && (obj instanceof bxa)) {
            bxa bxaVar = (bxa) obj;
            int i = bxaVar.a;
            if (i == 1) {
                if (this.g != null && !ListUtils.isEmpty(bxaVar.b) && !ListUtils.isEmpty(bxaVar.c)) {
                    this.g.setVisibility(0);
                }
            } else if (i == 3) {
                N(bxaVar.e);
            }
        }
    }

    @Override // com.baidu.tieba.wwa
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this.a.getPageActivity(), EBusinessProtocolView.WindowType.PROTOCOL);
            this.j = eBusinessProtocolView;
            eBusinessProtocolView.n(this.a.getString(R.string.obfuscated_res_0x7f0f1161));
            this.j.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f11c3));
            spannableString.setSpan(new a(this), 6, 17, 34);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), 6, 17, 34);
            TextView textView = this.i;
            if (textView == null) {
                return;
            }
            textView.setText(spannableString);
            this.i.setMovementMethod(LinkMovementMethod.getInstance());
            ImageView imageView = this.h;
            if (imageView == null) {
                return;
            }
            imageView.setOnClickListener(new b(this));
            this.j.l(new c(this));
            da5 p = da5.p();
            if (p.l(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false)) {
                L();
            } else {
                M();
            }
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ((jxa) this.d).a = true;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a0c, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((jxa) this.d).a = false;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080c24, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null && linearLayout.getVisibility() == 0 && !((jxa) this.d).a) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f1167));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wwa
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0542, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d63);
            this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091d68);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091d65);
            K();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
