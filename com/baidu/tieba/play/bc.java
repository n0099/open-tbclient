package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bc {
    public String UW;
    public String bxL;
    public String bxM;
    public String fmw;
    public String fmx;
    public String fmy;
    public String fmz;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.au f(com.baidu.tbadk.core.util.au auVar) {
        if (auVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                auVar.Z("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bxL)) {
                auVar.Z("tid", this.bxL);
            }
            if (!StringUtils.isNull(this.bxM)) {
                auVar.Z("fid", this.bxM);
            }
            if (!StringUtils.isNull(this.mUid)) {
                auVar.Z(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fmw)) {
                auVar.Z("obj_param1", this.fmw);
            }
            if (!StringUtils.isNull(this.fmx)) {
                auVar.Z("obj_param2", this.fmx);
            }
            if (!StringUtils.isNull(this.fmy)) {
                auVar.Z("obj_param3", this.fmy);
            }
            if (!StringUtils.isNull(this.UW)) {
                auVar.Z("obj_id", this.UW);
            }
            if (!StringUtils.isNull(this.fmz)) {
                auVar.Z("ab_tag", this.fmz);
            }
        }
        return auVar;
    }
}
