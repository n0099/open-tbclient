package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String byD;
    public String ctw;
    public String ekI;
    public String ekM;
    public String hYA;
    public String hYB;
    public String hYC;
    public String hYD;
    public String hYx;
    public String hYy;
    public String hYz;
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
            if (!StringUtils.isNull(this.ctw)) {
                amVar.bJ("tid", this.ctw);
            }
            if (!StringUtils.isNull(this.ekM)) {
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.ekM);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.bJ("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.hYx)) {
                amVar.bJ("obj_param1", this.hYx);
            } else {
                amVar.T("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.hYy)) {
                amVar.bJ("obj_param2", this.hYy);
            }
            if (!StringUtils.isNull(this.hYz)) {
                amVar.bJ("obj_param3", this.hYz);
            }
            if (!StringUtils.isNull(this.byD)) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byD);
            }
            if (!StringUtils.isNull(this.hYA)) {
                amVar.bJ("ab_tag", this.hYA);
            } else {
                amVar.T("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.hYC)) {
                amVar.bJ("topic_type", this.hYC);
            }
            if (!StringUtils.isNull(this.ekI)) {
                amVar.bJ("extra", this.ekI);
            } else {
                amVar.T("extra", 0);
            }
            if (!StringUtils.isNull(this.hYD)) {
                amVar.bJ("is_vertical", this.hYD);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.bJ("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z bTS() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.ctw = this.ctw;
        zVar.ekM = this.ekM;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.hYx = this.hYx;
        zVar.hYy = this.hYy;
        zVar.hYz = this.hYz;
        zVar.byD = this.byD;
        zVar.hYA = this.hYA;
        zVar.hYB = this.hYB;
        zVar.hYC = this.hYC;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
