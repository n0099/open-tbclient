package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes4.dex */
public class ad extends PostData {
    public static final BdUniqueId hLA = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap hLB;
    public com.baidu.tbadk.core.data.ap hLC;
    public com.baidu.tbadk.core.data.ap hLD;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLA;
    }

    public boolean hasData() {
        if (this.hLB == null || StringUtils.isNull(this.hLB.summary)) {
            if (this.hLC == null || StringUtils.isNull(this.hLC.summary)) {
                return (this.hLD == null || StringUtils.isNull(this.hLD.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
