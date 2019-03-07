package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId huo = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hup;
    public com.baidu.tbadk.core.data.ap huq;
    public com.baidu.tbadk.core.data.ap hur;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return huo;
    }

    public boolean hasData() {
        if (this.hup == null || StringUtils.isNull(this.hup.summary)) {
            if (this.huq == null || StringUtils.isNull(this.huq.summary)) {
                return (this.hur == null || StringUtils.isNull(this.hur.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
