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
    public long nvZ;
    public String nwa;
    public boolean nwb;
    private int nwc;
    private ArrayList<h> nwd;
    private ArrayList<k> nwe;
    private j nwf;
    private int nwg;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.nvZ = tPointPost.template_id.longValue();
                this.nwb = tPointPost.is_tuiguang.intValue() != 0;
                this.nwc = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.nwd = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.nwd.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.nwe = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.nwe.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.nwf = new j(tPointPost.detail_info);
                }
                this.nwa = tPointPost.monitor_id;
                this.nwg = tPointPost.hidden_day.intValue();
                this.eLW = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dNb() {
        return (k) y.getItem(this.nwe, 0);
    }
}
