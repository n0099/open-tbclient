package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ab extends PostData {
    public static final BdUniqueId iNV = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as iNW;
    public com.baidu.tbadk.core.data.as iNX;
    public com.baidu.tbadk.core.data.as iNY;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iNV;
    }

    public boolean hasData() {
        if (this.iNW == null || StringUtils.isNull(this.iNW.summary)) {
            if (this.iNX == null || StringUtils.isNull(this.iNX.summary)) {
                return (this.iNY == null || StringUtils.isNull(this.iNY.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
