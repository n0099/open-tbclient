package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ab extends PostData {
    public static final BdUniqueId jyi = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as jyj;
    public com.baidu.tbadk.core.data.as jyk;
    public com.baidu.tbadk.core.data.as jyl;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jyi;
    }

    public boolean hasData() {
        if (this.jyj == null || StringUtils.isNull(this.jyj.summary)) {
            if (this.jyk == null || StringUtils.isNull(this.jyk.summary)) {
                return (this.jyl == null || StringUtils.isNull(this.jyl.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
