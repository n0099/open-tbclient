package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumHttpResMsg;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumReqMsg;
import com.baidu.tieba.setting.forbiddenforum.ForbiddenForumSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public int b;
    public ov9 c;
    public b d;
    public kb e;

    /* loaded from: classes7.dex */
    public interface b {
        void a(ov9 ov9Var);

        void onError(int i, String str);
    }

    /* loaded from: classes7.dex */
    public class a extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nv9 nv9Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv9Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = nv9Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ov9 ov9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null && responsedMessage.getOrginalMessage().getTag() != this.a.a) {
                return;
            }
            if (responsedMessage instanceof ForbiddenForumHttpResMsg) {
                ov9Var = ((ForbiddenForumHttpResMsg) responsedMessage).getPageData();
            } else if (responsedMessage instanceof ForbiddenForumSocketResMsg) {
                ov9Var = ((ForbiddenForumSocketResMsg) responsedMessage).getPageData();
            } else {
                ov9Var = null;
            }
            if (responsedMessage.getError() == 0) {
                if (this.a.b == 1 && (ov9Var == null || ListUtils.isEmpty(ov9Var.a))) {
                    if (this.a.d != null) {
                        this.a.d.a(null);
                    }
                } else if (ov9Var != null) {
                    this.a.c.a.addAll(ov9Var.a);
                    if (!ListUtils.isEmpty(ov9Var.a)) {
                        this.a.c.b = ov9Var.b;
                        nv9.c(this.a);
                    } else {
                        this.a.c.b = false;
                    }
                    if (this.a.d != null) {
                        this.a.d.a(ov9Var);
                    }
                }
            } else if (this.a.d != null) {
                this.a.d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
            }
        }
    }

    public nv9(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, 309692);
        this.e = aVar;
        this.a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
        i();
        h();
        this.c = new ov9();
    }

    public static /* synthetic */ int c(nv9 nv9Var) {
        int i = nv9Var.b;
        nv9Var.b = i + 1;
        return i;
    }

    public void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void f(String str) {
        ov9 ov9Var;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (ov9Var = this.c) != null && !ListUtils.isEmpty(ov9Var.a)) {
            for (mv9 mv9Var : this.c.a) {
                if (mv9Var != null && (str2 = mv9Var.c) != null && str2.equals(str)) {
                    this.c.a.remove(mv9Var);
                    return;
                }
            }
        }
    }

    public ov9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ov9) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wt5 wt5Var = new wt5(309692);
            wt5Var.setResponsedClass(ForbiddenForumSocketResMsg.class);
            wt5Var.g(true);
            wt5Var.setPriority(4);
            MessageManager.getInstance().registerTask(wt5Var);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ForbiddenForumReqMsg forbiddenForumReqMsg = new ForbiddenForumReqMsg();
            forbiddenForumReqMsg.pageSize = 20;
            forbiddenForumReqMsg.pageNum = this.b;
            forbiddenForumReqMsg.setTag(this.a);
            MessageManager.getInstance().sendMessage(forbiddenForumReqMsg);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORBIDDEN_FORUM, v3a.a(TbConfig.URL_GET_FORBIDDEN_FORUM, 309692));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(ForbiddenForumHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
