package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes7.dex */
public class ae extends PostData {
    public static final BdUniqueId iKL = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as iKM;
    public com.baidu.tbadk.core.data.as iKN;
    public com.baidu.tbadk.core.data.as iKO;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iKL;
    }

    public boolean hasData() {
        if (this.iKM == null || StringUtils.isNull(this.iKM.summary)) {
            if (this.iKN == null || StringUtils.isNull(this.iKN.summary)) {
                return (this.iKO == null || StringUtils.isNull(this.iKO.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
