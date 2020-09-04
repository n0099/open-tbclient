package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String ala;
    public String dYs;
    public String eVx;
    public String ltn;
    public String lto;
    public String ltp;
    public int ltq;
    public String lts;
    public String ltt;
    public String ltu;
    public String ltv;
    public String ltw;
    public String ltx;
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
                aqVar.dD("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.ala)) {
                aqVar.dD("tid", this.ala);
            }
            if (!StringUtils.isNull(this.eVx)) {
                aqVar.dD("fid", this.eVx);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dD("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dD("obj_source", this.mSource);
            } else {
                aqVar.ai("obj_source", 0);
            }
            if (!StringUtils.isNull(this.ltn)) {
                aqVar.dD("obj_param1", this.ltn);
            } else {
                aqVar.ai("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.lto)) {
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, this.lto);
            }
            if (!StringUtils.isNull(this.ltp)) {
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, this.ltp);
            }
            if (this.ltq > 0) {
                aqVar.ai("obj_param5", this.ltq);
            }
            if (!StringUtils.isNull(this.dYs)) {
                aqVar.dD("obj_id", this.dYs);
            }
            if (!StringUtils.isNull(this.lts)) {
                aqVar.dD("ab_tag", this.lts);
            } else {
                aqVar.ai("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.ltu)) {
                aqVar.dD("topic_type", this.ltu);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dD("extra", this.mExtra);
            } else {
                aqVar.ai("extra", 0);
            }
            if (!StringUtils.isNull(this.ltv)) {
                aqVar.dD("is_vertical", this.ltv);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dD("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.ltw)) {
                aqVar.dD("resource_id", this.ltw);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dD("group_id", this.mGroupId);
            }
            aqVar.dD("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aqVar.dD("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dD("nid", StringUtils.isNull(this.ltx) ? "" : this.ltx);
        }
        return aqVar;
    }

    public o dkh() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.ala = this.ala;
        oVar.eVx = this.eVx;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.ltn = this.ltn;
        oVar.lto = this.lto;
        oVar.ltp = this.ltp;
        oVar.dYs = this.dYs;
        oVar.lts = this.lts;
        oVar.ltt = this.ltt;
        oVar.ltu = this.ltu;
        oVar.mFloor = this.mFloor;
        oVar.ltw = this.ltw;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.ltx = this.ltx;
        return oVar;
    }
}
