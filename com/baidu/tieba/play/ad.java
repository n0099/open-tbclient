package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class ad {
    public String aPG;
    public String aPH;
    public String eZn;
    public String eZo;
    public String mLocate;
    public String mSource;
    public String mUid;

    public ax f(ax axVar) {
        if (axVar != null) {
            if (!StringUtils.isNull(this.mLocate)) {
                axVar.ab("obj_locate", this.mLocate);
            }
            if (!StringUtils.isNull(this.aPH)) {
                axVar.ab("tid", this.aPH);
            }
            if (!StringUtils.isNull(this.aPG)) {
                axVar.ab("fid", this.aPG);
            }
            if (!StringUtils.isNull(this.mUid)) {
                axVar.ab("uid", this.mUid);
            }
            if (!StringUtils.isNull(this.mSource)) {
                axVar.ab("obj_source", this.mSource);
            }
            if (!StringUtils.isNull(this.eZn)) {
                axVar.ab("obj_param1", this.eZn);
            }
            if (!StringUtils.isNull(this.eZo)) {
                axVar.ab("obj_param2", this.eZo);
            }
        }
        return axVar;
    }
}
