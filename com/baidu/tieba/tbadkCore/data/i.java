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
    private VideoInfo bFv;
    public String jeD;
    public boolean jeE;
    private int jeF;
    private ArrayList<h> jeG;
    private ArrayList<k> jeH;
    private j jeI;
    private int jeJ;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.jeE = tPointPost.is_tuiguang.intValue() != 0;
                this.jeF = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.jeG = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.jeG.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.jeH = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.jeH.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.jeI = new j(tPointPost.detail_info);
                }
                this.jeD = tPointPost.monitor_id;
                this.jeJ = tPointPost.hidden_day.intValue();
                this.bFv = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k coS() {
        return (k) v.c(this.jeH, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> coT() {
        return this.jeG;
    }

    public ArrayList<k> coU() {
        return this.jeH;
    }

    public j coV() {
        return this.jeI;
    }

    public int coW() {
        return this.jeF;
    }

    public String getTagName() {
        return this.tagName;
    }
}
