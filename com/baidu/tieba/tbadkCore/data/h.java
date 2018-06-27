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
    private VideoInfo aeE;
    public String gMC;
    public boolean gMD;
    private int gME;
    private ArrayList<g> gMF;
    private ArrayList<j> gMG;
    private i gMH;
    private int gMI;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gMD = tPointPost.is_tuiguang.intValue() != 0;
                this.gME = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gMF = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gMF.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gMG = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gMG.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gMH = new i(tPointPost.detail_info);
                }
                this.gMC = tPointPost.monitor_id;
                this.gMI = tPointPost.hidden_day.intValue();
                this.aeE = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bxf() {
        return (j) w.d(this.gMG, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bxg() {
        return this.gMF;
    }

    public ArrayList<j> bxh() {
        return this.gMG;
    }

    public i bxi() {
        return this.gMH;
    }

    public int bxj() {
        return this.gME;
    }

    public String getTagName() {
        return this.tagName;
    }
}
