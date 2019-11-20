package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hSA = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hSB;
    public com.baidu.tbadk.core.data.ap hSC;
    public com.baidu.tbadk.core.data.ap hSD;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hSA;
    }

    public boolean hasData() {
        if (this.hSB == null || StringUtils.isNull(this.hSB.summary)) {
            if (this.hSC == null || StringUtils.isNull(this.hSC.summary)) {
                return (this.hSD == null || StringUtils.isNull(this.hSD.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
