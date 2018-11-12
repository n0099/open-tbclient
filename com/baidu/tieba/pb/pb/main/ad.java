package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ad extends PostData {
    public static final BdUniqueId fTy = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fTA;
    public com.baidu.tbadk.core.data.an fTB;
    public com.baidu.tbadk.core.data.an fTz;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fTy;
    }

    public boolean hasData() {
        if (this.fTz == null || StringUtils.isNull(this.fTz.summary)) {
            if (this.fTA == null || StringUtils.isNull(this.fTA.summary)) {
                return (this.fTB == null || StringUtils.isNull(this.fTB.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
