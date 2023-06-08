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
import com.baidu.tieba.c55;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.n55;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class wn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public l55 c;
    public n55 d;
    public c55 e;
    public j f;
    public CardPersonDynamicThreadData g;
    public List<j55> h;
    public j55 i;
    public j55 j;
    public j55 k;
    public j55 l;
    public SetPrivacyModel m;
    public ForumManageModel n;
    public boolean o;
    public gn6 p;
    public n55.e q;
    public SetPrivacyModel.a r;
    public n55.e s;
    public n55.e t;
    public n55.e u;
    public j9 v;

    /* loaded from: classes8.dex */
    public interface j {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
    public class a implements n55.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public a(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.n55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements n55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public b(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.n55.e
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

    /* loaded from: classes8.dex */
    public class c implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public c(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    vi.P(this.a.b, R.string.obfuscated_res_0x7f0f0def);
                    return;
                }
                if (this.a.g.q == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
                } else if (this.a.g.q == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
                if (this.a.o) {
                    this.a.n.o0(this.a.g.p);
                }
                this.a.n.q0(this.a.g.a, this.a.g.h, this.a.g.b, this.a.g.e, 0, 0, true, this.a.g.p.getBaijiahaoData(), false);
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements c55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.c55.e
        public void onClick(c55 c55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                c55Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements SetPrivacyModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public e(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vi.Q(this.a.b, str);
            }
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.g.o) {
                    this.a.g.o = false;
                    vi.P(this.a.b, R.string.thread_has_open);
                    if (this.a.i != null) {
                        this.a.i.n(this.a.b.getString(R.string.set_thread_privacy));
                    }
                    if (this.a.f != null) {
                        this.a.f.a(false);
                        return;
                    }
                    return;
                }
                this.a.g.o = true;
                if (this.a.i != null) {
                    this.a.i.n(this.a.b.getString(R.string.set_thread_public_open));
                }
                if (this.a.f != null) {
                    this.a.f.a(true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, this.a.g.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements n55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public f(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    vi.P(this.a.b, R.string.obfuscated_res_0x7f0f0def);
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
                if (!this.a.m.a0()) {
                    this.a.m.b0(this.a.r);
                    this.a.m.loadData();
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements n55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public g(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            String jumpUrlWithTid;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    vi.P(this.a.b, R.string.obfuscated_res_0x7f0f0def);
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

    /* loaded from: classes8.dex */
    public class h implements n55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public h(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    vi.P(this.a.b, R.string.obfuscated_res_0x7f0f0def);
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

    /* loaded from: classes8.dex */
    public class i extends j9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wn6 a;

        public i(wn6 wn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wn6Var;
        }

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ForumManageModel.b)) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.c == 0) {
                    vi.P(this.a.b, R.string.delete_success);
                    if (this.a.g != null) {
                        if (!ui.isEmpty(this.a.g.G)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, this.a.g.G));
                        } else if (!ui.isEmpty(this.a.g.b)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, this.a.g.b));
                        }
                    }
                } else if (!ui.isEmpty(bVar.b)) {
                    vi.Q(this.a.b, bVar.b);
                } else {
                    vi.P(this.a.b, R.string.delete_fail);
                }
            }
        }
    }

    public wn6(TbPageContext tbPageContext) {
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
        this.d = new n55(this.b);
        ForumManageModel forumManageModel = new ForumManageModel(this.a);
        this.n = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.v);
        this.p = new gn6(tbPageContext);
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
        j55 j55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, cardPersonDynamicThreadData, z) == null) {
            this.g = cardPersonDynamicThreadData;
            if (cardPersonDynamicThreadData == null || (j55Var = this.i) == null) {
                return;
            }
            if (cardPersonDynamicThreadData.o) {
                j55Var.n(this.b.getString(R.string.set_thread_public_open));
            } else {
                ThreadData threadData = cardPersonDynamicThreadData.p;
                if (threadData != null && threadData.notShowHideThreadBtn()) {
                    if (this.h.contains(this.i)) {
                        this.h.remove(this.i);
                        this.d.l(this.h);
                    }
                } else {
                    this.i.n(this.b.getString(R.string.set_thread_privacy));
                }
            }
            this.i.r(z);
            if (this.j != null) {
                if (TbSingleton.getInstance().mCanCallFans) {
                    this.j.n(this.b.getString(R.string.call_fans));
                } else {
                    if (TbSingleton.getInstance().mCallFansTid != null && this.g.getThreadData() != null && TbSingleton.getInstance().mCallFansTid.equals(this.g.getThreadData().getTid())) {
                        this.j.n(this.b.getString(R.string.have_called_fans));
                    } else {
                        this.j.n(this.b.getString(R.string.call_fans));
                    }
                    this.j.q(R.color.cp_cont_b_alpha33);
                }
                this.j.r(z);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c != null) {
            return;
        }
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null && TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen()) {
            j55 j55Var = new j55(this.b.getString(R.string.heating_thread), this.d);
            this.l = j55Var;
            j55Var.m(this.t);
            this.h.add(this.l);
        }
        j55 j55Var2 = new j55(this.d);
        this.i = j55Var2;
        j55Var2.m(this.s);
        if (!this.o) {
            this.h.add(this.i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.o) {
            j55 j55Var3 = new j55(this.b.getString(R.string.call_fans), this.d);
            this.j = j55Var3;
            j55Var3.m(this.q);
            this.h.add(this.j);
        }
        j55 j55Var4 = new j55(this.b.getString(R.string.obfuscated_res_0x7f0f053f), this.d);
        this.k = j55Var4;
        j55Var4.m(this.u);
        this.h.add(this.k);
        this.d.o(new a(this));
        this.d.l(this.h);
        this.c = new l55(this.a, this.d);
    }

    public final void p() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e != null) {
            return;
        }
        c55 c55Var = new c55(this.a.getPageActivity());
        this.e = c55Var;
        if (this.o) {
            c55Var.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.g;
            if (cardPersonDynamicThreadData != null && (threadData = cardPersonDynamicThreadData.p) != null && threadData.isDisplayHighQualityPrefix()) {
                this.e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f058f, new c(this));
        this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f0584, new d(this));
        this.e.setCancelable(true);
        this.e.create(this.a);
    }

    public void q() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (l55Var = this.c) != null && l55Var.isShowing()) {
            this.c.dismiss();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n55 n55Var = this.d;
            if (n55Var != null) {
                n55Var.j();
            }
            c55 c55Var = this.e;
            if (c55Var != null) {
                gt5.a(this.a, c55Var.getRealView());
            }
        }
    }

    public void u() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (l55Var = this.c) == null) {
            return;
        }
        l55Var.l();
    }
}
