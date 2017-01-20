package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
/* loaded from: classes.dex */
public class bb {
    public String Ql;
    public String bjS;
    public String bjT;
    public String eTA;
    public String eTy;
    public String eTz;
    public String mLocate;
    public String mSource;
    public String mUid;

    public com.baidu.tbadk.core.util.ar f(com.baidu.tbadk.core.util.ar arVar) {
        if (arVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                arVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bjS)) {
                arVar.ab("tid", this.bjS);
            }
            if (!StringUtils.isNull(this.bjT)) {
                arVar.ab("fid", this.bjT);
            }
            if (!StringUtils.isNull(this.mUid)) {
                arVar.ab(SapiAccountManager.SESSION_UID, this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.eTy)) {
                arVar.ab("obj_param1", this.eTy);
            }
            if (!StringUtils.isNull(this.eTz)) {
                arVar.ab("obj_param2", this.eTz);
            }
            if (!StringUtils.isNull(this.eTA)) {
                arVar.ab("obj_param3", this.eTA);
            }
            if (!StringUtils.isNull(this.Ql)) {
                arVar.ab("obj_id", this.Ql);
            }
        }
        return arVar;
    }
}
