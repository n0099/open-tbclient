package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class z extends PostData {
    public static final BdUniqueId eLv = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.at eLw;
    public com.baidu.tbadk.core.data.at eLx;
    public com.baidu.tbadk.core.data.at eLy;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eLv;
    }

    public boolean hasData() {
        if (this.eLw == null || StringUtils.isNull(this.eLw.summary)) {
            if (this.eLx == null || StringUtils.isNull(this.eLx.summary)) {
                return (this.eLy == null || StringUtils.isNull(this.eLy.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
