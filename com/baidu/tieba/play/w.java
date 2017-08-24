package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class w {
    public String WL;
    public String aAD;
    public String bDN;
    public String fCs;
    public String fCt;
    public String fCu;
    public String fCv;
    public String mLocate;
    public String mSource;
    public String mUid;

    public aj f(aj ajVar) {
        if (ajVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                ajVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bDN)) {
                ajVar.aa("tid", this.bDN);
            }
            if (!StringUtils.isNull(this.aAD)) {
                ajVar.aa("fid", this.aAD);
            }
            if (!StringUtils.isNull(this.mUid)) {
                ajVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fCs)) {
                ajVar.aa("obj_param1", this.fCs);
            }
            if (!StringUtils.isNull(this.fCt)) {
                ajVar.aa("obj_param2", this.fCt);
            }
            if (!StringUtils.isNull(this.fCu)) {
                ajVar.aa("obj_param3", this.fCu);
            }
            if (!StringUtils.isNull(this.WL)) {
                ajVar.aa("obj_id", this.WL);
            }
            if (!StringUtils.isNull(this.fCv)) {
                ajVar.aa("ab_tag", this.fCv);
            }
        }
        return ajVar;
    }
}
