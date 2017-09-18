package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class w {
    public String VU;
    public String azL;
    public String bHy;
    public String fBN;
    public String fBO;
    public String fBP;
    public String fBQ;
    public String fBR;
    public String mLocate;
    public String mSource;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ad("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bHy)) {
                akVar.ad("tid", this.bHy);
            }
            if (!StringUtils.isNull(this.azL)) {
                akVar.ad("fid", this.azL);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ad(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.fBN)) {
                akVar.ad("obj_param1", this.fBN);
            }
            if (!StringUtils.isNull(this.fBO)) {
                akVar.ad("obj_param2", this.fBO);
            }
            if (!StringUtils.isNull(this.fBP)) {
                akVar.ad("obj_param3", this.fBP);
            }
            if (!StringUtils.isNull(this.VU)) {
                akVar.ad("obj_id", this.VU);
            }
            if (!StringUtils.isNull(this.fBQ)) {
                akVar.ad("ab_tag", this.fBQ);
            }
        }
        return akVar;
    }
}
