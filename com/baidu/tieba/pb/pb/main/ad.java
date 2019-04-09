package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId htW = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap htX;
    public com.baidu.tbadk.core.data.ap htY;
    public com.baidu.tbadk.core.data.ap htZ;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return htW;
    }

    public boolean hasData() {
        if (this.htX == null || StringUtils.isNull(this.htX.summary)) {
            if (this.htY == null || StringUtils.isNull(this.htY.summary)) {
                return (this.htZ == null || StringUtils.isNull(this.htZ.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
