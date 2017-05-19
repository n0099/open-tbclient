package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bb {
    public String Vk;
    public String bti;
    public String btj;
    public String eTt;
    public String eTu;
    public String eTv;
    public String eTw;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.as f(com.baidu.tbadk.core.util.as asVar) {
        if (asVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                asVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bti)) {
                asVar.aa("tid", this.bti);
            }
            if (!StringUtils.isNull(this.btj)) {
                asVar.aa("fid", this.btj);
            }
            if (!StringUtils.isNull(this.mUid)) {
                asVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.eTt)) {
                asVar.aa("obj_param1", this.eTt);
            }
            if (!StringUtils.isNull(this.eTu)) {
                asVar.aa("obj_param2", this.eTu);
            }
            if (!StringUtils.isNull(this.eTv)) {
                asVar.aa("obj_param3", this.eTv);
            }
            if (!StringUtils.isNull(this.Vk)) {
                asVar.aa("obj_id", this.Vk);
            }
            if (!StringUtils.isNull(this.eTw)) {
                asVar.aa("ab_tag", this.eTw);
            }
        }
        return asVar;
    }
}
