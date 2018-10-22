package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId fRZ = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fSa;
    public com.baidu.tbadk.core.data.an fSb;
    public com.baidu.tbadk.core.data.an fSc;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fRZ;
    }

    public boolean hasData() {
        if (this.fSa == null || StringUtils.isNull(this.fSa.summary)) {
            if (this.fSb == null || StringUtils.isNull(this.fSb.summary)) {
                return (this.fSc == null || StringUtils.isNull(this.fSc.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
