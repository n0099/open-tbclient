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
    private VideoInfo aKY;
    public String haF;
    public boolean haG;
    private int haH;
    private ArrayList<g> haI;
    private ArrayList<j> haJ;
    private i haK;
    private int haL;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.haG = tPointPost.is_tuiguang.intValue() != 0;
                this.haH = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.haI = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.haI.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.haJ = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.haJ.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.haK = new i(tPointPost.detail_info);
                }
                this.haF = tPointPost.monitor_id;
                this.haL = tPointPost.hidden_day.intValue();
                this.aKY = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bwC() {
        return (j) v.f(this.haJ, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bwD() {
        return this.haI;
    }

    public ArrayList<j> bwE() {
        return this.haJ;
    }

    public i bwF() {
        return this.haK;
    }

    public int bwG() {
        return this.haH;
    }

    public String getTagName() {
        return this.tagName;
    }
}
