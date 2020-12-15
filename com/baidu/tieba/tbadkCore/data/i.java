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
    public long nlp;
    public String nlq;
    public boolean nlr;
    private int nls;
    private ArrayList<h> nlt;
    private ArrayList<k> nlu;
    private j nlv;
    private int nlw;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nlp = tPointPost.template_id.longValue();
                this.nlr = tPointPost.is_tuiguang.intValue() != 0;
                this.nls = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nlt = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nlt.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nlu = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nlu.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nlv = new j(tPointPost.detail_info);
                }
                this.nlq = tPointPost.monitor_id;
                this.nlw = tPointPost.hidden_day.intValue();
                this.eEF = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dOP() {
        return (k) y.getItem(this.nlu, 0);
    }
}
