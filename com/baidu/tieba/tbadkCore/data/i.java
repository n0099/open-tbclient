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
    private VideoInfo cNy;
    public long kgl;
    public String kgm;
    public boolean kgn;
    private int kgo;
    private ArrayList<h> kgp;
    private ArrayList<k> kgq;
    private j kgr;
    private int kgs;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.kgl = tPointPost.template_id.longValue();
                this.kgn = tPointPost.is_tuiguang.intValue() != 0;
                this.kgo = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kgp = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kgp.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kgq = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kgq.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kgr = new j(tPointPost.detail_info);
                }
                this.kgm = tPointPost.monitor_id;
                this.kgs = tPointPost.hidden_day.intValue();
                this.cNy = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cKJ() {
        return (k) v.getItem(this.kgq, 0);
    }
}
