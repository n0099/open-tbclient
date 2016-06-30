package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    public String eXk;
    public boolean eXl;
    private int eXm;
    private ArrayList<h> eXn;
    private ArrayList<k> eXo;
    private j eXp;
    private int eXq;
    private VideoInfo eXr;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.eXl = tPointPost.is_tuiguang.intValue() != 0;
                this.eXm = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.eXn = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.eXn.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.eXo = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.eXo.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.eXp = new j(tPointPost.detail_info);
                }
                this.eXk = tPointPost.monitor_id;
                this.eXq = tPointPost.hidden_day.intValue();
                this.eXr = tPointPost.t_video;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> bbL() {
        return this.eXn;
    }

    public ArrayList<k> bbM() {
        return this.eXo;
    }

    public j bbN() {
        return this.eXp;
    }

    public int bbO() {
        return this.eXm;
    }

    public String bbP() {
        return this.eXk;
    }

    public int bbQ() {
        return this.eXq;
    }

    public VideoInfo bbR() {
        return this.eXr;
    }
}
