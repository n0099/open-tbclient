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
    private VideoInfo aqw;
    public String hpk;
    public boolean hpl;
    private int hpm;
    private ArrayList<g> hpn;
    private ArrayList<j> hpo;
    private i hpp;
    private int hpq;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hpl = tPointPost.is_tuiguang.intValue() != 0;
                this.hpm = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hpn = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hpn.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hpo = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hpo.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.hpp = new i(tPointPost.detail_info);
                }
                this.hpk = tPointPost.monitor_id;
                this.hpq = tPointPost.hidden_day.intValue();
                this.aqw = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bEv() {
        return (j) v.d(this.hpo, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bEw() {
        return this.hpn;
    }

    public ArrayList<j> bEx() {
        return this.hpo;
    }

    public i bEy() {
        return this.hpp;
    }

    public int bEz() {
        return this.hpm;
    }

    public String getTagName() {
        return this.tagName;
    }
}
