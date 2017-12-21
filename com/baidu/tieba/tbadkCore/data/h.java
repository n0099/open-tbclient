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
    private VideoInfo Vr;
    public String gBA;
    public boolean gBB;
    private int gBC;
    private ArrayList<g> gBD;
    private ArrayList<j> gBE;
    private i gBF;
    private int gBG;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gBB = tPointPost.is_tuiguang.intValue() != 0;
                this.gBC = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gBD = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gBD.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gBE = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gBE.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gBF = new i(tPointPost.detail_info);
                }
                this.gBA = tPointPost.monitor_id;
                this.gBG = tPointPost.hidden_day.intValue();
                this.Vr = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bwz() {
        return (j) v.c(this.gBE, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bwA() {
        return this.gBD;
    }

    public ArrayList<j> bwB() {
        return this.gBE;
    }

    public i bwC() {
        return this.gBF;
    }

    public int bwD() {
        return this.gBC;
    }

    public String getTagName() {
        return this.tagName;
    }
}
