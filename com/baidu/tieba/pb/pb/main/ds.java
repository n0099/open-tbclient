package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ds extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId eqy = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.am eqA;
    public com.baidu.tbadk.core.data.am eqB;
    public com.baidu.tbadk.core.data.am eqz;

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eqy;
    }

    public boolean hasData() {
        if (this.eqz == null || StringUtils.isNull(this.eqz.summary)) {
            if (this.eqA == null || StringUtils.isNull(this.eqA.summary)) {
                return (this.eqB == null || StringUtils.isNull(this.eqB.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
