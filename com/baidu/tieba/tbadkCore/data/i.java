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
    private VideoInfo eEF;
    public long nln;
    public String nlo;
    public boolean nlp;
    private int nlq;
    private ArrayList<h> nlr;
    private ArrayList<k> nls;
    private j nlt;
    private int nlu;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nln = tPointPost.template_id.longValue();
                this.nlp = tPointPost.is_tuiguang.intValue() != 0;
                this.nlq = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nlr = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nlr.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nls = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nls.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nlt = new j(tPointPost.detail_info);
                }
                this.nlo = tPointPost.monitor_id;
                this.nlu = tPointPost.hidden_day.intValue();
                this.eEF = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dOO() {
        return (k) y.getItem(this.nls, 0);
    }
}
