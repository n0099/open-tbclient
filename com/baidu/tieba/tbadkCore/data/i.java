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
    private VideoInfo ezp;
    private ArrayList<h> mWA;
    private ArrayList<k> mWB;
    private j mWC;
    private int mWD;
    public long mWw;
    public String mWx;
    public boolean mWy;
    private int mWz;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.mWw = tPointPost.template_id.longValue();
                this.mWy = tPointPost.is_tuiguang.intValue() != 0;
                this.mWz = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.mWA = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.mWA.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.mWB = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.mWB.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.mWC = new j(tPointPost.detail_info);
                }
                this.mWx = tPointPost.monitor_id;
                this.mWD = tPointPost.hidden_day.intValue();
                this.ezp = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dJG() {
        return (k) y.getItem(this.mWB, 0);
    }
}
