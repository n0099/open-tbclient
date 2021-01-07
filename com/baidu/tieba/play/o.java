package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String anD;
    public String eQd;
    public String eVY;
    public String fPy;
    public String mDG;
    public String mDH;
    public String mDI;
    public int mDJ;
    public String mDK;
    public String mDL;
    public String mDM;
    public String mDN;
    public String mDO;
    public String mDP;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public aq f(aq aqVar) {
        if (aqVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                aqVar.dX("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.anD)) {
                aqVar.dX("tid", this.anD);
            }
            if (!StringUtils.isNull(this.fPy)) {
                aqVar.dX("fid", this.fPy);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dX("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dX("obj_source", this.mSource);
            } else {
                aqVar.an("obj_source", 0);
            }
            if (!StringUtils.isNull(this.mDG)) {
                aqVar.dX("obj_param1", this.mDG);
            } else {
                aqVar.an("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mDH)) {
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, this.mDH);
            }
            if (!StringUtils.isNull(this.mDI)) {
                aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, this.mDI);
            }
            if (this.mDJ > 0) {
                aqVar.an("obj_param5", this.mDJ);
            }
            if (!StringUtils.isNull(this.eQd)) {
                aqVar.dX("obj_id", this.eQd);
            }
            if (!StringUtils.isNull(this.mDK)) {
                aqVar.dX("ab_tag", this.mDK);
            } else {
                aqVar.an("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mDM)) {
                aqVar.dX("topic_type", this.mDM);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dX("extra", this.mExtra);
            } else {
                aqVar.an("extra", 0);
            }
            if (!StringUtils.isNull(this.mDN)) {
                aqVar.dX("is_vertical", this.mDN);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dX("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mDO)) {
                aqVar.dX("resource_id", this.mDO);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dX("group_id", this.mGroupId);
            }
            aqVar.dX("obj_param4", StringUtils.isNull(this.eVY) ? "" : this.eVY);
            aqVar.dX("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dX(IntentConfig.NID, StringUtils.isNull(this.mDP) ? "" : this.mDP);
        }
        return aqVar;
    }

    public o dBR() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.anD = this.anD;
        oVar.fPy = this.fPy;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mDG = this.mDG;
        oVar.mDH = this.mDH;
        oVar.mDI = this.mDI;
        oVar.eQd = this.eQd;
        oVar.mDK = this.mDK;
        oVar.mDL = this.mDL;
        oVar.mDM = this.mDM;
        oVar.mFloor = this.mFloor;
        oVar.mDO = this.mDO;
        oVar.mGroupId = this.mGroupId;
        oVar.eVY = this.eVY;
        oVar.mVid = this.mVid;
        oVar.mDP = this.mDP;
        return oVar;
    }
}
