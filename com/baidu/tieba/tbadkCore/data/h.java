package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class h {
    private VideoInfo aei;
    public String gNA;
    public boolean gNB;
    private int gNC;
    private ArrayList<g> gND;
    private ArrayList<j> gNE;
    private i gNF;
    private int gNG;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gNB = tPointPost.is_tuiguang.intValue() != 0;
                this.gNC = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gND = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gND.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gNE = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gNE.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gNF = new i(tPointPost.detail_info);
                }
                this.gNA = tPointPost.monitor_id;
                this.gNG = tPointPost.hidden_day.intValue();
                this.aei = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bvI() {
        return (j) w.d(this.gNE, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bvJ() {
        return this.gND;
    }

    public ArrayList<j> bvK() {
        return this.gNE;
    }

    public i bvL() {
        return this.gNF;
    }

    public int bvM() {
        return this.gNC;
    }

    public String getTagName() {
        return this.tagName;
    }
}
