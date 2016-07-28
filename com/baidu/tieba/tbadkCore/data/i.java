package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    public String fkm;
    public boolean fkn;
    private int fko;
    private ArrayList<h> fkp;
    private ArrayList<k> fkq;
    private j fkr;
    private int fks;
    private VideoInfo fkt;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fkn = tPointPost.is_tuiguang.intValue() != 0;
                this.fko = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fkp = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fkp.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fkq = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fkq.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fkr = new j(tPointPost.detail_info);
                }
                this.fkm = tPointPost.monitor_id;
                this.fks = tPointPost.hidden_day.intValue();
                this.fkt = tPointPost.t_video;
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

    public ArrayList<h> bfa() {
        return this.fkp;
    }

    public ArrayList<k> bfb() {
        return this.fkq;
    }

    public j bfc() {
        return this.fkr;
    }

    public int bfd() {
        return this.fko;
    }

    public String bfe() {
        return this.fkm;
    }

    public int bff() {
        return this.fks;
    }

    public VideoInfo bfg() {
        return this.fkt;
    }
}
