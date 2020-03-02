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
    private VideoInfo cNx;
    public long kfZ;
    public String kga;
    public boolean kgb;
    private int kgc;
    private ArrayList<h> kgd;
    private ArrayList<k> kge;
    private j kgf;
    private int kgg;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.kfZ = tPointPost.template_id.longValue();
                this.kgb = tPointPost.is_tuiguang.intValue() != 0;
                this.kgc = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kgd = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kgd.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kge = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kge.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kgf = new j(tPointPost.detail_info);
                }
                this.kga = tPointPost.monitor_id;
                this.kgg = tPointPost.hidden_day.intValue();
                this.cNx = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cKI() {
        return (k) v.getItem(this.kge, 0);
    }
}
