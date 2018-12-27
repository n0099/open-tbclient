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
public class h {
    private VideoInfo apT;
    public String hoe;
    public boolean hof;
    private int hog;
    private ArrayList<g> hoh;
    private ArrayList<j> hoi;
    private i hoj;
    private int hok;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hof = tPointPost.is_tuiguang.intValue() != 0;
                this.hog = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hoh = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hoh.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hoi = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hoi.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.hoj = new i(tPointPost.detail_info);
                }
                this.hoe = tPointPost.monitor_id;
                this.hok = tPointPost.hidden_day.intValue();
                this.apT = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bDM() {
        return (j) v.d(this.hoi, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bDN() {
        return this.hoh;
    }

    public ArrayList<j> bDO() {
        return this.hoi;
    }

    public i bDP() {
        return this.hoj;
    }

    public int bDQ() {
        return this.hog;
    }

    public String getTagName() {
        return this.tagName;
    }
}
