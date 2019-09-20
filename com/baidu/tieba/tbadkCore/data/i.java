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
    private VideoInfo bFU;
    public String jig;
    public boolean jih;
    private int jii;
    private ArrayList<h> jij;
    private ArrayList<k> jik;
    private j jil;
    private int jim;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.jih = tPointPost.is_tuiguang.intValue() != 0;
                this.jii = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.jij = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.jij.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.jik = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.jik.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.jil = new j(tPointPost.detail_info);
                }
                this.jig = tPointPost.monitor_id;
                this.jim = tPointPost.hidden_day.intValue();
                this.bFU = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cqc() {
        return (k) v.c(this.jik, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cqd() {
        return this.jij;
    }

    public ArrayList<k> cqe() {
        return this.jik;
    }

    public j cqf() {
        return this.jil;
    }

    public int cqg() {
        return this.jii;
    }

    public String getTagName() {
        return this.tagName;
    }
}
