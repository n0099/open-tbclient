package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bb {
    public String VP;
    public String bqu;
    public String bqv;
    public String eVd;
    public String eVe;
    public String eVf;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.as f(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                asVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bqu)) {
                asVar.aa("tid", this.bqu);
            }
            if (!StringUtils.isNull(this.bqv)) {
                asVar.aa("fid", this.bqv);
            }
            if (!StringUtils.isNull(this.mUid)) {
                asVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.eVd)) {
                asVar.aa("obj_param1", this.eVd);
            }
            if (!StringUtils.isNull(this.eVe)) {
                asVar.aa("obj_param2", this.eVe);
            }
            if (!StringUtils.isNull(this.eVf)) {
                asVar.aa("obj_param3", this.eVf);
            }
            if (!StringUtils.isNull(this.VP)) {
                asVar.aa("obj_id", this.VP);
            }
        }
        return asVar;
    }
}
