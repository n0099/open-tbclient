package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class x {
    public String VW;
    public String ayT;
    public String cyL;
    public String fxN;
    public String fxO;
    public String fxP;
    public String fxQ;
    public String fxR;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ac("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.cyL)) {
                akVar.ac("tid", this.cyL);
            }
            if (!StringUtils.isNull(this.ayT)) {
                akVar.ac("fid", this.ayT);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ac(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fxN)) {
                akVar.ac("obj_param1", this.fxN);
            }
            if (!StringUtils.isNull(this.fxO)) {
                akVar.ac("obj_param2", this.fxO);
            }
            if (!StringUtils.isNull(this.fxP)) {
                akVar.ac("obj_param3", this.fxP);
            }
            if (!StringUtils.isNull(this.VW)) {
                akVar.ac("obj_id", this.VW);
            }
            if (!StringUtils.isNull(this.fxQ)) {
                akVar.ac("ab_tag", this.fxQ);
            }
        }
        return akVar;
    }

    public x bez() {
        x xVar = new x();
        xVar.mLocate = this.mLocate;
        xVar.mType = this.mType;
        xVar.cyL = this.cyL;
        xVar.ayT = this.ayT;
        xVar.mUid = this.mUid;
        xVar.mSource = this.mSource;
        xVar.fxN = this.fxN;
        xVar.fxO = this.fxO;
        xVar.fxP = this.fxP;
        xVar.VW = this.VW;
        xVar.fxQ = this.fxQ;
        xVar.fxR = this.fxR;
        return xVar;
    }
}
