package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class af extends PostData {
    public static final BdUniqueId lSM = BdUniqueId.gen();
    public ba lSN;
    public ba lSO;
    public ba lSP;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lSM;
    }

    public boolean hasData() {
        if (this.lSN == null || StringUtils.isNull(this.lSN.summary)) {
            if (this.lSO == null || StringUtils.isNull(this.lSO.summary)) {
                return (this.lSP == null || StringUtils.isNull(this.lSP.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
