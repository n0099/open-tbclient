package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private VideoInfo dHm;
    public long lFr;
    public String lFs;
    public boolean lFt;
    private int lFu;
    private ArrayList<h> lFv;
    private ArrayList<k> lFw;
    private j lFx;
    private int lFy;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.lFr = tPointPost.template_id.longValue();
                this.lFt = tPointPost.is_tuiguang.intValue() != 0;
                this.lFu = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.lFv = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.lFv.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.lFw = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.lFw.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.lFx = new j(tPointPost.detail_info);
                }
                this.lFs = tPointPost.monitor_id;
                this.lFy = tPointPost.hidden_day.intValue();
                this.dHm = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dhF() {
        return (k) w.getItem(this.lFw, 0);
    }
}
