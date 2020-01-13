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
    private VideoInfo cJt;
    public String keT;
    public boolean keU;
    private int keV;
    private ArrayList<h> keW;
    private ArrayList<k> keX;
    private j keY;
    private int keZ;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.keU = tPointPost.is_tuiguang.intValue() != 0;
                this.keV = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.keW = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.keW.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.keX = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.keX.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.keY = new j(tPointPost.detail_info);
                }
                this.keT = tPointPost.monitor_id;
                this.keZ = tPointPost.hidden_day.intValue();
                this.cJt = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cJa() {
        return (k) v.getItem(this.keX, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cJb() {
        return this.keW;
    }

    public ArrayList<k> cJc() {
        return this.keX;
    }

    public j cJd() {
        return this.keY;
    }

    public int cJe() {
        return this.keV;
    }

    public String getTagName() {
        return this.tagName;
    }
}
