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
    public String hcC;
    public boolean hcD;
    private int hcE;
    private ArrayList<g> hcF;
    private ArrayList<j> hcG;
    private i hcH;
    private int hcI;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hcD = tPointPost.is_tuiguang.intValue() != 0;
                this.hcE = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hcF = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hcF.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hcG = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hcG.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.hcH = new i(tPointPost.detail_info);
                }
                this.hcC = tPointPost.monitor_id;
                this.hcI = tPointPost.hidden_day.intValue();
                this.alF = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bBE() {
        return (j) v.d(this.hcG, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bBF() {
        return this.hcF;
    }

    public ArrayList<j> bBG() {
        return this.hcG;
    }

    public i bBH() {
        return this.hcH;
    }

    public int bBI() {
        return this.hcE;
    }

    public String getTagName() {
        return this.tagName;
    }
}
