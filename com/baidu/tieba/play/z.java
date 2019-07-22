package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class z {
    public String bGR;
    public String bWO;
    public String eFu;
    public String eFy;
    public String ixA;
    public String ixB;
    public String ixC;
    public String ixD;
    public String ixE;
    public String ixF;
    public String ixy;
    public String ixz;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an d(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.bT("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bWO)) {
                anVar.bT("tid", this.bWO);
            }
            if (!StringUtils.isNull(this.eFy)) {
                anVar.bT("fid", this.eFy);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.bT("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.ixy)) {
                anVar.bT("obj_param1", this.ixy);
            } else {
                anVar.P("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.ixz)) {
                anVar.bT("obj_param2", this.ixz);
            }
            if (!StringUtils.isNull(this.ixA)) {
                anVar.bT("obj_param3", this.ixA);
            }
            if (!StringUtils.isNull(this.bGR)) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bGR);
            }
            if (!StringUtils.isNull(this.ixB)) {
                anVar.bT("ab_tag", this.ixB);
            } else {
                anVar.P("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.ixD)) {
                anVar.bT("topic_type", this.ixD);
            }
            if (!StringUtils.isNull(this.eFu)) {
                anVar.bT("extra", this.eFu);
            } else {
                anVar.P("extra", 0);
            }
            if (!StringUtils.isNull(this.ixE)) {
                anVar.bT("is_vertical", this.ixE);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.bT("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.ixF)) {
                anVar.bT("resource_id", this.ixF);
            }
        }
        return anVar;
    }

    public z ceN() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bWO = this.bWO;
        zVar.eFy = this.eFy;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.ixy = this.ixy;
        zVar.ixz = this.ixz;
        zVar.ixA = this.ixA;
        zVar.bGR = this.bGR;
        zVar.ixB = this.ixB;
        zVar.ixC = this.ixC;
        zVar.ixD = this.ixD;
        zVar.mFloor = this.mFloor;
        zVar.ixF = this.ixF;
        return zVar;
    }
}
