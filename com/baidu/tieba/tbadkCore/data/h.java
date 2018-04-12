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
    private VideoInfo Ws;
    public String gwc;
    public boolean gwd;
    private int gwe;
    private ArrayList<g> gwf;
    private ArrayList<j> gwg;
    private i gwh;
    private int gwi;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gwd = tPointPost.is_tuiguang.intValue() != 0;
                this.gwe = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gwf = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gwf.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gwg = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gwg.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gwh = new i(tPointPost.detail_info);
                }
                this.gwc = tPointPost.monitor_id;
                this.gwi = tPointPost.hidden_day.intValue();
                this.Ws = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j brE() {
        return (j) v.c(this.gwg, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> brF() {
        return this.gwf;
    }

    public ArrayList<j> brG() {
        return this.gwg;
    }

    public i brH() {
        return this.gwh;
    }

    public int brI() {
        return this.gwe;
    }

    public String getTagName() {
        return this.tagName;
    }
}
