package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class y {
    public String OC;
    public String cKC;
    public String fGQ;
    public String jsi;
    public String jsj;
    public String jsk;
    public String jsl;
    public String jsm;
    public String jsn;
    public String jso;
    public String mAbTag;
    public String mExtra;
    public String mFloor;
    public String mLocate;
    public String mNid;
    public String mSource;
    public String mType;
    public String mUid;
    public String mVid;

    public an d(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.cp("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.OC)) {
                anVar.cp("tid", this.OC);
            }
            if (!StringUtils.isNull(this.fGQ)) {
                anVar.cp("fid", this.fGQ);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.cp("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.cp("obj_source", this.mSource);
            } else {
                anVar.Z("obj_source", 0);
            }
            if (!StringUtils.isNull(this.jsi)) {
                anVar.cp("obj_param1", this.jsi);
            } else {
                anVar.Z("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.jsj)) {
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, this.jsj);
            }
            if (!StringUtils.isNull(this.jsk)) {
                anVar.cp(TiebaInitialize.Params.OBJ_PARAM3, this.jsk);
            }
            if (!StringUtils.isNull(this.cKC)) {
                anVar.cp("obj_id", this.cKC);
            }
            if (!StringUtils.isNull(this.mAbTag)) {
                anVar.cp(TiebaInitialize.Params.AB_TAG, this.mAbTag);
            } else {
                anVar.Z(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.jsm)) {
                anVar.cp("topic_type", this.jsm);
            }
            if (!StringUtils.isNull(this.mExtra)) {
                anVar.cp("extra", this.mExtra);
            } else {
                anVar.Z("extra", 0);
            }
            if (!StringUtils.isNull(this.jsn)) {
                anVar.cp("is_vertical", this.jsn);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.cp("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.jso)) {
                anVar.cp("resource_id", this.jso);
            }
            anVar.cp("obj_param4", StringUtils.isNull(this.mNid) ? "" : this.mNid);
            anVar.cp("obj_param6", StringUtils.isNull(this.mVid) ? "" : this.mVid);
        }
        return anVar;
    }

    public y cwO() {
        y yVar = new y();
        yVar.mLocate = this.mLocate;
        yVar.mType = this.mType;
        yVar.OC = this.OC;
        yVar.fGQ = this.fGQ;
        yVar.mUid = this.mUid;
        yVar.mSource = this.mSource;
        yVar.jsi = this.jsi;
        yVar.jsj = this.jsj;
        yVar.jsk = this.jsk;
        yVar.cKC = this.cKC;
        yVar.mAbTag = this.mAbTag;
        yVar.jsl = this.jsl;
        yVar.jsm = this.jsm;
        yVar.mFloor = this.mFloor;
        yVar.jso = this.jso;
        yVar.mNid = this.mNid;
        yVar.mVid = this.mVid;
        return yVar;
    }
}
