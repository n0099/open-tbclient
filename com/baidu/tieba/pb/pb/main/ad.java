package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hUJ = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hUK;
    public com.baidu.tbadk.core.data.ap hUL;
    public com.baidu.tbadk.core.data.ap hUM;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hUJ;
    }

    public boolean hasData() {
        if (this.hUK == null || StringUtils.isNull(this.hUK.summary)) {
            if (this.hUL == null || StringUtils.isNull(this.hUL.summary)) {
                return (this.hUM == null || StringUtils.isNull(this.hUM.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
