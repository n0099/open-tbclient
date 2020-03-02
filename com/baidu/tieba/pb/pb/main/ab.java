package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ab extends PostData {
    public static final BdUniqueId iMi = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as iMj;
    public com.baidu.tbadk.core.data.as iMk;
    public com.baidu.tbadk.core.data.as iMl;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iMi;
    }

    public boolean hasData() {
        if (this.iMj == null || StringUtils.isNull(this.iMj.summary)) {
            if (this.iMk == null || StringUtils.isNull(this.iMk.summary)) {
                return (this.iMl == null || StringUtils.isNull(this.iMl.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
