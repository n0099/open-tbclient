package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private VideoInfo dAV;
    private int llA;
    private ArrayList<h> llB;
    private ArrayList<k> llC;
    private j llD;
    private int llE;
    public long llx;
    public String lly;
    public boolean llz;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.llx = tPointPost.template_id.longValue();
                this.llz = tPointPost.is_tuiguang.intValue() != 0;
                this.llA = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.llB = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.llB.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.llC = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.llC.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.llD = new j(tPointPost.detail_info);
                }
                this.lly = tPointPost.monitor_id;
                this.llE = tPointPost.hidden_day.intValue();
                this.dAV = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k ddq() {
        return (k) v.getItem(this.llC, 0);
    }
}
