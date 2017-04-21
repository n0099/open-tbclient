package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bb {
    public String VR;
    public String bsL;
    public String bsM;
    public String eXt;
    public String eXu;
    public String eXv;
    public String eXw;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.as f(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                asVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bsL)) {
                asVar.aa("tid", this.bsL);
            }
            if (!StringUtils.isNull(this.bsM)) {
                asVar.aa("fid", this.bsM);
            }
            if (!StringUtils.isNull(this.mUid)) {
                asVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.eXt)) {
                asVar.aa("obj_param1", this.eXt);
            }
            if (!StringUtils.isNull(this.eXu)) {
                asVar.aa("obj_param2", this.eXu);
            }
            if (!StringUtils.isNull(this.eXv)) {
                asVar.aa("obj_param3", this.eXv);
            }
            if (!StringUtils.isNull(this.VR)) {
                asVar.aa("obj_id", this.VR);
            }
            if (!StringUtils.isNull(this.eXw)) {
                asVar.aa("ab_tag", this.eXw);
            }
        }
        return asVar;
    }
}
