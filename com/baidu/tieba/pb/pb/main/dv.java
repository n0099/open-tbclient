package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class dv extends com.baidu.tieba.tbadkCore.data.p {
    public static final BdUniqueId elT = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.aq elU;
    public com.baidu.tbadk.core.data.aq elV;
    public com.baidu.tbadk.core.data.aq elW;

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return elT;
    }

    public boolean hasData() {
        if (this.elU == null || StringUtils.isNull(this.elU.summary)) {
            if (this.elV == null || StringUtils.isNull(this.elV.summary)) {
                return (this.elW == null || StringUtils.isNull(this.elW.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
