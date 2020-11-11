package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String alT;
    public String eAX;
    public String fyR;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;
    public String mjR;
    public String mjS;
    public String mjT;
    public int mjU;
    public String mjV;
    public String mjW;
    public String mjX;
    public String mjY;
    public String mjZ;
    public String mka;

    public aq f(aq aqVar) {
        if (aqVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                aqVar.dR("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.alT)) {
                aqVar.dR("tid", this.alT);
            }
            if (!StringUtils.isNull(this.fyR)) {
                aqVar.dR("fid", this.fyR);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dR("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dR("obj_source", this.mSource);
            } else {
                aqVar.al("obj_source", 0);
            }
            if (!StringUtils.isNull(this.mjR)) {
                aqVar.dR("obj_param1", this.mjR);
            } else {
                aqVar.al("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mjS)) {
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, this.mjS);
            }
            if (!StringUtils.isNull(this.mjT)) {
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, this.mjT);
            }
            if (this.mjU > 0) {
                aqVar.al("obj_param5", this.mjU);
            }
            if (!StringUtils.isNull(this.eAX)) {
                aqVar.dR("obj_id", this.eAX);
            }
            if (!StringUtils.isNull(this.mjV)) {
                aqVar.dR("ab_tag", this.mjV);
            } else {
                aqVar.al("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mjX)) {
                aqVar.dR("topic_type", this.mjX);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dR("extra", this.mExtra);
            } else {
                aqVar.al("extra", 0);
            }
            if (!StringUtils.isNull(this.mjY)) {
                aqVar.dR("is_vertical", this.mjY);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dR("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mjZ)) {
                aqVar.dR("resource_id", this.mjZ);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dR("group_id", this.mGroupId);
            }
            aqVar.dR("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aqVar.dR("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dR("nid", StringUtils.isNull(this.mka) ? "" : this.mka);
        }
        return aqVar;
    }

    public o dxi() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.alT = this.alT;
        oVar.fyR = this.fyR;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mjR = this.mjR;
        oVar.mjS = this.mjS;
        oVar.mjT = this.mjT;
        oVar.eAX = this.eAX;
        oVar.mjV = this.mjV;
        oVar.mjW = this.mjW;
        oVar.mjX = this.mjX;
        oVar.mFloor = this.mFloor;
        oVar.mjZ = this.mjZ;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.mka = this.mka;
        return oVar;
    }
}
