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
    public String crJ;
    public String fQM;
    public String fQN;
    public String fQO;
    public String fQP;
    public String fQQ;
    public String fQR;
    public String fQS;
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
            if (!StringUtils.isNull(this.crJ)) {
                alVar.ac(ImageViewerConfig.FORUM_ID, this.crJ);
            }
            if (!StringUtils.isNull(this.mUid)) {
                alVar.ac("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fQM)) {
                alVar.ac("obj_param1", this.fQM);
            }
            if (!StringUtils.isNull(this.fQN)) {
                alVar.ac("obj_param2", this.fQN);
            }
            if (!StringUtils.isNull(this.fQO)) {
                alVar.ac("obj_param3", this.fQO);
            }
            if (!StringUtils.isNull(this.XM)) {
                alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XM);
            }
            if (!StringUtils.isNull(this.fQP)) {
                alVar.ac("ab_tag", this.fQP);
            }
            if (!StringUtils.isNull(this.fQR)) {
                alVar.ac("topic_type", this.fQR);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                alVar.ac("extra", this.mExtra);
            }
            if (!StringUtils.isNull(this.fQS)) {
                alVar.ac("is_vertical", this.fQS);
            }
        }
        return alVar;
    }

    public y bhc() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aNu = this.aNu;
        yVar.crJ = this.crJ;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.fQM = this.fQM;
        yVar.fQN = this.fQN;
        yVar.fQO = this.fQO;
        yVar.XM = this.XM;
        yVar.fQP = this.fQP;
        yVar.fQQ = this.fQQ;
        yVar.fQR = this.fQR;
        return yVar;
    }
}
