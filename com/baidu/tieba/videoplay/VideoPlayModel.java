package com.baidu.tieba.videoplay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.video.VideoItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VideoPlayModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";

    /* renamed from: e  reason: collision with root package name */
    public b f21662e;

    /* renamed from: f  reason: collision with root package name */
    public int f21663f;

    /* renamed from: g  reason: collision with root package name */
    public String f21664g;

    /* renamed from: h  reason: collision with root package name */
    public String f21665h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21666i;
    public VideoItemData j;
    public String k;
    public String l;
    public HttpMessageListener m;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ResponseGetNaniVideoMessage) {
                ResponseGetNaniVideoMessage responseGetNaniVideoMessage = (ResponseGetNaniVideoMessage) httpResponsedMessage;
                if (responseGetNaniVideoMessage.getError() == 0) {
                    TbSingleton.getInstance().clearVideoRecord();
                    if (VideoPlayModel.this.f21662e != null) {
                        if (VideoPlayModel.this.f21663f == 1) {
                            VideoPlayModel.this.f21662e.a(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                        } else {
                            VideoPlayModel.this.f21662e.b(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                        }
                    }
                    VideoPlayModel.y(VideoPlayModel.this);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list, boolean z);
    }

    public VideoPlayModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.l = "client_other";
        a aVar = new a(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        this.m = aVar;
        registerListener(aVar);
    }

    public static /* synthetic */ int y(VideoPlayModel videoPlayModel) {
        int i2 = videoPlayModel.f21663f;
        videoPlayModel.f21663f = i2 + 1;
        return i2;
    }

    public void A(VideoItemData videoItemData) {
        if (this.j == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        httpMessage.addParam("tid", this.j.thread_id);
        httpMessage.addParam("st_type", this.f21664g);
        httpMessage.addParam("yuelaou_locate", this.f21665h);
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, this.f21666i ? "1" : "0");
        httpMessage.addParam(Config.PACKAGE_NAME, this.f21663f);
        httpMessage.addParam("user_view_data", z());
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
        }
        sendMessage(httpMessage);
    }

    public void B(VideoItemData videoItemData, String str, String str2, boolean z) {
        this.f21663f = 1;
        if (videoItemData == null) {
            return;
        }
        this.f21664g = str;
        this.f21665h = str2;
        this.f21666i = z;
        this.j = videoItemData;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        httpMessage.addParam("tid", videoItemData.thread_id);
        httpMessage.addParam("st_type", str);
        httpMessage.addParam("yuelaou_locate", str2);
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, z ? "1" : "0");
        httpMessage.addParam(Config.PACKAGE_NAME, this.f21663f);
        httpMessage.addParam("user_view_data", z());
        if ("frs".equals(this.k)) {
            this.l = "client_frs";
        } else if ("index".equals(this.k)) {
            this.l = "client_index";
        } else {
            this.l = "client_other";
        }
        httpMessage.addParam(IntentConfig.CALL_FROM, this.l);
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
        }
        sendMessage(httpMessage);
    }

    public void C(b bVar) {
        this.f21662e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void setFrom(String str) {
        this.k = str;
    }

    public final String z() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<d.a.n0.g.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<d.a.n0.g.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        d.a.n0.g.a next = it.next();
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
}
