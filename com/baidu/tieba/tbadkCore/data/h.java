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
    private VideoInfo aJP;
    public String gYh;
    public boolean gYi;
    private int gYj;
    private ArrayList<g> gYk;
    private ArrayList<j> gYl;
    private i gYm;
    private int gYn;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gYi = tPointPost.is_tuiguang.intValue() != 0;
                this.gYj = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gYk = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gYk.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gYl = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gYl.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gYm = new i(tPointPost.detail_info);
                }
                this.gYh = tPointPost.monitor_id;
                this.gYn = tPointPost.hidden_day.intValue();
                this.aJP = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bvm() {
        return (j) v.f(this.gYl, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bvn() {
        return this.gYk;
    }

    public ArrayList<j> bvo() {
        return this.gYl;
    }

    public i bvp() {
        return this.gYm;
    }

    public int bvq() {
        return this.gYj;
    }

    public String getTagName() {
        return this.tagName;
    }
}
