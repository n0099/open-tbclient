package com.baidu.tieba.memberCenter.bubble;

import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class BubbleListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f54039e;

    /* renamed from: f  reason: collision with root package name */
    public d f54040f;

    /* renamed from: g  reason: collision with root package name */
    public int f54041g;

    /* renamed from: h  reason: collision with root package name */
    public int f54042h;

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f54043i;

    /* renamed from: j  reason: collision with root package name */
    public final HttpMessageListener f54044j;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleListModel f54045a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BubbleListModel bubbleListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleListModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54045a = bubbleListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001500 || this.f54045a.f54039e == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                this.f54045a.f54039e.a(null);
                return;
            }
            ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
            if (statusCode != 200 || error != 0) {
                this.f54045a.f54039e.a(responseBubbleListMessage.getBubbleListData());
            } else if (responseBubbleListMessage.getBubbleListData() == null) {
                this.f54045a.f54039e.a(responseBubbleListMessage.getBubbleListData());
            } else {
                this.f54045a.f54039e.b(responseBubbleListMessage.getBubbleListData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BubbleListModel f54046a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BubbleListModel bubbleListModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleListModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54046a = bubbleListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001501 || this.f54046a.f54040f == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                this.f54046a.f54040f.b(null);
                return;
            }
            ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
            if (statusCode != 200 || error != 0) {
                this.f54046a.f54040f.b(responseSetBubbleMessage.getSetBubbleResultData());
            } else if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                this.f54046a.f54040f.b(responseSetBubbleMessage.getSetBubbleResultData());
            } else {
                this.f54046a.f54040f.a(responseSetBubbleMessage.getSetBubbleResultData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(BubbleListData bubbleListData);

        void b(BubbleListData bubbleListData);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(SetBubbleResultData setBubbleResultData);

        void b(SetBubbleResultData setBubbleResultData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f54043i = new a(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.f54044j = new b(this, CmdConfigHttp.SET_BUBBLE_CMD);
    }

    public static boolean y(List<BubbleListData.BubbleData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.size() <= 0) {
                return true;
            }
            for (BubbleListData.BubbleData bubbleData : list) {
                if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54042h : invokeV.intValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REQUEST_BUBBLELIST_CMD, TbConfig.SERVER_ADDRESS + "c/e/bu/getbubblelist");
            tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.f54043i);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_BUBBLE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
            tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.f54044j);
        }
    }

    public void D(CustomMessageListener customMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, customMessageListener) == null) {
            registerListener(customMessageListener);
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
            httpMessage.addParam("pn", String.valueOf(i2));
            httpMessage.addParam("rn", String.valueOf(i3));
            httpMessage.addParam("scr_w", String.valueOf(i4));
            httpMessage.addParam("scr_h", String.valueOf(i5));
            sendMessage(httpMessage);
        }
    }

    public void F(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_BUBBLE_CMD);
            httpMessage.addParam("bcode", String.valueOf(i2));
            httpMessage.addParam("scr_w", String.valueOf(i3));
            httpMessage.addParam("scr_h", String.valueOf(i4));
            sendMessage(httpMessage);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "consume_20", null);
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f54041g = i2;
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f54042h = i2;
        }
    }

    public void I(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f54039e = cVar;
        }
    }

    public void J(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.f54040f = dVar;
        }
    }

    public void K(CustomMessageListener customMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, customMessageListener) == null) {
            MessageManager.getInstance().unRegisterListener(customMessageListener);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.unRegisterListener(this.f54044j);
            messageManager.unRegisterListener(this.f54043i);
        }
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f54041g : invokeV.intValue;
    }
}
