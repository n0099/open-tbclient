package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class z {
    public String bGS;
    public String bWU;
    public String eFB;
    public String eFF;
    public String iyB;
    public String iyC;
    public String iyD;
    public String iyE;
    public String iyF;
    public String iyG;
    public String iyH;
    public String iyI;
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
            if (!StringUtils.isNull(this.bWU)) {
                anVar.bT("tid", this.bWU);
            }
            if (!StringUtils.isNull(this.eFF)) {
                anVar.bT("fid", this.eFF);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.bT("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            } else {
                anVar.P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 0);
            }
            if (!StringUtils.isNull(this.iyB)) {
                anVar.bT("obj_param1", this.iyB);
            } else {
                anVar.P("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.iyC)) {
                anVar.bT("obj_param2", this.iyC);
            }
            if (!StringUtils.isNull(this.iyD)) {
                anVar.bT("obj_param3", this.iyD);
            }
            if (!StringUtils.isNull(this.bGS)) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.bGS);
            }
            if (!StringUtils.isNull(this.iyE)) {
                anVar.bT("ab_tag", this.iyE);
            } else {
                anVar.P("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.iyG)) {
                anVar.bT("topic_type", this.iyG);
            }
            if (!StringUtils.isNull(this.eFB)) {
                anVar.bT("extra", this.eFB);
            } else {
                anVar.P("extra", 0);
            }
            if (!StringUtils.isNull(this.iyH)) {
                anVar.bT("is_vertical", this.iyH);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.bT("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.iyI)) {
                anVar.bT("resource_id", this.iyI);
            }
        }
        return anVar;
    }

    public z cff() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.bWU = this.bWU;
        zVar.eFF = this.eFF;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.iyB = this.iyB;
        zVar.iyC = this.iyC;
        zVar.iyD = this.iyD;
        zVar.bGS = this.bGS;
        zVar.iyE = this.iyE;
        zVar.iyF = this.iyF;
        zVar.iyG = this.iyG;
        zVar.mFloor = this.mFloor;
        zVar.iyI = this.iyI;
        return zVar;
    }
}
