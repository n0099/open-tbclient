package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.aa5;
import com.baidu.tieba.ay7;
import com.baidu.tieba.vx7;
import com.baidu.tieba.wx7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public dy7 b;
    public ay7 c;
    public int d;
    public vx7 e;
    public wx7 f;
    public BdUniqueId g;
    public CustomMessageListener h;
    public NEGFeedBackView.b i;
    public final View.OnClickListener j;
    public aa5.g k;
    public BdListView.p l;
    public ay7.e m;
    public View.OnClickListener n;
    public wx7.f o;
    public vx7.b p;

    /* loaded from: classes8.dex */
    public class f implements ay7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.t();
                }
            }
        }

        public f(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // com.baidu.tieba.ay7.e
        public void a(int i, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.b.B();
                this.a.b.C();
                if (!z && !z2) {
                    this.a.b.p0(this.a.q(i));
                } else {
                    this.a.b.p0(null);
                }
                if (this.a.o()) {
                    return;
                }
                if (!ListUtils.isEmpty(this.a.c.m()) && !StringUtils.isNull(r95.p().w("key_game_video_tab_has_choosed_sub_class_name", ""))) {
                    this.a.b.T(this.a.f.i());
                    this.a.b.g0();
                    this.a.f.l(this.a.c.m());
                }
                if (i != 0) {
                    this.a.b.U(this.a.c.l());
                    this.a.b.d0(this.a.n);
                } else if (ListUtils.isEmpty(this.a.b.x())) {
                    this.a.b.k0();
                } else if (z) {
                    this.a.b.l0();
                }
            }
        }

        @Override // com.baidu.tieba.ay7.e
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.b.p0(null);
                this.a.b.B();
                this.a.b.C();
                if (ListUtils.isEmpty(this.a.b.x())) {
                    this.a.b.j0(new a(this));
                    return;
                }
                if (z) {
                    this.a.b.d0(this.a.n);
                }
                if (StringUtils.isNull(str)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f08c7);
                } else {
                    this.a.a.showToast(str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xx7 xx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var, Integer.valueOf(i)};
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
            this.a = xx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p(customResponsedMessage);
                if (this.a.b != null) {
                    this.a.b.N();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(k35 k35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k35Var, compoundButton, z) == null) {
            }
        }

        public b(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, k35Var) == null) && arrayList != null && k35Var != null) {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(arrayList.get(i2));
                    sb.append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                int i3 = k35Var.n;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 40) {
                    i = 2;
                } else if (i3 == 49) {
                    i = 3;
                }
                if (this.a.b != null) {
                    this.a.b.P();
                }
                TiebaStatic.log(new StatisticItem("c13500").param("tid", k35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", k35Var.c()).param("obj_param1", k35Var.k).param("obj_source", k35Var.l).param("obj_id", k35Var.m).param("obj_type", sb.toString()).param("obj_name", str).param(TiebaStatic.Params.OBJ_PARAM2, i));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k35Var) != null) || k35Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13500").param("obj_locate", "1").param("fid", k35Var.c()).param("tid", k35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new StatisticItem("c13499").param("fid", k35Var.c()).param("tid", k35Var.f()).param("obj_type", this.a.d).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        public c(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.b.F()) {
                return;
            }
            this.a.b.S(true);
            if (this.a.f.i()) {
                this.a.f.e();
                this.a.b.e0();
                SkinManager.setBackgroundResource(this.a.b.y(), R.color.CAM_X0207);
                return;
            }
            this.a.f.n(this.a.b.y());
            this.a.b.f0();
            SkinManager.setBackgroundResource(this.a.b.y(), R.color.CAM_X0201);
            if (this.a.c != null && !ListUtils.isEmpty(this.a.c.m())) {
                TiebaStatic.log("c13490");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements aa5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        public d(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // com.baidu.tieba.aa5.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.c.q(this.a.d);
                    this.a.u();
                    this.a.b.Z(false);
                    return;
                }
                this.a.b.p0(null);
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0a36);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        public e(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.h0();
                this.a.c.r(this.a.d);
                this.a.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        public g(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.c != null) {
                this.a.b.h0();
                this.a.c.r(this.a.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements wx7.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        public h(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // com.baidu.tieba.wx7.f
        public void a(yx7 yx7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yx7Var) != null) || yx7Var == null) {
                return;
            }
            this.a.d = yx7Var.a;
            this.a.m(yx7Var.a);
            if (this.a.b != null) {
                this.a.b.W(yx7Var.a);
                this.a.b.T(false);
                this.a.b.V(yx7Var.b);
            }
        }

        @Override // com.baidu.tieba.wx7.f
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null) {
                this.a.b.T(false);
                this.a.b.J(false);
            }
        }

        @Override // com.baidu.tieba.wx7.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.b.J(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements vx7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx7 a;

        public i(xx7 xx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx7Var;
        }

        @Override // com.baidu.tieba.vx7.b
        public void a(yx7 yx7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, yx7Var) != null) || yx7Var == null) {
                return;
            }
            this.a.d = yx7Var.a;
            this.a.m(yx7Var.a);
            if (this.a.b != null) {
                this.a.b.W(yx7Var.a);
                this.a.b.T(false);
                this.a.b.V(yx7Var.b);
            }
        }
    }

    public xx7(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this, 2016488);
        this.i = new b(this);
        this.j = new c(this);
        this.k = new d(this);
        this.l = new e(this);
        this.m = new f(this);
        this.n = new g(this);
        this.o = new h(this);
        this.p = new i(this);
        this.a = tbPageContext;
        this.g = bdUniqueId;
        this.b = new dy7(baseFragment, tbPageContext, bdUniqueId, this.i);
        this.c = new ay7(this.a, this.m);
        wx7 wx7Var = new wx7(tbPageContext, this.g);
        this.f = wx7Var;
        wx7Var.m(this.o);
        vx7 vx7Var = new vx7(tbPageContext, this.g);
        this.e = vx7Var;
        vx7Var.i(this.p);
        this.b.Y(this.j);
        int q = r95.p().q("key_game_video_tab_has_choosed_sub_class_id", 0);
        this.d = q;
        this.b.W(q);
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            wx7 wx7Var = this.f;
            if (wx7Var != null) {
                wx7Var.p(i2);
            }
            ay7 ay7Var = this.c;
            if (ay7Var != null) {
                ay7Var.x();
            }
            t();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            dy7 dy7Var = this.b;
            if (dy7Var != null) {
                dy7Var.s();
            }
            wx7 wx7Var = this.f;
            if (wx7Var != null) {
                wx7Var.j();
            }
            vx7 vx7Var = this.e;
            if (vx7Var != null) {
                vx7Var.f();
            }
            if (this.f.i()) {
                SkinManager.setBackgroundResource(this.b.y(), R.color.CAM_X0201);
            } else {
                SkinManager.setBackgroundResource(this.b.y(), R.color.CAM_X0207);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            dy7 dy7Var = this.b;
            if (dy7Var != null) {
                dy7Var.X(null);
                this.b.a0(null);
                this.b.K();
            }
            wx7 wx7Var = this.f;
            if (wx7Var != null) {
                wx7Var.k();
            }
            vx7 vx7Var = this.e;
            if (vx7Var != null) {
                vx7Var.g();
            }
            ay7 ay7Var = this.c;
            if (ay7Var != null) {
                ay7Var.t();
            }
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        vx7 vx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ay7 ay7Var = this.c;
            if (ay7Var != null && !ListUtils.isEmpty(ay7Var.m())) {
                if ((this.c.o() || this.d == 0) && (vx7Var = this.e) != null) {
                    vx7Var.h(this.c.m());
                    this.e.c((ViewGroup) this.b.z());
                    r95.p().Q("key_game_video_tab_has_choosed_sub_class_id");
                    r95.p().Q("key_game_video_tab_has_choosed_sub_class_name");
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p(CustomResponsedMessage<?> customResponsedMessage) {
        ay7 ay7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (ay7Var = this.c) != null && !ListUtils.isEmpty(ay7Var.l())) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            this.c.w(optString);
            this.c.v(optString);
            dy7 dy7Var = this.b;
            if (dy7Var != null) {
                dy7Var.R(optString);
            }
        }
    }

    public final aa5.i q(int i2) {
        InterceptResult invokeI;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 <= 0) {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08c5);
            } else {
                string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f08c6, Integer.valueOf(i2));
            }
            return new aa5.i(string, 1000);
        }
        return (aa5.i) invokeI.objValue;
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                TiebaStatic.log(new StatisticItem("c13486").param("obj_type", this.d));
                if (!this.f.i()) {
                    this.b.c0();
                    return;
                }
                return;
            }
            wx7 wx7Var = this.f;
            if (wx7Var != null) {
                wx7Var.f();
            }
            this.b.M();
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dy7 dy7Var = this.b;
            if (dy7Var != null) {
                return dy7Var.z();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.u();
            this.b.D();
            this.b.X(this.k);
            this.b.a0(this.l);
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            dy7 dy7Var = this.b;
            if (dy7Var != null) {
                dy7Var.t();
                this.b.i0();
            }
            ay7 ay7Var = this.c;
            if (ay7Var != null) {
                ay7Var.q(this.d);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TiebaStatic.log(new StatisticItem("c13493").param("obj_type", this.d));
        }
    }

    public void v() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (dy7Var = this.b) != null) {
            dy7Var.I();
        }
    }

    public void x() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (dy7Var = this.b) != null) {
            dy7Var.L();
            this.b.M();
            this.b.b0(true);
        }
    }

    public void y() {
        dy7 dy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (dy7Var = this.b) != null) {
            dy7Var.H();
            this.b.n0();
            this.b.Z(false);
            this.b.o0();
        }
    }
}
