package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SelectCoverActivityConfig;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class h {
    private VideoInfo Up;
    public String ghO;
    public boolean ghP;
    private int ghQ;
    private ArrayList<g> ghR;
    private ArrayList<j> ghS;
    private i ghT;
    private int ghU;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.ghP = tPointPost.is_tuiguang.intValue() != 0;
                this.ghQ = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.ghR = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.ghR.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.ghS = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.ghS.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.ghT = new i(tPointPost.detail_info);
                }
                this.ghO = tPointPost.monitor_id;
                this.ghU = tPointPost.hidden_day.intValue();
                this.Up = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public h(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                this.position = jSONObject.optString("position");
                this.templateId = jSONObject.optLong("template_id");
                this.ghP = jSONObject.optInt("is_tuiguang") != 0;
                this.ghQ = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.ghR = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.ghR.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.ghS = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.ghS.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.ghT = new i(jSONObject.getJSONObject("detail_info"));
                this.ghO = jSONObject.optString("monitor_id");
                this.ghU = jSONObject.optInt("hidden_day");
                this.tagName = jSONObject.optString("tag_name");
                if (this.ghQ == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.video_md5 = jSONObject2.optString("video_md5");
                    builder.video_url = jSONObject2.optString("video_url");
                    builder.video_duration = Integer.valueOf(jSONObject2.optInt("video_duration"));
                    builder.video_width = Integer.valueOf(jSONObject2.optInt(SelectCoverActivityConfig.VIDEO_WIDTH));
                    builder.video_height = Integer.valueOf(jSONObject2.optInt(SelectCoverActivityConfig.VIDEO_HEIGHT));
                    builder.thumbnail_url = jSONObject2.optString("thumbnail_url");
                    builder.thumbnail_width = Integer.valueOf(jSONObject2.optInt("thumbnail_width"));
                    builder.thumbnail_height = Integer.valueOf(jSONObject2.optInt("thumbnail_height"));
                    builder.video_length = Integer.valueOf(jSONObject2.optInt("video_length"));
                    builder.play_count = Integer.valueOf(jSONObject2.optInt("play_count"));
                    this.Up = builder.build(false);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j brR() {
        return (j) v.c(this.ghS, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> brS() {
        return this.ghR;
    }

    public ArrayList<j> brT() {
        return this.ghS;
    }

    public i brU() {
        return this.ghT;
    }

    public int brV() {
        return this.ghQ;
    }

    public String brW() {
        return this.ghO;
    }

    public String getTagName() {
        return this.tagName;
    }
}
