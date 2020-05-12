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
    private VideoInfo dmT;
    public long kRY;
    public String kRZ;
    public boolean kSa;
    private int kSb;
    private ArrayList<h> kSc;
    private ArrayList<k> kSd;
    private j kSe;
    private int kSf;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.kRY = tPointPost.template_id.longValue();
                this.kSa = tPointPost.is_tuiguang.intValue() != 0;
                this.kSb = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.kSc = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.kSc.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.kSd = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.kSd.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.kSe = new j(tPointPost.detail_info);
                }
                this.kRZ = tPointPost.monitor_id;
                this.kSf = tPointPost.hidden_day.intValue();
                this.dmT = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cVX() {
        return (k) v.getItem(this.kSd, 0);
    }
}
