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
    private VideoInfo UK;
    public String goR;
    public boolean goS;
    private int goT;
    private ArrayList<g> goU;
    private ArrayList<j> goV;
    private i goW;
    private int goX;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.goS = tPointPost.is_tuiguang.intValue() != 0;
                this.goT = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.goU = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.goU.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.goV = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.goV.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.goW = new i(tPointPost.detail_info);
                }
                this.goR = tPointPost.monitor_id;
                this.goX = tPointPost.hidden_day.intValue();
                this.UK = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j btY() {
        return (j) v.c(this.goV, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> btZ() {
        return this.goU;
    }

    public ArrayList<j> bua() {
        return this.goV;
    }

    public i bub() {
        return this.goW;
    }

    public int buc() {
        return this.goT;
    }

    public String getTagName() {
        return this.tagName;
    }
}
