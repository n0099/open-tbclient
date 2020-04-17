package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class ab extends PostData {
    public static final BdUniqueId jye = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.as jyf;
    public com.baidu.tbadk.core.data.as jyg;
    public com.baidu.tbadk.core.data.as jyh;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jye;
    }

    public boolean hasData() {
        if (this.jyf == null || StringUtils.isNull(this.jyf.summary)) {
            if (this.jyg == null || StringUtils.isNull(this.jyg.summary)) {
                return (this.jyh == null || StringUtils.isNull(this.jyh.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
