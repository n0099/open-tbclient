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
    private VideoInfo UK;
    public String gpU;
    public boolean gpV;
    private int gpW;
    private ArrayList<g> gpX;
    private ArrayList<j> gpY;
    private i gpZ;
    private int gqa;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.gpV = tPointPost.is_tuiguang.intValue() != 0;
                this.gpW = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.gpX = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.gpX.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.gpY = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.gpY.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.gpZ = new i(tPointPost.detail_info);
                }
                this.gpU = tPointPost.monitor_id;
                this.gqa = tPointPost.hidden_day.intValue();
                this.UK = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j buk() {
        return (j) v.c(this.gpY, 0);
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bul() {
        return this.gpX;
    }

    public ArrayList<j> bum() {
        return this.gpY;
    }

    public i bun() {
        return this.gpZ;
    }

    public int buo() {
        return this.gpW;
    }

    public String getTagName() {
        return this.tagName;
    }
}
