package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fCU = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fCV;
    public com.baidu.tbadk.core.data.an fCW;
    public com.baidu.tbadk.core.data.an fCX;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fCU;
    }

    public boolean hasData() {
        if (this.fCV == null || StringUtils.isNull(this.fCV.summary)) {
            if (this.fCW == null || StringUtils.isNull(this.fCW.summary)) {
                return (this.fCX == null || StringUtils.isNull(this.fCX.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
