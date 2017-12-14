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
    private VideoInfo Vo;
    private i gBA;
    private int gBB;
    public String gBv;
    public boolean gBw;
    private int gBx;
    private ArrayList<g> gBy;
    private ArrayList<j> gBz;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gBw = tPointPost.is_tuiguang.intValue() != 0;
                this.gBx = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gBy = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gBy.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gBz = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gBz.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gBA = new i(tPointPost.detail_info);
                }
                this.gBv = tPointPost.monitor_id;
                this.gBB = tPointPost.hidden_day.intValue();
                this.Vo = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bwz() {
        return (j) v.c(this.gBz, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bwA() {
        return this.gBy;
    }

    public ArrayList<j> bwB() {
        return this.gBz;
    }

    public i bwC() {
        return this.gBA;
    }

    public int bwD() {
        return this.gBx;
    }

    public String getTagName() {
        return this.tagName;
    }
}
