package com.baidu.tieba.videoplay;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lq4;
import com.baidu.tieba.uq5;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class VideoPlayModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public c b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public VideoItemData g;
    public String h;
    public String i;
    public boolean j;
    public LiveConfig k;
    public int l;
    public HttpMessageListener m;
    public final CustomMessageListener n;

    /* loaded from: classes8.dex */
    public interface c {
        void a(List<VideoItemData> list, boolean z, LiveConfig liveConfig);

        void b(List<VideoItemData> list, boolean z, LiveConfig liveConfig);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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

    /* loaded from: classes8.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayModel videoPlayModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = videoPlayModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof ResponseGetNaniVideoMessage)) {
                return;
            }
            ResponseGetNaniVideoMessage responseGetNaniVideoMessage = (ResponseGetNaniVideoMessage) httpResponsedMessage;
            if (responseGetNaniVideoMessage.getLiveConfig() != null) {
                this.a.k = responseGetNaniVideoMessage.getLiveConfig();
            }
            new ArrayList();
            if (responseGetNaniVideoMessage.getError() == 0) {
                List<VideoItemData> videoItemDatas = responseGetNaniVideoMessage.getVideoItemDatas();
                int i = 0;
                while (i < videoItemDatas.size()) {
                    videoItemDatas.get(i).setChannelMidRequestNum(this.a.c);
                    i++;
                    videoItemDatas.get(i).setChannelMidRequestVideoNum(i);
                }
                TbSingleton.getInstance().clearVideoRecord();
                if (this.a.b != null) {
                    if (this.a.c == 1) {
                        this.a.b.b(videoItemDatas, responseGetNaniVideoMessage.isHasMore(), this.a.k);
                        this.a.j = false;
                    } else {
                        this.a.b.a(videoItemDatas, responseGetNaniVideoMessage.isHasMore(), this.a.k);
                    }
                }
                VideoPlayModel.Q(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoPlayModel videoPlayModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = videoPlayModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showLongToast(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e4f));
                return;
            }
            Object data = customResponsedMessage.getData();
            if (!(data instanceof Integer) || ((Integer) data).intValue() != this.a.l || this.a.j) {
                return;
            }
            this.a.j = true;
            VideoPlayModel videoPlayModel = this.a;
            videoPlayModel.c0(videoPlayModel.g, this.a.d, this.a.e, this.a.f);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921575, Integer.valueOf(this.a.l)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = "client_other";
        this.j = false;
        this.m = new a(this, CmdConfigHttp.CMD_GET_NANI_VIDEO, true);
        this.n = new b(this, 2921574, true);
        this.a = tbPageContext;
        setUniqueId(bdUniqueId);
        registerListener(this.m);
        registerListener(this.n);
    }

    public static /* synthetic */ int Q(VideoPlayModel videoPlayModel) {
        int i = videoPlayModel.c;
        videoPlayModel.c = i + 1;
        return i;
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.l = i;
        }
    }

    public void e0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.h = str;
        }
    }

    public final String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            LinkedList<lq4> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
            if (videoRecordList != null) {
                try {
                    if (videoRecordList.size() > 0) {
                        Iterator<lq4> it = videoRecordList.iterator();
                        while (it.hasNext()) {
                            lq4 next = it.next();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tid", next.a());
                            jSONObject.put("duration", next.b());
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public void b0(VideoItemData videoItemData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoItemData) != null) || this.g == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        httpMessage.addParam("tid", this.g.thread_id);
        httpMessage.addParam("st_type", this.d);
        httpMessage.addParam("yuelaou_locate", this.e);
        if (this.f) {
            str = "1";
        } else {
            str = "0";
        }
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, str);
        httpMessage.addParam("pn", this.c);
        httpMessage.addParam("user_view_data", a0());
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
        }
        httpMessage.addParam("app_transmit_data", uq5.a());
        sendMessage(httpMessage);
    }

    public void c0(VideoItemData videoItemData, String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{videoItemData, str, str2, Boolean.valueOf(z)}) == null) {
            this.c = 1;
            if (videoItemData == null) {
                return;
            }
            this.d = str;
            this.e = str2;
            this.f = z;
            this.g = videoItemData;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
            httpMessage.addParam("tid", videoItemData.thread_id);
            httpMessage.addParam("st_type", str);
            httpMessage.addParam("yuelaou_locate", str2);
            if (z) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, str3);
            httpMessage.addParam("pn", this.c);
            httpMessage.addParam("user_view_data", a0());
            if ("frs".equals(this.h)) {
                this.i = "client_frs";
            } else if ("index".equals(this.h)) {
                this.i = "client_index";
            } else {
                this.i = "client_other";
            }
            httpMessage.addParam(IntentConfig.CALL_FROM, this.i);
            BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
            if (baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
                httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
            }
            httpMessage.addParam("app_transmit_data", uq5.a());
            sendMessage(httpMessage);
        }
    }
}
