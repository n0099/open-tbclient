package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hTr = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hTs;
    public com.baidu.tbadk.core.data.ap hTt;
    public com.baidu.tbadk.core.data.ap hTu;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hTr;
    }

    public boolean hasData() {
        if (this.hTs == null || StringUtils.isNull(this.hTs.summary)) {
            if (this.hTt == null || StringUtils.isNull(this.hTt.summary)) {
                return (this.hTu == null || StringUtils.isNull(this.hTu.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
