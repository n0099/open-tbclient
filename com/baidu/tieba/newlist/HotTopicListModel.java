package com.baidu.tieba.newlist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.tieba.n67;
import com.baidu.tieba.pb;
import com.baidu.tieba.r9;
import com.baidu.tieba.us7;
import com.baidu.tieba.ys7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class HotTopicListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public us7 a;
    public boolean b;

    /* loaded from: classes5.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicListModel hotTopicListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = hotTopicListModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
        @Override // com.baidu.tieba.pb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            n67 n67Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                int i = 0;
                this.a.b = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof ResponseHttpHotRanklistMessage;
                if ((z || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    if (z) {
                        ResponseHttpHotRanklistMessage responseHttpHotRanklistMessage = (ResponseHttpHotRanklistMessage) responsedMessage;
                        if (responseHttpHotRanklistMessage.getHotRanklistData() != null) {
                            n67Var = responseHttpHotRanklistMessage.getHotRanklistData();
                            if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                                ResponseSocketHotRanklistMessage responseSocketHotRanklistMessage = (ResponseSocketHotRanklistMessage) responsedMessage;
                                if (responseSocketHotRanklistMessage.getHotRanklistData() != null) {
                                    n67Var = responseSocketHotRanklistMessage.getHotRanklistData();
                                }
                            }
                            if (n67Var != null) {
                                if (!ListUtils.isEmpty(n67Var.g)) {
                                    LinkedList linkedList = new LinkedList();
                                    int size = n67Var.g.size();
                                    while (i < size) {
                                        linkedList.add(new ys7(n67Var.g.get(i), i));
                                        i++;
                                    }
                                    this.a.a.j(responsedMessage.getError(), linkedList);
                                    i = 1;
                                }
                                if (i != 0) {
                                    return;
                                }
                            }
                            this.a.a.j(-1, null);
                        }
                    }
                    n67Var = null;
                    if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                    }
                    if (n67Var != null) {
                    }
                    this.a.a.j(-1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListModel(TbPageContext<?> tbPageContext, us7 us7Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, us7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        B();
        this.a = us7Var;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289));
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately() || this.b) {
                return false;
            }
            cancelLoadData();
            RequestHotRanklistMessage requestHotRanklistMessage = new RequestHotRanklistMessage();
            requestHotRanklistMessage.setTag(this.unique_id);
            requestHotRanklistMessage.setCallFrom("newbang");
            requestHotRanklistMessage.setListType("all");
            requestHotRanklistMessage.setNeedTabList("0");
            requestHotRanklistMessage.setFid(0L);
            boolean sendMessage = MessageManager.getInstance().sendMessage(requestHotRanklistMessage);
            this.b = sendMessage;
            return sendMessage;
        }
        return invokeV.booleanValue;
    }
}
