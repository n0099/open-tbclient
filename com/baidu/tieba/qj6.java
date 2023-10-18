package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.hz4;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.rz4;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public pz4 c;
    public rz4 d;
    public hz4 e;
    public j f;
    public CardPersonDynamicThreadData g;
    public List<nz4> h;
    public nz4 i;
    public nz4 j;
    public nz4 k;
    public nz4 l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public aj6 p;
    public rz4.e q;
    public SetPrivacyModel.a r;
    public rz4.e s;
    public rz4.e t;
    public rz4.e u;
    public g4 v;

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public class a implements rz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public a(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.rz4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public b(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.rz4.e
        public void onClick() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.g == null) {
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
            if (this.a.g != null && this.a.g.o) {
                this.a.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                if (this.a.g.getThreadData() != null) {
                    this.a.p.d(i, 3, this.a.g.getThreadData().getTid());
                    return;
                }
                return;
            }
            if (this.a.g.getThreadData() != null) {
                this.a.p.f(this.a.g.getThreadData().getTid());
            }
            i2 = (TbSingleton.getInstance().mCallFansTid == null || this.a.g.getThreadData() == null || !TbSingleton.getInstance().mCallFansTid.equals(this.a.g.getThreadData().getTid())) ? 1 : 1;
            this.a.p.b();
            if (this.a.g.getThreadData() != null) {
                this.a.p.d(i, i2, this.a.g.getThreadData().getTid());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public c(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.a.b, (int) R.string.obfuscated_res_0x7f0f0e4f);
                    return;
                }
                if (this.a.g.q == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                } else if (this.a.g.q == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
                if (this.a.o) {
                    this.a.n.h0(this.a.g.p);
                }
                this.a.n.j0(this.a.g.a, this.a.g.h, this.a.g.b, this.a.g.e, 0, 0, true, this.a.g.p.getBaijiahaoData(), false);
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public e(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                BdUtilHelper.showToast(this.a.b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g.o) {
                    this.a.g.o = false;
                    BdUtilHelper.showToast(this.a.b, (int) R.string.thread_has_open);
                    if (this.a.i != null) {
                        this.a.i.o(this.a.b.getString(R.string.set_thread_privacy));
                    }
                    if (this.a.f != null) {
                        this.a.f.a(false);
                        return;
                    }
                    return;
                }
                this.a.g.o = true;
                if (this.a.i != null) {
                    this.a.i.o(this.a.b.getString(R.string.set_thread_public_open));
                }
                if (this.a.f != null) {
                    this.a.f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.g.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements rz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public f(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.rz4.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.a.b, (int) R.string.obfuscated_res_0x7f0f0e4f);
                    return;
                }
                if (this.a.g.o) {
                    if (this.a.g.q == 1) {
                        TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                    }
                } else if (this.a.g.q == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
                } else if (this.a.g.q == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                }
                if (this.a.m == null) {
                    this.a.m = new SetPrivacyModel(this.a.a, this.a.g);
                }
                if (!this.a.m.T()) {
                    this.a.m.U(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements rz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public g(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.rz4.e
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.a.b, (int) R.string.obfuscated_res_0x7f0f0e4f);
                    return;
                }
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                ThreadData threadData = this.a.g.getThreadData();
                if (tiebaPlusConfigData != null && threadData != null && (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(threadData.getTid())) != null) {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{jumpUrlWithTid});
                    TiebaPlusConfigData.addClickStatsForFireLink(5);
                    this.a.q();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements rz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public h(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.rz4.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.a.b, (int) R.string.obfuscated_res_0x7f0f0e4f);
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

    /* loaded from: classes7.dex */
    public class i extends g4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qj6 a;

        public i(qj6 qj6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qj6Var;
        }

        @Override // com.baidu.tieba.g4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.c == 0) {
                    BdUtilHelper.showToast(this.a.b, (int) R.string.delete_success);
                    if (this.a.g != null) {
                        if (!ad.isEmpty(this.a.g.G)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.g.G));
                        } else if (!ad.isEmpty(this.a.g.b)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.g.b));
                        }
                    }
                } else if (!ad.isEmpty(bVar.b)) {
                    BdUtilHelper.showToast(this.a.b, bVar.b);
                } else {
                    BdUtilHelper.showToast(this.a.b, (int) R.string.delete_fail);
                }
            }
        }
    }

    public qj6(TbPageContext tbPageContext) {
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
        this.d = new rz4(this.b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new aj6(tbPageContext);
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

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        nz4 nz4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (nz4Var = this.i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.o) {
                nz4Var.o(this.b.getString(R.string.set_thread_public_open));
            } else {
                ThreadData threadData = cardPersonDynamicThreadData.p;
                if (threadData != null && threadData.notShowHideThreadBtn()) {
                    if (this.h.contains(this.i)) {
                        this.h.remove(this.i);
                        this.d.m(this.h);
                    }
                } else {
                    this.i.o(this.b.getString(R.string.set_thread_privacy));
                }
            }
            this.i.s(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.o(this.b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.g.getThreadData().getTid())) {
                        this.j.o(this.b.getString(R.string.have_called_fans));
                    } else {
                        this.j.o(this.b.getString(R.string.call_fans));
                    }
                    this.j.r(R.color.cp_cont_b_alpha33);
                }
                this.j.s(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c != null) {
            return;
        }
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen()) {
            nz4 nz4Var = new nz4(this.b.getString(R.string.heating_thread), this.d);
            this.l = nz4Var;
            nz4Var.m(this.t);
            this.h.add(this.l);
        }
        nz4 nz4Var2 = new nz4(this.d);
        this.i = nz4Var2;
        nz4Var2.m(this.s);
        if (!this.o) {
            this.h.add(this.i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.o) {
            nz4 nz4Var3 = new nz4(this.b.getString(R.string.call_fans), this.d);
            this.j = nz4Var3;
            nz4Var3.m(this.q);
            this.h.add(this.j);
        }
        nz4 nz4Var4 = new nz4(this.b.getString(R.string.obfuscated_res_0x7f0f0551), this.d);
        this.k = nz4Var4;
        nz4Var4.m(this.u);
        this.h.add(this.k);
        this.d.p(new a(this));
        this.d.m(this.h);
        this.c = new pz4(this.a, this.d);
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e != null) {
            return;
        }
        hz4 hz4Var = new hz4(this.a.getPageActivity());
        this.e = hz4Var;
        if (this.o) {
            hz4Var.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.g;
            if (cardPersonDynamicThreadData != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.isDisplayHighQualityPrefix()) {
                this.e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f05a1, new c(this));
        this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f0596, new d(this));
        this.e.setCancelable(true);
        this.e.create(this.a);
    }

    public void q() {
        pz4 pz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pz4Var = this.c) != null && pz4Var.isShowing()) {
            this.c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rz4 rz4Var = this.d;
            if (rz4Var != null) {
                rz4Var.k();
            }
            hz4 hz4Var = this.e;
            if (hz4Var != null) {
                co5.a(this.a, hz4Var.getRealView());
            }
        }
    }

    public void u() {
        pz4 pz4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (pz4Var = this.c) == null) {
            return;
        }
        pz4Var.l();
    }
}
