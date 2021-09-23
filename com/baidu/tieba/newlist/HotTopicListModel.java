package com.baidu.tieba.newlist;

import c.a.e.a.f;
import c.a.r0.g2.b;
import c.a.r0.i1.c.j;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hottopic.message.RequestHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotRanklistMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotRanklistMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class HotTopicListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f54916e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54917f;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicListModel f54918a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicListModel hotTopicListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54918a = hotTopicListModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
        @Override // c.a.e.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                int i2 = 0;
                this.f54918a.f54917f = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof ResponseHttpHotRanklistMessage;
                if ((z || (responsedMessage instanceof ResponseSocketHotRanklistMessage)) && responsedMessage.getOrginalMessage().getTag() == this.f54918a.getUniqueId()) {
                    if (z) {
                        ResponseHttpHotRanklistMessage responseHttpHotRanklistMessage = (ResponseHttpHotRanklistMessage) responsedMessage;
                        if (responseHttpHotRanklistMessage.getHotRanklistData() != null) {
                            jVar = responseHttpHotRanklistMessage.getHotRanklistData();
                            if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                                ResponseSocketHotRanklistMessage responseSocketHotRanklistMessage = (ResponseSocketHotRanklistMessage) responsedMessage;
                                if (responseSocketHotRanklistMessage.getHotRanklistData() != null) {
                                    jVar = responseSocketHotRanklistMessage.getHotRanklistData();
                                }
                            }
                            if (jVar != null) {
                                if (!ListUtils.isEmpty(jVar.f19316h)) {
                                    LinkedList linkedList = new LinkedList();
                                    int size = jVar.f19316h.size();
                                    while (i2 < size) {
                                        linkedList.add(new c.a.r0.g2.d.b(jVar.f19316h.get(i2), i2));
                                        i2++;
                                    }
                                    this.f54918a.f54916e.netCallback(responsedMessage.getError(), linkedList);
                                    i2 = 1;
                                }
                                if (i2 != 0) {
                                    return;
                                }
                            }
                            this.f54918a.f54916e.netCallback(-1, null);
                        }
                    }
                    jVar = null;
                    if (responsedMessage instanceof ResponseSocketHotRanklistMessage) {
                    }
                    if (jVar != null) {
                    }
                    this.f54918a.f54916e.netCallback(-1, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicListModel(TbPageContext<?> tbPageContext, b bVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        y();
        this.f54916e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!c.a.e.e.p.j.A() || this.f54917f) {
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
            this.f54917f = sendMessage;
            return sendMessage;
        }
        return invokeV.booleanValue;
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

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HOT_TOPIC_RANKLIST, 309289));
        }
    }
}
