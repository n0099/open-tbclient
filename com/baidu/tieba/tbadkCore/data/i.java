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
    public long lMH;
    public String lMI;
    public boolean lMJ;
    private int lMK;
    private ArrayList<h> lML;
    private ArrayList<k> lMM;
    private j lMN;
    private int lMO;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.lMH = tPointPost.template_id.longValue();
                this.lMJ = tPointPost.is_tuiguang.intValue() != 0;
                this.lMK = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.lML = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.lML.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.lMM = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.lMM.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.lMN = new j(tPointPost.detail_info);
                }
                this.lMI = tPointPost.monitor_id;
                this.lMO = tPointPost.hidden_day.intValue();
                this.dNx = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dkO() {
        return (k) x.getItem(this.lMM, 0);
    }
}
