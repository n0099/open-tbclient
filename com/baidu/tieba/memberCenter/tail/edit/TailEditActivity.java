package com.baidu.tieba.memberCenter.tail.edit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.c05;
import com.baidu.tieba.e85;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailEditActivityConfig;
import com.baidu.tieba.pc5;
import com.baidu.tieba.q25;
import com.baidu.tieba.qc5;
import com.baidu.tieba.qm8;
import com.baidu.tieba.rm8;
import com.baidu.tieba.sl8;
import com.baidu.tieba.vl8;
import com.baidu.tieba.wl8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TailEditActivity extends BaseActivity<TailEditActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vl8 a;
    public wl8 b;
    public View c;
    public qm8<Integer> d;
    public qm8<Integer> e;
    public View.OnClickListener f;
    public View.OnClickListener g;
    public View.OnTouchListener h;
    public TextWatcher i;
    public qc5 j;

    /* loaded from: classes5.dex */
    public class a implements qm8<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public a(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm8
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) != null) {
                return;
            }
            this.a.O1(true, z, str, num);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qm8<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public b(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm8
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) != null) {
                return;
            }
            this.a.O1(false, z, str, num);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public c(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b.h().length() == 0) {
                    TailEditActivity tailEditActivity = this.a;
                    tailEditActivity.showToast(tailEditActivity.getResources().getString(R.string.obfuscated_res_0x7f0f1458));
                    return;
                }
                this.a.b.r();
                this.a.a.r(this.a.b.h().getText().toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public d(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.i().setContent(this.a.b.g());
                if (this.a.a.k()) {
                    this.a.I1();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public e(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.b.j();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public f(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) {
                return;
            }
            this.a.P1(charSequence.toString());
        }
    }

    /* loaded from: classes5.dex */
    public class g implements qc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TailEditActivity a;

        public g(TailEditActivity tailEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tailEditActivity;
        }

        @Override // com.baidu.tieba.qc5
        public void C(pc5 pc5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, pc5Var) != null) || pc5Var == null) {
                return;
            }
            int i = pc5Var.a;
            if (i != 24) {
                if (i != 26) {
                    if (i == 3) {
                        this.a.b.e();
                        return;
                    }
                    return;
                }
                this.a.H1(pc5Var.c);
                return;
            }
            this.a.G1(pc5Var.c);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ TailEditActivity b;

        public h(TailEditActivity tailEditActivity, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity, c05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tailEditActivity;
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements c05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c05 a;
        public final /* synthetic */ TailEditActivity b;

        public i(TailEditActivity tailEditActivity, c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tailEditActivity, c05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tailEditActivity;
            this.a = c05Var;
        }

        @Override // com.baidu.tieba.c05.e
        public void onClick(c05 c05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c05Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                this.b.finish();
            }
        }
    }

    public TailEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.e = new b(this);
        this.f = new c(this);
        this.g = new d(this);
        this.h = new e(this);
        this.i = new f(this);
        this.j = new g(this);
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c05 c05Var = new c05(getActivity());
            c05Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f144d));
            c05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new h(this, c05Var));
            c05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045d, new i(this, c05Var));
            c05Var.create(getPageContext());
            c05Var.show();
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.j(getIntent().getIntExtra(TailEditActivityConfig.TAIL_ID, 0), getIntent().getStringExtra(TailEditActivityConfig.TAIL_CONTENT), getIntent().getStringExtra(TailEditActivityConfig.TAIL_COLOR), getIntent().getBooleanExtra(TailEditActivityConfig.IS_NO_TAIL, false));
            this.b.s(this.a.i());
        }
    }

    public final void H1(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) != null) || obj == null) {
            return;
        }
        String obj2 = obj.toString();
        this.b.m(obj2);
        this.a.o(obj2);
        this.b.p(this.a.s());
    }

    public final String J1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.a.m(this.a.e(str))) {
                String h2 = this.a.h(str);
                this.b.n(h2);
                this.b.k();
                return h2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.b.l(i2);
            q25 d2 = q25.d(this.c);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
        }
    }

    public final void G1(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            this.a.i().setContent(this.b.g());
            vl8 vl8Var = this.a;
            if (vl8Var.l(vl8Var.e(vl8Var.i().getContent()))) {
                showToast(R.string.over_limit_tip);
            } else if (obj != null && (obj instanceof e85)) {
                new rm8().b(this, this.b.h(), (e85) obj);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d08c7);
            setActivityBgTransparent();
            setSwipeBackEnabled(false);
            this.b = new wl8(this, this.f, this.g);
            this.a = new vl8(getPageContext());
            this.c = findViewById(R.id.obfuscated_res_0x7f092281);
            L1();
            M1();
            K1();
            this.b.f();
            adjustResizeForSoftInput(R.color.common_color_10022, true);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.a(this.j, this.a.g());
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            overridePendingTransition(R.anim.fade_in, R.anim.obfuscated_res_0x7f010064);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            N1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            N1();
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.n(this.d);
            this.a.q(this.e);
            this.b.h().addTextChangedListener(this.i);
            this.b.h().setOnTouchListener(this.h);
        }
    }

    public final void O1(boolean z, boolean z2, String str, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, num}) == null) {
            this.b.i();
            if (z2) {
                showToast(str);
            } else if (num == null) {
            } else {
                TailData tailData = new TailData();
                tailData.setId(num.intValue());
                tailData.setContent(this.a.i().getContent());
                tailData.setFontColor(this.a.g());
                sl8 sl8Var = new sl8(1, tailData);
                if (!z) {
                    sl8Var.a = 2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001348, null));
                Intent intent = new Intent();
                intent.putExtra("tailId", String.valueOf(tailData.getId()));
                intent.putExtra("tailColor", tailData.getFontColor());
                intent.putExtra("tailContent", tailData.getContent());
                setResult(-1, intent);
                finish();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001340, sl8Var));
            }
        }
    }

    public final void P1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            String J1 = J1(str);
            this.a.i().setContent(J1);
            this.b.q(this.a.e(J1), 50);
            this.b.p(this.a.s());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                this.a.i().setContent(this.b.g());
                if (this.a.k()) {
                    I1();
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
