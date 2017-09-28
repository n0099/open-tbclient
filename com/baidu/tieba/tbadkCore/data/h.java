package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
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
    private VideoInfo UE;
    public String ggq;
    public boolean ggr;
    private int ggs;
    private ArrayList<g> ggt;
    private ArrayList<j> ggu;
    private i ggv;
    private int ggw;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.ggr = tPointPost.is_tuiguang.intValue() != 0;
                this.ggs = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.ggt = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.ggt.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.ggu = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.ggu.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.ggv = new i(tPointPost.detail_info);
                }
                this.ggq = tPointPost.monitor_id;
                this.ggw = tPointPost.hidden_day.intValue();
                this.UE = tPointPost.t_video;
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
                this.ggr = jSONObject.optInt("is_tuiguang") != 0;
                this.ggs = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.ggt = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.ggt.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.ggu = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.ggu.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.ggv = new i(jSONObject.getJSONObject("detail_info"));
                this.ggq = jSONObject.optString("monitor_id");
                this.ggw = jSONObject.optInt("hidden_day");
                this.tagName = jSONObject.optString("tag_name");
                if (this.ggs == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
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
                    this.UE = builder.build(false);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bra() {
        return (j) v.c(this.ggu, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> brb() {
        return this.ggt;
    }

    public ArrayList<j> brc() {
        return this.ggu;
    }

    public i brd() {
        return this.ggv;
    }

    public int bre() {
        return this.ggs;
    }

    public String brf() {
        return this.ggq;
    }

    public String getTagName() {
        return this.tagName;
    }
}
