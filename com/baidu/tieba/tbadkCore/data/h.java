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
    public String ggp;
    public boolean ggq;
    private int ggr;
    private ArrayList<g> ggs;
    private ArrayList<j> ggt;
    private i ggu;
    private int ggv;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.ggq = tPointPost.is_tuiguang.intValue() != 0;
                this.ggr = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.ggs = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.ggs.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.ggt = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.ggt.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.ggu = new i(tPointPost.detail_info);
                }
                this.ggp = tPointPost.monitor_id;
                this.ggv = tPointPost.hidden_day.intValue();
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
                this.ggq = jSONObject.optInt("is_tuiguang") != 0;
                this.ggr = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.ggs = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.ggs.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.ggt = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.ggt.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.ggu = new i(jSONObject.getJSONObject("detail_info"));
                this.ggp = jSONObject.optString("monitor_id");
                this.ggv = jSONObject.optInt("hidden_day");
                this.tagName = jSONObject.optString("tag_name");
                if (this.ggr == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
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

    public j bqZ() {
        return (j) v.c(this.ggt, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bra() {
        return this.ggs;
    }

    public ArrayList<j> brb() {
        return this.ggt;
    }

    public i brc() {
        return this.ggu;
    }

    public int brd() {
        return this.ggr;
    }

    public String bre() {
        return this.ggp;
    }

    public String getTagName() {
        return this.tagName;
    }
}
