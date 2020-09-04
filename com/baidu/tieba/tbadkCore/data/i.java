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
    private VideoInfo dWK;
    public long meI;
    public String meJ;
    public boolean meK;
    private int meL;
    private ArrayList<h> meM;
    private ArrayList<k> meN;
    private j meO;
    private int meP;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.meI = tPointPost.template_id.longValue();
                this.meK = tPointPost.is_tuiguang.intValue() != 0;
                this.meL = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.meM = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.meM.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.meN = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.meN.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.meO = new j(tPointPost.detail_info);
                }
                this.meJ = tPointPost.monitor_id;
                this.meP = tPointPost.hidden_day.intValue();
                this.dWK = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dwr() {
        return (k) y.getItem(this.meN, 0);
    }
}
