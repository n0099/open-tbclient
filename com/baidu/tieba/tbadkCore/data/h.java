package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class h {
    private VideoInfo aJO;
    public String hin;
    public boolean hio;
    private int hip;
    private ArrayList<g> hiq;
    private ArrayList<j> hir;
    private i his;
    private int hit;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hio = tPointPost.is_tuiguang.intValue() != 0;
                this.hip = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hiq = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hiq.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hir = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hir.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.his = new i(tPointPost.detail_info);
                }
                this.hin = tPointPost.monitor_id;
                this.hit = tPointPost.hidden_day.intValue();
                this.aJO = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bBO() {
        return (j) v.f(this.hir, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bBP() {
        return this.hiq;
    }

    public ArrayList<j> bBQ() {
        return this.hir;
    }

    public i bBR() {
        return this.his;
    }

    public int bBS() {
        return this.hip;
    }

    public String getTagName() {
        return this.tagName;
    }
}
