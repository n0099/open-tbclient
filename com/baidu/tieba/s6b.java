package com.baidu.tieba;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.t4b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class s6b extends m6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f4b V;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s6b a;

        public a(s6b s6bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s6bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BrowserHelper.startWebActivity(this.a.a.getPageActivity(), "", BdUtilHelper.urlAddParam(TbConfig.QUESTION_THREAD_RULE, "refer=3"), true, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements t4b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t4b a;
        public final /* synthetic */ s6b b;

        public b(s6b s6bVar, t4b t4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s6bVar, t4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s6bVar;
            this.a = t4bVar;
        }

        @Override // com.baidu.tieba.t4b.b
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p4b p4bVar = this.b.D;
                if (p4bVar != null) {
                    p4bVar.P(0);
                }
                if (this.b.V != null) {
                    this.b.V.z(8);
                }
                this.a.B(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s6b(@NonNull TbPageContext<?> tbPageContext, @NonNull NavigationBar navigationBar, @NonNull LinearLayout linearLayout, @NonNull EditorTools editorTools, @NonNull y4b y4bVar, boolean z) {
        super(tbPageContext, navigationBar, linearLayout, editorTools, y4bVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, navigationBar, linearLayout, editorTools, y4bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (NavigationBar) objArr2[1], (LinearLayout) objArr2[2], (EditorTools) objArr2[3], (y4b) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void T(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.T(bundle);
            this.p.setQuestionThread(true);
        }
    }

    public final boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return !TimeHelper.isSameDay(System.currentTimeMillis(), SharedPrefHelper.getInstance().getLong("key_question_write_guide_time", 0L));
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SharedPrefHelper.getInstance().putLong("key_question_write_guide_time", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            wga.s(this.p.getForumId(), this);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b, com.baidu.tieba.b5b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.b();
            wga.D(this.p.getForumId(), this.p, true);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.c0();
            wga.D(this.p.getForumId(), this.p, false);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void L(@NonNull List<z4b<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            list.add(c6b.o(this.a));
            p4b n = c6b.n(this.a, this, this.s, this.J);
            this.D = n;
            n.Q(false);
            list.add(this.D);
            z0(list);
            e4b c = c6b.c(this.a, this, this.d, this.s, this.J);
            this.E = c;
            list.add(c);
            list.add(c6b.h(this.a, this.C));
            m4b k = c6b.k(this.a);
            k.w(this.E);
            list.add(k);
            n4b l = c6b.l(this.a);
            k.w(l);
            list.add(l);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void N(@NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, editorTools) == null) {
            editorTools.setMoreButtonAtEnd(false);
            editorTools.setBarLauncherType(8);
            editorTools.F(true);
            editorTools.G(false);
            editorTools.setBackgroundColorId(R.color.CAM_X0201);
            e6b.m(this.a, editorTools, this.p.getCallFrom(), this).n(false);
            editorTools.f();
            super.N(editorTools);
        }
    }

    @Override // com.baidu.tieba.m6b, com.baidu.tieba.n6b
    public void O(@NonNull NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, navigationBar) == null) {
            super.O(navigationBar);
            navigationBar.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f113c));
            q0(0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_W_X002));
            r0(R.drawable.obfuscated_res_0x7f080bde, R.dimen.tbds42, R.dimen.tbds42, R.dimen.tbds3);
            this.j.setOnClickListener(new a(this));
        }
    }

    public final void z0(@NonNull List<z4b<?>> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, list) == null) && B0()) {
            t4b r = c6b.r(this.a);
            r.A(new b(this, r));
            list.add(r);
            p4b p4bVar = this.D;
            if (p4bVar != null) {
                p4bVar.P(8);
            }
            f4b d = c6b.d(this.a);
            this.V = d;
            list.add(d);
            C0();
        }
    }

    @Override // com.baidu.tieba.n6b, com.baidu.tieba.v4b
    public void q(@NonNull a5b a5bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, a5bVar, z) == null) {
            super.q(a5bVar, z);
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
