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
    private VideoInfo bEu;
    public String iYi;
    public boolean iYj;
    private int iYk;
    private ArrayList<h> iYl;
    private ArrayList<k> iYm;
    private j iYn;
    private int iYo;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iYj = tPointPost.is_tuiguang.intValue() != 0;
                this.iYk = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iYl = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iYl.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iYm = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iYm.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iYn = new j(tPointPost.detail_info);
                }
                this.iYi = tPointPost.monitor_id;
                this.iYo = tPointPost.hidden_day.intValue();
                this.bEu = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k clZ() {
        return (k) v.c(this.iYm, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cma() {
        return this.iYl;
    }

    public ArrayList<k> cmb() {
        return this.iYm;
    }

    public j cmc() {
        return this.iYn;
    }

    public int cmd() {
        return this.iYk;
    }

    public String getTagName() {
        return this.tagName;
    }
}
