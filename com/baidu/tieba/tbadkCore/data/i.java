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
    private VideoInfo PQ;
    private String PR;
    public String fgd;
    public boolean fge;
    private int fgf;
    private ArrayList<h> fgg;
    private ArrayList<k> fgh;
    private j fgi;
    private int fgj;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fge = tPointPost.is_tuiguang.intValue() != 0;
                this.fgf = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fgg = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fgg.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fgh = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fgh.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fgi = new j(tPointPost.detail_info);
                }
                this.fgd = tPointPost.monitor_id;
                this.fgj = tPointPost.hidden_day.intValue();
                this.PQ = tPointPost.t_video;
                this.PR = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k bfA() {
        return (k) x.c(this.fgh, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> bfB() {
        return this.fgg;
    }

    public ArrayList<k> bfC() {
        return this.fgh;
    }

    public j bfD() {
        return this.fgi;
    }

    public int bfE() {
        return this.fgf;
    }

    public String bfF() {
        return this.fgd;
    }

    public VideoInfo bfG() {
        return this.PQ;
    }
}
