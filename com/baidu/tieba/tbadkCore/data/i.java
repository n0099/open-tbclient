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
    private VideoInfo ekW;
    public long mDN;
    public String mDO;
    public boolean mDP;
    private int mDQ;
    private ArrayList<h> mDR;
    private ArrayList<k> mDS;
    private j mDT;
    private int mDU;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.mDN = tPointPost.template_id.longValue();
                this.mDP = tPointPost.is_tuiguang.intValue() != 0;
                this.mDQ = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.mDR = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.mDR.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.mDS = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.mDS.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.mDT = new j(tPointPost.detail_info);
                }
                this.mDO = tPointPost.monitor_id;
                this.mDU = tPointPost.hidden_day.intValue();
                this.ekW = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dDW() {
        return (k) y.getItem(this.mDS, 0);
    }
}
