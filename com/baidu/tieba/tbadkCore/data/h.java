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
    public String hkT;
    public boolean hkU;
    private int hkV;
    private ArrayList<g> hkW;
    private ArrayList<j> hkX;
    private i hkY;
    private int hkZ;
    public String position;
    private String tagName;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.hkU = tPointPost.is_tuiguang.intValue() != 0;
                this.hkV = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.hkW = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.hkW.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.hkX = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.hkX.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.hkY = new i(tPointPost.detail_info);
                }
                this.hkT = tPointPost.monitor_id;
                this.hkZ = tPointPost.hidden_day.intValue();
                this.apT = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public j bCV() {
        return (j) v.d(this.hkX, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> bCW() {
        return this.hkW;
    }

    public ArrayList<j> bCX() {
        return this.hkX;
    }

    public i bCY() {
        return this.hkY;
    }

    public int bCZ() {
        return this.hkV;
    }

    public String getTagName() {
        return this.tagName;
    }
}
