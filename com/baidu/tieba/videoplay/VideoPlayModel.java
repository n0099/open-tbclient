package com.baidu.tieba.videoplay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
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
    public VideoPlayActivity f22323e;

    /* renamed from: f  reason: collision with root package name */
    public b f22324f;

    /* renamed from: g  reason: collision with root package name */
    public int f22325g;

    /* renamed from: h  reason: collision with root package name */
    public String f22326h;

    /* renamed from: i  reason: collision with root package name */
    public String f22327i;
    public boolean j;
    public VideoItemData k;
    public String l;
    public String m;
    public HttpMessageListener n;

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
                    if (VideoPlayModel.this.f22324f != null) {
                        if (VideoPlayModel.this.f22325g == 1) {
                            VideoPlayModel.this.f22324f.b(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                        } else {
                            VideoPlayModel.this.f22324f.a(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                        }
                    }
                    VideoPlayModel.u(VideoPlayModel.this);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(List<VideoItemData> list, boolean z);

        void b(List<VideoItemData> list, boolean z);
    }

    public VideoPlayModel(VideoPlayActivity videoPlayActivity) {
        super(videoPlayActivity.getPageContext());
        this.m = "client_other";
        a aVar = new a(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        this.n = aVar;
        this.f22323e = videoPlayActivity;
        registerListener(aVar);
    }

    public static /* synthetic */ int u(VideoPlayModel videoPlayModel) {
        int i2 = videoPlayModel.f22325g;
        videoPlayModel.f22325g = i2 + 1;
        return i2;
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
        this.l = str;
    }

    public final String v() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<d.a.i0.g.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<d.a.i0.g.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        d.a.i0.g.a next = it.next();
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

    public void w(VideoItemData videoItemData) {
        if (this.k == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        httpMessage.addParam("tid", this.k.thread_id);
        httpMessage.addParam("st_type", this.f22326h);
        httpMessage.addParam("yuelaou_locate", this.f22327i);
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, this.j ? "1" : "0");
        httpMessage.addParam(Config.PACKAGE_NAME, this.f22325g);
        httpMessage.addParam("user_view_data", v());
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, videoItemData.baijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
        }
        sendMessage(httpMessage);
    }

    public void x(VideoItemData videoItemData, String str, String str2, boolean z) {
        this.f22325g = 1;
        if (videoItemData == null) {
            return;
        }
        this.f22326h = str;
        this.f22327i = str2;
        this.j = z;
        this.k = videoItemData;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
        httpMessage.addParam("tid", videoItemData.thread_id);
        httpMessage.addParam("st_type", str);
        httpMessage.addParam("yuelaou_locate", str2);
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, z ? "1" : "0");
        httpMessage.addParam(Config.PACKAGE_NAME, this.f22325g);
        httpMessage.addParam("user_view_data", v());
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

    public void y(b bVar) {
        this.f22324f = bVar;
    }
}
