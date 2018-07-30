package com.baidu.tieba.videoplay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.video.VideoItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoPlayModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";
    private String dHW;
    private VideoPlayActivity hnG;
    private a hnH;
    private VideoItemData hnI;
    private HttpMessageListener hnJ;
    private String mFrom;
    private String mLocate;
    private int mPn;
    private String mStType;

    /* loaded from: classes2.dex */
    public interface a {
        void o(List<VideoItemData> list, boolean z);

        void p(List<VideoItemData> list, boolean z);
    }

    static /* synthetic */ int c(VideoPlayModel videoPlayModel) {
        int i = videoPlayModel.mPn;
        videoPlayModel.mPn = i + 1;
        return i;
    }

    public VideoPlayModel(VideoPlayActivity videoPlayActivity) {
        super(videoPlayActivity.getPageContext());
        this.dHW = "client_other";
        this.hnJ = new HttpMessageListener(CmdConfigHttp.CMD_GET_NANI_VIDEO) { // from class: com.baidu.tieba.videoplay.VideoPlayModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof ResponseGetNaniVideoMessage) {
                    ResponseGetNaniVideoMessage responseGetNaniVideoMessage = (ResponseGetNaniVideoMessage) httpResponsedMessage;
                    if (responseGetNaniVideoMessage.getError() == 0) {
                        TbSingleton.getInstance().clearVideoRecord();
                        if (VideoPlayModel.this.hnH != null) {
                            if (VideoPlayModel.this.mPn == 1) {
                                VideoPlayModel.this.hnH.o(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                            } else {
                                VideoPlayModel.this.hnH.p(responseGetNaniVideoMessage.getVideoItemDatas(), responseGetNaniVideoMessage.isHasMore());
                            }
                        }
                        VideoPlayModel.c(VideoPlayModel.this);
                    }
                }
            }
        };
        this.hnG = videoPlayActivity;
        registerListener(this.hnJ);
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
            this.hnI = videoItemData;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
            httpMessage.addParam("tid", videoItemData.thread_id);
            httpMessage.addParam("st_type", str);
            httpMessage.addParam("yuelaou_locate", str2);
            httpMessage.addParam("is_vertical", "1");
            httpMessage.addParam("pn", this.mPn);
            httpMessage.addParam("user_view_data", aBb());
            if ("frs".equals(this.mFrom)) {
                this.dHW = "client_frs";
            } else if ("index".equals(this.mFrom)) {
                this.dHW = "client_index";
            } else {
                this.dHW = "client_other";
            }
            httpMessage.addParam(IntentConfig.CALL_FROM, this.dHW);
            sendMessage(httpMessage);
        }
    }

    public void Tn() {
        if (this.hnI != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_NANI_VIDEO);
            httpMessage.addParam("tid", this.hnI.thread_id);
            httpMessage.addParam("st_type", this.mStType);
            httpMessage.addParam("yuelaou_locate", this.mLocate);
            httpMessage.addParam("is_vertical", "1");
            httpMessage.addParam("pn", this.mPn);
            httpMessage.addParam("user_view_data", aBb());
            sendMessage(httpMessage);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    private String aBb() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<com.baidu.tbadk.c.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<com.baidu.tbadk.c.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        com.baidu.tbadk.c.a next = it.next();
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
        this.hnH = aVar;
    }
}
