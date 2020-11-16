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
    private VideoInfo exE;
    public long mXp;
    public String mXq;
    public boolean mXr;
    private int mXs;
    private ArrayList<h> mXt;
    private ArrayList<k> mXu;
    private j mXv;
    private int mXw;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.mXp = tPointPost.template_id.longValue();
                this.mXr = tPointPost.is_tuiguang.intValue() != 0;
                this.mXs = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.mXt = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.mXt.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.mXu = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.mXu.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.mXv = new j(tPointPost.detail_info);
                }
                this.mXq = tPointPost.monitor_id;
                this.mXw = tPointPost.hidden_day.intValue();
                this.exE = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dJx() {
        return (k) y.getItem(this.mXu, 0);
    }
}
