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
public class i {
    private VideoInfo eOv;
    public long nqX;
    public String nqY;
    public boolean nqZ;
    private int nra;
    private ArrayList<h> nrb;
    private ArrayList<k> nrc;
    private j nrd;
    private int nre;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nqX = tPointPost.template_id.longValue();
                this.nqZ = tPointPost.is_tuiguang.intValue() != 0;
                this.nra = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nrb = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nrb.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nrc = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nrc.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nrd = new j(tPointPost.detail_info);
                }
                this.nqY = tPointPost.monitor_id;
                this.nre = tPointPost.hidden_day.intValue();
                this.eOv = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dOH() {
        return (k) x.getItem(this.nrc, 0);
    }
}
