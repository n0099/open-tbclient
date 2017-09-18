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
    public String giJ;
    public boolean giK;
    private int giL;
    private ArrayList<g> giM;
    private ArrayList<j> giN;
    private i giO;
    private int giP;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.giK = tPointPost.is_tuiguang.intValue() != 0;
                this.giL = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.giM = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.giM.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.giN = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.giN.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.giO = new i(tPointPost.detail_info);
                }
                this.giJ = tPointPost.monitor_id;
                this.giP = tPointPost.hidden_day.intValue();
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
                this.giK = jSONObject.optInt("is_tuiguang") != 0;
                this.giL = jSONObject.optInt("template_type");
                JSONArray optJSONArray = jSONObject.optJSONArray("act_btn");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.giM = new ArrayList<>();
                    for (int i = 0; i != optJSONArray.length(); i++) {
                        this.giM.add(new g(optJSONArray.getJSONObject(i)));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("t_imgs");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    this.giN = new ArrayList<>();
                    for (int i2 = 0; i2 != optJSONArray2.length(); i2++) {
                        this.giN.add(new j(optJSONArray2.getJSONObject(i2)));
                    }
                }
                this.giO = new i(jSONObject.getJSONObject("detail_info"));
                this.giJ = jSONObject.optString("monitor_id");
                this.giP = jSONObject.optInt("hidden_day");
                this.tagName = jSONObject.optString("tag_name");
                if (this.giL == 3 && (jSONObject2 = jSONObject.getJSONObject("t_video")) != null) {
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

    public j bsc() {
        return (j) v.c(this.giN, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bsd() {
        return this.giM;
    }

    public ArrayList<j> bse() {
        return this.giN;
    }

    public i bsf() {
        return this.giO;
    }

    public int bsg() {
        return this.giL;
    }

    public String bsh() {
        return this.giJ;
    }

    public String getTagName() {
        return this.tagName;
    }
}
