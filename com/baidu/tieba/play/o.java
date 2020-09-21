package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String alA;
    public String eYo;
    public String eaC;
    public String lCf;
    public String lCg;
    public String lCh;
    public int lCi;
    public String lCj;
    public String lCk;
    public String lCl;
    public String lCm;
    public String lCn;
    public String lCo;
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
                aqVar.dF("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.alA)) {
                aqVar.dF("tid", this.alA);
            }
            if (!StringUtils.isNull(this.eYo)) {
                aqVar.dF("fid", this.eYo);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dF("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dF("obj_source", this.mSource);
            } else {
                aqVar.ai("obj_source", 0);
            }
            if (!StringUtils.isNull(this.lCf)) {
                aqVar.dF("obj_param1", this.lCf);
            } else {
                aqVar.ai("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.lCg)) {
                aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, this.lCg);
            }
            if (!StringUtils.isNull(this.lCh)) {
                aqVar.dF(TiebaInitialize.Params.OBJ_PARAM3, this.lCh);
            }
            if (this.lCi > 0) {
                aqVar.ai("obj_param5", this.lCi);
            }
            if (!StringUtils.isNull(this.eaC)) {
                aqVar.dF("obj_id", this.eaC);
            }
            if (!StringUtils.isNull(this.lCj)) {
                aqVar.dF("ab_tag", this.lCj);
            } else {
                aqVar.ai("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.lCl)) {
                aqVar.dF("topic_type", this.lCl);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dF("extra", this.mExtra);
            } else {
                aqVar.ai("extra", 0);
            }
            if (!StringUtils.isNull(this.lCm)) {
                aqVar.dF("is_vertical", this.lCm);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dF("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.lCn)) {
                aqVar.dF("resource_id", this.lCn);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dF("group_id", this.mGroupId);
            }
            aqVar.dF("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aqVar.dF("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dF("nid", StringUtils.isNull(this.lCo) ? "" : this.lCo);
        }
        return aqVar;
    }

    public o dnO() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.alA = this.alA;
        oVar.eYo = this.eYo;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.lCf = this.lCf;
        oVar.lCg = this.lCg;
        oVar.lCh = this.lCh;
        oVar.eaC = this.eaC;
        oVar.lCj = this.lCj;
        oVar.lCk = this.lCk;
        oVar.lCl = this.lCl;
        oVar.mFloor = this.mFloor;
        oVar.lCn = this.lCn;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.lCo = this.lCo;
        return oVar;
    }
}
