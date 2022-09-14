package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.au4;
import com.baidu.tieba.enterForum.data.HotSearchInfoData;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.message.ForumGuideRequestMessage;
import com.baidu.tieba.enterForum.message.ForumGuideSocketResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumHttpResponseMessage;
import com.baidu.tieba.enterForum.message.SetLikeForumSocketResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.lx4;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class z86 implements t75, ib5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lx4.g A;
    public EnterForumFragment a;
    public ra6 b;
    public EnterForumModel c;
    public RecentlyVisitedForumModel d;
    public lt8 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public BaseFragmentActivity j;
    public long k;
    public boolean l;
    public LikeModel m;
    public ViewEventCenter n;
    public fx4 o;
    public int p;
    public va6 q;
    public boolean r;
    public View s;
    public final v96 t;
    public boolean u;
    public CustomMessageListener v;
    public pb w;
    public pb x;
    public q9 y;
    public final EnterForumModel.f z;

    /* loaded from: classes6.dex */
    public class a implements lx4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        public a(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // com.baidu.tieba.lx4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.e.F();
                this.a.c.K(!StringUtils.isNull(this.a.i));
                this.a.d.loadData();
                this.a.c.Z(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                this.a.t.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(z86 z86Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a)) {
                    return null;
                }
                ya7.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(z86 z86Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, Integer.valueOf(i)};
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
            this.a = z86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.h = true;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(z86 z86Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, Integer.valueOf(i)};
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
            this.a = z86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.b != null && this.a.b.L()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements CustomMessageTask.CustomRunnable<cs4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        public e(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<cs4> run(CustomMessage<cs4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                cs4 cs4Var = new cs4();
                ArrayList arrayList = new ArrayList();
                if (this.a.c != null && this.a.c.D() != null && this.a.c.D().e() != null && ListUtils.getCount(this.a.c.D().e().b()) > 0) {
                    Iterator<q86> it = this.a.c.D().e().b().iterator();
                    while (it.hasNext()) {
                        q86 next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(dh.g(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.r());
                            hotTopicBussinessData.setForumAvatar(next.h());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    cs4Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, cs4Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(z86 z86Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ForumGuideSocketResponseMessage;
                if ((z || (responsedMessage instanceof ForumGuideHttpResponseMessage)) && this.a.c.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                    this.a.b.M();
                    this.a.b.z = true;
                    if (responsedMessage.hasError()) {
                        if (this.a.u || responsedMessage.getError() != -100000303) {
                            if (this.a.b.Z()) {
                                this.a.b.F0(this.a.s);
                                return;
                            }
                            return;
                        } else if (responsedMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                            this.a.c.L(true, ((ForumGuideRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getSortType().intValue());
                            this.a.u = true;
                            return;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        this.a.c.R((ForumGuideSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                        this.a.c.Q((ForumGuideHttpResponseMessage) responsedMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(z86 z86Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (((responsedMessage instanceof SetLikeForumSocketResponseMessage) || (responsedMessage instanceof SetLikeForumHttpResponseMessage)) && (currentActivity = TbadkApplication.getInst().getCurrentActivity()) != null) {
                    if (responsedMessage.getError() == 0) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.h(true);
                        bdTopToast.g(this.a.j.getActivity().getString(R.string.obfuscated_res_0x7f0f09f7));
                        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
                        return;
                    }
                    BdTopToast bdTopToast2 = new BdTopToast(currentActivity, 2000);
                    bdTopToast2.h(false);
                    bdTopToast2.g(responsedMessage.getErrorString());
                    bdTopToast2.i((ViewGroup) currentActivity.findViewById(16908290));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q86 a;
        public final /* synthetic */ z86 b;

        public h(z86 z86Var, q86 q86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, q86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z86Var;
            this.a = q86Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                if (!ej.D()) {
                    this.b.j.showToast(R.string.obfuscated_res_0x7f0f04b6);
                } else {
                    new m(this.b, this.a).execute(new q86[0]);
                }
                TiebaStatic.eventStat(this.b.j.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        public j(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.m.getErrorCode(), this.a.m.getErrorString())) {
                    AntiHelper.u(this.a.j.getPageContext().getPageActivity(), this.a.m.getErrorString());
                } else if (obj != null) {
                    this.a.c.K(!StringUtils.isNull(this.a.i));
                } else if (StringUtils.isNull(this.a.m.getErrorString())) {
                } else {
                    ej.N(TbadkCoreApplication.getInst(), this.a.m.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z86 a;

        public k(z86 z86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z86Var;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null || this.a.a == null) {
                return;
            }
            if (eVar.c == 1) {
                this.a.b.M();
            }
            if (eVar.b) {
                int i = eVar.c;
                if (i == 1) {
                    this.a.g = true;
                    o86 o86Var = eVar.d;
                    this.a.M(o86Var);
                    if (o86Var.g() > 0) {
                        bx4.k().w("key_LIKE_forum_sort_state", o86Var.g());
                        bx4.k().u("like_forum_sort_level", o86Var.g() == 2);
                    }
                } else if (i == 0 && !this.a.g) {
                    o86 o86Var2 = eVar.d;
                    this.a.c.W(o86Var2);
                    this.a.M(o86Var2);
                }
            } else {
                String str = eVar.a;
                if (str != null && !str.equals("")) {
                    this.a.j.showToast(eVar.a);
                    this.a.b.h0(g86.a(2));
                }
            }
            if (eVar.c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.a.G()) {
                TbadkCoreApplication.getInst().setIsNewRegUser(false);
            }
            if (eVar.c == 1 && this.a.k > -1) {
                long currentTimeMillis = System.currentTimeMillis();
                TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.a.k, this.a.c.F() - this.a.k, this.a.c.H(), this.a.c.G(), currentTimeMillis - this.a.c.E());
                this.a.k = -1L;
            }
            String string = this.a.j.getResources().getString(R.string.obfuscated_res_0x7f0f0589);
            o86 o86Var3 = eVar.d;
            if (o86Var3 != null && o86Var3.d() != null) {
                HotSearchInfoData d = eVar.d.d();
                bx4.k().y("hot_search_info", OrmObject.jsonStrWithObject(d));
                if (d != null && d.z() != null) {
                    string = d.z();
                }
            }
            this.a.T(string);
            o86 o86Var4 = eVar.d;
            if (o86Var4 == null || o86Var4.c() == null) {
                return;
            }
            this.a.b.t0(eVar.d.c());
        }
    }

    /* loaded from: classes6.dex */
    public class l extends BdAsyncTask<q86, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public q86 b;
        public final /* synthetic */ z86 c;

        public l(z86 z86Var, q86 q86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, q86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z86Var;
            this.a = null;
            this.b = null;
            this.b = q86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(q86... q86VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q86VarArr)) == null) {
                q86 q86Var = this.b;
                if (q86Var != null) {
                    try {
                        if (q86Var.getId() == null || q86Var.r() == null) {
                            return null;
                        }
                        if (q86Var.l() == 0) {
                            this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                        } else {
                            this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                        }
                        this.a.addPostData("forum_id", q86Var.getId());
                        this.a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.a.postNetData();
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.U(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((l) str);
                this.c.U(false);
                int l = this.b.l();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            this.c.j.showToast(this.c.j.getActivity().getString(l > 0 ? R.string.obfuscated_res_0x7f0f058f : R.string.obfuscated_res_0x7f0f058b));
                        }
                        this.c.c.K(true);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            this.c.j.showToast(this.c.j.getActivity().getString(l > 0 ? R.string.obfuscated_res_0x7f0f058e : R.string.obfuscated_res_0x7f0f058a));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends BdAsyncTask<q86, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public q86 b;
        public final /* synthetic */ z86 c;

        public m(z86 z86Var, q86 q86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z86Var, q86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = z86Var;
            this.a = null;
            this.b = null;
            this.b = q86Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(q86... q86VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, q86VarArr)) == null) {
                q86 q86Var = this.b;
                if (q86Var != null) {
                    try {
                        if (q86Var.getId() == null || q86Var.r() == null) {
                            return null;
                        }
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                        this.a = netWork;
                        netWork.addPostData("fid", q86Var.getId());
                        this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, q86Var.r());
                        this.a.getNetContext().getRequest().mIsNeedTbs = true;
                        this.a.postNetData();
                        return null;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.c.U(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((m) str);
                this.c.U(false);
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.obfuscated_res_0x7f0f14df));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.c.Q(false, this.b.getId());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.b.getId()));
                        long g = dh.g(this.b.getId(), 0L);
                        if (g > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(g)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.b.r()));
                        }
                        this.c.b.n0(this.b, this.c.c.I());
                        this.c.c.N(this.b);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.obfuscated_res_0x7f0f04b6));
                        }
                    }
                }
            }
        }
    }

    public z86(EnterForumFragment enterForumFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = true;
        this.g = false;
        this.k = -1L;
        this.p = 1;
        this.v = new c(this, 2921032);
        this.w = new f(this, CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683);
        this.x = new g(this, CmdConfigHttp.CMD_SET_LIKE_FORUM, 309685);
        this.y = new j(this);
        this.z = new k(this);
        this.A = new a(this);
        this.a = enterForumFragment;
        this.j = enterForumFragment.getBaseFragmentActivity();
        ViewEventCenter viewEventCenter = new ViewEventCenter();
        this.n = viewEventCenter;
        viewEventCenter.addEventDelegate(this);
        cs6.d();
        this.k = System.currentTimeMillis();
        this.f = true;
        this.g = false;
        this.i = "";
        this.c = new EnterForumModel(this.j.getPageContext());
        this.t = new v96();
        this.d = new RecentlyVisitedForumModel();
        this.m = new LikeModel(this.j.getPageContext());
        this.e = new lt8(this.j.getPageContext());
        this.m.setLoadDataCallBack(this.y);
        this.c.Y(this.z);
        bx4.k().u("enter_forum_edit_mode", false);
        l96.b().c(this.a.getFragmentActivity(), ej.s(this.a.getFragmentActivity()));
        E();
        D();
        O();
    }

    public ra6 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (ra6) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public void C() {
        ra6 ra6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ra6Var = this.b) == null) {
            return;
        }
        ra6Var.X(this.s);
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            P();
            this.a.registerListener(this.w);
            this.a.registerListener(this.x);
            this.a.registerListener(this.v);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.s = LayoutInflater.from(this.j.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d027a, (ViewGroup) null);
            ra6 ra6Var = new ra6(this.a, this.s, this.n, this.d, this.c);
            this.b = ra6Var;
            ra6Var.A0(this.t);
            this.b.v0(this.A);
            I(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o = new fx4(this.j.getPageContext());
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.a.isHidden() : invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.b == null) {
            return;
        }
        y(false);
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ra6 ra6Var = this.b;
            if (ra6Var != null) {
                ra6Var.d0(i2);
            }
            va6 va6Var = this.q;
            if (va6Var != null) {
                va6Var.q();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            v();
            l96.b().a();
            ra6 ra6Var = this.b;
            if (ra6Var != null) {
                ra6Var.e0();
            }
            MessageManager.getInstance().unRegisterTask(2016527);
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.onDestroy();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.onDestroy();
            }
            ViewEventCenter viewEventCenter = this.n;
            if (viewEventCenter != null) {
                viewEventCenter.removeEventDelegate(this);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ra6 ra6Var = this.b;
            if (ra6Var != null && ra6Var.Q() != null) {
                this.b.Q().z();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.A();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.P();
            }
            ra6 ra6Var2 = this.b;
            if (ra6Var2 != null) {
                ra6Var2.f0();
            }
        }
    }

    public void L() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.a.isAdded() && this.a.isPrimary() && (recentlyVisitedForumModel = this.d) != null) {
                recentlyVisitedForumModel.B();
            }
            ra6 ra6Var = this.b;
            if (ra6Var != null) {
                ra6Var.g0();
            }
        }
    }

    public void M(o86 o86Var) {
        ra6 ra6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, o86Var) == null) || (ra6Var = this.b) == null) {
            return;
        }
        if (o86Var == null) {
            ra6Var.F0(this.s);
            return;
        }
        s86 e2 = o86Var.e();
        ArrayList<q86> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        w(arrayList, o86Var.f());
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(bx4.k().q("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.z() != null) {
            T(hotSearchInfoData.z());
        }
        this.b.i0();
        this.b.h0(o86Var.g());
    }

    public void N(boolean z) {
        ra6 ra6Var;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (ra6Var = this.b) == null || (enterForumFragment = this.a) == null) {
            return;
        }
        if (z) {
            if (enterForumFragment.isPrimary() && this.a.isResumed()) {
                this.b.G0();
            } else {
                this.b.M();
            }
        } else {
            ra6Var.M();
        }
        this.b.u0(z);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016527, new e(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.a.registerListener(new d(this, 2007010));
        }
    }

    public final void Q(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, str) == null) {
            new b(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void R(n86 n86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, n86Var) == null) {
            this.b.q0(n86Var);
            this.a.x1(n86Var);
        }
    }

    @Override // com.baidu.tieba.ib5
    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void S(BdUniqueId bdUniqueId) {
        ra6 ra6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) || (ra6Var = this.b) == null) {
            return;
        }
        ra6Var.x0(bdUniqueId);
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || this.a.u1() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.a.u1().V(str.trim());
        } else {
            this.a.u1().V(this.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0589));
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (this.o == null) {
                F();
            }
            this.o.h(z);
        }
    }

    public void V(q86 q86Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, q86Var) == null) || q86Var == null) {
            return;
        }
        au4 au4Var = new au4(this.j.getPageContext().getPageActivity());
        au4Var.setMessage(String.format(this.j.getPageContext().getString(R.string.obfuscated_res_0x7f0f02b7), q86Var.r()));
        au4Var.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0376), new h(this, q86Var));
        au4Var.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0375), new i(this));
        au4Var.setButtonTextColor(R.color.CAM_X0105);
        au4Var.create(this.j.getPageContext());
        au4Var.show();
    }

    @Override // com.baidu.tieba.t75
    public void a(on onVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048599, this, onVar, str, z) != null) || onVar == null) {
        }
    }

    @Override // com.baidu.tieba.ib5
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.j.getUniqueId() : (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ib5
    public boolean r0(jb5 jb5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, jb5Var)) == null) {
            int b2 = jb5Var.b();
            za5 a2 = jb5Var.a();
            switch (b2) {
                case 1:
                    if (this.p == 2 || !(a2 instanceof q86)) {
                        return false;
                    }
                    q86 q86Var = (q86) a2;
                    String r = q86Var.r();
                    if (dj.isForumName(r)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.j.getPageContext().getPageActivity()).createNormalCfg(r, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        Object c2 = jb5Var.c();
                        if (c2 instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            if (UbsABTestHelper.isEnterFrsNoAnmi()) {
                                intent.putExtra("transition_type", 0);
                            } else if (q86Var.s() && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
                                intent.putExtra("transition_type", 2);
                                Bundle bundle = (Bundle) c2;
                                intent.putExtra("info_forum_image_rect", bundle.getParcelable("info_forum_image_rect"));
                                intent.putExtra("info_forum_image_url", q86Var.h());
                                intent.putExtra("info_forum_name_rect", bundle.getParcelable("info_forum_name_rect"));
                                intent.putExtra("info_forum_name_text", r);
                                intent.putExtra("info_forum_head_background_color", q86Var.z());
                                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    if (q86Var.B().night != null && q86Var.B().night.pattern_image != null) {
                                        intent.putExtra("info_forum_head_background_vector", q86Var.B().night.pattern_image);
                                    }
                                } else if (q86Var.B().day != null && q86Var.B().day.pattern_image != null) {
                                    intent.putExtra("info_forum_head_background_vector", q86Var.B().day.pattern_image);
                                }
                            } else {
                                intent.putExtra("transition_type", 0);
                            }
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, q86Var.j());
                            q86Var.K(0L);
                        }
                        this.j.sendMessage(new CustomMessage(2003000, callFrom));
                        if (YYLiveUtil.isLiveRoom(r)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        TiebaStatic.log(new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", this.c.D().g() != 1 ? 1 : 2).param("fid", q86Var.getId()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.p == 2) {
                        return false;
                    }
                    if (bx4.k().h("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    bx4.k().u("enter_forum_edit_mode", true);
                    if (this.a.getView() != null && this.a.getView().getParent() != null) {
                        this.a.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    bx4.k().u("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (a2 instanceof q86) {
                        V((q86) a2);
                        return true;
                    }
                    return false;
                case 6:
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(this.j.getActivity());
                        return true;
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.j.getPageContext().getPageActivity(), "notlogin_6", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("find_more_text_click"));
                    return true;
                case 7:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new IntentConfig(this.j.getPageContext().getPageActivity())));
                    if (!TbadkCoreApplication.isLogin()) {
                        TiebaStatic.eventStat(this.j.getPageContext().getPageActivity(), "notlogin_8", "click", 1, new Object[0]);
                    }
                    TiebaStatic.log(new StatisticItem("c13367").param("obj_location", "1"));
                    return true;
                case 8:
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_type", "2").param("obj_locate", 1));
                    this.j.finish();
                    return true;
                case 9:
                    ra6 ra6Var = this.b;
                    if (ra6Var != null) {
                        ra6Var.G0();
                    }
                    return true;
                case 10:
                    this.p = 2;
                    return true;
                case 11:
                    this.p = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 1));
                    return true;
                case 12:
                    if (this.p == 2) {
                        return true;
                    }
                    if (this.q == null) {
                        this.q = new va6(this.j.getPageContext(), this.n);
                    }
                    if (a2 instanceof q86) {
                        this.q.r((q86) a2);
                        this.q.k();
                    }
                    return true;
                case 13:
                    if (a2 instanceof q86) {
                        q86 q86Var2 = (q86) a2;
                        new l(this, q86Var2).execute(new q86[0]);
                        TiebaStatic.log(new StatisticItem("c13370").param("obj_type", q86Var2.l() <= 0 ? 1 : 2).param("fid", q86Var2.getId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                        return true;
                    }
                    return false;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.e.d() && (a2 instanceof q86)) {
                        UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=" + ((q86) a2).getId() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    R((n86) jb5Var.d());
                    break;
                case 17:
                    R((n86) jb5Var.d());
                    break;
                case 18:
                    R((n86) jb5Var.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void v() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (enterForumModel = this.c) == null) {
            return;
        }
        enterForumModel.cancelLoadData();
    }

    public final void w(List<q86> list, bt4 bt4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048603, this, list, bt4Var) == null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.b.l0(this.c.a0(list, mg5.a()), bt4Var, this.c.I());
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.b == null || this.a == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
    }

    public void y(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.r || this.c == null || this.b == null) {
            return;
        }
        String str = this.i;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.i = currentAccount;
        if (this.f) {
            this.f = false;
            z2 = false;
            z3 = true;
        } else {
            z2 = (currentAccount == null || currentAccount.equals(str)) ? false : true;
            z3 = false;
        }
        if (TbadkCoreApplication.getInst().getLikeBarChanged()) {
            TbadkCoreApplication.getInst().setLikeBarChanged(false);
            z2 = true;
        }
        if (z) {
            z2 = true;
        }
        if (TbadkCoreApplication.getInst().signedForumCount() > 0) {
            EnterForumModel enterForumModel2 = this.c;
            if (enterForumModel2 != null && enterForumModel2.D() != null && this.c.D().e() != null) {
                Iterator<q86> it = this.c.D().e().b().iterator();
                while (it.hasNext()) {
                    q86 next = it.next();
                    if (TbadkCoreApplication.getInst().hasSignedForum(next.r())) {
                        next.L(1);
                        int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.r());
                        if (signLevelUpValue > 0) {
                            next.M(signLevelUpValue);
                        }
                    }
                }
            }
            TbadkCoreApplication.getInst().clearSignedForum();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                tn8.g(currentAccount2);
            }
            this.b.c0(this.c.I());
        }
        if (z3 || z2) {
            v();
            v96 v96Var = this.t;
            if (v96Var != null) {
                v96Var.h();
            }
            if (z2) {
                EnterForumModel enterForumModel3 = this.c;
                if (enterForumModel3 != null) {
                    enterForumModel3.J(!StringUtils.isNull(this.i));
                }
                this.d.loadData();
            } else if (!z3 || (enterForumModel = this.c) == null) {
            } else {
                enterForumModel.J(!StringUtils.isNull(this.i));
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.b == null) {
            return;
        }
        y(true);
    }
}
