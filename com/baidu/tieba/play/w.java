package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class w {
    public String WI;
    public String aAB;
    public String bDd;
    public String fAA;
    public String fAx;
    public String fAy;
    public String fAz;
    public String mLocate;
    public String mSource;
    public String mUid;

    public aj f(aj ajVar) {
        if (ajVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                ajVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bDd)) {
                ajVar.aa("tid", this.bDd);
            }
            if (!StringUtils.isNull(this.aAB)) {
                ajVar.aa("fid", this.aAB);
            }
            if (!StringUtils.isNull(this.mUid)) {
                ajVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fAx)) {
                ajVar.aa("obj_param1", this.fAx);
            }
            if (!StringUtils.isNull(this.fAy)) {
                ajVar.aa("obj_param2", this.fAy);
            }
            if (!StringUtils.isNull(this.fAz)) {
                ajVar.aa("obj_param3", this.fAz);
            }
            if (!StringUtils.isNull(this.WI)) {
                ajVar.aa("obj_id", this.WI);
            }
            if (!StringUtils.isNull(this.fAA)) {
                ajVar.aa("ab_tag", this.fAA);
            }
        }
        return ajVar;
    }
}
