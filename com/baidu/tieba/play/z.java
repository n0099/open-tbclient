package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String byA;
    public String ctu;
    public String ekW;
    public String ela;
    public String hYL;
    public String hYM;
    public String hYN;
    public String hYO;
    public String hYP;
    public String hYQ;
    public String hYR;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public am c(am amVar) {
        if (amVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                amVar.bJ("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.ctu)) {
                amVar.bJ("tid", this.ctu);
            }
            if (!StringUtils.isNull(this.ela)) {
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.ela);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.bJ("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.hYL)) {
                amVar.bJ("obj_param1", this.hYL);
            } else {
                amVar.T("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.hYM)) {
                amVar.bJ("obj_param2", this.hYM);
            }
            if (!StringUtils.isNull(this.hYN)) {
                amVar.bJ("obj_param3", this.hYN);
            }
            if (!StringUtils.isNull(this.byA)) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byA);
            }
            if (!StringUtils.isNull(this.hYO)) {
                amVar.bJ("ab_tag", this.hYO);
            } else {
                amVar.T("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.hYQ)) {
                amVar.bJ("topic_type", this.hYQ);
            }
            if (!StringUtils.isNull(this.ekW)) {
                amVar.bJ("extra", this.ekW);
            } else {
                amVar.T("extra", 0);
            }
            if (!StringUtils.isNull(this.hYR)) {
                amVar.bJ("is_vertical", this.hYR);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.bJ("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z bTW() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.ctu = this.ctu;
        zVar.ela = this.ela;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.hYL = this.hYL;
        zVar.hYM = this.hYM;
        zVar.hYN = this.hYN;
        zVar.byA = this.byA;
        zVar.hYO = this.hYO;
        zVar.hYP = this.hYP;
        zVar.hYQ = this.hYQ;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
