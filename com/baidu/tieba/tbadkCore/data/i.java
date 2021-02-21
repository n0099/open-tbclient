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
    private VideoInfo eLW;
    public String nwA;
    public boolean nwB;
    private int nwC;
    private ArrayList<h> nwD;
    private ArrayList<k> nwE;
    private j nwF;
    private int nwG;
    public long nwz;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nwz = tPointPost.template_id.longValue();
                this.nwB = tPointPost.is_tuiguang.intValue() != 0;
                this.nwC = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nwD = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nwD.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nwE = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nwE.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nwF = new j(tPointPost.detail_info);
                }
                this.nwA = tPointPost.monitor_id;
                this.nwG = tPointPost.hidden_day.intValue();
                this.eLW = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dNj() {
        return (k) y.getItem(this.nwE, 0);
    }
}
