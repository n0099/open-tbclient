package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String alS;
    public String emE;
    public String fkA;
    public String lRA;
    public String lRB;
    public String lRC;
    public String lRD;
    public String lRu;
    public String lRv;
    public String lRw;
    public int lRx;
    public String lRy;
    public String lRz;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public aq f(aq aqVar) {
        if (aqVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                aqVar.dK("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.alS)) {
                aqVar.dK("tid", this.alS);
            }
            if (!StringUtils.isNull(this.fkA)) {
                aqVar.dK("fid", this.fkA);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dK("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dK("obj_source", this.mSource);
            } else {
                aqVar.aj("obj_source", 0);
            }
            if (!StringUtils.isNull(this.lRu)) {
                aqVar.dK("obj_param1", this.lRu);
            } else {
                aqVar.aj("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.lRv)) {
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, this.lRv);
            }
            if (!StringUtils.isNull(this.lRw)) {
                aqVar.dK(TiebaInitialize.Params.OBJ_PARAM3, this.lRw);
            }
            if (this.lRx > 0) {
                aqVar.aj("obj_param5", this.lRx);
            }
            if (!StringUtils.isNull(this.emE)) {
                aqVar.dK("obj_id", this.emE);
            }
            if (!StringUtils.isNull(this.lRy)) {
                aqVar.dK("ab_tag", this.lRy);
            } else {
                aqVar.aj("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.lRA)) {
                aqVar.dK("topic_type", this.lRA);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dK("extra", this.mExtra);
            } else {
                aqVar.aj("extra", 0);
            }
            if (!StringUtils.isNull(this.lRB)) {
                aqVar.dK("is_vertical", this.lRB);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dK("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.lRC)) {
                aqVar.dK("resource_id", this.lRC);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dK("group_id", this.mGroupId);
            }
            aqVar.dK("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aqVar.dK("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dK("nid", StringUtils.isNull(this.lRD) ? "" : this.lRD);
        }
        return aqVar;
    }

    public o drz() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.alS = this.alS;
        oVar.fkA = this.fkA;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.lRu = this.lRu;
        oVar.lRv = this.lRv;
        oVar.lRw = this.lRw;
        oVar.emE = this.emE;
        oVar.lRy = this.lRy;
        oVar.lRz = this.lRz;
        oVar.lRA = this.lRA;
        oVar.mFloor = this.mFloor;
        oVar.lRC = this.lRC;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.lRD = this.lRD;
        return oVar;
    }
}
