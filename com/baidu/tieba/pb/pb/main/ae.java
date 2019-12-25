package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class ae extends PostData {
    public static final BdUniqueId iHh = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as iHi;
    public com.baidu.tbadk.core.data.as iHj;
    public com.baidu.tbadk.core.data.as iHk;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iHh;
    }

    public boolean hasData() {
        if (this.iHi == null || StringUtils.isNull(this.iHi.summary)) {
            if (this.iHj == null || StringUtils.isNull(this.iHj.summary)) {
                return (this.iHk == null || StringUtils.isNull(this.iHk.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
