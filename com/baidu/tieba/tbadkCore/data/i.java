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
    private VideoInfo bEv;
    public String iYm;
    public boolean iYn;
    private int iYo;
    private ArrayList<h> iYp;
    private ArrayList<k> iYq;
    private j iYr;
    private int iYs;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iYn = tPointPost.is_tuiguang.intValue() != 0;
                this.iYo = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iYp = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iYp.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iYq = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iYq.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iYr = new j(tPointPost.detail_info);
                }
                this.iYm = tPointPost.monitor_id;
                this.iYs = tPointPost.hidden_day.intValue();
                this.bEv = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cma() {
        return (k) v.c(this.iYq, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cmb() {
        return this.iYp;
    }

    public ArrayList<k> cmc() {
        return this.iYq;
    }

    public j cmd() {
        return this.iYr;
    }

    public int cme() {
        return this.iYo;
    }

    public String getTagName() {
        return this.tagName;
    }
}
