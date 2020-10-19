package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class am extends PostData {
    public static final BdUniqueId lgT = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ay lgU;
    public com.baidu.tbadk.core.data.ay lgV;
    public com.baidu.tbadk.core.data.ay lgW;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lgT;
    }

    public boolean hasData() {
        if (this.lgU == null || StringUtils.isNull(this.lgU.summary)) {
            if (this.lgV == null || StringUtils.isNull(this.lgV.summary)) {
                return (this.lgW == null || StringUtils.isNull(this.lgW.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
