package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class aa {
    public String aMq;
    public String bCS;
    public String cZI;
    public String gvL;
    public String gvM;
    public String gvN;
    public String gvO;
    public String gvP;
    public String gvQ;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bCS)) {
                akVar.ab("tid", this.bCS);
            }
            if (!StringUtils.isNull(this.cZI)) {
                akVar.ab(ImageViewerConfig.FORUM_ID, this.cZI);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.gvL)) {
                akVar.ab("obj_param1", this.gvL);
            }
            if (!StringUtils.isNull(this.gvM)) {
                akVar.ab("obj_param2", this.gvM);
            }
            if (!StringUtils.isNull(this.gvN)) {
                akVar.ab("obj_param3", this.gvN);
            }
            if (!StringUtils.isNull(this.aMq)) {
                akVar.ab("obj_id", this.aMq);
            }
            if (!StringUtils.isNull(this.gvO)) {
                akVar.ab("ab_tag", this.gvO);
            }
            if (!StringUtils.isNull(this.gvQ)) {
                akVar.ab("topic_type", this.gvQ);
            }
        }
        return akVar;
    }

    public aa blV() {
        aa aaVar = new aa();
        aaVar.mLocate = this.mLocate;
        aaVar.mType = this.mType;
        aaVar.bCS = this.bCS;
        aaVar.cZI = this.cZI;
        aaVar.mUid = this.mUid;
        aaVar.mSource = this.mSource;
        aaVar.gvL = this.gvL;
        aaVar.gvM = this.gvM;
        aaVar.gvN = this.gvN;
        aaVar.aMq = this.aMq;
        aaVar.gvO = this.gvO;
        aaVar.gvP = this.gvP;
        aaVar.gvQ = this.gvQ;
        return aaVar;
    }
}
