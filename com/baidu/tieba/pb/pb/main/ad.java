package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class ad extends PostData {
    public static final BdUniqueId fOW = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fOX;
    public com.baidu.tbadk.core.data.an fOY;
    public com.baidu.tbadk.core.data.an fOZ;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fOW;
    }

    public boolean hasData() {
        if (this.fOX == null || StringUtils.isNull(this.fOX.summary)) {
            if (this.fOY == null || StringUtils.isNull(this.fOY.summary)) {
                return (this.fOZ == null || StringUtils.isNull(this.fOZ.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
