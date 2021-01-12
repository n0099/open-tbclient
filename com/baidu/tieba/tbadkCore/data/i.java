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
    private VideoInfo eJK;
    public long nmp;
    public String nmq;
    public boolean nmr;
    private int nms;
    private ArrayList<h> nmt;
    private ArrayList<k> nmu;
    private j nmv;
    private int nmw;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nmp = tPointPost.template_id.longValue();
                this.nmr = tPointPost.is_tuiguang.intValue() != 0;
                this.nms = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nmt = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nmt.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nmu = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nmu.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nmv = new j(tPointPost.detail_info);
                }
                this.nmq = tPointPost.monitor_id;
                this.nmw = tPointPost.hidden_day.intValue();
                this.eJK = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dKQ() {
        return (k) x.getItem(this.nmu, 0);
    }
}
