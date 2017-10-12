package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class x {
    public String Wi;
    public String azf;
    public String cyX;
    public String fyb;
    public String fyc;
    public String fyd;
    public String fye;
    public String fyf;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ad("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.cyX)) {
                akVar.ad("tid", this.cyX);
            }
            if (!StringUtils.isNull(this.azf)) {
                akVar.ad("fid", this.azf);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ad(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fyb)) {
                akVar.ad("obj_param1", this.fyb);
            }
            if (!StringUtils.isNull(this.fyc)) {
                akVar.ad("obj_param2", this.fyc);
            }
            if (!StringUtils.isNull(this.fyd)) {
                akVar.ad("obj_param3", this.fyd);
            }
            if (!StringUtils.isNull(this.Wi)) {
                akVar.ad("obj_id", this.Wi);
            }
            if (!StringUtils.isNull(this.fye)) {
                akVar.ad("ab_tag", this.fye);
            }
        }
        return akVar;
    }

    public x beE() {
        x xVar = new x();
        xVar.mLocate = this.mLocate;
        xVar.mType = this.mType;
        xVar.cyX = this.cyX;
        xVar.azf = this.azf;
        xVar.mUid = this.mUid;
        xVar.mSource = this.mSource;
        xVar.fyb = this.fyb;
        xVar.fyc = this.fyc;
        xVar.fyd = this.fyd;
        xVar.Wi = this.Wi;
        xVar.fye = this.fye;
        xVar.fyf = this.fyf;
        return xVar;
    }
}
