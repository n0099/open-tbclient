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
    private VideoInfo cJi;
    public String kbp;
    public boolean kbq;
    private int kbr;
    private ArrayList<h> kbs;
    private ArrayList<k> kbt;
    private j kbu;
    private int kbv;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.kbq = tPointPost.is_tuiguang.intValue() != 0;
                this.kbr = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kbs = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kbs.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kbt = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kbt.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kbu = new j(tPointPost.detail_info);
                }
                this.kbp = tPointPost.monitor_id;
                this.kbv = tPointPost.hidden_day.intValue();
                this.cJi = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cHW() {
        return (k) v.getItem(this.kbt, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cHX() {
        return this.kbs;
    }

    public ArrayList<k> cHY() {
        return this.kbt;
    }

    public j cHZ() {
        return this.kbu;
    }

    public int cIa() {
        return this.kbr;
    }

    public String getTagName() {
        return this.tagName;
    }
}
