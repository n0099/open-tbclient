package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hLE = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hLF;
    public com.baidu.tbadk.core.data.ap hLG;
    public com.baidu.tbadk.core.data.ap hLH;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLE;
    }

    public boolean hasData() {
        if (this.hLF == null || StringUtils.isNull(this.hLF.summary)) {
            if (this.hLG == null || StringUtils.isNull(this.hLG.summary)) {
                return (this.hLH == null || StringUtils.isNull(this.hLH.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
