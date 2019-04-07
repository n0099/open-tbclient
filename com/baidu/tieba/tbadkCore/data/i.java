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
    private VideoInfo bxi;
    public String iFs;
    public boolean iFt;
    private int iFu;
    private ArrayList<h> iFv;
    private ArrayList<k> iFw;
    private j iFx;
    private int iFy;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iFt = tPointPost.is_tuiguang.intValue() != 0;
                this.iFu = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iFv = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iFv.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iFw = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iFw.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iFx = new j(tPointPost.detail_info);
                }
                this.iFs = tPointPost.monitor_id;
                this.iFy = tPointPost.hidden_day.intValue();
                this.bxi = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cdS() {
        return (k) v.c(this.iFw, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cdT() {
        return this.iFv;
    }

    public ArrayList<k> cdU() {
        return this.iFw;
    }

    public j cdV() {
        return this.iFx;
    }

    public int cdW() {
        return this.iFu;
    }

    public String getTagName() {
        return this.tagName;
    }
}
