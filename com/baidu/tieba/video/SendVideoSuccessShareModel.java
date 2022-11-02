package com.baidu.tieba.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class SendVideoSuccessShareModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpMessageListener a;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class SendVideoSuccessShareOriginalThreadInfoResponse extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public OriginalThreadInfo threadInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendVideoSuccessShareOriginalThreadInfoResponse(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
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
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                super.decodeLogicInBackGround(i, jSONObject);
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error >= 0 && jSONObject != null) {
                    this.threadInfo = new OriginalThreadInfo();
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                    String optString3 = jSONObject.optString("video_id");
                    OriginalThreadInfo originalThreadInfo = this.threadInfo;
                    originalThreadInfo.c = optString2;
                    originalThreadInfo.a = 3;
                    originalThreadInfo.b = optString;
                    originalThreadInfo.l = optString3;
                }
            }
        }

        public OriginalThreadInfo getThreadInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.threadInfo;
            }
            return (OriginalThreadInfo) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SendVideoSuccessShareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SendVideoSuccessShareModel sendVideoSuccessShareModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sendVideoSuccessShareModel, Integer.valueOf(i)};
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
            this.a = sendVideoSuccessShareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003384 && (httpResponsedMessage instanceof SendVideoSuccessShareOriginalThreadInfoResponse)) {
                SendVideoSuccessShareOriginalThreadInfoResponse sendVideoSuccessShareOriginalThreadInfoResponse = (SendVideoSuccessShareOriginalThreadInfoResponse) httpResponsedMessage;
                if (sendVideoSuccessShareOriginalThreadInfoResponse.threadInfo != null && this.a.mLoadDataCallBack != null) {
                    this.a.mLoadDataCallBack.c(sendVideoSuccessShareOriginalThreadInfoResponse.getThreadInfo());
                }
            }
        }
    }

    public SendVideoSuccessShareModel() {
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
        this.a = new a(this, CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID);
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.a.setTag(getUniqueId());
        this.a.setSelfListener(true);
        registerListener(this.a);
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID);
            httpMessage.addParam("video_id", str);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.a);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_VIDEO_INFO_BY_LOGVID, TbConfig.SERVER_ADDRESS + TbConfig.URL_GET_VIDEO_INFO_BY_VLOGID);
            tbHttpMessageTask.setResponsedClass(SendVideoSuccessShareOriginalThreadInfoResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
