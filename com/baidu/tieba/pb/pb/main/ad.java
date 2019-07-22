package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hRR = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hRS;
    public com.baidu.tbadk.core.data.ap hRT;
    public com.baidu.tbadk.core.data.ap hRU;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hRR;
    }

    public boolean hasData() {
        if (this.hRS == null || StringUtils.isNull(this.hRS.summary)) {
            if (this.hRT == null || StringUtils.isNull(this.hRT.summary)) {
                return (this.hRU == null || StringUtils.isNull(this.hRU.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
