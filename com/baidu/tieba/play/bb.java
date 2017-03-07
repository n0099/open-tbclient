package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bb {
    public String Vy;
    public String bqB;
    public String bqC;
    public String eXe;
    public String eXf;
    public String eXg;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.as f(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                asVar.Z("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bqB)) {
                asVar.Z("tid", this.bqB);
            }
            if (!StringUtils.isNull(this.bqC)) {
                asVar.Z("fid", this.bqC);
            }
            if (!StringUtils.isNull(this.mUid)) {
                asVar.Z(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.eXe)) {
                asVar.Z("obj_param1", this.eXe);
            }
            if (!StringUtils.isNull(this.eXf)) {
                asVar.Z("obj_param2", this.eXf);
            }
            if (!StringUtils.isNull(this.eXg)) {
                asVar.Z("obj_param3", this.eXg);
            }
            if (!StringUtils.isNull(this.Vy)) {
                asVar.Z("obj_id", this.Vy);
            }
        }
        return asVar;
    }
}
