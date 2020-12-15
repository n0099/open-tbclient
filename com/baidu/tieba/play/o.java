package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class o {
    public String amY;
    public String eGn;
    public String fFV;
    public String mExtra;
    public String mFloor;
    public String mGroupId;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;
    public String myq;
    public String myr;
    public String mys;
    public int myt;
    public String myu;
    public String myv;
    public String myw;
    public String myx;
    public String myy;
    public String myz;

    public ar f(ar arVar) {
        if (arVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                arVar.dY("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.amY)) {
                arVar.dY("tid", this.amY);
            }
            if (!StringUtils.isNull(this.fFV)) {
                arVar.dY("fid", this.fFV);
            }
            if (!StringUtils.isNull(this.mUid)) {
                arVar.dY("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                arVar.dY("obj_source", this.mSource);
            } else {
                arVar.al("obj_source", 0);
            }
            if (!StringUtils.isNull(this.myq)) {
                arVar.dY("obj_param1", this.myq);
            } else {
                arVar.al("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.myr)) {
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, this.myr);
            }
            if (!StringUtils.isNull(this.mys)) {
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, this.mys);
            }
            if (this.myt > 0) {
                arVar.al("obj_param5", this.myt);
            }
            if (!StringUtils.isNull(this.eGn)) {
                arVar.dY("obj_id", this.eGn);
            }
            if (!StringUtils.isNull(this.myu)) {
                arVar.dY("ab_tag", this.myu);
            } else {
                arVar.al("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.myw)) {
                arVar.dY("topic_type", this.myw);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                arVar.dY("extra", this.mExtra);
            } else {
                arVar.al("extra", 0);
            }
            if (!StringUtils.isNull(this.myx)) {
                arVar.dY("is_vertical", this.myx);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                arVar.dY("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.myy)) {
                arVar.dY("resource_id", this.myy);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                arVar.dY("group_id", this.mGroupId);
            }
            arVar.dY("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            arVar.dY("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            arVar.dY("nid", StringUtils.isNull(this.myz) ? "" : this.myz);
        }
        return arVar;
    }

    public o dCb() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.amY = this.amY;
        oVar.fFV = this.fFV;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.myq = this.myq;
        oVar.myr = this.myr;
        oVar.mys = this.mys;
        oVar.eGn = this.eGn;
        oVar.myu = this.myu;
        oVar.myv = this.myv;
        oVar.myw = this.myw;
        oVar.mFloor = this.mFloor;
        oVar.myy = this.myy;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.myz = this.myz;
        return oVar;
    }
}
