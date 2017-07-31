package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.u;
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
    private VideoInfo Vk;
    private String Vl;
    private int ghA;
    public String ghu;
    public boolean ghv;
    private int ghw;
    private ArrayList<g> ghx;
    private ArrayList<j> ghy;
    private i ghz;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.ghv = tPointPost.is_tuiguang.intValue() != 0;
                this.ghw = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.ghx = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.ghx.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.ghy = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.ghy.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.ghz = new i(tPointPost.detail_info);
                }
                this.ghu = tPointPost.monitor_id;
                this.ghA = tPointPost.hidden_day.intValue();
                this.Vk = tPointPost.t_video;
                this.Vl = tPointPost.tag_name;
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
                this.ghv = jSONObject.optInt("is_tuiguang") != 0;
                this.ghw = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.ghx = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.ghx.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.ghy = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.ghy.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.ghz = new i(jSONObject.getJSONObject("detail_info"));
                this.ghu = jSONObject.optString("monitor_id");
                this.ghA = jSONObject.optInt("hidden_day");
                this.Vl = jSONObject.optString("tag_name");
                if (this.ghw == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
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
                    this.Vk = builder.build(false);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bsb() {
        return (j) u.c(this.ghy, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bsc() {
        return this.ghx;
    }

    public ArrayList<j> bsd() {
        return this.ghy;
    }

    public i bse() {
        return this.ghz;
    }

    public int bsf() {
        return this.ghw;
    }

    public String bsg() {
        return this.ghu;
    }

    public String getTagName() {
        return this.Vl;
    }
}
