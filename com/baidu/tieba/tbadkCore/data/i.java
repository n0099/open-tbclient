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
    private VideoInfo etw;
    private int mQA;
    public long mQt;
    public String mQu;
    public boolean mQv;
    private int mQw;
    private ArrayList<h> mQx;
    private ArrayList<k> mQy;
    private j mQz;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.mQt = tPointPost.template_id.longValue();
                this.mQv = tPointPost.is_tuiguang.intValue() != 0;
                this.mQw = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.mQx = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.mQx.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.mQy = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.mQy.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.mQz = new j(tPointPost.detail_info);
                }
                this.mQu = tPointPost.monitor_id;
                this.mQA = tPointPost.hidden_day.intValue();
                this.etw = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dHe() {
        return (k) y.getItem(this.mQy, 0);
    }
}
