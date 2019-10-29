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
    private VideoInfo bXM;
    public String jhT;
    public boolean jhU;
    private int jhV;
    private ArrayList<h> jhW;
    private ArrayList<k> jhX;
    private j jhY;
    private int jhZ;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.jhU = tPointPost.is_tuiguang.intValue() != 0;
                this.jhV = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.jhW = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.jhW.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.jhX = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.jhX.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.jhY = new j(tPointPost.detail_info);
                }
                this.jhT = tPointPost.monitor_id;
                this.jhZ = tPointPost.hidden_day.intValue();
                this.bXM = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cnS() {
        return (k) v.getItem(this.jhX, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cnT() {
        return this.jhW;
    }

    public ArrayList<k> cnU() {
        return this.jhX;
    }

    public j cnV() {
        return this.jhY;
    }

    public int cnW() {
        return this.jhV;
    }

    public String getTagName() {
        return this.tagName;
    }
}
