package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.z;
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
    private VideoInfo Tv;
    private String Tw;
    public String fLM;
    public boolean fLN;
    private int fLO;
    private ArrayList<g> fLP;
    private ArrayList<j> fLQ;
    private i fLR;
    private int fLS;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fLN = tPointPost.is_tuiguang.intValue() != 0;
                this.fLO = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fLP = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fLP.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fLQ = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fLQ.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fLR = new i(tPointPost.detail_info);
                }
                this.fLM = tPointPost.monitor_id;
                this.fLS = tPointPost.hidden_day.intValue();
                this.Tv = tPointPost.t_video;
                this.Tw = tPointPost.tag_name;
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
                this.fLN = jSONObject.optInt("is_tuiguang") != 0;
                this.fLO = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.fLP = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.fLP.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.fLQ = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.fLQ.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.fLR = new i(jSONObject.getJSONObject("detail_info"));
                this.fLM = jSONObject.optString("monitor_id");
                this.fLS = jSONObject.optInt("hidden_day");
                this.Tw = jSONObject.optString("tag_name");
                if (this.fLO == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
                    VideoInfo.Builder builder = new VideoInfo.Builder();
                    builder.video_md5 = jSONObject2.optString("video_md5");
                    builder.video_url = jSONObject2.optString("video_url");
                    builder.video_duration = Integer.valueOf(jSONObject2.optInt("video_duration"));
                    builder.video_width = Integer.valueOf(jSONObject2.optInt("video_width"));
                    builder.video_height = Integer.valueOf(jSONObject2.optInt("video_height"));
                    builder.thumbnail_url = jSONObject2.optString("thumbnail_url");
                    builder.thumbnail_width = Integer.valueOf(jSONObject2.optInt("thumbnail_width"));
                    builder.thumbnail_height = Integer.valueOf(jSONObject2.optInt("thumbnail_height"));
                    builder.video_length = Integer.valueOf(jSONObject2.optInt("video_length"));
                    builder.play_count = Integer.valueOf(jSONObject2.optInt("play_count"));
                    this.Tv = builder.build(false);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j blX() {
        return (j) z.c(this.fLQ, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> blY() {
        return this.fLP;
    }

    public ArrayList<j> blZ() {
        return this.fLQ;
    }

    public i bma() {
        return this.fLR;
    }

    public int bmb() {
        return this.fLO;
    }

    public String bmc() {
        return this.fLM;
    }

    public String getTagName() {
        return this.Tw;
    }
}
