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
    private VideoInfo aJM;
    public String gXN;
    public boolean gXO;
    private int gXP;
    private ArrayList<g> gXQ;
    private ArrayList<j> gXR;
    private i gXS;
    private int gXT;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gXO = tPointPost.is_tuiguang.intValue() != 0;
                this.gXP = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gXQ = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gXQ.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gXR = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gXR.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gXS = new i(tPointPost.detail_info);
                }
                this.gXN = tPointPost.monitor_id;
                this.gXT = tPointPost.hidden_day.intValue();
                this.aJM = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bvk() {
        return (j) v.f(this.gXR, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bvl() {
        return this.gXQ;
    }

    public ArrayList<j> bvm() {
        return this.gXR;
    }

    public i bvn() {
        return this.gXS;
    }

    public int bvo() {
        return this.gXP;
    }

    public String getTagName() {
        return this.tagName;
    }
}
