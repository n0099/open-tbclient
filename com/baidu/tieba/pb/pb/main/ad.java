package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fCN = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fCO;
    public com.baidu.tbadk.core.data.an fCP;
    public com.baidu.tbadk.core.data.an fCQ;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCN;
    }

    public boolean hasData() {
        if (this.fCO == null || StringUtils.isNull(this.fCO.summary)) {
            if (this.fCP == null || StringUtils.isNull(this.fCP.summary)) {
                return (this.fCQ == null || StringUtils.isNull(this.fCQ.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
