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
    private VideoInfo PD;
    private String PE;
    public String fsg;
    public boolean fsh;
    private int fsi;
    private ArrayList<h> fsj;
    private ArrayList<k> fsk;
    private j fsl;
    private int fsm;
    public String position;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.fsh = tPointPost.is_tuiguang.intValue() != 0;
                this.fsi = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.fsj = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.fsj.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.fsk = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.fsk.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.fsl = new j(tPointPost.detail_info);
                }
                this.fsg = tPointPost.monitor_id;
                this.fsm = tPointPost.hidden_day.intValue();
                this.PD = tPointPost.t_video;
                this.PE = tPointPost.tag_name;
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

    public ArrayList<h> biF() {
        return this.fsj;
    }

    public ArrayList<k> biG() {
        return this.fsk;
    }

    public j biH() {
        return this.fsl;
    }

    public int biI() {
        return this.fsi;
    }

    public String biJ() {
        return this.fsg;
    }

    public int biK() {
        return this.fsm;
    }

    public VideoInfo biL() {
        return this.PD;
    }

    public String getTagName() {
        return this.PE;
    }
}
