package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class y {
    public String XN;
    public String aNv;
    public String csP;
    public String fRP;
    public String fRQ;
    public String fRR;
    public String fRS;
    public String fRT;
    public String fRU;
    public String fRV;
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
            if (!StringUtils.isNull(this.aNv)) {
                alVar.ac("tid", this.aNv);
            }
            if (!StringUtils.isNull(this.csP)) {
                alVar.ac(ImageViewerConfig.FORUM_ID, this.csP);
            }
            if (!StringUtils.isNull(this.mUid)) {
                alVar.ac("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fRP)) {
                alVar.ac("obj_param1", this.fRP);
            }
            if (!StringUtils.isNull(this.fRQ)) {
                alVar.ac("obj_param2", this.fRQ);
            }
            if (!StringUtils.isNull(this.fRR)) {
                alVar.ac("obj_param3", this.fRR);
            }
            if (!StringUtils.isNull(this.XN)) {
                alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.XN);
            }
            if (!StringUtils.isNull(this.fRS)) {
                alVar.ac("ab_tag", this.fRS);
            }
            if (!StringUtils.isNull(this.fRU)) {
                alVar.ac("topic_type", this.fRU);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                alVar.ac("extra", this.mExtra);
            }
            if (!StringUtils.isNull(this.fRV)) {
                alVar.ac("is_vertical", this.fRV);
            }
        }
        return alVar;
    }

    public y bhc() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.aNv = this.aNv;
        yVar.csP = this.csP;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.fRP = this.fRP;
        yVar.fRQ = this.fRQ;
        yVar.fRR = this.fRR;
        yVar.XN = this.XN;
        yVar.fRS = this.fRS;
        yVar.fRT = this.fRT;
        yVar.fRU = this.fRU;
        return yVar;
    }
}
