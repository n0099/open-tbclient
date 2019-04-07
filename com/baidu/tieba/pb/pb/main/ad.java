package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId htV = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap htW;
    public com.baidu.tbadk.core.data.ap htX;
    public com.baidu.tbadk.core.data.ap htY;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return htV;
    }

    public boolean hasData() {
        if (this.htW == null || StringUtils.isNull(this.htW.summary)) {
            if (this.htX == null || StringUtils.isNull(this.htX.summary)) {
                return (this.htY == null || StringUtils.isNull(this.htY.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
