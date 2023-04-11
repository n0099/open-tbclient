package com.baidu.tieba.memberCenter.bubble;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.a9;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class BubbleListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public d b;
    public int c;
    public int d;
    public final HttpMessageListener e;
    public final HttpMessageListener f;

    /* loaded from: classes5.dex */
    public interface c {
        void a(BubbleListData bubbleListData);

        void b(BubbleListData bubbleListData);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(SetBubbleResultData setBubbleResultData);

        void b(SetBubbleResultData setBubbleResultData);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BubbleListModel bubbleListModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleListModel, Integer.valueOf(i)};
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
            this.a = bubbleListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001500 || this.a.a == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof ResponseBubbleListMessage)) {
                this.a.a.a(null);
                return;
            }
            ResponseBubbleListMessage responseBubbleListMessage = (ResponseBubbleListMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0) {
                if (responseBubbleListMessage.getBubbleListData() == null) {
                    this.a.a.a(responseBubbleListMessage.getBubbleListData());
                    return;
                } else {
                    this.a.a.b(responseBubbleListMessage.getBubbleListData());
                    return;
                }
            }
            this.a.a.a(responseBubbleListMessage.getBubbleListData());
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BubbleListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BubbleListModel bubbleListModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bubbleListModel, Integer.valueOf(i)};
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
            this.a = bubbleListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001501 || this.a.b == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (!(httpResponsedMessage instanceof ResponseSetBubbleMessage)) {
                this.a.b.b(null);
                return;
            }
            ResponseSetBubbleMessage responseSetBubbleMessage = (ResponseSetBubbleMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0) {
                if (responseSetBubbleMessage.getSetBubbleResultData() == null) {
                    this.a.b.b(responseSetBubbleMessage.getSetBubbleResultData());
                    return;
                } else {
                    this.a.b.a(responseSetBubbleMessage.getSetBubbleResultData());
                    return;
                }
            }
            this.a.b.b(responseSetBubbleMessage.getSetBubbleResultData());
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
        this.f = new b(this, CmdConfigHttp.SET_BUBBLE_CMD);
    }

    public void X(CustomMessageListener customMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, customMessageListener) == null) {
            registerListener(customMessageListener);
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c = i;
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
        }
    }

    public void c0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void d0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void e0(CustomMessageListener customMessageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, customMessageListener) == null) {
            MessageManager.getInstance().unRegisterListener(customMessageListener);
        }
    }

    public static boolean S(List<BubbleListData.BubbleData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list != null && list.size() > 0) {
                for (BubbleListData.BubbleData bubbleData : list) {
                    if (bubbleData.getBcode() != 0 && bubbleData.isDef()) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.unRegisterListener(this.f);
            messageManager.unRegisterListener(this.e);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.REQUEST_BUBBLELIST_CMD, TbConfig.SERVER_ADDRESS + "c/e/bu/getbubblelist");
            tbHttpMessageTask.setResponsedClass(ResponseBubbleListMessage.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.e);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_BUBBLE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.BUBBLE_SET);
            tbHttpMessageTask.setResponsedClass(ResponseSetBubbleMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.f);
        }
    }

    public void Y(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
            httpMessage.addParam("pn", String.valueOf(i));
            httpMessage.addParam("rn", String.valueOf(i2));
            httpMessage.addParam("scr_w", String.valueOf(i3));
            httpMessage.addParam("scr_h", String.valueOf(i4));
            sendMessage(httpMessage);
        }
    }

    public void Z(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_BUBBLE_CMD);
            httpMessage.addParam("bcode", String.valueOf(i));
            httpMessage.addParam("scr_w", String.valueOf(i2));
            httpMessage.addParam("scr_h", String.valueOf(i3));
            sendMessage(httpMessage);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "consume_20", null);
        }
    }
}
