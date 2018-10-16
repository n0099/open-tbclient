package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId fRY = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fRZ;
    public com.baidu.tbadk.core.data.an fSa;
    public com.baidu.tbadk.core.data.an fSb;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fRY;
    }

    public boolean hasData() {
        if (this.fRZ == null || StringUtils.isNull(this.fRZ.summary)) {
            if (this.fSa == null || StringUtils.isNull(this.fSa.summary)) {
                return (this.fSb == null || StringUtils.isNull(this.fSb.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
