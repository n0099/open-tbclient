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
public class i {
    private VideoInfo bxf;
    public String iFI;
    public boolean iFJ;
    private int iFK;
    private ArrayList<h> iFL;
    private ArrayList<k> iFM;
    private j iFN;
    private int iFO;
    public String position;
    private String tagName;
    public long templateId;

    public i(TPointPost tPointPost) {
        if (tPointPost != null) {
            try {
                this.position = tPointPost.position;
                this.templateId = tPointPost.template_id.longValue();
                this.iFJ = tPointPost.is_tuiguang.intValue() != 0;
                this.iFK = tPointPost.template_type.intValue();
                List<ActBtn> list = tPointPost.act_btn;
                if (list != null && list.size() > 0) {
                    this.iFL = new ArrayList<>();
                    for (int i = 0; i != list.size(); i++) {
                        this.iFL.add(new h(list.get(i)));
                    }
                }
                List<Timgs> list2 = tPointPost.t_imgs;
                if (list2 != null && list2.size() > 0) {
                    this.iFM = new ArrayList<>();
                    for (int i2 = 0; i2 != list2.size(); i2++) {
                        this.iFM.add(new k(list2.get(i2)));
                    }
                }
                if (tPointPost.detail_info != null) {
                    this.iFN = new j(tPointPost.detail_info);
                }
                this.iFI = tPointPost.monitor_id;
                this.iFO = tPointPost.hidden_day.intValue();
                this.bxf = tPointPost.t_video;
                this.tagName = tPointPost.tag_name;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public k cdW() {
        return (k) v.c(this.iFM, 0);
    }

    public String getPosition() {
        return this.position;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public ArrayList<h> cdX() {
        return this.iFL;
    }

    public ArrayList<k> cdY() {
        return this.iFM;
    }

    public j cdZ() {
        return this.iFN;
    }

    public int cea() {
        return this.iFK;
    }

    public String getTagName() {
        return this.tagName;
    }
}
