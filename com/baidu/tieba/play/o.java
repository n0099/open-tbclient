package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class o {
    public String amM;
    public String eLs;
    public String eRn;
    public String fKR;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;
    public String myX;
    public String myY;
    public String myZ;
    public int mza;
    public String mzb;
    public String mzc;
    public String mzd;
    public String mze;
    public String mzf;
    public String mzg;

    public aq f(aq aqVar) {
        if (aqVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                aqVar.dW("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.amM)) {
                aqVar.dW("tid", this.amM);
            }
            if (!StringUtils.isNull(this.fKR)) {
                aqVar.dW("fid", this.fKR);
            }
            if (!StringUtils.isNull(this.mUid)) {
                aqVar.dW("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                aqVar.dW("obj_source", this.mSource);
            } else {
                aqVar.an("obj_source", 0);
            }
            if (!StringUtils.isNull(this.myX)) {
                aqVar.dW("obj_param1", this.myX);
            } else {
                aqVar.an("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.myY)) {
                aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, this.myY);
            }
            if (!StringUtils.isNull(this.myZ)) {
                aqVar.dW(TiebaInitialize.Params.OBJ_PARAM3, this.myZ);
            }
            if (this.mza > 0) {
                aqVar.an("obj_param5", this.mza);
            }
            if (!StringUtils.isNull(this.eLs)) {
                aqVar.dW("obj_id", this.eLs);
            }
            if (!StringUtils.isNull(this.mzb)) {
                aqVar.dW("ab_tag", this.mzb);
            } else {
                aqVar.an("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.mzd)) {
                aqVar.dW("topic_type", this.mzd);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                aqVar.dW("extra", this.mExtra);
            } else {
                aqVar.an("extra", 0);
            }
            if (!StringUtils.isNull(this.mze)) {
                aqVar.dW("is_vertical", this.mze);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                aqVar.dW("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.mzf)) {
                aqVar.dW("resource_id", this.mzf);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                aqVar.dW("group_id", this.mGroupId);
            }
            aqVar.dW("obj_param4", StringUtils.isNull(this.eRn) ? "" : this.eRn);
            aqVar.dW("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            aqVar.dW(IntentConfig.NID, StringUtils.isNull(this.mzg) ? "" : this.mzg);
        }
        return aqVar;
    }

    public o dxZ() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.amM = this.amM;
        oVar.fKR = this.fKR;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.myX = this.myX;
        oVar.myY = this.myY;
        oVar.myZ = this.myZ;
        oVar.eLs = this.eLs;
        oVar.mzb = this.mzb;
        oVar.mzc = this.mzc;
        oVar.mzd = this.mzd;
        oVar.mFloor = this.mFloor;
        oVar.mzf = this.mzf;
        oVar.mGroupId = this.mGroupId;
        oVar.eRn = this.eRn;
        oVar.mVid = this.mVid;
        oVar.mzg = this.mzg;
        return oVar;
    }
}
