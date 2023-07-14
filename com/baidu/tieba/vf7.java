package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.forumMember.member.ForumMemberHttpResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberReadCacheResponseMessage;
import com.baidu.tieba.forumMember.member.ForumMemberRequestMessage;
import com.baidu.tieba.forumMember.member.ForumMemberSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class vf7 implements fj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public yba d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public jj7 k;
    public boolean l;
    public uj7 m;
    public kb n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes8.dex */
    public class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vf7 vf7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = vf7Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ForumMemberHttpResponseMessage;
            if (!z && !(responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() == 0) {
                if (z) {
                    ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                    this.a.d = forumMemberHttpResponseMessage.getUserInfo();
                    this.a.e = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                    this.a.f = forumMemberHttpResponseMessage.getMemberGodInfo();
                    this.a.g = forumMemberHttpResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberHttpResponseMessage.isBawuShow();
                    this.a.h = forumMemberHttpResponseMessage.isPrivateForum();
                    this.a.j = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                    ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                    this.a.d = forumMemberSocketResponseMessage.getUserInfo();
                    this.a.e = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                    this.a.f = forumMemberSocketResponseMessage.getMemberGodInfo();
                    this.a.g = forumMemberSocketResponseMessage.getManagerApplyInfo();
                    this.a.i = forumMemberSocketResponseMessage.isBawuShow();
                    this.a.h = forumMemberSocketResponseMessage.isPrivateForum();
                    this.a.j = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                }
            }
            this.a.l = false;
            this.a.m.e = responsedMessage.getError();
            this.a.m.f = responsedMessage.getErrorString();
            this.a.m.g = false;
            this.a.m.i = false;
            this.a.m.h = false;
            this.a.m.b = this.a.b;
            this.a.m.a = this.a.c;
            this.a.m.c = 1;
            if (this.a.k != null) {
                jj7 jj7Var = this.a.k;
                uj7 uj7Var = this.a.m;
                vf7 vf7Var = this.a;
                jj7Var.a(3, 0, uj7Var, vf7Var.y(vf7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vf7 vf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf7Var, Integer.valueOf(i)};
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
            this.a = vf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ForumMemberReadCacheResponseMessage)) {
                return;
            }
            ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
            if (customResponsedMessage.getError() == 0) {
                this.a.d = forumMemberReadCacheResponseMessage.getUserInfo();
                this.a.e = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                this.a.f = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                this.a.g = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                this.a.i = forumMemberReadCacheResponseMessage.isBawuShow();
                this.a.h = forumMemberReadCacheResponseMessage.isPrivateForum();
                this.a.j = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
            }
            this.a.m.e = customResponsedMessage.getError();
            this.a.m.f = customResponsedMessage.getErrorString();
            this.a.m.g = false;
            this.a.m.i = false;
            this.a.m.h = false;
            this.a.m.b = this.a.b;
            this.a.m.a = this.a.c;
            this.a.m.c = 1;
            if (this.a.k != null) {
                vf7 vf7Var = this.a;
                ArrayList<yn> y = vf7Var.y(vf7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j);
                if (y != null && y.size() > 0) {
                    this.a.k.a(3, 0, this.a.m, y);
                } else if (!this.a.l) {
                    this.a.k.a(3, 0, this.a.m, y);
                }
            }
            if (this.a.l) {
                vf7 vf7Var2 = this.a;
                vf7Var2.x(wg.g(vf7Var2.b, 0L), this.a.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(vf7 vf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf7Var, Integer.valueOf(i)};
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
            this.a = vf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yba)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                yba ybaVar = (yba) customResponsedMessage.getData();
                if (ybaVar != null && ybaVar.n() == 0 && this.a.d != null) {
                    ybaVar.u(this.a.d.c());
                    ybaVar.x(this.a.d.i());
                }
                this.a.d = ybaVar;
                if (this.a.k != null) {
                    jj7 jj7Var = this.a.k;
                    uj7 uj7Var = this.a.m;
                    vf7 vf7Var = this.a;
                    jj7Var.a(3, 0, uj7Var, vf7Var.y(vf7Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vf7 vf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vf7Var, Integer.valueOf(i)};
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
            this.a = vf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                vf7 vf7Var = this.a;
                vf7Var.x(wg.g(vf7Var.b, 0L), this.a.c);
            }
        }
    }

    public vf7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = false;
        this.l = true;
        this.m = new uj7();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new d(this, 2001222);
    }

    public void C(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.baidu.tieba.fj7
    public void S(jj7 jj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jj7Var) == null) {
            this.k = jj7Var;
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            uj7 uj7Var = this.m;
            uj7Var.e = 0;
            uj7Var.g = false;
            uj7Var.i = false;
            uj7Var.h = false;
            uj7Var.b = this.b;
            uj7Var.a = this.c;
            uj7Var.c = 1;
            jj7 jj7Var = this.k;
            if (jj7Var != null) {
                jj7Var.a(3, 0, uj7Var, y(this.d, this.e, this.f, this.g, this.i, this.h, this.j));
            }
        }
    }

    @Override // com.baidu.tieba.fj7
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gca.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            gca.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            gca.b(2003009, wf7.class);
        }
    }

    @Override // com.baidu.tieba.fj7
    public void N(int i, int i2, pj7 pj7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, pj7Var) == null) && i == 3 && pj7Var != null) {
            String str = pj7Var.b;
            this.b = str;
            String str2 = pj7Var.a;
            this.c = str2;
            if (this.l) {
                w(str2);
            } else if (pj7Var.c == -1) {
                x(wg.g(str, 0L), pj7Var.a);
            } else {
                A();
            }
        }
    }

    @Override // com.baidu.tieba.fj7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            B();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.o.setTag(bdUniqueId);
                this.n.setTag(this.a);
                this.o.setSelfListener(true);
                if (this.n.getHttpMessageListener() != null) {
                    this.n.getHttpMessageListener().setSelfListener(true);
                }
                if (this.n.getSocketMessageListener() != null) {
                    this.n.getSocketMessageListener().setSelfListener(true);
                }
            }
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    public final bi7 v() {
        InterceptResult invokeV;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list != null && list.size() > 0) {
                bi7 bi7Var = new bi7();
                int j = yi.j(TbadkCoreApplication.getInst().getContext());
                int g2 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
                int g3 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070422);
                int g4 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703bc);
                int size = this.e.size();
                if (TbadkCoreApplication.isLogin()) {
                    g = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703b7);
                } else {
                    g = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07038f);
                }
                bi7Var.d(j - (((g2 + g3) + g) + (g4 * size)));
                bi7Var.c(R.drawable.transparent_bg);
                return bi7Var;
            }
            return null;
        }
        return (bi7) invokeV.objValue;
    }

    public void x(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) && j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberRequestMessage.setTag(bdUniqueId);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    public ArrayList<yn> y(yba ybaVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{ybaVar, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (ybaVar == null) {
                return null;
            }
            ArrayList<yn> arrayList = new ArrayList<>();
            if (ybaVar.n() == 1) {
                zf7 zf7Var = new zf7();
                zf7Var.f(ybaVar);
                zf7Var.d(this.b);
                zf7Var.e(this.c);
                arrayList.add(zf7Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        bg7 bg7Var = new bg7();
                        bg7Var.c(this.b);
                        bg7Var.d(this.c);
                        bg7Var.e(list.get(i));
                        if (i == size - 1) {
                            bg7Var.f(true);
                        } else {
                            bg7Var.f(false);
                        }
                        arrayList.add(bg7Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    fg7 fg7Var = new fg7();
                    fg7Var.g(priManagerApplyInfo.assist_left_num.intValue());
                    fg7Var.f(priManagerApplyInfo.assist_apply_url);
                    fg7Var.e(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(fg7Var);
                }
            } else {
                dg7 dg7Var = new dg7();
                if (managerApplyInfo != null) {
                    dg7Var.h(managerApplyInfo.manager_left_num.intValue());
                    dg7Var.g(managerApplyInfo.manager_apply_url);
                    dg7Var.e(managerApplyInfo.assist_left_num.intValue());
                    dg7Var.d(managerApplyInfo.assist_apply_url);
                    dg7Var.f(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(dg7Var);
                tf7 tf7Var = new tf7();
                tf7Var.a = R.string.obfuscated_res_0x7f0f04b2;
                tf7Var.b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.b;
                arrayList.add(tf7Var);
            }
            z(memberGodInfo, arrayList);
            yn v = v();
            if (v != null) {
                arrayList.add(v);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void z(MemberGodInfo memberGodInfo, ArrayList<yn> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, memberGodInfo, arrayList) == null) && memberGodInfo != null && (list = memberGodInfo.forum_god_list) != null && list.size() > 0 && arrayList != null) {
            List<User> list2 = memberGodInfo.forum_god_list;
            if (memberGodInfo.forum_god_num.intValue() != 0 && list2.size() != 0) {
                pf7 pf7Var = new pf7();
                pf7Var.c(memberGodInfo);
                arrayList.add(pf7Var);
                boolean z = false;
                for (int i = 0; i < list2.size(); i++) {
                    User user = list2.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        rf7 rf7Var = new rf7();
                        rf7Var.o(user, i);
                        arrayList.add(rf7Var);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    arrayList.remove(pf7Var);
                }
            }
        }
    }
}
