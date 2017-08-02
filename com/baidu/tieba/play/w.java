package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class w {
    public String Vm;
    public String azk;
    public String bBT;
    public String fzl;
    public String fzm;
    public String fzn;
    public String fzo;
    public String mLocate;
    public String mSource;
    public String mUid;

    public aj f(aj ajVar) {
        if (ajVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                ajVar.aa("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bBT)) {
                ajVar.aa("tid", this.bBT);
            }
            if (!StringUtils.isNull(this.azk)) {
                ajVar.aa("fid", this.azk);
            }
            if (!StringUtils.isNull(this.mUid)) {
                ajVar.aa(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fzl)) {
                ajVar.aa("obj_param1", this.fzl);
            }
            if (!StringUtils.isNull(this.fzm)) {
                ajVar.aa("obj_param2", this.fzm);
            }
            if (!StringUtils.isNull(this.fzn)) {
                ajVar.aa("obj_param3", this.fzn);
            }
            if (!StringUtils.isNull(this.Vm)) {
                ajVar.aa("obj_id", this.Vm);
            }
            if (!StringUtils.isNull(this.fzo)) {
                ajVar.aa("ab_tag", this.fzo);
            }
        }
        return ajVar;
    }
}
