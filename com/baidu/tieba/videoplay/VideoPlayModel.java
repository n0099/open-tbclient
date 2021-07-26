package com.baidu.tieba.videoplay;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoPlayModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f21978e;

    /* renamed from: f  reason: collision with root package name */
    public c f21979f;

    /* renamed from: g  reason: collision with root package name */
    public int f21980g;

    /* renamed from: h  reason: collision with root package name */
    public String f21981h;

    /* renamed from: i  reason: collision with root package name */
    public String f21982i;
    public boolean j;
    public VideoItemData k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public HttpMessageListener p;
    public final CustomMessageListener q;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayModel f21983a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayModel videoPlayModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayModel, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f21983a = videoPlayModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetNaniVideoMessage)) {
                ResponseGetNaniVideoMessage responseGetNaniVideoMessage = (ResponseGetNaniVideoMessage) httpResponsedMessage;
                if (responseGetNaniVideoMessage.getError() == 0) {
                    TbSingleton.getInstance().clearVideoRecord();
                    if (this.f21983a.f21979f != null) {
                        if (this.f21983a.f21980g == 1) {
                            this.f21983a.f21979f.a(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                            this.f21983a.n = false;
                        } else {
                            this.f21983a.f21979f.b(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                        }
                    }
                    VideoPlayModel.y(this.f21983a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayModel f21984a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoPlayModel videoPlayModel, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayModel, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f21984a = videoPlayModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!j.z()) {
                l.J(this.f21984a.f21978e.getPageActivity(), this.f21984a.f21978e.getResources().getString(R.string.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == this.f21984a.o && !this.f21984a.n) {
                this.f21984a.n = true;
                VideoPlayModel videoPlayModel = this.f21984a;
                videoPlayModel.J(videoPlayModel.k, this.f21984a.f21981h, this.f21984a.f21982i, this.f21984a.j);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921575, Integer.valueOf(this.f21984a.o)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list, boolean z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = "client_other";
        this.n = false;
        this.p = new a(this, CmdConfigHttp.CMD_GET_NANI_VIDEO, true);
        this.q = new b(this, 2921574, true);
        this.f21978e = tbPageContext;
        setUniqueId(bdUniqueId);
        registerListener(this.p);
        registerListener(this.q);
    }

    public static /* synthetic */ int y(VideoPlayModel videoPlayModel) {
        int i2 = videoPlayModel.f21980g;
        videoPlayModel.f21980g = i2 + 1;
        return i2;
    }

    public final String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            LinkedList<d.a.p0.h.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
            if (videoRecordList != null) {
                try {
                    if (videoRecordList.size() > 0) {
                        Iterator<d.a.p0.h.a> it = videoRecordList.iterator();
                        while (it.hasNext()) {
                            d.a.p0.h.a next = it.next();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("tid", next.a());
                            jSONObject.put("duration", next.b());
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public void I(VideoItemData videoItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoItemData) == null) || this.k == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        httpMessage.addParam("tid", this.k.thread_id);
        httpMessage.addParam("st_type", this.f21981h);
        httpMessage.addParam("yuelaou_locate", this.f21982i);
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, this.j ? "1" : "0");
        httpMessage.addParam(Config.PACKAGE_NAME, this.f21980g);
        httpMessage.addParam("user_view_data", H());
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
        }
        sendMessage(httpMessage);
    }

    public void J(VideoItemData videoItemData, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{videoItemData, str, str2, Boolean.valueOf(z)}) == null) {
            this.f21980g = 1;
            if (videoItemData == null) {
                return;
            }
            this.f21981h = str;
            this.f21982i = str2;
            this.j = z;
            this.k = videoItemData;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
            httpMessage.addParam("tid", videoItemData.thread_id);
            httpMessage.addParam("st_type", str);
            httpMessage.addParam("yuelaou_locate", str2);
            httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, z ? "1" : "0");
            httpMessage.addParam(Config.PACKAGE_NAME, this.f21980g);
            httpMessage.addParam("user_view_data", H());
            if ("frs".equals(this.l)) {
                this.m = "client_frs";
            } else if ("index".equals(this.l)) {
                this.m = "client_index";
            } else {
                this.m = "client_other";
            }
            httpMessage.addParam(IntentConfig.CALL_FROM, this.m);
            BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
            if (baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
                httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
            }
            sendMessage(httpMessage);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.o = i2;
        }
    }

    public void L(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f21979f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
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
            this.l = str;
        }
    }
}
