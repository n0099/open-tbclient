package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumMember.bawu.BawuTeamHttpResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoReadCacheRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamReadCacheResponseMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamRequestMessage;
import com.baidu.tieba.forumMember.bawu.BawuTeamSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes7.dex */
public class qf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam a;
    public boolean b;
    public ManagerApplyInfo c;
    public c d;
    public NetMessageListener e;
    public CustomMessageListener f;

    /* loaded from: classes7.dex */
    public interface c {
        void a(ArrayList<uf7> arrayList, kg7 kg7Var, boolean z, int i, String str);
    }

    /* loaded from: classes7.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qf7 qf7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = qf7Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BawuTeamHttpResponseMessage;
            if (!z && !(responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                return;
            }
            boolean z2 = true;
            if (z) {
                BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                this.a.a = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                qf7 qf7Var = this.a;
                if (bawuTeamHttpResponseMessage.isPrivateForum() == 0) {
                    z2 = false;
                }
                qf7Var.b = z2;
                this.a.c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
            } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                this.a.a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                qf7 qf7Var2 = this.a;
                if (bawuTeamSocketResponseMessage.isPrivateForum() == 0) {
                    z2 = false;
                }
                qf7Var2.b = z2;
                this.a.c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
            }
            kg7 kg7Var = new kg7();
            if (this.a.c != null) {
                kg7Var.h(this.a.c.manager_left_num.intValue());
                kg7Var.g(this.a.c.manager_apply_url);
                qf7 qf7Var3 = this.a;
                kg7Var.e(qf7Var3.i(qf7Var3.c, this.a.a));
                kg7Var.d(this.a.c.assist_apply_url);
            }
            if (this.a.d != null) {
                c cVar = this.a.d;
                qf7 qf7Var4 = this.a;
                cVar.a(qf7Var4.m(qf7Var4.a), kg7Var, true, responsedMessage.getError(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qf7 qf7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf7Var, Integer.valueOf(i)};
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
            this.a = qf7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.a.a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                qf7 qf7Var = this.a;
                if (bawuTeamReadCacheResponseMessage.isPrivateForum() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                qf7Var.b = z;
                this.a.c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                kg7 kg7Var = new kg7();
                if (this.a.c != null) {
                    kg7Var.h(this.a.c.manager_left_num.intValue());
                    kg7Var.g(this.a.c.manager_apply_url);
                    qf7 qf7Var2 = this.a;
                    kg7Var.e(qf7Var2.i(qf7Var2.c, this.a.a));
                    kg7Var.d(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    qf7 qf7Var3 = this.a;
                    cVar.a(qf7Var3.m(qf7Var3.a), kg7Var, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    public qf7() {
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
        this.d = null;
        this.e = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.f = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.e);
    }

    public final int j(@NonNull BawuRoleDes bawuRoleDes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bawuRoleDes)) == null) {
            return bawuRoleDes.role_info.size();
        }
        return invokeL.intValue;
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.d = cVar;
        }
    }

    @NonNull
    public final ArrayList<BawuRoleDes> o(@NonNull BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bawuTeam)) == null) {
            return new ArrayList<>(bawuTeam.bawu_team_list);
        }
        return (ArrayList) invokeL.objValue;
    }

    public final int i(@NonNull ManagerApplyInfo managerApplyInfo, @Nullable BawuTeam bawuTeam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, managerApplyInfo, bawuTeam)) == null) {
            return managerApplyInfo.assist_left_num.intValue();
        }
        return invokeLL.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.f);
        }
    }

    public ArrayList<uf7> m(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bawuTeam)) == null) {
            ArrayList<uf7> arrayList = new ArrayList<>();
            if (bawuTeam != null && bawuTeam.bawu_team_list != null) {
                ArrayList<BawuRoleDes> o = o(bawuTeam);
                int size = o.size();
                for (int i = 0; i < size; i++) {
                    BawuRoleDes bawuRoleDes = o.get(i);
                    if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list = bawuRoleDes.role_info) != null && list.size() > 0) {
                        of7 of7Var = new of7();
                        of7Var.c(bawuRoleDes.role_name + "(" + j(bawuRoleDes) + SmallTailInfo.EMOTION_SUFFIX);
                        arrayList.add(of7Var);
                        int size2 = bawuRoleDes.role_info.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            nf7 nf7Var = new nf7();
                            nf7Var.i(bawuRoleDes.role_name);
                            ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                            arrayList2.add(bawuRoleDes.role_info.get(i2));
                            int i3 = i2 + 1;
                            if (i3 < size2) {
                                arrayList2.add(bawuRoleDes.role_info.get(i3));
                            }
                            i2 += 2;
                            if (i2 >= size2) {
                                if (this.b) {
                                    nf7Var.f(false);
                                } else {
                                    nf7Var.f(true);
                                }
                                nf7Var.g(true);
                            } else {
                                nf7Var.g(false);
                            }
                            nf7Var.h(arrayList2);
                            arrayList.add(nf7Var);
                        }
                        if (i <= size - 2) {
                            arrayList.add(new mf7());
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }
}
