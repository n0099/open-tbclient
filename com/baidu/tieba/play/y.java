package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String OG;
    public String cKN;
    public String fKa;
    public String jvO;
    public String jvP;
    public String jvQ;
    public int jvR;
    public String jvS;
    public String jvT;
    public String jvU;
    public String jvV;
    public String mAbTag;
    public String mExtra;
    public String mFloor;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public an d(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.cp("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.OG)) {
                anVar.cp("tid", this.OG);
            }
            if (!StringUtils.isNull(this.fKa)) {
                anVar.cp("fid", this.fKa);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cp("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cp("obj_source", this.mSource);
            } else {
                anVar.Z("obj_source", 0);
            }
            if (!StringUtils.isNull(this.jvO)) {
                anVar.cp("obj_param1", this.jvO);
            } else {
                anVar.Z("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jvP)) {
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, this.jvP);
            }
            if (!StringUtils.isNull(this.jvQ)) {
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, this.jvQ);
            }
            if (this.jvR > 0) {
                anVar.Z("obj_param5", this.jvR);
            }
            if (!StringUtils.isNull(this.cKN)) {
                anVar.cp("obj_id", this.cKN);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cp(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.Z(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jvT)) {
                anVar.cp("topic_type", this.jvT);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cp("extra", this.mExtra);
            } else {
                anVar.Z("extra", 0);
            }
            if (!StringUtils.isNull(this.jvU)) {
                anVar.cp("is_vertical", this.jvU);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cp("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jvV)) {
                anVar.cp("resource_id", this.jvV);
            }
            anVar.cp("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cp("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y cxX() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.OG = this.OG;
        yVar.fKa = this.fKa;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jvO = this.jvO;
        yVar.jvP = this.jvP;
        yVar.jvQ = this.jvQ;
        yVar.cKN = this.cKN;
        yVar.mAbTag = this.mAbTag;
        yVar.jvS = this.jvS;
        yVar.jvT = this.jvT;
        yVar.mFloor = this.mFloor;
        yVar.jvV = this.jvV;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
