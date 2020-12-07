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
    public String myo;
    public String myp;
    public String myq;
    public int myr;
    public String mys;
    public String myt;
    public String myu;
    public String myv;
    public String myw;
    public String myx;

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
            if (!StringUtils.isNull(this.myo)) {
                arVar.dY("obj_param1", this.myo);
            } else {
                arVar.al("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.myp)) {
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, this.myp);
            }
            if (!StringUtils.isNull(this.myq)) {
                arVar.dY(TiebaInitialize.Params.OBJ_PARAM3, this.myq);
            }
            if (this.myr > 0) {
                arVar.al("obj_param5", this.myr);
            }
            if (!StringUtils.isNull(this.eGn)) {
                arVar.dY("obj_id", this.eGn);
            }
            if (!StringUtils.isNull(this.mys)) {
                arVar.dY("ab_tag", this.mys);
            } else {
                arVar.al("ab_tag", 0);
            }
            if (!StringUtils.isNull(this.myu)) {
                arVar.dY("topic_type", this.myu);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                arVar.dY("extra", this.mExtra);
            } else {
                arVar.al("extra", 0);
            }
            if (!StringUtils.isNull(this.myv)) {
                arVar.dY("is_vertical", this.myv);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                arVar.dY("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.myw)) {
                arVar.dY("resource_id", this.myw);
            }
            if (!StringUtils.isNull(this.mGroupId)) {
                arVar.dY("group_id", this.mGroupId);
            }
            arVar.dY("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            arVar.dY("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
            arVar.dY("nid", StringUtils.isNull(this.myx) ? "" : this.myx);
        }
        return arVar;
    }

    public o dCa() {
        o oVar = new o();
        oVar.mLocate = this.mLocate;
        oVar.mType = this.mType;
        oVar.amY = this.amY;
        oVar.fFV = this.fFV;
        oVar.mUid = this.mUid;
        oVar.mSource = this.mSource;
        oVar.myo = this.myo;
        oVar.myp = this.myp;
        oVar.myq = this.myq;
        oVar.eGn = this.eGn;
        oVar.mys = this.mys;
        oVar.myt = this.myt;
        oVar.myu = this.myu;
        oVar.mFloor = this.mFloor;
        oVar.myw = this.myw;
        oVar.mGroupId = this.mGroupId;
        oVar.mNid = this.mNid;
        oVar.mVid = this.mVid;
        oVar.myx = this.myx;
        return oVar;
    }
}
