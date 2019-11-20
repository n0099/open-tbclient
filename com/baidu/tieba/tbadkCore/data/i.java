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
    private VideoInfo bWV;
    public String jhc;
    public boolean jhd;
    private int jhe;
    private ArrayList<h> jhf;
    private ArrayList<k> jhg;
    private j jhh;
    private int jhi;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.jhd = tPointPost.is_tuiguang.intValue() != 0;
                this.jhe = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.jhf = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.jhf.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.jhg = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.jhg.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.jhh = new j(tPointPost.detail_info);
                }
                this.jhc = tPointPost.monitor_id;
                this.jhi = tPointPost.hidden_day.intValue();
                this.bWV = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cnQ() {
        return (k) v.getItem(this.jhg, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cnR() {
        return this.jhf;
    }

    public ArrayList<k> cnS() {
        return this.jhg;
    }

    public j cnT() {
        return this.jhh;
    }

    public int cnU() {
        return this.jhe;
    }

    public String getTagName() {
        return this.tagName;
    }
}
