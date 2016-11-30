package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private VideoInfo PV;
    private String PW;
    public String fBY;
    public boolean fBZ;
    private int fCa;
    private ArrayList<h> fCb;
    private ArrayList<k> fCc;
    private j fCd;
    private int fCe;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fBZ = tPointPost.is_tuiguang.intValue() != 0;
                this.fCa = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fCb = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fCb.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fCc = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fCc.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fCd = new j(tPointPost.detail_info);
                }
                this.fBY = tPointPost.monitor_id;
                this.fCe = tPointPost.hidden_day.intValue();
                this.PV = tPointPost.t_video;
                this.PW = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k blL() {
        return (k) x.c(this.fCc, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> blM() {
        return this.fCb;
    }

    public ArrayList<k> blN() {
        return this.fCc;
    }

    public j blO() {
        return this.fCd;
    }

    public int blP() {
        return this.fCa;
    }

    public String blQ() {
        return this.fBY;
    }

    public VideoInfo blR() {
        return this.PV;
    }
}
