package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hLD = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hLE;
    public com.baidu.tbadk.core.data.ap hLF;
    public com.baidu.tbadk.core.data.ap hLG;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLD;
    }

    public boolean hasData() {
        if (this.hLE == null || StringUtils.isNull(this.hLE.summary)) {
            if (this.hLF == null || StringUtils.isNull(this.hLF.summary)) {
                return (this.hLG == null || StringUtils.isNull(this.hLG.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
