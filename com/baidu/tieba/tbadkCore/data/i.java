package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class i {
    public String epm;
    public boolean epn;
    private int epo;
    private ArrayList<h> epp;
    private ArrayList<k> epq;
    private j epr;
    private int eps;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.epn = tPointPost.is_tuiguang.intValue() != 0;
                this.epo = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.epp = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.epp.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.epq = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.epq.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.epr = new j(tPointPost.detail_info);
                }
                this.epm = tPointPost.monitor_id;
                this.eps = tPointPost.hidden_day.intValue();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> aSR() {
        return this.epp;
    }

    public ArrayList<k> aSS() {
        return this.epq;
    }

    public j aST() {
        return this.epr;
    }

    public int aSU() {
        return this.epo;
    }

    public String aSV() {
        return this.epm;
    }

    public int aSW() {
        return this.eps;
    }
}
