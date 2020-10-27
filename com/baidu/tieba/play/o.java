package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String alT;
    public String eve;
    public String fsZ;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;
    public String mdS;
    public String mdT;
    public String mdU;
    public int mdV;
    public String mdW;
    public String mdX;
    public String mdY;
    public String mdZ;
    public String mea;
    public String meb;

    public aq f(aq aqVar) {
        if (aqVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                aqVar.dR("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.alT)) {
                aqVar.dR("tid", this.alT);
            }
            if (!StringUtils.isNull(this.fsZ)) {
                aqVar.dR("fid", this.fsZ);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dR("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dR("obj_source", this.mSource);
            } else {
                aqVar.aj("obj_source", 0);
            }
            if (!StringUtils.isNull(this.mdS)) {
                aqVar.dR("obj_param1", this.mdS);
            } else {
                aqVar.aj("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mdT)) {
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, this.mdT);
            }
            if (!StringUtils.isNull(this.mdU)) {
                aqVar.dR(TiebaInitialize.Params.OBJ_PARAM3, this.mdU);
            }
            if (this.mdV > 0) {
                aqVar.aj("obj_param5", this.mdV);
            }
            if (!StringUtils.isNull(this.eve)) {
                aqVar.dR("obj_id", this.eve);
            }
            if (!StringUtils.isNull(this.mdW)) {
                aqVar.dR("ab_tag", this.mdW);
            } else {
                aqVar.aj("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mdY)) {
                aqVar.dR("topic_type", this.mdY);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dR("extra", this.mExtra);
            } else {
                aqVar.aj("extra", 0);
            }
            if (!StringUtils.isNull(this.mdZ)) {
                aqVar.dR("is_vertical", this.mdZ);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dR("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mea)) {
                aqVar.dR("resource_id", this.mea);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dR("group_id", this.mGroupId);
            }
            aqVar.dR("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aqVar.dR("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dR("nid", StringUtils.isNull(this.meb) ? "" : this.meb);
        }
        return aqVar;
    }

    public o duG() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.alT = this.alT;
        oVar.fsZ = this.fsZ;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mdS = this.mdS;
        oVar.mdT = this.mdT;
        oVar.mdU = this.mdU;
        oVar.eve = this.eve;
        oVar.mdW = this.mdW;
        oVar.mdX = this.mdX;
        oVar.mdY = this.mdY;
        oVar.mFloor = this.mFloor;
        oVar.mea = this.mea;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.meb = this.meb;
        return oVar;
    }
}
