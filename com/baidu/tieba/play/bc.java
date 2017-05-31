package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bc {
    public String UX;
    public String buq;
    public String bur;
    public String fcg;
    public String fch;
    public String fci;
    public String fcj;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.as f(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                asVar.Z("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.buq)) {
                asVar.Z("tid", this.buq);
            }
            if (!StringUtils.isNull(this.bur)) {
                asVar.Z("fid", this.bur);
            }
            if (!StringUtils.isNull(this.mUid)) {
                asVar.Z(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fcg)) {
                asVar.Z("obj_param1", this.fcg);
            }
            if (!StringUtils.isNull(this.fch)) {
                asVar.Z("obj_param2", this.fch);
            }
            if (!StringUtils.isNull(this.fci)) {
                asVar.Z("obj_param3", this.fci);
            }
            if (!StringUtils.isNull(this.UX)) {
                asVar.Z("obj_id", this.UX);
            }
            if (!StringUtils.isNull(this.fcj)) {
                asVar.Z("ab_tag", this.fcj);
            }
        }
        return asVar;
    }
}
