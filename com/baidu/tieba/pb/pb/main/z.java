package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.at;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class z extends PostData {
    public static final BdUniqueId eNS = BdUniqueId.gen();
    public at eNT;
    public at eNU;
    public at eNV;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return eNS;
    }

    public boolean hasData() {
        if (this.eNT == null || StringUtils.isNull(this.eNT.summary)) {
            if (this.eNU == null || StringUtils.isNull(this.eNU.summary)) {
                return (this.eNV == null || StringUtils.isNull(this.eNV.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
