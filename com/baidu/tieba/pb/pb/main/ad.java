package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hui = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap huj;
    public com.baidu.tbadk.core.data.ap huk;
    public com.baidu.tbadk.core.data.ap hul;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hui;
    }

    public boolean hasData() {
        if (this.huj == null || StringUtils.isNull(this.huj.summary)) {
            if (this.huk == null || StringUtils.isNull(this.huk.summary)) {
                return (this.hul == null || StringUtils.isNull(this.hul.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
