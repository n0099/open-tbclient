package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ac extends PostData {
    public static final BdUniqueId fRT = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fRU;
    public com.baidu.tbadk.core.data.an fRV;
    public com.baidu.tbadk.core.data.an fRW;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fRT;
    }

    public boolean hasData() {
        if (this.fRU == null || StringUtils.isNull(this.fRU.summary)) {
            if (this.fRV == null || StringUtils.isNull(this.fRV.summary)) {
                return (this.fRW == null || StringUtils.isNull(this.fRW.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
