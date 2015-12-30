package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class h {
    public String dGI;
    public boolean dGJ;
    private int dGK;
    private ArrayList<g> dGL;
    private ArrayList<j> dGM;
    private i dGN;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.dGJ = tPointPost.is_tuiguang.intValue() != 0;
                this.dGK = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.dGL = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.dGL.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.dGM = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.dGM.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.dGN = new i(tPointPost.detail_info);
                }
                this.dGI = tPointPost.monitor_id;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<g> aEQ() {
        return this.dGL;
    }

    public ArrayList<j> aER() {
        return this.dGM;
    }

    public i aES() {
        return this.dGN;
    }

    public int aET() {
        return this.dGK;
    }

    public String aEU() {
        return this.dGI;
    }
}
