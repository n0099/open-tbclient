package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class dr extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId dSc = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ah dSd;
    public com.baidu.tbadk.core.data.ah dSe;
    public com.baidu.tbadk.core.data.ah dSf;

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dSc;
    }

    public boolean hasData() {
        if (this.dSd == null || StringUtils.isNull(this.dSd.summary)) {
            if (this.dSe == null || StringUtils.isNull(this.dSe.summary)) {
                return (this.dSf == null || StringUtils.isNull(this.dSf.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
