package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.nu4;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class y16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public wu4 c;
    public yu4 d;
    public nu4 e;
    public j f;
    public CardPersonDynamicThreadData g;
    public List<uu4> h;
    public uu4 i;
    public uu4 j;
    public uu4 k;
    public uu4 l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public g16 p;
    public yu4.d q;
    public SetPrivacyModel.a r;
    public yu4.d s;
    public yu4.d t;
    public yu4.d u;
    public q9 v;

    /* loaded from: classes6.dex */
    public class a implements yu4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public a(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.yu4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public b(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g == null) {
                return;
            }
            this.a.q();
            int i2 = 2;
            if (this.a.g.q == 1) {
                i = 2;
            } else {
                int i3 = this.a.g.q;
                i = 1;
            }
            if (this.a.g == null || !this.a.g.o) {
                if (this.a.g.getThreadData() != null) {
                    this.a.p.f(this.a.g.getThreadData().getTid());
                }
                i2 = (TbSingleton.getInstance().mCallFansTid == null || this.a.g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.g.getThreadData().getTid())) ? 1 : 1;
                this.a.p.b();
                if (this.a.g.getThreadData() != null) {
                    this.a.p.d(i, i2, this.a.g.getThreadData().getTid());
                    return;
                }
                return;
            }
            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0f2c);
            if (this.a.g.getThreadData() != null) {
                this.a.p.d(i, 3, this.a.g.getThreadData().getTid());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public c(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f0c59);
                    return;
                }
                if (this.a.g.q != 1) {
                    if (this.a.g.q == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                }
                if (this.a.o) {
                    this.a.n.T(this.a.g.p);
                }
                this.a.n.V(this.a.g.a, this.a.g.h, this.a.g.b, this.a.g.e, 0, 0, true, this.a.g.p.getBaijiahaoData(), false);
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public e(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ej.N(this.a.b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g.o) {
                    this.a.g.o = false;
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f13ed);
                    if (this.a.i != null) {
                        this.a.i.n(this.a.b.getString(R.string.obfuscated_res_0x7f0f113b));
                    }
                    if (this.a.f != null) {
                        this.a.f.a(false);
                        return;
                    }
                    return;
                }
                this.a.g.o = true;
                if (this.a.i != null) {
                    this.a.i.n(this.a.b.getString(R.string.obfuscated_res_0x7f0f113c));
                }
                if (this.a.f != null) {
                    this.a.f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.g.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public f(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f0c59);
                    return;
                }
                if (this.a.g.o) {
                    if (this.a.g.q == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.g.q != 1) {
                    if (this.a.g.q == 3) {
                        TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.g);
                }
                if (!this.a.m.F()) {
                    this.a.m.G(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public g(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f0c59);
                    return;
                }
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                ThreadData threadData = this.a.g.getThreadData();
                if (tiebaPlusConfigData == null || threadData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(threadData.getTid())) == null) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.a, new String[]{jumpUrlWithTid});
                TiebaPlusConfigData.addClickStatsForFireLink(5);
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public h(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f0c59);
                    return;
                }
                if (this.a.g != null && this.a.n != null) {
                    this.a.p();
                    this.a.e.show();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y16 a;

        public i(y16 y16Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y16Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y16Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.c == 0) {
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f04be);
                    if (this.a.g != null) {
                        if (dj.isEmpty(this.a.g.G)) {
                            if (dj.isEmpty(this.a.g.b)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.g.b));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.g.G));
                    }
                } else if (!dj.isEmpty(bVar.b)) {
                    ej.N(this.a.b, bVar.b);
                } else {
                    ej.M(this.a.b, R.string.obfuscated_res_0x7f0f04b5);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(boolean z);
    }

    public y16(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.q = new b(this);
        this.r = new e(this);
        this.s = new f(this);
        this.t = new g(this);
        this.u = new h(this);
        this.v = new i(this);
        if (tbPageContext == null) {
            return;
        }
        this.a = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        this.h = new ArrayList();
        this.d = new yu4(this.b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new g16(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        uu4 uu4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (uu4Var = this.i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.o) {
                uu4Var.n(this.b.getString(R.string.obfuscated_res_0x7f0f113c));
            } else {
                ThreadData threadData = cardPersonDynamicThreadData.p;
                if (threadData != null && threadData.notShowHideThreadBtn()) {
                    if (this.h.contains(this.i)) {
                        this.h.remove(this.i);
                        this.d.j(this.h);
                    }
                } else {
                    this.i.n(this.b.getString(R.string.obfuscated_res_0x7f0f113b));
                }
            }
            this.i.r(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0368));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.g.getThreadData().getTid())) {
                        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f084a));
                    } else {
                        this.j.n(this.b.getString(R.string.obfuscated_res_0x7f0f0368));
                    }
                    this.j.q(R.color.cp_cont_b_alpha33);
                }
                this.j.r(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c == null) {
            if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen()) {
                uu4 uu4Var = new uu4(this.b.getString(R.string.obfuscated_res_0x7f0f0854), this.d);
                this.l = uu4Var;
                uu4Var.m(this.t);
                this.h.add(this.l);
            }
            uu4 uu4Var2 = new uu4(this.d);
            this.i = uu4Var2;
            uu4Var2.m(this.s);
            if (!this.o) {
                this.h.add(this.i);
            }
            if (TbSingleton.getInstance().mShowCallFans && !this.o) {
                uu4 uu4Var3 = new uu4(this.b.getString(R.string.obfuscated_res_0x7f0f0368), this.d);
                this.j = uu4Var3;
                uu4Var3.m(this.q);
                this.h.add(this.j);
            }
            uu4 uu4Var4 = new uu4(this.b.getString(R.string.obfuscated_res_0x7f0f04b0), this.d);
            this.k = uu4Var4;
            uu4Var4.m(this.u);
            this.h.add(this.k);
            this.d.m(new a(this));
            this.d.j(this.h);
            this.c = new wu4(this.a, this.d);
        }
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e == null) {
            nu4 nu4Var = new nu4(this.a.getPageActivity());
            this.e = nu4Var;
            if (this.o) {
                nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f04a7);
            } else {
                CardPersonDynamicThreadData cardPersonDynamicThreadData = this.g;
                if (cardPersonDynamicThreadData != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.isDisplayHighQualityPrefix()) {
                    this.e.setMessageId(R.string.obfuscated_res_0x7f0f04af);
                } else {
                    this.e.setMessageId(R.string.obfuscated_res_0x7f0f04ae);
                }
            }
            this.e.setPositiveButton(R.string.dialog_ok, new c(this));
            this.e.setNegativeButton(R.string.dialog_cancel, new d(this));
            this.e.setCancelable(true);
            this.e.create(this.a);
        }
    }

    public void q() {
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (wu4Var = this.c) != null && wu4Var.isShowing()) {
            this.c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yu4 yu4Var = this.d;
            if (yu4Var != null) {
                yu4Var.i();
            }
            nu4 nu4Var = this.e;
            if (nu4Var != null) {
                ge5.a(this.a, nu4Var.getRealView());
            }
        }
    }

    public void s(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jVar) == null) {
            this.f = jVar;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void u() {
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (wu4Var = this.c) == null) {
            return;
        }
        wu4Var.k();
    }
}
