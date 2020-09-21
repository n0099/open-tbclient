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
    private VideoInfo dYU;
    public long mog;
    public String moh;
    public boolean moi;
    private int moj;
    private ArrayList<h> mok;
    private ArrayList<k> mol;
    private j mom;
    private int moo;
    public String position;
    private String tagName;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.mog = tPointPost.template_id.longValue();
                this.moi = tPointPost.is_tuiguang.intValue() != 0;
                this.moj = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.mok = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.mok.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.mol = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.mol.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.mom = new j(tPointPost.detail_info);
                }
                this.moh = tPointPost.monitor_id;
                this.moo = tPointPost.hidden_day.intValue();
                this.dYU = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k dAk() {
        return (k) y.getItem(this.mol, 0);
    }
}
