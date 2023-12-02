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
/* loaded from: classes8.dex */
public class rp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BawuTeam a;
    public boolean b;
    public ManagerApplyInfo c;
    public c d;
    public bq7 e;
    public NetMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes8.dex */
    public interface c {
        void a(ArrayList<vp7> arrayList, lq7 lq7Var, bq7 bq7Var, boolean z, int i, String str);
    }

    /* loaded from: classes8.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rp7 rp7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = rp7Var;
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
                rp7 rp7Var = this.a;
                if (bawuTeamHttpResponseMessage.isPrivateForum() == 0) {
                    z2 = false;
                }
                rp7Var.b = z2;
                this.a.c = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                this.a.e = bawuTeamHttpResponseMessage.getComplaintBarlordData();
            } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                this.a.a = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                rp7 rp7Var2 = this.a;
                if (bawuTeamSocketResponseMessage.isPrivateForum() == 0) {
                    z2 = false;
                }
                rp7Var2.b = z2;
                this.a.c = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                this.a.e = bawuTeamSocketResponseMessage.getComplaintBarlordData();
            }
            lq7 lq7Var = new lq7();
            if (this.a.c != null) {
                lq7Var.h(this.a.c.manager_left_num.intValue());
                lq7Var.g(this.a.c.manager_apply_url);
                rp7 rp7Var3 = this.a;
                lq7Var.e(rp7Var3.k(rp7Var3.c, this.a.a));
                lq7Var.d(this.a.c.assist_apply_url);
            }
            if (this.a.d != null) {
                c cVar = this.a.d;
                rp7 rp7Var4 = this.a;
                cVar.a(rp7Var4.o(rp7Var4.a), lq7Var, this.a.e, true, responsedMessage.getError(), responsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rp7 rp7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp7Var, Integer.valueOf(i)};
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
            this.a = rp7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                this.a.a = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                rp7 rp7Var = this.a;
                if (bawuTeamReadCacheResponseMessage.isPrivateForum() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                rp7Var.b = z;
                this.a.c = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                this.a.e = bawuTeamReadCacheResponseMessage.getComplaintBarlordData();
                lq7 lq7Var = new lq7();
                if (this.a.c != null) {
                    lq7Var.h(this.a.c.manager_left_num.intValue());
                    lq7Var.g(this.a.c.manager_apply_url);
                    rp7 rp7Var2 = this.a;
                    lq7Var.e(rp7Var2.k(rp7Var2.c, this.a.a));
                    lq7Var.d(this.a.c.assist_apply_url);
                }
                if (this.a.d != null) {
                    c cVar = this.a.d;
                    rp7 rp7Var3 = this.a;
                    cVar.a(rp7Var3.o(rp7Var3.a), lq7Var, this.a.e, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    }

    public rp7() {
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
        this.f = new a(this, CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
        this.g = new b(this, 2003005);
        MessageManager.getInstance().registerListener(this.g);
        MessageManager.getInstance().registerListener(this.f);
    }

    public final int l(@NonNull BawuRoleDes bawuRoleDes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bawuRoleDes)) == null) {
            return bawuRoleDes.role_info.size();
        }
        return invokeL.intValue;
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
            bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
            MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
            bawuTeamRequestMessage.setForumId(j);
            MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
        }
    }

    public void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.d = cVar;
        }
    }

    @NonNull
    public final ArrayList<BawuRoleDes> q(@NonNull BawuTeam bawuTeam) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bawuTeam)) == null) {
            return new ArrayList<>(bawuTeam.bawu_team_list);
        }
        return (ArrayList) invokeL.objValue;
    }

    public final int k(@NonNull ManagerApplyInfo managerApplyInfo, @Nullable BawuTeam bawuTeam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, managerApplyInfo, bawuTeam)) == null) {
            return managerApplyInfo.assist_left_num.intValue();
        }
        return invokeLL.intValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public ArrayList<vp7> o(BawuTeam bawuTeam) {
        InterceptResult invokeL;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bawuTeam)) == null) {
            ArrayList<vp7> arrayList = new ArrayList<>();
            if (bawuTeam != null && bawuTeam.bawu_team_list != null) {
                ArrayList<BawuRoleDes> q = q(bawuTeam);
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    BawuRoleDes bawuRoleDes = q.get(i);
                    if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && (list = bawuRoleDes.role_info) != null && list.size() > 0) {
                        pp7 pp7Var = new pp7();
                        pp7Var.c(bawuRoleDes.role_name + "(" + l(bawuRoleDes) + SmallTailInfo.EMOTION_SUFFIX);
                        arrayList.add(pp7Var);
                        int size2 = bawuRoleDes.role_info.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            op7 op7Var = new op7();
                            op7Var.i(bawuRoleDes.role_name);
                            ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                            arrayList2.add(bawuRoleDes.role_info.get(i2));
                            int i3 = i2 + 1;
                            if (i3 < size2) {
                                arrayList2.add(bawuRoleDes.role_info.get(i3));
                            }
                            i2 += 2;
                            if (i2 >= size2) {
                                if (this.b) {
                                    op7Var.f(false);
                                } else {
                                    op7Var.f(true);
                                }
                                op7Var.g(true);
                            } else {
                                op7Var.g(false);
                            }
                            op7Var.h(arrayList2);
                            arrayList.add(op7Var);
                        }
                        if (i <= size - 2) {
                            arrayList.add(new np7());
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
