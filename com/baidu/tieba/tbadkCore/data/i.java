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
    public String keY;
    public boolean keZ;
    private int kfa;
    private ArrayList<h> kfb;
    private ArrayList<k> kfc;
    private j kfd;
    private int kfe;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.keZ = tPointPost.is_tuiguang.intValue() != 0;
                this.kfa = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kfb = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kfb.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kfc = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kfc.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kfd = new j(tPointPost.detail_info);
                }
                this.keY = tPointPost.monitor_id;
                this.kfe = tPointPost.hidden_day.intValue();
                this.cJt = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cJc() {
        return (k) v.getItem(this.kfc, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cJd() {
        return this.kfb;
    }

    public ArrayList<k> cJe() {
        return this.kfc;
    }

    public j cJf() {
        return this.kfd;
    }

    public int cJg() {
        return this.kfa;
    }

    public String getTagName() {
        return this.tagName;
    }
}
