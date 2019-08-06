package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hSM = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hSN;
    public com.baidu.tbadk.core.data.ap hSO;
    public com.baidu.tbadk.core.data.ap hSP;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hSM;
    }

    public boolean hasData() {
        if (this.hSN == null || StringUtils.isNull(this.hSN.summary)) {
            if (this.hSO == null || StringUtils.isNull(this.hSO.summary)) {
                return (this.hSP == null || StringUtils.isNull(this.hSP.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
