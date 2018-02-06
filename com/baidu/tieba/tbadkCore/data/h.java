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
    private VideoInfo aLi;
    private ArrayList<g> haA;
    private ArrayList<j> haB;
    private i haC;
    private int haD;
    public String hax;
    public boolean hay;
    private int haz;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hay = tPointPost.is_tuiguang.intValue() != 0;
                this.haz = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.haA = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.haA.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.haB = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.haB.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.haC = new i(tPointPost.detail_info);
                }
                this.hax = tPointPost.monitor_id;
                this.haD = tPointPost.hidden_day.intValue();
                this.aLi = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bwy() {
        return (j) v.f(this.haB, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bwz() {
        return this.haA;
    }

    public ArrayList<j> bwA() {
        return this.haB;
    }

    public i bwB() {
        return this.haC;
    }

    public int bwC() {
        return this.haz;
    }

    public String getTagName() {
        return this.tagName;
    }
}
