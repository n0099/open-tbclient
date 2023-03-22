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
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.v35;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class zm6 implements me5, gj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v35.g A;
    public EnterForumFragment a;
    public ro6 b;
    public EnterForumModel c;
    public RecentlyVisitedForumModel d;
    public dj9 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public BaseFragmentActivity j;
    public long k;
    public boolean l;
    public LikeModel m;
    public ViewEventCenter n;
    public p35 o;
    public int p;
    public vo6 q;
    public boolean r;
    public View s;
    public final vn6 t;
    public boolean u;
    public CustomMessageListener v;
    public za w;
    public za x;
    public z8 y;
    public final EnterForumModel.f z;

    @Override // com.baidu.tieba.me5
    public void a(rm rmVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048598, this, rmVar, str, z) != null) || rmVar == null) {
        }
    }

    @Override // com.baidu.tieba.gj5
    public boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a implements v35.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        public a(zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm6Var;
        }

        @Override // com.baidu.tieba.v35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                EnterForumDelegateStatic.e.X();
                this.a.c.c0(!StringUtils.isNull(this.a.i));
                this.a.d.loadData();
                this.a.c.r0(true);
                TbadkCoreApplication.getInst().setLikeBarChanged(false);
                this.a.t.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(zm6 zm6Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, str, Boolean.valueOf(z)};
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
                ar7.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a), this.b);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(zm6 zm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, Integer.valueOf(i)};
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
            this.a = zm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.h = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(zm6 zm6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, Integer.valueOf(i)};
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
            this.a = zm6Var;
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

    /* loaded from: classes7.dex */
    public class e implements CustomMessageTask.CustomRunnable<zx4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        public e(zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm6Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<zx4> run(CustomMessage<zx4> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                zx4 zx4Var = new zx4();
                ArrayList arrayList = new ArrayList();
                if (this.a.c != null && this.a.c.V() != null && this.a.c.V().e() != null && ListUtils.getCount(this.a.c.V().e().b()) > 0) {
                    Iterator<qm6> it = this.a.c.V().e().b().iterator();
                    while (it.hasNext()) {
                        qm6 next = it.next();
                        if (next != null) {
                            HotTopicBussinessData hotTopicBussinessData = new HotTopicBussinessData();
                            hotTopicBussinessData.setForumId(gg.g(next.getId(), 0L));
                            hotTopicBussinessData.setForumName(next.m());
                            hotTopicBussinessData.setForumAvatar(next.g());
                            arrayList.add(hotTopicBussinessData);
                        }
                    }
                    zx4Var.a(arrayList);
                }
                return new CustomResponsedMessage<>(2016527, zx4Var);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(zm6 zm6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = zm6Var;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof ForumGuideSocketResponseMessage;
                if ((!z && !(responsedMessage instanceof ForumGuideHttpResponseMessage)) || this.a.c.getUniqueId() != responsedMessage.getOrginalMessage().getTag()) {
                    return;
                }
                this.a.b.M();
                this.a.b.z = true;
                if (responsedMessage.hasError()) {
                    if (!this.a.u && responsedMessage.getError() == -100000303) {
                        if (responsedMessage.getOrginalMessage().getExtra() instanceof ForumGuideRequestMessage) {
                            this.a.c.d0(true, ((ForumGuideRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getSortType().intValue());
                            this.a.u = true;
                            return;
                        }
                        return;
                    } else if (this.a.b.Z()) {
                        this.a.b.F0(this.a.s);
                        return;
                    } else {
                        return;
                    }
                }
                if (z) {
                    this.a.c.j0((ForumGuideSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ForumGuideHttpResponseMessage) {
                    this.a.c.i0((ForumGuideHttpResponseMessage) responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(zm6 zm6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = zm6Var;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Activity currentActivity;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if ((!(responsedMessage instanceof SetLikeForumSocketResponseMessage) && !(responsedMessage instanceof SetLikeForumHttpResponseMessage)) || (currentActivity = TbadkApplication.getInst().getCurrentActivity()) == null) {
                    return;
                }
                if (responsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.j.getActivity().getString(R.string.obfuscated_res_0x7f0f0aa7));
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

    /* loaded from: classes7.dex */
    public class h implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm6 a;
        public final /* synthetic */ zm6 b;

        public h(zm6 zm6Var, qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, qm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zm6Var;
            this.a = qm6Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (hi.F()) {
                    new m(this.b, this.a).execute(new qm6[0]);
                } else {
                    this.b.j.showToast(R.string.obfuscated_res_0x7f0f04e3);
                }
                TiebaStatic.eventStat(this.b.j.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        public j(zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm6Var;
        }

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.a.m.getErrorCode(), this.a.m.getErrorString())) {
                    AntiHelper.u(this.a.j.getPageContext().getPageActivity(), this.a.m.getErrorString());
                } else if (obj != null) {
                    this.a.c.c0(!StringUtils.isNull(this.a.i));
                } else if (!StringUtils.isNull(this.a.m.getErrorString())) {
                    hi.Q(TbadkCoreApplication.getInst(), this.a.m.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zm6 a;

        public k(zm6 zm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zm6Var;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) && eVar != null && this.a.a != null) {
                if (eVar.c == 1) {
                    this.a.b.M();
                }
                if (eVar.b) {
                    int i = eVar.c;
                    if (i == 1) {
                        this.a.g = true;
                        om6 om6Var = eVar.d;
                        this.a.M(om6Var);
                        if (om6Var.g() > 0) {
                            m35.m().z("key_LIKE_forum_sort_state", om6Var.g());
                            m35 m = m35.m();
                            if (om6Var.g() == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            m.w("like_forum_sort_level", z);
                        }
                    } else if (i == 0 && !this.a.g) {
                        om6 om6Var2 = eVar.d;
                        this.a.c.o0(om6Var2);
                        this.a.M(om6Var2);
                    }
                } else {
                    String str = eVar.a;
                    if (str != null && !str.equals("")) {
                        this.a.j.showToast(eVar.a);
                        this.a.b.h0(gm6.a(2));
                    }
                }
                if (eVar.c == 1 && TbadkCoreApplication.getInst().getIsNewRegUser() && this.a.G()) {
                    TbadkCoreApplication.getInst().setIsNewRegUser(false);
                }
                if (eVar.c == 1 && this.a.k > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaStatic.OpKey.OP_FORUM_ENTER, currentTimeMillis - this.a.k, this.a.c.X() - this.a.k, this.a.c.Z(), this.a.c.Y(), currentTimeMillis - this.a.c.W());
                    this.a.k = -1L;
                }
                String string = this.a.j.getResources().getString(R.string.obfuscated_res_0x7f0f05ba);
                om6 om6Var3 = eVar.d;
                if (om6Var3 != null && om6Var3.d() != null) {
                    HotSearchInfoData d = eVar.d.d();
                    m35.m().B("hot_search_info", OrmObject.jsonStrWithObject(d));
                    if (d != null && d.R() != null) {
                        string = d.R();
                    }
                }
                this.a.T(string);
                om6 om6Var4 = eVar.d;
                if (om6Var4 != null && om6Var4.c() != null) {
                    this.a.b.t0(eVar.d.c());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends BdAsyncTask<qm6, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public qm6 b;
        public final /* synthetic */ zm6 c;

        public l(zm6 zm6Var, qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, qm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zm6Var;
            this.a = null;
            this.b = null;
            this.b = qm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(qm6... qm6VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qm6VarArr)) == null) {
                qm6 qm6Var = this.b;
                if (qm6Var != null) {
                    try {
                        if (qm6Var.getId() != null && qm6Var.m() != null) {
                            if (qm6Var.i() == 0) {
                                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/topforum");
                            } else {
                                this.a = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/untopforum");
                            }
                            this.a.addPostData("forum_id", qm6Var.getId());
                            this.a.getNetContext().getRequest().mIsNeedTbs = true;
                            this.a.postNetData();
                            return null;
                        }
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
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((l) str);
                this.c.U(false);
                int i3 = this.b.i();
                NetWork netWork = this.a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        this.c.l = true;
                        if (this.c.a.isAdded() && this.c.j != null) {
                            BaseFragmentActivity baseFragmentActivity = this.c.j;
                            Activity activity = this.c.j.getActivity();
                            if (i3 > 0) {
                                i2 = R.string.obfuscated_res_0x7f0f05c0;
                            } else {
                                i2 = R.string.obfuscated_res_0x7f0f05bc;
                            }
                            baseFragmentActivity.showToast(activity.getString(i2));
                        }
                        this.c.c.c0(true);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            BaseFragmentActivity baseFragmentActivity2 = this.c.j;
                            Activity activity2 = this.c.j.getActivity();
                            if (i3 > 0) {
                                i = R.string.obfuscated_res_0x7f0f05bf;
                            } else {
                                i = R.string.obfuscated_res_0x7f0f05bb;
                            }
                            baseFragmentActivity2.showToast(activity2.getString(i));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends BdAsyncTask<qm6, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public qm6 b;
        public final /* synthetic */ zm6 c;

        public m(zm6 zm6Var, qm6 qm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zm6Var, qm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zm6Var;
            this.a = null;
            this.b = null;
            this.b = qm6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(qm6... qm6VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qm6VarArr)) == null) {
                qm6 qm6Var = this.b;
                if (qm6Var != null) {
                    try {
                        if (qm6Var.getId() != null && qm6Var.m() != null) {
                            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/forum/unfavo");
                            this.a = netWork;
                            netWork.addPostData("fid", qm6Var.getId());
                            this.a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, qm6Var.m());
                            this.a.getNetContext().getRequest().mIsNeedTbs = true;
                            this.a.postNetData();
                            return null;
                        }
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
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.unlike_success));
                        }
                        TbadkCoreApplication.getInst().setLikeBarChanged(true);
                        this.c.Q(false, this.b.getId());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, this.b.getId()));
                        long g = gg.g(this.b.getId(), 0L);
                        if (g > 0) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(g)));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.b.m()));
                        }
                        this.c.b.n0(this.b, this.c.c.a0());
                        this.c.c.f0(this.b);
                    } else if (this.c.j == null) {
                    } else {
                        if (!StringUtils.isNull(this.a.getErrorString())) {
                            this.c.j.showToast(this.a.getErrorString());
                        } else if (this.c.a.isAdded()) {
                            this.c.j.showToast(this.c.j.getActivity().getString(R.string.obfuscated_res_0x7f0f04e3));
                        }
                    }
                }
            }
        }
    }

    public zm6(EnterForumFragment enterForumFragment) {
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
        r77.d();
        this.k = System.currentTimeMillis();
        this.f = true;
        this.g = false;
        this.i = "";
        this.c = new EnterForumModel(this.j.getPageContext());
        this.t = new vn6();
        this.d = new RecentlyVisitedForumModel();
        this.m = new LikeModel(this.j.getPageContext());
        this.e = new dj9(this.j.getPageContext());
        this.m.setLoadDataCallBack(this.y);
        this.c.q0(this.z);
        m35.m().w("enter_forum_edit_mode", false);
        ln6.b().c(this.a.getFragmentActivity(), hi.u(this.a.getFragmentActivity()));
        E();
        D();
        O();
    }

    public void y(boolean z) {
        boolean z2;
        boolean z3;
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z) == null) && !this.r && this.c != null && this.b != null) {
            String str = this.i;
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.i = currentAccount;
            if (this.f) {
                this.f = false;
                z2 = false;
                z3 = true;
            } else {
                if (currentAccount != null && !currentAccount.equals(str)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
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
                if (enterForumModel2 != null && enterForumModel2.V() != null && this.c.V().e() != null) {
                    Iterator<qm6> it = this.c.V().e().b().iterator();
                    while (it.hasNext()) {
                        qm6 next = it.next();
                        if (TbadkCoreApplication.getInst().hasSignedForum(next.m())) {
                            next.E(1);
                            int signLevelUpValue = TbadkCoreApplication.getInst().getSignLevelUpValue(next.m());
                            if (signLevelUpValue > 0) {
                                next.F(signLevelUpValue);
                            }
                        }
                    }
                }
                TbadkCoreApplication.getInst().clearSignedForum();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    ad9.g(currentAccount2);
                }
                this.b.c0(this.c.a0());
            }
            if (!z3 && !z2) {
                return;
            }
            v();
            vn6 vn6Var = this.t;
            if (vn6Var != null) {
                vn6Var.h();
            }
            if (z2) {
                EnterForumModel enterForumModel3 = this.c;
                if (enterForumModel3 != null) {
                    enterForumModel3.b0(!StringUtils.isNull(this.i));
                }
                this.d.loadData();
            } else if (z3 && (enterForumModel = this.c) != null) {
                enterForumModel.b0(!StringUtils.isNull(this.i));
            }
        }
    }

    public final void Q(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, str) == null) {
            new b(this, str, z).execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            ro6 ro6Var = this.b;
            if (ro6Var != null) {
                ro6Var.d0(i2);
            }
            vo6 vo6Var = this.q;
            if (vo6Var != null) {
                vo6Var.q();
            }
        }
    }

    public void R(nm6 nm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, nm6Var) == null) {
            this.b.q0(nm6Var);
            this.a.L1(nm6Var);
        }
    }

    public void S(BdUniqueId bdUniqueId) {
        ro6 ro6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, bdUniqueId) == null) && (ro6Var = this.b) != null) {
            ro6Var.x0(bdUniqueId);
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            if (this.o == null) {
                F();
            }
            this.o.h(z);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && this.b != null && this.a != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, Integer.valueOf(z ? 1 : 0)));
        }
    }

    public ro6 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ro6) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    public void C() {
        ro6 ro6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ro6Var = this.b) != null) {
            ro6Var.X(this.s);
        }
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

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o = new p35(this.j.getPageContext());
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a.isHidden()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.b == null) {
            return;
        }
        y(false);
    }

    public void L() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.a.isAdded() && this.a.isPrimary() && (recentlyVisitedForumModel = this.d) != null) {
                recentlyVisitedForumModel.T();
            }
            ro6 ro6Var = this.b;
            if (ro6Var != null) {
                ro6Var.g0();
            }
        }
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

    @Override // com.baidu.tieba.gj5
    public BdUniqueId getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.j.getUniqueId();
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void v() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (enterForumModel = this.c) != null) {
            enterForumModel.cancelLoadData();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || this.b == null) {
            return;
        }
        y(true);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.s = LayoutInflater.from(this.j.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0292, (ViewGroup) null);
            ro6 ro6Var = new ro6(this.a, this.s, this.n, this.d, this.c);
            this.b = ro6Var;
            ro6Var.A0(this.t);
            this.b.v0(this.A);
            I(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            v();
            ln6.b().a();
            ro6 ro6Var = this.b;
            if (ro6Var != null) {
                ro6Var.e0();
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
            ro6 ro6Var = this.b;
            if (ro6Var != null && ro6Var.Q() != null) {
                this.b.Q().y();
            }
            RecentlyVisitedForumModel recentlyVisitedForumModel = this.d;
            if (recentlyVisitedForumModel != null) {
                recentlyVisitedForumModel.S();
            }
            EnterForumModel enterForumModel = this.c;
            if (enterForumModel != null) {
                enterForumModel.h0();
            }
            ro6 ro6Var2 = this.b;
            if (ro6Var2 != null) {
                ro6Var2.f0();
            }
        }
    }

    public void M(om6 om6Var) {
        ro6 ro6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, om6Var) != null) || (ro6Var = this.b) == null) {
            return;
        }
        if (om6Var == null) {
            ro6Var.F0(this.s);
            return;
        }
        sm6 e2 = om6Var.e();
        ArrayList<qm6> arrayList = new ArrayList<>();
        if (e2 != null) {
            arrayList = e2.b();
        }
        w(arrayList, om6Var.f());
        HotSearchInfoData hotSearchInfoData = (HotSearchInfoData) OrmObject.objectWithJsonStr(m35.m().s("hot_search_info", ""), HotSearchInfoData.class);
        if (hotSearchInfoData != null && hotSearchInfoData.R() != null) {
            T(hotSearchInfoData.R());
        }
        this.b.i0();
        this.b.h0(om6Var.g());
    }

    public void N(boolean z) {
        ro6 ro6Var;
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (ro6Var = this.b) != null && (enterForumFragment = this.a) != null) {
            if (z) {
                if (enterForumFragment.isPrimary() && this.a.isResumed()) {
                    this.b.G0();
                } else {
                    this.b.M();
                }
            } else {
                ro6Var.M();
            }
            this.b.u0(z);
        }
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, str) != null) || this.a.I1() == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.a.I1().X(str.trim());
        } else {
            this.a.I1().X(this.j.getActivity().getString(R.string.obfuscated_res_0x7f0f05ba));
        }
    }

    public void V(qm6 qm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, qm6Var) != null) || qm6Var == null) {
            return;
        }
        zz4 zz4Var = new zz4(this.j.getPageContext().getPageActivity());
        zz4Var.setMessage(String.format(this.j.getPageContext().getString(R.string.obfuscated_res_0x7f0f02c1), qm6Var.m()));
        zz4Var.setPositiveButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f038f), new h(this, qm6Var));
        zz4Var.setNegativeButton(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f038e), new i(this));
        zz4Var.setButtonTextColor(R.color.CAM_X0105);
        zz4Var.create(this.j.getPageContext());
        zz4Var.show();
    }

    @Override // com.baidu.tieba.gj5
    public boolean u0(hj5 hj5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, hj5Var)) == null) {
            int b2 = hj5Var.b();
            xi5 a2 = hj5Var.a();
            int i2 = 2;
            switch (b2) {
                case 1:
                    if (this.p == 2 || !(a2 instanceof qm6)) {
                        return false;
                    }
                    qm6 qm6Var = (qm6) a2;
                    String m2 = qm6Var.m();
                    if (gi.isForumName(m2)) {
                        FrsActivityConfig callFrom = new FrsActivityConfig(this.j.getPageContext().getPageActivity()).createNormalCfg(m2, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3);
                        if (hj5Var.c() instanceof Bundle) {
                            Intent intent = callFrom.getIntent();
                            intent.putExtra("transition_type", 0);
                            intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, qm6Var.h());
                            qm6Var.D(0L);
                        }
                        this.j.sendMessage(new CustomMessage(2003000, callFrom));
                        if (YYLiveUtil.isLiveRoom(m2)) {
                            StatisticItem statisticItem = new StatisticItem("c12888");
                            TiebaStaticHelper.addYYParam(statisticItem);
                            TiebaStatic.log(statisticItem);
                        }
                        StatisticItem param = new StatisticItem("c13368").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        if (this.c.V().g() != 1) {
                            i2 = 1;
                        }
                        TiebaStatic.log(param.param("obj_type", i2).param("fid", qm6Var.getId()));
                        return true;
                    }
                    break;
                case 2:
                    if (this.p == 2) {
                        return false;
                    }
                    if (m35.m().i("enter_forum_edit_mode", false)) {
                        return true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
                    m35.m().w("enter_forum_edit_mode", true);
                    if (this.a.getView() != null && this.a.getView().getParent() != null) {
                        this.a.getView().getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                case 3:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007011));
                    m35.m().w("enter_forum_edit_mode", false);
                    return true;
                case 4:
                    if (!(a2 instanceof qm6)) {
                        return false;
                    }
                    V((qm6) a2);
                    return true;
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
                    ro6 ro6Var = this.b;
                    if (ro6Var != null) {
                        ro6Var.G0();
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
                        this.q = new vo6(this.j.getPageContext(), this.n);
                    }
                    if (a2 instanceof qm6) {
                        this.q.r((qm6) a2);
                        this.q.k();
                    }
                    return true;
                case 13:
                    if (!(a2 instanceof qm6)) {
                        return false;
                    }
                    qm6 qm6Var2 = (qm6) a2;
                    new l(this, qm6Var2).execute(new qm6[0]);
                    StatisticItem statisticItem2 = new StatisticItem("c13370");
                    if (qm6Var2.i() <= 0) {
                        i2 = 1;
                    }
                    TiebaStatic.log(statisticItem2.param("obj_type", i2).param("fid", qm6Var2.getId()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    return true;
                case 14:
                    UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/create/info?nomenu=1"});
                    return true;
                case 15:
                    if (!this.e.d() && (a2 instanceof qm6)) {
                        UrlManager.getInstance().dealOneLink(this.j.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "mo/q/priforum/editinfo?fid=" + ((qm6) a2).getId() + "&nomenu=1"});
                    }
                    return true;
                case 16:
                    R((nm6) hj5Var.d());
                    break;
                case 17:
                    R((nm6) hj5Var.d());
                    break;
                case 18:
                    R((nm6) hj5Var.d());
                    break;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void w(List<qm6> list, xy4 xy4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048603, this, list, xy4Var) != null) || list == null) {
            return;
        }
        if (list.size() > 500) {
            list = list.subList(0, 500);
        }
        this.b.l0(this.c.s0(list, mo5.a()), xy4Var, this.c.a0());
    }
}
