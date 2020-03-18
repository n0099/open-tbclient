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
    private VideoInfo cNL;
    public long khN;
    public String khO;
    public boolean khP;
    private int khQ;
    private ArrayList<h> khR;
    private ArrayList<k> khS;
    private j khT;
    private int khU;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.khN = tPointPost.template_id.longValue();
                this.khP = tPointPost.is_tuiguang.intValue() != 0;
                this.khQ = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.khR = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.khR.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.khS = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.khS.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.khT = new j(tPointPost.detail_info);
                }
                this.khO = tPointPost.monitor_id;
                this.khU = tPointPost.hidden_day.intValue();
                this.cNL = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cLd() {
        return (k) v.getItem(this.khS, 0);
    }
}
