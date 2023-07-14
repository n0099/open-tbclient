package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.qwa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class pya extends jya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cwa V;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pya a;

        public a(pya pyaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pyaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pyaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nx4.x(this.a.a.getPageActivity(), "", yi.U(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements qwa.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qwa a;
        public final /* synthetic */ pya b;

        public b(pya pyaVar, qwa qwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pyaVar, qwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pyaVar;
            this.a = qwaVar;
        }

        @Override // com.baidu.tieba.qwa.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mwa mwaVar = this.b.D;
                if (mwaVar != null) {
                    mwaVar.P(0);
                }
                if (this.b.V != null) {
                    this.b.V.z(8);
                }
                this.a.B(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pya(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull vwa vwaVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, vwaVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, vwaVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (vwa) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void U(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.U(bundle);
            this.p.setQuestionThread(true);
        }
    }

    public final void A0(@NonNull List<wwa<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && B0()) {
            qwa r = zxa.r(this.a);
            r.A(new b(this, r));
            list.add(r);
            mwa mwaVar = this.D;
            if (mwaVar != null) {
                mwaVar.P(8);
            }
            cwa d = zxa.d(this.a);
            this.V = d;
            list.add(d);
            C0();
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void O(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, editorTools) == null) {
            editorTools.setMoreButtonAtEnd(false);
            editorTools.setBarLauncherType(8);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            bya.m(this.a, editorTools, this.p.getCallFrom(), this).n(false);
            editorTools.f();
            super.O(editorTools);
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void P(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, navigationBar) == null) {
            super.P(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f1117));
            r0(0, yi.g(this.a.getPageActivity(), R.dimen.M_W_X002));
            s0(R.drawable.obfuscated_res_0x7f080bbc, R.dimen.tbds42, R.dimen.tbds42, R.dimen.tbds3);
            this.j.setOnClickListener(new a(this));
        }
    }

    public final boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TimeHelper.isSameDay(System.currentTimeMillis(), da5.p().r("key_question_write_guide_time", 0L));
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            da5.p().H("key_question_write_guide_time", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            bca.q(this.p.getForumId(), this);
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.c0();
            bca.A(this.p.getForumId(), this.p, false);
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya, com.baidu.tieba.ywa
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.j();
            bca.A(this.p.getForumId(), this.p, true);
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya
    public void M(@NonNull List<wwa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            list.add(zxa.o(this.a));
            mwa n = zxa.n(this.a, this, this.s, this.J);
            this.D = n;
            n.Q(false);
            list.add(this.D);
            A0(list);
            bwa c = zxa.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            list.add(zxa.h(this.a, this.C));
            jwa k = zxa.k(this.a);
            k.w(this.E);
            list.add(k);
            kwa l = zxa.l(this.a);
            k.w(l);
            list.add(l);
        }
    }

    @Override // com.baidu.tieba.jya, com.baidu.tieba.kya, com.baidu.tieba.swa
    public void q(@NonNull xwa xwaVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, xwaVar, z) == null) {
            super.q(xwaVar, z);
            if (this.a.getPageActivity() == null) {
                return;
            }
            if (z) {
                this.a.getPageActivity().getWindow().setSoftInputMode(16);
            } else {
                this.a.getPageActivity().getWindow().setSoftInputMode(48);
            }
        }
    }
}
