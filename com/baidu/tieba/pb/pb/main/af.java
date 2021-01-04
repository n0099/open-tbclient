package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class af extends PostData {
    public static final BdUniqueId lSN = BdUniqueId.gen();
    public ba lSO;
    public ba lSP;
    public ba lSQ;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lSN;
    }

    public boolean hasData() {
        if (this.lSO == null || StringUtils.isNull(this.lSO.summary)) {
            if (this.lSP == null || StringUtils.isNull(this.lSP.summary)) {
                return (this.lSQ == null || StringUtils.isNull(this.lSQ.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
