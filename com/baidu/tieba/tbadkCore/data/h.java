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
    private VideoInfo alF;
    public String hcB;
    public boolean hcC;
    private int hcD;
    private ArrayList<g> hcE;
    private ArrayList<j> hcF;
    private i hcG;
    private int hcH;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hcC = tPointPost.is_tuiguang.intValue() != 0;
                this.hcD = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hcE = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hcE.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hcF = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hcF.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.hcG = new i(tPointPost.detail_info);
                }
                this.hcB = tPointPost.monitor_id;
                this.hcH = tPointPost.hidden_day.intValue();
                this.alF = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bBE() {
        return (j) v.d(this.hcF, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bBF() {
        return this.hcE;
    }

    public ArrayList<j> bBG() {
        return this.hcF;
    }

    public i bBH() {
        return this.hcG;
    }

    public int bBI() {
        return this.hcD;
    }

    public String getTagName() {
        return this.tagName;
    }
}
