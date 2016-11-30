package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ax {
    public String aRN;
    public String aRO;
    public String fgJ;
    public String fgK;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.av f(com.baidu.tbadk.core.util.av avVar) {
        if (avVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                avVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aRO)) {
                avVar.ab("tid", this.aRO);
            }
            if (!StringUtils.isNull(this.aRN)) {
                avVar.ab("fid", this.aRN);
            }
            if (!StringUtils.isNull(this.mUid)) {
                avVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                avVar.ab("obj_source", this.mSource);
            }
            if (!StringUtils.isNull(this.fgJ)) {
                avVar.ab("obj_param1", this.fgJ);
            }
            if (!StringUtils.isNull(this.fgK)) {
                avVar.ab("obj_param2", this.fgK);
            }
        }
        return avVar;
    }
}
