package com.baidu.tieba.videoplay.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.hi;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoChannelModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public c b;
    public int c;
    public boolean d;
    public int e;
    public HttpMessageListener f;
    public final CustomMessageListener g;

    /* loaded from: classes6.dex */
    public interface c {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoChannelModel videoChannelModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelModel, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                int i = 0;
                if (this.a.c == 1) {
                    this.a.d = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921576, Integer.valueOf(this.a.e)));
                }
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    List<VideoItemData> arrayList = new ArrayList<>();
                    if (httpResponsedMessage instanceof VideoChannelHttpResponseMessage) {
                        arrayList = ((VideoChannelHttpResponseMessage) httpResponsedMessage).getVideoItemDatas();
                        while (i < arrayList.size()) {
                            arrayList.get(i).setChannelMidRequestNum(this.a.c);
                            i++;
                            arrayList.get(i).setChannelMidRequestVideoNum(i);
                        }
                    }
                    TbSingleton.getInstance().clearVideoRecord();
                    if (this.a.b != null) {
                        if (this.a.c == 1) {
                            this.a.b.a(arrayList, this.a.d);
                        } else {
                            this.a.b.b(arrayList);
                        }
                    }
                    VideoChannelModel.S(this.a);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoChannelModel videoChannelModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelModel, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                hi.N(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1f));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Integer) || ((Integer) data).intValue() != this.a.e || this.a.d) {
                return;
            }
            this.a.d = true;
            this.a.Z();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921575, Integer.valueOf(this.a.e)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoChannelModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.d = false;
        this.f = new a(this, CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, true);
        this.g = new b(this, 2921574, true);
        this.a = tbPageContext;
        setUniqueId(bdUniqueId);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, TbConfig.SERVER_ADDRESS + "c/f/video/feed");
        tbHttpMessageTask.setResponsedClass(VideoChannelHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.f);
        registerListener(this.g);
    }

    public static /* synthetic */ int S(VideoChannelModel videoChannelModel) {
        int i = videoChannelModel.c;
        videoChannelModel.c = i + 1;
        return i;
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e = i;
        }
    }

    public void b0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public final HttpMessage Y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED);
            httpMessage.addParam("scr_w", hi.l(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", hi.j(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_dip", Float.valueOf(hi.i(TbadkCoreApplication.getInst())));
            httpMessage.addParam("new_net_type", BdNetTypeUtil.netType());
            httpMessage.addParam("load_type", i);
            return httpMessage;
        }
        return (HttpMessage) invokeI.objValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = 1;
            sendMessage(Y(1));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.c < 2) {
                this.c = 2;
            }
            sendMessage(Y(2));
        }
    }
}
