package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class z {
    public String byy;
    public String ctx;
    public String ela;
    public String ele;
    public String hYR;
    public String hYS;
    public String hYT;
    public String hYU;
    public String hYV;
    public String hYW;
    public String hYX;
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
            if (!StringUtils.isNull(this.ele)) {
                amVar.bJ(ImageViewerConfig.FORUM_ID, this.ele);
            }
            if (!StringUtils.isNull(this.mUid)) {
                amVar.bJ("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.hYR)) {
                amVar.bJ("obj_param1", this.hYR);
            } else {
                amVar.T("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.hYS)) {
                amVar.bJ("obj_param2", this.hYS);
            }
            if (!StringUtils.isNull(this.hYT)) {
                amVar.bJ("obj_param3", this.hYT);
            }
            if (!StringUtils.isNull(this.byy)) {
                amVar.bJ(VideoPlayActivityConfig.OBJ_ID, this.byy);
            }
            if (!StringUtils.isNull(this.hYU)) {
                amVar.bJ("ab_tag", this.hYU);
            } else {
                amVar.T("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.hYW)) {
                amVar.bJ("topic_type", this.hYW);
            }
            if (!StringUtils.isNull(this.ela)) {
                amVar.bJ("extra", this.ela);
            } else {
                amVar.T("extra", 0);
            }
            if (!StringUtils.isNull(this.hYX)) {
                amVar.bJ("is_vertical", this.hYX);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                amVar.bJ("obj_floor", this.mFloor);
            }
        }
        return amVar;
    }

    public z bTU() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.ctx = this.ctx;
        zVar.ele = this.ele;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.hYR = this.hYR;
        zVar.hYS = this.hYS;
        zVar.hYT = this.hYT;
        zVar.byy = this.byy;
        zVar.hYU = this.hYU;
        zVar.hYV = this.hYV;
        zVar.hYW = this.hYW;
        zVar.mFloor = this.mFloor;
        return zVar;
    }
}
