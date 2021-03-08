package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private VideoInfo eNx;
    public long nyD;
    public String nyE;
    public boolean nyF;
    private int nyG;
    private ArrayList<h> nyH;
    private ArrayList<k> nyI;
    private j nyJ;
    private int nyK;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nyD = tPointPost.template_id.longValue();
                this.nyF = tPointPost.is_tuiguang.intValue() != 0;
                this.nyG = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nyH = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nyH.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nyI = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nyI.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nyJ = new j(tPointPost.detail_info);
                }
                this.nyE = tPointPost.monitor_id;
                this.nyK = tPointPost.hidden_day.intValue();
                this.eNx = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dNr() {
        return (k) y.getItem(this.nyI, 0);
    }
}
