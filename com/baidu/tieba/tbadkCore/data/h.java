package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class h {
    public String dWE;
    public boolean dWF;
    private int dWG;
    private ArrayList<g> dWH;
    private ArrayList<j> dWI;
    private i dWJ;
    public String position;
    public long templateId;

    public h(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.dWF = tPointPost.is_tuiguang.intValue() != 0;
                this.dWG = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.dWH = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.dWH.add(new g(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.dWI = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.dWI.add(new j(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.dWJ = new i(tPointPost.detail_info);
                }
                this.dWE = tPointPost.monitor_id;
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

    public ArrayList<g> aLW() {
        return this.dWH;
    }

    public ArrayList<j> aLX() {
        return this.dWI;
    }

    public i aLY() {
        return this.dWJ;
    }

    public int aLZ() {
        return this.dWG;
    }

    public String aMa() {
        return this.dWE;
    }
}
