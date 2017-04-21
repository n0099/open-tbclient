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
    private VideoInfo Uv;
    private String Uw;
    public String fxN;
    public boolean fxO;
    private int fxP;
    private ArrayList<g> fxQ;
    private ArrayList<j> fxR;
    private i fxS;
    private int fxT;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fxO = tPointPost.is_tuiguang.intValue() != 0;
                this.fxP = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fxQ = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fxQ.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fxR = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fxR.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fxS = new i(tPointPost.detail_info);
                }
                this.fxN = tPointPost.monitor_id;
                this.fxT = tPointPost.hidden_day.intValue();
                this.Uv = tPointPost.t_video;
                this.Uw = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j biP() {
        return (j) x.c(this.fxR, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> biQ() {
        return this.fxQ;
    }

    public ArrayList<j> biR() {
        return this.fxR;
    }

    public i biS() {
        return this.fxS;
    }

    public int biT() {
        return this.fxP;
    }

    public String biU() {
        return this.fxN;
    }

    public VideoInfo biV() {
        return this.Uv;
    }

    public String getTagName() {
        return this.Uw;
    }
}
