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
    private VideoInfo agJ;
    public String gVg;
    public boolean gVh;
    private int gVi;
    private ArrayList<g> gVj;
    private ArrayList<j> gVk;
    private i gVl;
    private int gVm;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gVh = tPointPost.is_tuiguang.intValue() != 0;
                this.gVi = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gVj = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gVj.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gVk = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gVk.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gVl = new i(tPointPost.detail_info);
                }
                this.gVg = tPointPost.monitor_id;
                this.gVm = tPointPost.hidden_day.intValue();
                this.agJ = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j byp() {
        return (j) v.d(this.gVk, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> byq() {
        return this.gVj;
    }

    public ArrayList<j> byr() {
        return this.gVk;
    }

    public i bys() {
        return this.gVl;
    }

    public int byt() {
        return this.gVi;
    }

    public String getTagName() {
        return this.tagName;
    }
}
