package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabRequestMessage;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tf6 implements wj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public int b;
    public lk7 c;
    public ArrayList<bn> d;
    public ak7 e;
    public NetMessageListener f;
    public HttpMessageListener g;

    /* loaded from: classes8.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tf6 tf6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = tf6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null || responsedMessage.getOrginalMessage().getTag() != this.a.a) {
                return;
            }
            List<Long> list = null;
            if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
            }
            if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                list = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
            }
            if (!ListUtils.isEmpty(this.a.d) && !ListUtils.isEmpty(list)) {
                boolean z = false;
                for (int size = this.a.d.size() - 1; size >= 0; size--) {
                    if (this.a.d.get(size).getType() == ThreadData.TYPE_VIDEO_ALA_ONLIVE && (threadData = (ThreadData) this.a.d.get(size)) != null && threadData.getThreadAlaInfo() != null && list.contains(Long.valueOf(threadData.getThreadAlaInfo().live_id))) {
                        this.a.d.remove(size);
                        z = true;
                    }
                }
                if (z && this.a.e != null) {
                    this.a.e.a(49, this.a.b, this.a.c, this.a.d);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(tf6 tf6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf6Var, Integer.valueOf(i)};
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
            this.a = tf6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                    if (frsPageAlaTabResponseMessage.errCode == 0) {
                        ArrayList<bn> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                        ArrayList<bn> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                        lk7 lk7Var = frsPageAlaTabResponseMessage.pageInfo;
                        int i = frsPageAlaTabResponseMessage.alaLiveCount;
                        this.a.c = lk7Var;
                        if (lk7Var.c == 1) {
                            this.a.d.clear();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i)));
                        if (this.a.e != null) {
                            if (arrayList != null && arrayList.size() > 0) {
                                this.a.d.addAll(arrayList);
                                this.a.e.a(49, this.a.b, lk7Var, this.a.d);
                                return;
                            }
                            ThreadData threadData = new ThreadData();
                            threadData.setThreadType(51);
                            if (this.a.d.size() == 0 || (this.a.d.size() > 0 && ((ThreadData) this.a.d.get(0)).getThreadType() != 51)) {
                                this.a.d.add(0, threadData);
                            }
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                threadData.hasRecommend = true;
                                if (arrayList2.get(0) != null) {
                                    ((ThreadData) arrayList2.get(0)).isFirstRecommend = true;
                                }
                                this.a.d.addAll(arrayList2);
                            }
                            this.a.e.a(49, this.a.b, lk7Var, this.a.d);
                            return;
                        }
                        return;
                    } else if (this.a.e != null) {
                        this.a.e.a(49, this.a.b, null, null);
                        return;
                    } else {
                        return;
                    }
                }
                this.a.e.a(49, this.a.b, null, null);
            }
        }
    }

    public tf6() {
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
        this.d = new ArrayList<>();
        this.f = new a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.g = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    @Override // com.baidu.tieba.wj7
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // com.baidu.tieba.wj7
    public void L(ak7 ak7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ak7Var) == null) {
            this.e = ak7Var;
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.a = bdUniqueId;
    }

    @Override // com.baidu.tieba.wj7
    public void H(int i, int i2, gk7 gk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, gk7Var) == null) {
            this.b = i2;
            if (gk7Var != null && !TextUtils.isEmpty(gk7Var.a) && !TextUtils.isEmpty(gk7Var.b)) {
                if (gk7Var.c <= 0) {
                    gk7Var.c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, gk7Var.a, gk7Var.b, gk7Var.c));
                return;
            }
            this.e.a(49, this.b, null, null);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.g.setTag(bdUniqueId);
                this.f.setTag(this.a);
            }
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.g);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    @Override // com.baidu.tieba.wj7
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
            h();
        }
    }
}
