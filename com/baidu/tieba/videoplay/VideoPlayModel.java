package com.baidu.tieba.videoplay;

import c.a.e.a.f;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class VideoPlayModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f57738e;

    /* renamed from: f  reason: collision with root package name */
    public c f57739f;

    /* renamed from: g  reason: collision with root package name */
    public int f57740g;

    /* renamed from: h  reason: collision with root package name */
    public String f57741h;

    /* renamed from: i  reason: collision with root package name */
    public String f57742i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57743j;
    public VideoItemData k;
    public String l;
    public String m;
    public boolean n;
    public int o;
    public HttpMessageListener p;
    public final CustomMessageListener q;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayModel f57744a;

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
            this.f57744a = videoPlayModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetNaniVideoMessage)) {
                ResponseGetNaniVideoMessage responseGetNaniVideoMessage = (ResponseGetNaniVideoMessage) httpResponsedMessage;
                if (responseGetNaniVideoMessage.getError() == 0) {
                    TbSingleton.getInstance().clearVideoRecord();
                    if (this.f57744a.f57739f != null) {
                        if (this.f57744a.f57740g == 1) {
                            this.f57744a.f57739f.a(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                            this.f57744a.n = false;
                        } else {
                            this.f57744a.f57739f.b(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                        }
                    }
                    VideoPlayModel.y(this.f57744a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayModel f57745a;

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
            this.f57745a = videoPlayModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (!j.z()) {
                l.J(this.f57745a.f57738e.getPageActivity(), this.f57745a.f57738e.getResources().getString(R.string.neterror));
                return;
            }
            Object data = customResponsedMessage.getData();
            if ((data instanceof Integer) && ((Integer) data).intValue() == this.f57745a.o && !this.f57745a.n) {
                this.f57745a.n = true;
                VideoPlayModel videoPlayModel = this.f57745a;
                videoPlayModel.J(videoPlayModel.k, this.f57745a.f57741h, this.f57745a.f57742i, this.f57745a.f57743j);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921575, Integer.valueOf(this.f57745a.o)));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f57738e = tbPageContext;
        setUniqueId(bdUniqueId);
        registerListener(this.p);
        registerListener(this.q);
    }

    public static /* synthetic */ int y(VideoPlayModel videoPlayModel) {
        int i2 = videoPlayModel.f57740g;
        videoPlayModel.f57740g = i2 + 1;
        return i2;
    }

    public final String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            LinkedList<c.a.p0.h.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
            if (videoRecordList != null) {
                try {
                    if (videoRecordList.size() > 0) {
                        Iterator<c.a.p0.h.a> it = videoRecordList.iterator();
                        while (it.hasNext()) {
                            c.a.p0.h.a next = it.next();
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
        httpMessage.addParam("st_type", this.f57741h);
        httpMessage.addParam("yuelaou_locate", this.f57742i);
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, this.f57743j ? "1" : "0");
        httpMessage.addParam("pn", this.f57740g);
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
            this.f57740g = 1;
            if (videoItemData == null) {
                return;
            }
            this.f57741h = str;
            this.f57742i = str2;
            this.f57743j = z;
            this.k = videoItemData;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
            httpMessage.addParam("tid", videoItemData.thread_id);
            httpMessage.addParam("st_type", str);
            httpMessage.addParam("yuelaou_locate", str2);
            httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, z ? "1" : "0");
            httpMessage.addParam("pn", this.f57740g);
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
            this.f57739f = cVar;
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
