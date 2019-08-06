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
public class i {
    private VideoInfo bFw;
    public String jfK;
    public boolean jfL;
    private int jfM;
    private ArrayList<h> jfN;
    private ArrayList<k> jfO;
    private j jfP;
    private int jfQ;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.jfL = tPointPost.is_tuiguang.intValue() != 0;
                this.jfM = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.jfN = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.jfN.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.jfO = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.jfO.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.jfP = new j(tPointPost.detail_info);
                }
                this.jfK = tPointPost.monitor_id;
                this.jfQ = tPointPost.hidden_day.intValue();
                this.bFw = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cpo() {
        return (k) v.c(this.jfO, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cpp() {
        return this.jfN;
    }

    public ArrayList<k> cpq() {
        return this.jfO;
    }

    public j cpr() {
        return this.jfP;
    }

    public int cps() {
        return this.jfM;
    }

    public String getTagName() {
        return this.tagName;
    }
}
