package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class du extends PostData {
    public static final BdUniqueId emX = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ar emY;
    public com.baidu.tbadk.core.data.ar emZ;
    public com.baidu.tbadk.core.data.ar ena;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return emX;
    }

    public boolean hasData() {
        if (this.emY == null || StringUtils.isNull(this.emY.summary)) {
            if (this.emZ == null || StringUtils.isNull(this.emZ.summary)) {
                return (this.ena == null || StringUtils.isNull(this.ena.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
