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
/* loaded from: classes6.dex */
public class tg6 implements ak6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public String b;
    public String c;
    public ao8 d;
    public List<MemberGroupInfo> e;
    public MemberGodInfo f;
    public ManagerApplyInfo g;
    public boolean h;
    public boolean i;
    public PriManagerApplyInfo j;
    public ek6 k;
    public boolean l;
    public pk6 m;
    public pb n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes6.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tg6 tg6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = tg6Var;
        }

        @Override // com.baidu.tieba.pb
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
                ek6 ek6Var = this.a.k;
                pk6 pk6Var = this.a.m;
                tg6 tg6Var = this.a;
                ek6Var.a(3, 0, pk6Var, tg6Var.A(tg6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, this.a.d));
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tg6 tg6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg6Var, Integer.valueOf(i)};
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
            this.a = tg6Var;
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
                tg6 tg6Var = this.a;
                ArrayList<wn> A = tg6Var.A(tg6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j);
                if (A != null && A.size() > 0) {
                    this.a.k.a(3, 0, this.a.m, A);
                } else if (!this.a.l) {
                    this.a.k.a(3, 0, this.a.m, A);
                }
            }
            if (this.a.l) {
                tg6 tg6Var2 = this.a;
                tg6Var2.z(wg.g(tg6Var2.b, 0L), this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(tg6 tg6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg6Var, Integer.valueOf(i)};
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
            this.a = tg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ao8)) {
                this.a.m.e = customResponsedMessage.getError();
                this.a.m.f = customResponsedMessage.getErrorString();
                this.a.m.g = false;
                this.a.m.i = false;
                this.a.m.h = false;
                this.a.m.b = this.a.b;
                this.a.m.a = this.a.c;
                this.a.m.c = 1;
                ao8 ao8Var = (ao8) customResponsedMessage.getData();
                if (ao8Var != null && ao8Var.m() == 0 && this.a.d != null) {
                    ao8Var.t(this.a.d.c());
                    ao8Var.w(this.a.d.i());
                }
                this.a.d = ao8Var;
                if (this.a.k != null) {
                    ek6 ek6Var = this.a.k;
                    pk6 pk6Var = this.a.m;
                    tg6 tg6Var = this.a;
                    ek6Var.a(3, 0, pk6Var, tg6Var.A(tg6Var.d, this.a.e, this.a.f, this.a.g, this.a.i, this.a.h, this.a.j));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(tg6 tg6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg6Var, Integer.valueOf(i)};
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
            this.a = tg6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                tg6 tg6Var = this.a;
                tg6Var.z(wg.g(tg6Var.b, 0L), this.a.c);
            }
        }
    }

    public tg6() {
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
        this.m = new pk6();
        this.n = new a(this, CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004);
        this.o = new b(this, 2003009);
        this.p = new c(this, 2001266);
        this.q = new d(this, 2001222);
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.baidu.tieba.ak6
    public void w(ek6 ek6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ek6Var) == null) {
            this.k = ek6Var;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                forumMemberReadCacheRequestMessage.setTag(bdUniqueId);
            }
            forumMemberReadCacheRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
        }
    }

    public ArrayList<wn> A(ao8 ao8Var, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{ao8Var, list, memberGodInfo, managerApplyInfo, Boolean.valueOf(z), Boolean.valueOf(z2), priManagerApplyInfo})) == null) {
            if (ao8Var == null) {
                return null;
            }
            ArrayList<wn> arrayList = new ArrayList<>();
            if (ao8Var.m() == 1) {
                xg6 xg6Var = new xg6();
                xg6Var.h(ao8Var);
                xg6Var.f(this.b);
                xg6Var.g(this.c);
                arrayList.add(xg6Var);
            }
            if (list != null && list.size() > 0) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && ListUtils.getCount(list.get(i).member_group_list) > 0) {
                        zg6 zg6Var = new zg6();
                        zg6Var.c(this.b);
                        zg6Var.f(this.c);
                        zg6Var.g(list.get(i));
                        if (i == size - 1) {
                            zg6Var.h(true);
                        } else {
                            zg6Var.h(false);
                        }
                        arrayList.add(zg6Var);
                    }
                }
            }
            if (this.h) {
                if (this.i && priManagerApplyInfo != null) {
                    dh6 dh6Var = new dh6();
                    dh6Var.j(priManagerApplyInfo.assist_left_num.intValue());
                    dh6Var.h(priManagerApplyInfo.assist_apply_url);
                    dh6Var.g(priManagerApplyInfo.assist_apply_status.intValue());
                    arrayList.add(dh6Var);
                }
            } else {
                bh6 bh6Var = new bh6();
                if (managerApplyInfo != null) {
                    bh6Var.k(managerApplyInfo.manager_left_num.intValue());
                    bh6Var.j(managerApplyInfo.manager_apply_url);
                    bh6Var.g(managerApplyInfo.assist_left_num.intValue());
                    bh6Var.f(managerApplyInfo.assist_apply_url);
                    bh6Var.h(managerApplyInfo.manager_apply_status.intValue());
                }
                arrayList.add(bh6Var);
                rg6 rg6Var = new rg6();
                rg6Var.a = R.string.obfuscated_res_0x7f0f042f;
                rg6Var.b = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.b;
                arrayList.add(rg6Var);
            }
            B(memberGodInfo, arrayList);
            wn x = x();
            if (x != null) {
                arrayList.add(x);
            }
            return arrayList;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public final void B(MemberGodInfo memberGodInfo, ArrayList<wn> arrayList) {
        List<User> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberGodInfo, arrayList) == null) && memberGodInfo != null && (list = memberGodInfo.forum_god_list) != null && list.size() > 0 && arrayList != null) {
            List<User> list2 = memberGodInfo.forum_god_list;
            if (memberGodInfo.forum_god_num.intValue() != 0 && list2.size() != 0) {
                ng6 ng6Var = new ng6();
                ng6Var.c(memberGodInfo);
                arrayList.add(ng6Var);
                boolean z = false;
                for (int i = 0; i < list2.size(); i++) {
                    User user = list2.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        pg6 pg6Var = new pg6();
                        pg6Var.r(user, i);
                        arrayList.add(pg6Var);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    arrayList.remove(ng6Var);
                }
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pk6 pk6Var = this.m;
            pk6Var.e = 0;
            pk6Var.g = false;
            pk6Var.i = false;
            pk6Var.h = false;
            pk6Var.b = this.b;
            pk6Var.a = this.c;
            pk6Var.c = 1;
            ek6 ek6Var = this.k;
            if (ek6Var != null) {
                ek6Var.a(3, 0, pk6Var, A(this.d, this.e, this.f, this.g, this.i, this.h, this.j));
            }
        }
    }

    @Override // com.baidu.tieba.ak6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            io8.h(301004, ForumMemberSocketResponseMessage.class, false, false);
            io8.c(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
            io8.b(2003009, ug6.class);
        }
    }

    @Override // com.baidu.tieba.ak6
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            D();
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

    @Override // com.baidu.tieba.ak6
    public void t(int i, int i2, kk6 kk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, kk6Var) == null) && i == 3 && kk6Var != null) {
            String str = kk6Var.b;
            this.b = str;
            String str2 = kk6Var.a;
            this.c = str2;
            if (this.l) {
                y(str2);
            } else if (kk6Var.c == -1) {
                z(wg.g(str, 0L), kk6Var.a);
            } else {
                C();
            }
        }
    }

    public final xi6 x() {
        InterceptResult invokeV;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<MemberGroupInfo> list = this.e;
            if (list != null && list.size() > 0) {
                xi6 xi6Var = new xi6();
                int j = xi.j(TbadkCoreApplication.getInst().getContext());
                int g2 = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07019a);
                int g3 = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070308);
                int g4 = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07029e);
                int size = this.e.size();
                if (TbadkCoreApplication.isLogin()) {
                    g = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070299);
                } else {
                    g = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f07026c);
                }
                xi6Var.f(j - (((g2 + g3) + g) + (g4 * size)));
                xi6Var.c(R.drawable.obfuscated_res_0x7f08126e);
                return xi6Var;
            }
            return null;
        }
        return (xi6) invokeV.objValue;
    }

    public void z(long j, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) && j > 0 && !StringUtils.isNull(str)) {
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
}
