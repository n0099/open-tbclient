package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActBtn;
import tbclient.TPointPost;
import tbclient.Timgs;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class i {
    private VideoInfo PA;
    private String PC;
    public String fuM;
    public boolean fuN;
    private int fuO;
    private ArrayList<h> fuP;
    private ArrayList<k> fuQ;
    private j fuR;
    private int fuS;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fuN = tPointPost.is_tuiguang.intValue() != 0;
                this.fuO = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fuP = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fuP.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fuQ = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fuQ.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fuR = new j(tPointPost.detail_info);
                }
                this.fuM = tPointPost.monitor_id;
                this.fuS = tPointPost.hidden_day.intValue();
                this.PA = tPointPost.t_video;
                this.PC = tPointPost.tag_name;
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

    public ArrayList<h> bjq() {
        return this.fuP;
    }

    public ArrayList<k> bjr() {
        return this.fuQ;
    }

    public j bjs() {
        return this.fuR;
    }

    public int bjt() {
        return this.fuO;
    }

    public String bju() {
        return this.fuM;
    }

    public int bjv() {
        return this.fuS;
    }

    public VideoInfo bjw() {
        return this.PA;
    }

    public String getTagName() {
        return this.PC;
    }
}
