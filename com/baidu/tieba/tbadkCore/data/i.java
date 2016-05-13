package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
/* loaded from: classes.dex */
public class i {
    private ArrayList<k> esA;
    private j esB;
    private int esC;
    public String esw;
    public boolean esx;
    private int esy;
    private ArrayList<h> esz;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.esx = tPointPost.is_tuiguang.intValue() != 0;
                this.esy = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.esz = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.esz.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.esA = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.esA.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.esB = new j(tPointPost.detail_info);
                }
                this.esw = tPointPost.monitor_id;
                this.esC = tPointPost.hidden_day.intValue();
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

    public ArrayList<h> aTy() {
        return this.esz;
    }

    public ArrayList<k> aTz() {
        return this.esA;
    }

    public j aTA() {
        return this.esB;
    }

    public int aTB() {
        return this.esy;
    }

    public String aTC() {
        return this.esw;
    }

    public int aTD() {
        return this.esC;
    }
}
