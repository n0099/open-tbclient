package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String OG;
    public String cKN;
    public String fKa;
    public String jvJ;
    public String jvK;
    public String jvL;
    public int jvM;
    public String jvN;
    public String jvO;
    public String jvP;
    public String jvQ;
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
            if (!StringUtils.isNull(this.jvJ)) {
                anVar.cp("obj_param1", this.jvJ);
            } else {
                anVar.Z("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jvK)) {
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, this.jvK);
            }
            if (!StringUtils.isNull(this.jvL)) {
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, this.jvL);
            }
            if (this.jvM > 0) {
                anVar.Z("obj_param5", this.jvM);
            }
            if (!StringUtils.isNull(this.cKN)) {
                anVar.cp("obj_id", this.cKN);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cp(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.Z(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jvO)) {
                anVar.cp("topic_type", this.jvO);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cp("extra", this.mExtra);
            } else {
                anVar.Z("extra", 0);
            }
            if (!StringUtils.isNull(this.jvP)) {
                anVar.cp("is_vertical", this.jvP);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cp("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jvQ)) {
                anVar.cp("resource_id", this.jvQ);
            }
            anVar.cp("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cp("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y cxV() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.OG = this.OG;
        yVar.fKa = this.fKa;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jvJ = this.jvJ;
        yVar.jvK = this.jvK;
        yVar.jvL = this.jvL;
        yVar.cKN = this.cKN;
        yVar.mAbTag = this.mAbTag;
        yVar.jvN = this.jvN;
        yVar.jvO = this.jvO;
        yVar.mFloor = this.mFloor;
        yVar.jvQ = this.jvQ;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
