package com.baidu.tieba.videoplay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tieba.video.VideoItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class VideoPlayModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    private String jld;
    private String mFrom;
    private String mLocate;
    private int mPn;
    private String mStType;
    private VideoPlayActivity nxG;
    private a nxH;
    private VideoItemData nxI;
    private HttpMessageListener nxJ;

    /* loaded from: classes24.dex */
    public interface a {
        void v(List<VideoItemData> list, boolean z);

        void w(List<VideoItemData> list, boolean z);
    }

    static /* synthetic */ int c(VideoPlayModel videoPlayModel) {
        int i = videoPlayModel.mPn;
        videoPlayModel.mPn = i + 1;
        return i;
    }

    public VideoPlayModel(VideoPlayActivity videoPlayActivity) {
        super(videoPlayActivity.getPageContext());
        this.jld = "client_other";
        this.nxJ = new HttpMessageListener(1003399) { // from class: com.baidu.tieba.videoplay.VideoPlayModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetNaniVideoMessage) {
                    ResponseGetNaniVideoMessage responseGetNaniVideoMessage = (ResponseGetNaniVideoMessage) httpResponsedMessage;
                    if (responseGetNaniVideoMessage.getError() == 0) {
                        TbSingleton.getInstance().clearVideoRecord();
                        if (VideoPlayModel.this.nxH != null) {
                            if (VideoPlayModel.this.mPn == 1) {
                                VideoPlayModel.this.nxH.v(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                            } else {
                                VideoPlayModel.this.nxH.w(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                            }
                        }
                        VideoPlayModel.c(VideoPlayModel.this);
                    }
                }
            }
        };
        this.nxG = videoPlayActivity;
        registerListener(this.nxJ);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(VideoItemData videoItemData, String str, String str2) {
        this.mPn = 1;
        if (videoItemData != null) {
            this.mStType = str;
            this.mLocate = str2;
            this.nxI = videoItemData;
            HttpMessage httpMessage = new HttpMessage(1003399);
            httpMessage.addParam("tid", videoItemData.thread_id);
            httpMessage.addParam("st_type", str);
            httpMessage.addParam("yuelaou_locate", str2);
            httpMessage.addParam("is_vertical", "1");
            httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
            httpMessage.addParam("user_view_data", cGQ());
            if ("frs".equals(this.mFrom)) {
                this.jld = "client_frs";
            } else if ("index".equals(this.mFrom)) {
                this.jld = "client_index";
            } else {
                this.jld = "client_other";
            }
            httpMessage.addParam("call_from", this.jld);
            if (videoItemData.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_nid", videoItemData.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_type", videoItemData.baijiahaoData.oriUgcType);
                httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
            }
            sendMessage(httpMessage);
        }
    }

    public void b(VideoItemData videoItemData) {
        if (this.nxI != null) {
            HttpMessage httpMessage = new HttpMessage(1003399);
            httpMessage.addParam("tid", this.nxI.thread_id);
            httpMessage.addParam("st_type", this.mStType);
            httpMessage.addParam("yuelaou_locate", this.mLocate);
            httpMessage.addParam("is_vertical", "1");
            httpMessage.addParam(Config.PACKAGE_NAME, this.mPn);
            httpMessage.addParam("user_view_data", cGQ());
            if (videoItemData.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_nid", videoItemData.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_type", videoItemData.baijiahaoData.oriUgcType);
                httpMessage.addParam("ori_ugc_vid", videoItemData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_tid", videoItemData.baijiahaoData.oriUgcTid);
            }
            sendMessage(httpMessage);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    private String cGQ() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<com.baidu.tbadk.d.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<com.baidu.tbadk.d.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.d.a next = it.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tid", next.getKey());
                        jSONObject.put("duration", next.getValue());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        return jSONArray.toString();
    }

    public void a(a aVar) {
        this.nxH = aVar;
    }
}
