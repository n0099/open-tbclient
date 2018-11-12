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
    private VideoInfo ams;
    public String hdZ;
    public boolean hea;
    private int heb;
    private ArrayList<g> hec;
    private ArrayList<j> hed;
    private i hee;
    private int hef;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hea = tPointPost.is_tuiguang.intValue() != 0;
                this.heb = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hec = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hec.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hed = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hed.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.hee = new i(tPointPost.detail_info);
                }
                this.hdZ = tPointPost.monitor_id;
                this.hef = tPointPost.hidden_day.intValue();
                this.ams = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bBa() {
        return (j) v.d(this.hed, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bBb() {
        return this.hec;
    }

    public ArrayList<j> bBc() {
        return this.hed;
    }

    public i bBd() {
        return this.hee;
    }

    public int bBe() {
        return this.heb;
    }

    public String getTagName() {
        return this.tagName;
    }
}
