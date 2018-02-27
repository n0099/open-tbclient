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
    private VideoInfo aKX;
    public String hai;
    public boolean haj;
    private int hak;
    private ArrayList<g> hal;
    private ArrayList<j> ham;
    private i han;
    private int hao;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.haj = tPointPost.is_tuiguang.intValue() != 0;
                this.hak = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hal = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hal.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.ham = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.ham.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.han = new i(tPointPost.detail_info);
                }
                this.hai = tPointPost.monitor_id;
                this.hao = tPointPost.hidden_day.intValue();
                this.aKX = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bwx() {
        return (j) v.f(this.ham, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bwy() {
        return this.hal;
    }

    public ArrayList<j> bwz() {
        return this.ham;
    }

    public i bwA() {
        return this.han;
    }

    public int bwB() {
        return this.hak;
    }

    public String getTagName() {
        return this.tagName;
    }
}
