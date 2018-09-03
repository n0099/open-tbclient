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
    public String gNC;
    public boolean gND;
    private int gNE;
    private ArrayList<g> gNF;
    private ArrayList<j> gNG;
    private i gNH;
    private int gNI;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gND = tPointPost.is_tuiguang.intValue() != 0;
                this.gNE = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gNF = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gNF.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gNG = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gNG.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gNH = new i(tPointPost.detail_info);
                }
                this.gNC = tPointPost.monitor_id;
                this.gNI = tPointPost.hidden_day.intValue();
                this.aei = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bvJ() {
        return (j) w.d(this.gNG, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bvK() {
        return this.gNF;
    }

    public ArrayList<j> bvL() {
        return this.gNG;
    }

    public i bvM() {
        return this.gNH;
    }

    public int bvN() {
        return this.gNE;
    }

    public String getTagName() {
        return this.tagName;
    }
}
