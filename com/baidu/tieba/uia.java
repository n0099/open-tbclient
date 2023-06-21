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
import com.baidu.tieba.d55;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class uia extends dja<vja> implements fja {
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

    @Override // com.baidu.tieba.ija
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.ija
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.ija
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uia a;

        /* loaded from: classes8.dex */
        public class a implements d55.e {
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

            @Override // com.baidu.tieba.d55.e
            public void onClick(d55 d55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                    o95 p = o95.p();
                    p.A(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", true);
                    d55Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.uia$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0471b implements d55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0471b(b bVar) {
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

            @Override // com.baidu.tieba.d55.e
            public void onClick(d55 d55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                    o95 p = o95.p();
                    p.A(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false);
                    d55Var.dismiss();
                }
            }
        }

        public b(uia uiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uiaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.getPageActivity() != null && !this.a.a.getPageActivity().isFinishing()) {
                if (((vja) this.a.d).a) {
                    this.a.M();
                } else {
                    this.a.L();
                }
                o95 p = o95.p();
                if (!p.l(TbadkCoreApplication.getCurrentAccount() + "is_agree_protocol", false) && ((vja) this.a.d).a) {
                    d55 d55Var = new d55(this.a.a.getPageActivity());
                    d55Var.setNegativeTextColor(R.color.CAM_X0105);
                    d55Var.setTitle("");
                    d55Var.setMessage(this.a.a.getString(R.string.obfuscated_res_0x7f0f1131));
                    d55Var.setContentViewSize(1);
                    d55Var.setPositiveButton("同意", new a(this));
                    d55Var.setNegativeButton("取消", new C0471b(this));
                    d55Var.create(this.a.a).show();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uia a;

        public a(uia uiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uiaVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                zg.i(this.a.j, this.a.a.getPageActivity());
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

    /* loaded from: classes8.dex */
    public class c implements EBusinessProtocolView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uia a;

        public c(uia uiaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uiaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uiaVar;
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
    public uia(TbPageContext<?> tbPageContext) {
        super(tbPageContext, vja.class);
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

    public final void N(List<g25> list) {
        boolean z;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                for (g25 g25Var : list) {
                    if (g25Var.b == 2) {
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

    @Override // com.baidu.tieba.fja
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, obj) == null) && (obj instanceof nja)) {
            nja njaVar = (nja) obj;
            int i = njaVar.a;
            if (i == 1) {
                if (this.g != null && !ListUtils.isEmpty(njaVar.b) && !ListUtils.isEmpty(njaVar.c)) {
                    this.g.setVisibility(0);
                }
            } else if (i == 3) {
                N(njaVar.e);
            }
        }
    }

    @Override // com.baidu.tieba.ija
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
            eBusinessProtocolView.n(this.a.getString(R.string.obfuscated_res_0x7f0f1132));
            this.j.i("file:///android_asset/protocol.html");
            SpannableString spannableString = new SpannableString(this.a.getString(R.string.obfuscated_res_0x7f0f1194));
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
            o95 p = o95.p();
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
            ((vja) this.d).a = true;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080a03, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((vja) this.d).a = false;
            WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080c0e, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.dja, com.baidu.tieba.ija
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null && linearLayout.getVisibility() == 0 && !((vja) this.d).a) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f1138));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ija
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0535, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091cee);
            this.h = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091cf3);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091cf0);
            K();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
