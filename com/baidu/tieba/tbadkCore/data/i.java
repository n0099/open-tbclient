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
    private VideoInfo cNw;
    public long kfX;
    public String kfY;
    public boolean kfZ;
    private int kga;
    private ArrayList<h> kgb;
    private ArrayList<k> kgc;
    private j kgd;
    private int kge;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.kfX = tPointPost.template_id.longValue();
                this.kfZ = tPointPost.is_tuiguang.intValue() != 0;
                this.kga = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kgb = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kgb.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kgc = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kgc.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kgd = new j(tPointPost.detail_info);
                }
                this.kfY = tPointPost.monitor_id;
                this.kge = tPointPost.hidden_day.intValue();
                this.cNw = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cKG() {
        return (k) v.getItem(this.kgc, 0);
    }
}
