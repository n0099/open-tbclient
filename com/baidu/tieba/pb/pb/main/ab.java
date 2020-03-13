package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ab extends PostData {
    public static final BdUniqueId iMu = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as iMv;
    public com.baidu.tbadk.core.data.as iMw;
    public com.baidu.tbadk.core.data.as iMx;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iMu;
    }

    public boolean hasData() {
        if (this.iMv == null || StringUtils.isNull(this.iMv.summary)) {
            if (this.iMw == null || StringUtils.isNull(this.iMw.summary)) {
                return (this.iMx == null || StringUtils.isNull(this.iMx.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
