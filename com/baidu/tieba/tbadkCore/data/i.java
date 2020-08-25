package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class i {
    private VideoInfo dWG;
    private int meA;
    public long met;
    public String meu;
    public boolean mev;
    private int mew;
    private ArrayList<h> mex;
    private ArrayList<k> mey;
    private j mez;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.met = tPointPost.template_id.longValue();
                this.mev = tPointPost.is_tuiguang.intValue() != 0;
                this.mew = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.mex = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.mex.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.mey = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.mey.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.mez = new j(tPointPost.detail_info);
                }
                this.meu = tPointPost.monitor_id;
                this.meA = tPointPost.hidden_day.intValue();
                this.dWG = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dwm() {
        return (k) y.getItem(this.mey, 0);
    }
}
