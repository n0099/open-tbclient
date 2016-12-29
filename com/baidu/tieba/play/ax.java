package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes.dex */
public class ax {
    public String aRe;
    public String aRf;
    public String eKb;
    public String eKc;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.at f(com.baidu.tbadk.core.util.at atVar) {
        if (atVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                atVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aRf)) {
                atVar.ab("tid", this.aRf);
            }
            if (!StringUtils.isNull(this.aRe)) {
                atVar.ab("fid", this.aRe);
            }
            if (!StringUtils.isNull(this.mUid)) {
                atVar.ab(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                atVar.ab("obj_source", this.mSource);
            }
            if (!StringUtils.isNull(this.eKb)) {
                atVar.ab("obj_param1", this.eKb);
            }
            if (!StringUtils.isNull(this.eKc)) {
                atVar.ab("obj_param2", this.eKc);
            }
        }
        return atVar;
    }
}
