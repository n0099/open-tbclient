package com.baidu.tieba;

import android.view.View;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d67;
import com.baidu.tieba.yx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d67 a;
    public f67 b;
    public TbPageContext c;
    public CustomMessageListener d;
    public NEGFeedBackView.b e;
    public yx4.g f;
    public BdListView.p g;
    public d67.f h;
    public View.OnClickListener i;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u57 u57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u57Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.h(customResponsedMessage);
                if (this.a.b != null) {
                    this.a.b.G();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u57 a;

        public b(u57 u57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u57Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, vs4 vs4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, vs4Var) == null) || arrayList == null || vs4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sb.append(arrayList.get(i));
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            int i2 = vs4Var.n;
            if (i2 != 0 && i2 == 40) {
            }
            if (this.a.b != null) {
                this.a.b.I();
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(vs4 vs4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vs4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(vs4 vs4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vs4Var) != null) || vs4Var == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements yx4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u57 a;

        public c(u57 u57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u57Var;
        }

        @Override // com.baidu.tieba.yx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.b.N(false);
                    this.a.a.j();
                    TiebaStatic.log(new StatisticItem("c13582"));
                    return;
                }
                this.a.b.Z(null);
                this.a.c.showToast(R.string.obfuscated_res_0x7f0f0c59);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u57 a;

        public d(u57 u57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u57Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.S();
                this.a.a.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements d67.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u57 a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.l();
                }
            }
        }

        public e(u57 u57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u57Var;
        }

        @Override // com.baidu.tieba.d67.f
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.b.u();
                this.a.b.v();
                if (z || z2) {
                    this.a.b.Z(null);
                } else {
                    this.a.b.Z(this.a.i(i));
                }
                if (i != 0) {
                    this.a.b.L(this.a.a.h());
                    this.a.b.R(this.a.i);
                } else if (ListUtils.isEmpty(this.a.b.r())) {
                    this.a.b.V();
                } else if (z) {
                    this.a.b.W();
                }
            }
        }

        @Override // com.baidu.tieba.d67.f
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.b.Z(null);
                this.a.b.u();
                this.a.b.v();
                if (ListUtils.isEmpty(this.a.b.r())) {
                    this.a.b.U(new a(this));
                    return;
                }
                if (z) {
                    this.a.b.R(this.a.i);
                }
                if (StringUtils.isNull(str)) {
                    this.a.c.showToast(R.string.obfuscated_res_0x7f0f155b);
                } else {
                    this.a.c.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u57 a;

        public f(u57 u57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.a == null) {
                return;
            }
            this.a.b.S();
            this.a.a.l();
        }
    }

    public u57(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, 2016488);
        this.e = new b(this);
        this.f = new c(this);
        this.g = new d(this);
        this.h = new e(this);
        this.i = new f(this);
        this.c = tbPageContext;
        this.b = new f67(baseFragment, tbPageContext, bdUniqueId, this.e);
        this.a = new d67(this.c, this.h);
    }

    public void g() {
        f67 f67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (f67Var = this.b) == null) {
            return;
        }
        f67Var.n();
    }

    public final void h(CustomResponsedMessage<?> customResponsedMessage) {
        d67 d67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (d67Var = this.a) == null || ListUtils.isEmpty(d67Var.h())) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        this.a.r(optString);
        this.a.q(optString);
        f67 f67Var = this.b;
        if (f67Var != null) {
            f67Var.K(optString);
        }
    }

    public final yx4.i i(int i) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i <= 0) {
                string = this.c.getResources().getString(R.string.obfuscated_res_0x7f0f155c);
            } else {
                string = this.c.getResources().getString(R.string.obfuscated_res_0x7f0f155a, Integer.valueOf(i));
            }
            return new yx4.i(string, 1000);
        }
        return (yx4.i) invokeI.objValue;
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            f67 f67Var = this.b;
            if (f67Var != null) {
                return f67Var.s();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.p();
            this.b.w();
            this.b.M(this.f);
            this.b.O(this.g);
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f67 f67Var = this.b;
            if (f67Var != null) {
                f67Var.o();
                this.b.T();
            }
            d67 d67Var = this.a;
            if (d67Var != null) {
                d67Var.j();
            }
        }
    }

    public void m() {
        f67 f67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (f67Var = this.b) == null) {
            return;
        }
        f67Var.A();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f67 f67Var = this.b;
            if (f67Var != null) {
                f67Var.M(null);
                this.b.O(null);
                this.b.C();
            }
            d67 d67Var = this.a;
            if (d67Var != null) {
                d67Var.o();
            }
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }

    public void o() {
        f67 f67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (f67Var = this.b) == null) {
            return;
        }
        f67Var.D();
        this.b.E();
        this.b.Q(true);
    }

    public void p() {
        f67 f67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (f67Var = this.b) == null) {
            return;
        }
        f67Var.N(false);
        this.b.Y();
        this.b.z();
        this.b.X();
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.b.F();
            } else {
                this.b.E();
            }
        }
    }
}
