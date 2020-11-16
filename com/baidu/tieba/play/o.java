package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class o {
    public String alZ;
    public String ezo;
    public String fyg;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;
    public String mkk;
    public String mkl;
    public String mkm;
    public int mkn;
    public String mko;
    public String mkp;
    public String mkq;
    public String mkr;
    public String mks;
    public String mkt;

    public ar f(ar arVar) {
        if (arVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                arVar.dR("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.alZ)) {
                arVar.dR("tid", this.alZ);
            }
            if (!StringUtils.isNull(this.fyg)) {
                arVar.dR("fid", this.fyg);
            }
            if (!StringUtils.isNull(this.mUid)) {
                arVar.dR("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                arVar.dR("obj_source", this.mSource);
            } else {
                arVar.ak("obj_source", 0);
            }
            if (!StringUtils.isNull(this.mkk)) {
                arVar.dR("obj_param1", this.mkk);
            } else {
                arVar.ak("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.mkl)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, this.mkl);
            }
            if (!StringUtils.isNull(this.mkm)) {
                arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, this.mkm);
            }
            if (this.mkn > 0) {
                arVar.ak("obj_param5", this.mkn);
            }
            if (!StringUtils.isNull(this.ezo)) {
                arVar.dR("obj_id", this.ezo);
            }
            if (!StringUtils.isNull(this.mko)) {
                arVar.dR("ab_tag", this.mko);
            } else {
                arVar.ak("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mkq)) {
                arVar.dR("topic_type", this.mkq);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                arVar.dR("extra", this.mExtra);
            } else {
                arVar.ak("extra", 0);
            }
            if (!StringUtils.isNull(this.mkr)) {
                arVar.dR("is_vertical", this.mkr);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                arVar.dR("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mks)) {
                arVar.dR("resource_id", this.mks);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                arVar.dR("group_id", this.mGroupId);
            }
            arVar.dR("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            arVar.dR("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            arVar.dR("nid", StringUtils.isNull(this.mkt) ? "" : this.mkt);
        }
        return arVar;
    }

    public o dwI() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.alZ = this.alZ;
        oVar.fyg = this.fyg;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.mkk = this.mkk;
        oVar.mkl = this.mkl;
        oVar.mkm = this.mkm;
        oVar.ezo = this.ezo;
        oVar.mko = this.mko;
        oVar.mkp = this.mkp;
        oVar.mkq = this.mkq;
        oVar.mFloor = this.mFloor;
        oVar.mks = this.mks;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.mkt = this.mkt;
        return oVar;
    }
}
