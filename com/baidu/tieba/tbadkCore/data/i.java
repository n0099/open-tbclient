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
    public String iFP;
    public boolean iFQ;
    private int iFR;
    private ArrayList<h> iFS;
    private ArrayList<k> iFT;
    private j iFU;
    private int iFV;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iFQ = tPointPost.is_tuiguang.intValue() != 0;
                this.iFR = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iFS = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iFS.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iFT = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iFT.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iFU = new j(tPointPost.detail_info);
                }
                this.iFP = tPointPost.monitor_id;
                this.iFV = tPointPost.hidden_day.intValue();
                this.bxd = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cdT() {
        return (k) v.c(this.iFT, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cdU() {
        return this.iFS;
    }

    public ArrayList<k> cdV() {
        return this.iFT;
    }

    public j cdW() {
        return this.iFU;
    }

    public int cdX() {
        return this.iFR;
    }

    public String getTagName() {
        return this.tagName;
    }
}
