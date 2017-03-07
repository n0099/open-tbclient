package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class dw extends PostData {
    public static final BdUniqueId eoQ = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as eoR;
    public com.baidu.tbadk.core.data.as eoS;
    public com.baidu.tbadk.core.data.as eoT;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eoQ;
    }

    public boolean hasData() {
        if (this.eoR == null || StringUtils.isNull(this.eoR.summary)) {
            if (this.eoS == null || StringUtils.isNull(this.eoS.summary)) {
                return (this.eoT == null || StringUtils.isNull(this.eoT.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
