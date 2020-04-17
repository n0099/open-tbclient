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
    private VideoInfo dmP;
    public long kRU;
    public String kRV;
    public boolean kRW;
    private int kRX;
    private ArrayList<h> kRY;
    private ArrayList<k> kRZ;
    private j kSa;
    private int kSb;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.kRU = tPointPost.template_id.longValue();
                this.kRW = tPointPost.is_tuiguang.intValue() != 0;
                this.kRX = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kRY = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kRY.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kRZ = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kRZ.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kSa = new j(tPointPost.detail_info);
                }
                this.kRV = tPointPost.monitor_id;
                this.kSb = tPointPost.hidden_day.intValue();
                this.dmP = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cVZ() {
        return (k) v.getItem(this.kRZ, 0);
    }
}
