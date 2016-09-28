package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class ds extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId esw = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.ao esx;
    public com.baidu.tbadk.core.data.ao esy;
    public com.baidu.tbadk.core.data.ao esz;

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return esw;
    }

    public boolean hasData() {
        if (this.esx == null || StringUtils.isNull(this.esx.summary)) {
            if (this.esy == null || StringUtils.isNull(this.esy.summary)) {
                return (this.esz == null || StringUtils.isNull(this.esz.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
