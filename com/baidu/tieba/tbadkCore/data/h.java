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
    private VideoInfo Wo;
    public String gxd;
    public boolean gxe;
    private int gxf;
    private ArrayList<g> gxg;
    private ArrayList<j> gxh;
    private i gxi;
    private int gxj;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gxe = tPointPost.is_tuiguang.intValue() != 0;
                this.gxf = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gxg = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gxg.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gxh = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gxh.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gxi = new i(tPointPost.detail_info);
                }
                this.gxd = tPointPost.monitor_id;
                this.gxj = tPointPost.hidden_day.intValue();
                this.Wo = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j brC() {
        return (j) v.c(this.gxh, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> brD() {
        return this.gxg;
    }

    public ArrayList<j> brE() {
        return this.gxh;
    }

    public i brF() {
        return this.gxi;
    }

    public int brG() {
        return this.gxf;
    }

    public String getTagName() {
        return this.tagName;
    }
}
