package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.at;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class z extends PostData {
    public static final BdUniqueId eMY = BdUniqueId.gen();
    public at eMZ;
    public at eNa;
    public at eNb;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eMY;
    }

    public boolean hasData() {
        if (this.eMZ == null || StringUtils.isNull(this.eMZ.summary)) {
            if (this.eNa == null || StringUtils.isNull(this.eNa.summary)) {
                return (this.eNb == null || StringUtils.isNull(this.eNb.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
