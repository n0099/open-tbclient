package com.baidu.tieba.videoplay.model;

import b.a.e.a.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoAttentionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f55117e;

    /* renamed from: f  reason: collision with root package name */
    public long f55118f;

    /* renamed from: g  reason: collision with root package name */
    public String f55119g;

    /* renamed from: h  reason: collision with root package name */
    public int f55120h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55121i;
    public int j;
    public HttpMessageListener k;
    public final CustomMessageListener l;
    public int mHasMore;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionModel f55122a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionModel videoAttentionModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionModel, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f55122a = videoAttentionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.f55122a.f55120h == 1) {
                    this.f55122a.f55121i = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921576, Integer.valueOf(this.f55122a.j)));
                }
                if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0) {
                    return;
                }
                List<VideoItemData> arrayList = new ArrayList<>();
                List<VideoAttentionPersonListData> arrayList2 = new ArrayList<>();
                if (httpResponsedMessage instanceof VideoAttentionHttpResponseMessage) {
                    VideoAttentionHttpResponseMessage videoAttentionHttpResponseMessage = (VideoAttentionHttpResponseMessage) httpResponsedMessage;
                    arrayList = videoAttentionHttpResponseMessage.getVideoItemDatas();
                    arrayList2 = videoAttentionHttpResponseMessage.getVideoAttentionPersonListData();
                    this.f55122a.f55118f = videoAttentionHttpResponseMessage.getFeedId();
                    this.f55122a.f55119g = videoAttentionHttpResponseMessage.getShowWord();
                    this.f55122a.mHasMore = videoAttentionHttpResponseMessage.getHasMore();
                }
                TbSingleton.getInstance().clearVideoRecord();
                if (this.f55122a.f55117e != null) {
                    if (ListUtils.isEmpty(arrayList)) {
                        this.f55122a.f55117e.c(arrayList2, this.f55122a.f55119g, this.f55122a.f55121i);
                        return;
                    } else if (this.f55122a.f55120h == 1) {
                        if (arrayList != null) {
                            this.f55122a.f55117e.a(arrayList, this.f55122a.f55121i);
                        }
                    } else if (arrayList != null) {
                        this.f55122a.f55117e.b(arrayList);
                    }
                }
                VideoAttentionModel.x(this.f55122a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionModel f55123a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoAttentionModel videoAttentionModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionModel, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f55123a = videoAttentionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == this.f55123a.j && TbadkCoreApplication.isLogin() && !this.f55123a.f55121i) {
                this.f55123a.f55121i = true;
                this.f55123a.G();
                TbSingleton.getInstance().setVideoChannelAttentionRedIcon(null);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921575, Integer.valueOf(this.f55123a.j)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list);

        void c(List<VideoAttentionPersonListData> list, String str, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAttentionModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f55121i = false;
        this.k = new a(this, CmdConfigHttp.CMD_HTTP_VIDEO_ATTENTION_FEED, true);
        this.l = new b(this, 2921574, true);
        setUniqueId(bdUniqueId);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_VIDEO_ATTENTION_FEED, TbConfig.SERVER_ADDRESS + "c/f/video/concernTab");
        tbHttpMessageTask.setResponsedClass(VideoAttentionHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.k);
        registerListener(this.l);
    }

    public static /* synthetic */ int x(VideoAttentionModel videoAttentionModel) {
        int i2 = videoAttentionModel.f55120h;
        videoAttentionModel.f55120h = i2 + 1;
        return i2;
    }

    public final HttpMessage F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_VIDEO_ATTENTION_FEED);
            httpMessage.addParam("load_type", i2);
            httpMessage.addParam(Constants.EXTRA_CONFIG_LIMIT, 10);
            if (i2 == 0) {
                this.f55118f = 0L;
            }
            httpMessage.addParam("feed_id", this.f55118f);
            return httpMessage;
        }
        return (HttpMessage) invokeI.objValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f55120h = 1;
            sendMessage(F(0));
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.j = i2;
        }
    }

    public void I(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f55117e = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.mHasMore == 1) {
            sendMessage(F(1));
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }
}
