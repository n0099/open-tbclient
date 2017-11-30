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
    private VideoInfo Vu;
    public String gyM;
    public boolean gyN;
    private int gyO;
    private ArrayList<g> gyP;
    private ArrayList<j> gyQ;
    private i gyR;
    private int gyS;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gyN = tPointPost.is_tuiguang.intValue() != 0;
                this.gyO = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gyP = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gyP.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gyQ = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gyQ.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gyR = new i(tPointPost.detail_info);
                }
                this.gyM = tPointPost.monitor_id;
                this.gyS = tPointPost.hidden_day.intValue();
                this.Vu = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bvS() {
        return (j) v.c(this.gyQ, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bvT() {
        return this.gyP;
    }

    public ArrayList<j> bvU() {
        return this.gyQ;
    }

    public i bvV() {
        return this.gyR;
    }

    public int bvW() {
        return this.gyO;
    }

    public String getTagName() {
        return this.tagName;
    }
}
