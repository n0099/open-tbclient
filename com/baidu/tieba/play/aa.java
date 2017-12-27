package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class aa {
    public String aLg;
    public String bAK;
    public String cSk;
    public String gEO;
    public String gEP;
    public String gEQ;
    public String gER;
    public String gES;
    public String mLocate;
    public String mSource;
    public String mType;
    public String mUid;

    public ak f(ak akVar) {
        if (akVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                akVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.bAK)) {
                akVar.ab("tid", this.bAK);
            }
            if (!StringUtils.isNull(this.cSk)) {
                akVar.ab(ImageViewerConfig.FORUM_ID, this.cSk);
            }
            if (!StringUtils.isNull(this.mUid)) {
                akVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mSource);
            }
            if (!StringUtils.isNull(this.gEO)) {
                akVar.ab("obj_param1", this.gEO);
            }
            if (!StringUtils.isNull(this.gEP)) {
                akVar.ab("obj_param2", this.gEP);
            }
            if (!StringUtils.isNull(this.gEQ)) {
                akVar.ab("obj_param3", this.gEQ);
            }
            if (!StringUtils.isNull(this.aLg)) {
                akVar.ab("obj_id", this.aLg);
            }
            if (!StringUtils.isNull(this.gER)) {
                akVar.ab("ab_tag", this.gER);
            }
        }
        return akVar;
    }

    public aa brp() {
        aa aaVar = new aa();
        aaVar.mLocate = this.mLocate;
        aaVar.mType = this.mType;
        aaVar.bAK = this.bAK;
        aaVar.cSk = this.cSk;
        aaVar.mUid = this.mUid;
        aaVar.mSource = this.mSource;
        aaVar.gEO = this.gEO;
        aaVar.gEP = this.gEP;
        aaVar.gEQ = this.gEQ;
        aaVar.aLg = this.aLg;
        aaVar.gER = this.gER;
        aaVar.gES = this.gES;
        return aaVar;
    }
}
