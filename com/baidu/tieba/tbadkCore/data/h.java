package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class h {
    private VideoInfo OY;
    private String OZ;
    public String fpr;
    public boolean fpt;
    private int fpu;
    private ArrayList<g> fpv;
    private ArrayList<j> fpw;
    private i fpx;
    private int fpy;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fpt = tPointPost.is_tuiguang.intValue() != 0;
                this.fpu = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fpv = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fpv.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fpw = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fpw.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fpx = new i(tPointPost.detail_info);
                }
                this.fpr = tPointPost.monitor_id;
                this.fpy = tPointPost.hidden_day.intValue();
                this.OY = tPointPost.t_video;
                this.OZ = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bhq() {
        return (j) w.c(this.fpw, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bhr() {
        return this.fpv;
    }

    public ArrayList<j> bhs() {
        return this.fpw;
    }

    public i bht() {
        return this.fpx;
    }

    public int bhu() {
        return this.fpu;
    }

    public String bhv() {
        return this.fpr;
    }

    public VideoInfo bhw() {
        return this.OY;
    }

    public String getTagName() {
        return this.OZ;
    }
}
