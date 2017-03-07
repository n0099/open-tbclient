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
    private VideoInfo Ub;
    private String Uc;
    public String ftN;
    public boolean ftO;
    private int ftP;
    private ArrayList<g> ftQ;
    private ArrayList<j> ftR;
    private i ftS;
    private int ftT;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.ftO = tPointPost.is_tuiguang.intValue() != 0;
                this.ftP = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.ftQ = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.ftQ.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.ftR = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.ftR.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.ftS = new i(tPointPost.detail_info);
                }
                this.ftN = tPointPost.monitor_id;
                this.ftT = tPointPost.hidden_day.intValue();
                this.Ub = tPointPost.t_video;
                this.Uc = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bhd() {
        return (j) x.c(this.ftR, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bhe() {
        return this.ftQ;
    }

    public ArrayList<j> bhf() {
        return this.ftR;
    }

    public i bhg() {
        return this.ftS;
    }

    public int bhh() {
        return this.ftP;
    }

    public String bhi() {
        return this.ftN;
    }

    public VideoInfo bhj() {
        return this.Ub;
    }

    public String getTagName() {
        return this.Uc;
    }
}
