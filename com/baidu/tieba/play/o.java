package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes2.dex */
public class o {
    public String akY;
    public String dYo;
    public String eVt;
    public String ltc;
    public String ltd;
    public String lte;
    public int ltf;
    public String ltg;
    public String lth;
    public String lti;
    public String ltj;
    public String ltk;
    public String ltl;
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
            if (!StringUtils.isNull(this.akY)) {
                aqVar.dD("tid", this.akY);
            }
            if (!StringUtils.isNull(this.eVt)) {
                aqVar.dD("fid", this.eVt);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dD("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dD("obj_source", this.mSource);
            } else {
                aqVar.ai("obj_source", 0);
            }
            if (!StringUtils.isNull(this.ltc)) {
                aqVar.dD("obj_param1", this.ltc);
            } else {
                aqVar.ai("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.ltd)) {
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, this.ltd);
            }
            if (!StringUtils.isNull(this.lte)) {
                aqVar.dD(TiebaInitialize.Params.OBJ_PARAM3, this.lte);
            }
            if (this.ltf > 0) {
                aqVar.ai("obj_param5", this.ltf);
            }
            if (!StringUtils.isNull(this.dYo)) {
                aqVar.dD("obj_id", this.dYo);
            }
            if (!StringUtils.isNull(this.ltg)) {
                aqVar.dD("ab_tag", this.ltg);
            } else {
                aqVar.ai("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.lti)) {
                aqVar.dD("topic_type", this.lti);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dD("extra", this.mExtra);
            } else {
                aqVar.ai("extra", 0);
            }
            if (!StringUtils.isNull(this.ltj)) {
                aqVar.dD("is_vertical", this.ltj);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dD("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.ltk)) {
                aqVar.dD("resource_id", this.ltk);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dD("group_id", this.mGroupId);
            }
            aqVar.dD("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            aqVar.dD("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dD("nid", StringUtils.isNull(this.ltl) ? "" : this.ltl);
        }
        return aqVar;
    }

    public o dke() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.akY = this.akY;
        oVar.eVt = this.eVt;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.ltc = this.ltc;
        oVar.ltd = this.ltd;
        oVar.lte = this.lte;
        oVar.dYo = this.dYo;
        oVar.ltg = this.ltg;
        oVar.lth = this.lth;
        oVar.lti = this.lti;
        oVar.mFloor = this.mFloor;
        oVar.ltk = this.ltk;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.ltl = this.ltl;
        return oVar;
    }
}
