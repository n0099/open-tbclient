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
    private VideoInfo dAV;
    public long lko;
    public String lkp;
    public boolean lkq;
    private int lkr;
    private ArrayList<h> lks;
    private ArrayList<k> lkt;
    private j lku;
    private int lkv;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.lko = tPointPost.template_id.longValue();
                this.lkq = tPointPost.is_tuiguang.intValue() != 0;
                this.lkr = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.lks = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.lks.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.lkt = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.lkt.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.lku = new j(tPointPost.detail_info);
                }
                this.lkp = tPointPost.monitor_id;
                this.lkv = tPointPost.hidden_day.intValue();
                this.dAV = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k ddb() {
        return (k) v.getItem(this.lkt, 0);
    }
}
