package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class y {
    public String XM;
    public String aNu;
    public String crG;
    public String fQJ;
    public String fQK;
    public String fQL;
    public String fQM;
    public String fQN;
    public String fQO;
    public String fQP;
    public String mExtra;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public al b(al alVar) {
        if (alVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                alVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aNu)) {
                alVar.ac("tid", this.aNu);
            }
            if (!StringUtils.isNull(this.crG)) {
                alVar.ac(ImageViewerConfig.FORUM_ID, this.crG);
            }
            if (!StringUtils.isNull(this.mUid)) {
                alVar.ac("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fQJ)) {
                alVar.ac("obj_param1", this.fQJ);
            }
            if (!StringUtils.isNull(this.fQK)) {
                alVar.ac("obj_param2", this.fQK);
            }
            if (!StringUtils.isNull(this.fQL)) {
                alVar.ac("obj_param3", this.fQL);
            }
            if (!StringUtils.isNull(this.XM)) {
                alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XM);
            }
            if (!StringUtils.isNull(this.fQM)) {
                alVar.ac("ab_tag", this.fQM);
            }
            if (!StringUtils.isNull(this.fQO)) {
                alVar.ac("topic_type", this.fQO);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                alVar.ac("extra", this.mExtra);
            }
            if (!StringUtils.isNull(this.fQP)) {
                alVar.ac("is_vertical", this.fQP);
            }
        }
        return alVar;
    }

    public y bhc() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aNu = this.aNu;
        yVar.crG = this.crG;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.fQJ = this.fQJ;
        yVar.fQK = this.fQK;
        yVar.fQL = this.fQL;
        yVar.XM = this.XM;
        yVar.fQM = this.fQM;
        yVar.fQN = this.fQN;
        yVar.fQO = this.fQO;
        return yVar;
    }
}
