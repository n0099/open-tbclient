package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class z {
    public String bZb;
    public String cmS;
    public String din;
    public String ePT;
    public String iza;
    public String izb;
    public String izc;
    public String izd;
    public String ize;
    public String izf;
    public String izg;
    public String izh;
    public String mFloor;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public an d(an anVar) {
        if (anVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                anVar.bS("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.cmS)) {
                anVar.bS("tid", this.cmS);
            }
            if (!StringUtils.isNull(this.ePT)) {
                anVar.bS("fid", this.ePT);
            }
            if (!StringUtils.isNull(this.mUid)) {
                anVar.bS("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                anVar.bS("obj_source", this.mSource);
            } else {
                anVar.O("obj_source", 0);
            }
            if (!StringUtils.isNull(this.iza)) {
                anVar.bS("obj_param1", this.iza);
            } else {
                anVar.O("obj_param1", 0);
            }
            if (!StringUtils.isNull(this.izb)) {
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM2, this.izb);
            }
            if (!StringUtils.isNull(this.izc)) {
                anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, this.izc);
            }
            if (!StringUtils.isNull(this.bZb)) {
                anVar.bS("obj_id", this.bZb);
            }
            if (!StringUtils.isNull(this.izd)) {
                anVar.bS(TiebaInitialize.Params.AB_TAG, this.izd);
            } else {
                anVar.O(TiebaInitialize.Params.AB_TAG, 0);
            }
            if (!StringUtils.isNull(this.izf)) {
                anVar.bS("topic_type", this.izf);
            }
            if (!StringUtils.isNull(this.din)) {
                anVar.bS("extra", this.din);
            } else {
                anVar.O("extra", 0);
            }
            if (!StringUtils.isNull(this.izg)) {
                anVar.bS("is_vertical", this.izg);
            }
            if (!StringUtils.isNull(this.mFloor)) {
                anVar.bS("obj_floor", this.mFloor);
            }
            if (!StringUtils.isNull(this.izh)) {
                anVar.bS("resource_id", this.izh);
            }
        }
        return anVar;
    }

    public z ccU() {
        z zVar = new z();
        zVar.mLocate = this.mLocate;
        zVar.mType = this.mType;
        zVar.cmS = this.cmS;
        zVar.ePT = this.ePT;
        zVar.mUid = this.mUid;
        zVar.mSource = this.mSource;
        zVar.iza = this.iza;
        zVar.izb = this.izb;
        zVar.izc = this.izc;
        zVar.bZb = this.bZb;
        zVar.izd = this.izd;
        zVar.ize = this.ize;
        zVar.izf = this.izf;
        zVar.mFloor = this.mFloor;
        zVar.izh = this.izh;
        return zVar;
    }
}
