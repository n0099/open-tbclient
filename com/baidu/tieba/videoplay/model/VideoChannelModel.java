package com.baidu.tieba.videoplay.model;

import c.a.e.a.f;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoChannelModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f57868e;

    /* renamed from: f  reason: collision with root package name */
    public c f57869f;

    /* renamed from: g  reason: collision with root package name */
    public int f57870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57871h;

    /* renamed from: i  reason: collision with root package name */
    public int f57872i;

    /* renamed from: j  reason: collision with root package name */
    public HttpMessageListener f57873j;
    public final CustomMessageListener k;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelModel f57874a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoChannelModel videoChannelModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57874a = videoChannelModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f57874a.f57870g == 1) {
                    this.f57874a.f57871h = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921576, Integer.valueOf(this.f57874a.f57872i)));
                }
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    return;
                }
                List<VideoItemData> arrayList = new ArrayList<>();
                if (httpResponsedMessage instanceof VideoChannelHttpResponseMessage) {
                    arrayList = ((VideoChannelHttpResponseMessage) httpResponsedMessage).getVideoItemDatas();
                }
                TbSingleton.getInstance().clearVideoRecord();
                if (this.f57874a.f57869f != null) {
                    if (this.f57874a.f57870g == 1) {
                        this.f57874a.f57869f.a(arrayList, this.f57874a.f57871h);
                    } else {
                        this.f57874a.f57869f.b(arrayList);
                    }
                }
                VideoChannelModel.x(this.f57874a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelModel f57875a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoChannelModel videoChannelModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelModel, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57875a = videoChannelModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!j.z()) {
                l.J(this.f57875a.f57868e.getPageActivity(), this.f57875a.f57868e.getResources().getString(R.string.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == this.f57875a.f57872i && !this.f57875a.f57871h) {
                this.f57875a.f57871h = true;
                this.f57875a.E();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921575, Integer.valueOf(this.f57875a.f57872i)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57871h = false;
        this.f57873j = new a(this, CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, true);
        this.k = new b(this, 2921574, true);
        this.f57868e = tbPageContext;
        setUniqueId(bdUniqueId);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_VIDEO_CHANNEL_FEED, TbConfig.SERVER_ADDRESS + "c/f/video/feed");
        tbHttpMessageTask.setResponsedClass(VideoChannelHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_JUMP_YY_LIVE_IN_VIDEO_LIST, TbConfig.SERVER_ADDRESS + TbConfig.URL_JUMP_YY_LIVE_IN_VIDEO_LIST);
        tbHttpMessageTask2.setResponsedClass(JumpYYLiveHttpResponseMessage.class);
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        registerListener(this.f57873j);
        registerListener(this.k);
    }

    public static /* synthetic */ int x(VideoChannelModel videoChannelModel) {
        int i2 = videoChannelModel.f57870g;
        videoChannelModel.f57870g = i2 + 1;
        return i2;
    }

    public final NetMessage D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            VideoChannelRequestNetMessage videoChannelRequestNetMessage = new VideoChannelRequestNetMessage();
            videoChannelRequestNetMessage.setLoadType(i2);
            return videoChannelRequestNetMessage;
        }
        return (NetMessage) invokeI.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57870g = 1;
            sendMessage(D(1));
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f57872i = i2;
        }
    }

    public void G(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f57869f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    public void loadMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            sendMessage(D(2));
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }
}
