package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fKx = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fKA;
    public com.baidu.tbadk.core.data.an fKy;
    public com.baidu.tbadk.core.data.an fKz;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fKx;
    }

    public boolean hasData() {
        if (this.fKy == null || StringUtils.isNull(this.fKy.summary)) {
            if (this.fKz == null || StringUtils.isNull(this.fKz.summary)) {
                return (this.fKA == null || StringUtils.isNull(this.fKA.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
