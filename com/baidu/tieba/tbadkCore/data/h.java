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
    private VideoInfo Vm;
    private String Vn;
    public String gjn;
    public boolean gjo;
    private int gjp;
    private ArrayList<g> gjq;
    private ArrayList<j> gjr;
    private i gjs;
    private int gjt;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gjo = tPointPost.is_tuiguang.intValue() != 0;
                this.gjp = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gjq = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gjq.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gjr = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gjr.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gjs = new i(tPointPost.detail_info);
                }
                this.gjn = tPointPost.monitor_id;
                this.gjt = tPointPost.hidden_day.intValue();
                this.Vm = tPointPost.t_video;
                this.Vn = tPointPost.tag_name;
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
                this.gjo = jSONObject.optInt("is_tuiguang") != 0;
                this.gjp = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.gjq = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.gjq.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.gjr = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.gjr.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.gjs = new i(jSONObject.getJSONObject("detail_info"));
                this.gjn = jSONObject.optString("monitor_id");
                this.gjt = jSONObject.optInt("hidden_day");
                this.Vn = jSONObject.optString("tag_name");
                if (this.gjp == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
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
                    this.Vm = builder.build(false);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bsJ() {
        return (j) u.c(this.gjr, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bsK() {
        return this.gjq;
    }

    public ArrayList<j> bsL() {
        return this.gjr;
    }

    public i bsM() {
        return this.gjs;
    }

    public int bsN() {
        return this.gjp;
    }

    public String bsO() {
        return this.gjn;
    }

    public String getTagName() {
        return this.Vn;
    }
}
