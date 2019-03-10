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
public class i {
    private VideoInfo bxd;
    public String iFQ;
    public boolean iFR;
    private int iFS;
    private ArrayList<h> iFT;
    private ArrayList<k> iFU;
    private j iFV;
    private int iFW;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iFR = tPointPost.is_tuiguang.intValue() != 0;
                this.iFS = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iFT = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iFT.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iFU = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iFU.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iFV = new j(tPointPost.detail_info);
                }
                this.iFQ = tPointPost.monitor_id;
                this.iFW = tPointPost.hidden_day.intValue();
                this.bxd = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cdU() {
        return (k) v.c(this.iFU, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cdV() {
        return this.iFT;
    }

    public ArrayList<k> cdW() {
        return this.iFU;
    }

    public j cdX() {
        return this.iFV;
    }

    public int cdY() {
        return this.iFS;
    }

    public String getTagName() {
        return this.tagName;
    }
}
