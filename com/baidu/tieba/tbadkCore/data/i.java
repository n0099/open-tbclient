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
    public String iYg;
    public boolean iYh;
    private int iYi;
    private ArrayList<h> iYj;
    private ArrayList<k> iYk;
    private j iYl;
    private int iYm;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iYh = tPointPost.is_tuiguang.intValue() != 0;
                this.iYi = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iYj = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iYj.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iYk = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iYk.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iYl = new j(tPointPost.detail_info);
                }
                this.iYg = tPointPost.monitor_id;
                this.iYm = tPointPost.hidden_day.intValue();
                this.bEu = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k clX() {
        return (k) v.c(this.iYk, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> clY() {
        return this.iYj;
    }

    public ArrayList<k> clZ() {
        return this.iYk;
    }

    public j cma() {
        return this.iYl;
    }

    public int cmb() {
        return this.iYi;
    }

    public String getTagName() {
        return this.tagName;
    }
}
