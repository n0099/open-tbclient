package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class w {
    public String WK;
    public String aAC;
    public String bDM;
    public String fCq;
    public String fCr;
    public String fCs;
    public String fCt;
    public String mLocate;
    public String mSource;
    public String mUid;

    public aj f(aj ajVar) {
        if (ajVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                ajVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bDM)) {
                ajVar.aa("tid", this.bDM);
            }
            if (!StringUtils.isNull(this.aAC)) {
                ajVar.aa("fid", this.aAC);
            }
            if (!StringUtils.isNull(this.mUid)) {
                ajVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fCq)) {
                ajVar.aa("obj_param1", this.fCq);
            }
            if (!StringUtils.isNull(this.fCr)) {
                ajVar.aa("obj_param2", this.fCr);
            }
            if (!StringUtils.isNull(this.fCs)) {
                ajVar.aa("obj_param3", this.fCs);
            }
            if (!StringUtils.isNull(this.WK)) {
                ajVar.aa("obj_id", this.WK);
            }
            if (!StringUtils.isNull(this.fCt)) {
                ajVar.aa("ab_tag", this.fCt);
            }
        }
        return ajVar;
    }
}
