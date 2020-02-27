package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ab extends PostData {
    public static final BdUniqueId iMg = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as iMh;
    public com.baidu.tbadk.core.data.as iMi;
    public com.baidu.tbadk.core.data.as iMj;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iMg;
    }

    public boolean hasData() {
        if (this.iMh == null || StringUtils.isNull(this.iMh.summary)) {
            if (this.iMi == null || StringUtils.isNull(this.iMi.summary)) {
                return (this.iMj == null || StringUtils.isNull(this.iMj.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
