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
public class h {
    private VideoInfo Ut;
    private String Uu;
    private ArrayList<j> fvA;
    private i fvB;
    private int fvC;
    public String fvw;
    public boolean fvx;
    private int fvy;
    private ArrayList<g> fvz;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fvx = tPointPost.is_tuiguang.intValue() != 0;
                this.fvy = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fvz = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fvz.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fvA = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fvA.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fvB = new i(tPointPost.detail_info);
                }
                this.fvw = tPointPost.monitor_id;
                this.fvC = tPointPost.hidden_day.intValue();
                this.Ut = tPointPost.t_video;
                this.Uu = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bhO() {
        return (j) x.c(this.fvA, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bhP() {
        return this.fvz;
    }

    public ArrayList<j> bhQ() {
        return this.fvA;
    }

    public i bhR() {
        return this.fvB;
    }

    public int bhS() {
        return this.fvy;
    }

    public String bhT() {
        return this.fvw;
    }

    public VideoInfo bhU() {
        return this.Ut;
    }

    public String getTagName() {
        return this.Uu;
    }
}
