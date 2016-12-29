package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId eda = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ap edb;
    public com.baidu.tbadk.core.data.ap edc;
    public com.baidu.tbadk.core.data.ap edd;

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eda;
    }

    public boolean hasData() {
        if (this.edb == null || StringUtils.isNull(this.edb.summary)) {
            if (this.edc == null || StringUtils.isNull(this.edc.summary)) {
                return (this.edd == null || StringUtils.isNull(this.edd.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
