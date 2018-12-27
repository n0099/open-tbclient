package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String arh;
    public String biz;
    public String daG;
    public String gHE;
    public String gHF;
    public String gHG;
    public String gHH;
    public String gHI;
    public String gHJ;
    public String gHK;
    public String mExtra;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am b(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.aA("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.biz)) {
                amVar.aA("tid", this.biz);
            }
            if (!StringUtils.isNull(this.daG)) {
                amVar.aA(ImageViewerConfig.FORUM_ID, this.daG);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.aA("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.gHE)) {
                amVar.aA("obj_param1", this.gHE);
            } else {
                amVar.x("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.gHF)) {
                amVar.aA("obj_param2", this.gHF);
            }
            if (!StringUtils.isNull(this.gHG)) {
                amVar.aA("obj_param3", this.gHG);
            }
            if (!StringUtils.isNull(this.arh)) {
                amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.arh);
            }
            if (!StringUtils.isNull(this.gHH)) {
                amVar.aA("ab_tag", this.gHH);
            } else {
                amVar.x("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.gHJ)) {
                amVar.aA("topic_type", this.gHJ);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                amVar.aA("extra", this.mExtra);
            } else {
                amVar.x("extra", 0);
            }
            if (!StringUtils.isNull(this.gHK)) {
                amVar.aA("is_vertical", this.gHK);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.aA("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z bsP() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.biz = this.biz;
        zVar.daG = this.daG;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.gHE = this.gHE;
        zVar.gHF = this.gHF;
        zVar.gHG = this.gHG;
        zVar.arh = this.arh;
        zVar.gHH = this.gHH;
        zVar.gHI = this.gHI;
        zVar.gHJ = this.gHJ;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
