package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String byE;
    public String ctx;
    public String ekJ;
    public String ekN;
    public String hYA;
    public String hYB;
    public String hYC;
    public String hYD;
    public String hYE;
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
            if (!StringUtils.isNull(this.ctx)) {
                amVar.bJ("tid", this.ctx);
            }
            if (!StringUtils.isNull(this.ekN)) {
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.ekN);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.bJ("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.hYy)) {
                amVar.bJ("obj_param1", this.hYy);
            } else {
                amVar.T("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.hYz)) {
                amVar.bJ("obj_param2", this.hYz);
            }
            if (!StringUtils.isNull(this.hYA)) {
                amVar.bJ("obj_param3", this.hYA);
            }
            if (!StringUtils.isNull(this.byE)) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byE);
            }
            if (!StringUtils.isNull(this.hYB)) {
                amVar.bJ("ab_tag", this.hYB);
            } else {
                amVar.T("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.hYD)) {
                amVar.bJ("topic_type", this.hYD);
            }
            if (!StringUtils.isNull(this.ekJ)) {
                amVar.bJ("extra", this.ekJ);
            } else {
                amVar.T("extra", 0);
            }
            if (!StringUtils.isNull(this.hYE)) {
                amVar.bJ("is_vertical", this.hYE);
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
        zVar.ctx = this.ctx;
        zVar.ekN = this.ekN;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.hYy = this.hYy;
        zVar.hYz = this.hYz;
        zVar.hYA = this.hYA;
        zVar.byE = this.byE;
        zVar.hYB = this.hYB;
        zVar.hYC = this.hYC;
        zVar.hYD = this.hYD;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
