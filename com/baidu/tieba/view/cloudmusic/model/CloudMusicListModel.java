package com.baidu.tieba.view.cloudmusic.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.z5b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CloudMusicListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z5b<CloudMusicData.MusicTagList> a;
    public int b;
    public final HttpMessageListener c;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public static class VideoCloudMusicListResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CloudMusicData.MusicTagList mCloudMusicWithTagData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoCloudMusicListResponseMessage(int i) {
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
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error == 0 && jSONObject != null) {
                    this.mCloudMusicWithTagData = (CloudMusicData.MusicTagList) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), CloudMusicData.MusicTagList.class);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CloudMusicListModel cloudMusicListModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudMusicListModel, Integer.valueOf(i)};
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
            this.a = cloudMusicListModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003367 || !(httpResponsedMessage instanceof VideoCloudMusicListResponseMessage) || this.a.a == null) {
                return;
            }
            if (httpResponsedMessage.hasError() && httpResponsedMessage.getError() != 0) {
                CloudMusicListModel.P(this.a);
            }
            this.a.a.a(((VideoCloudMusicListResponseMessage) httpResponsedMessage).mCloudMusicWithTagData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloudMusicListModel(BdPageContext bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = new a(this, CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
        R();
        this.c.setTag(getUniqueId());
        this.c.setSelfListener(true);
        registerListener(this.c);
    }

    public static /* synthetic */ int P(CloudMusicListModel cloudMusicListModel) {
        int i = cloudMusicListModel.b;
        cloudMusicListModel.b = i - 1;
        return i;
    }

    public void Q(int i, z5b<CloudMusicData.MusicTagList> z5bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, z5bVar) == null) && z5bVar != null && i >= 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
            int i2 = this.b + 1;
            this.b = i2;
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("rn", 10);
            httpMessage.addParam(PushConstants.SUB_TAGS_STATUS_ID, i);
            sendMessage(httpMessage);
            this.a = z5bVar;
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST, TbConfig.SERVER_ADDRESS + "c/f/video/getMusicTagList");
            tbHttpMessageTask.setResponsedClass(VideoCloudMusicListResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = 1;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_CLOUD_MUSIC_LIST);
            return false;
        }
        return invokeV.booleanValue;
    }
}
