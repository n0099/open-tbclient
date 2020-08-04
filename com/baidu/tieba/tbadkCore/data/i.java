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
    private VideoInfo dNx;
    public long lMJ;
    public String lMK;
    public boolean lML;
    private int lMM;
    private ArrayList<h> lMN;
    private ArrayList<k> lMO;
    private j lMP;
    private int lMQ;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.lMJ = tPointPost.template_id.longValue();
                this.lML = tPointPost.is_tuiguang.intValue() != 0;
                this.lMM = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.lMN = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.lMN.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.lMO = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.lMO.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.lMP = new j(tPointPost.detail_info);
                }
                this.lMK = tPointPost.monitor_id;
                this.lMQ = tPointPost.hidden_day.intValue();
                this.dNx = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dkP() {
        return (k) x.getItem(this.lMO, 0);
    }
}
