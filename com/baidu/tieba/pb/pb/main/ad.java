package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hup = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap huq;
    public com.baidu.tbadk.core.data.ap hur;
    public com.baidu.tbadk.core.data.ap hus;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hup;
    }

    public boolean hasData() {
        if (this.huq == null || StringUtils.isNull(this.huq.summary)) {
            if (this.hur == null || StringUtils.isNull(this.hur.summary)) {
                return (this.hus == null || StringUtils.isNull(this.hus.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
