package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ac extends PostData {
    public static final BdUniqueId faj = BdUniqueId.gen();
    public com.baidu.tbadk.core.data.an fak;
    public com.baidu.tbadk.core.data.an fal;
    public com.baidu.tbadk.core.data.an fam;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return faj;
    }

    public boolean hasData() {
        if (this.fak == null || StringUtils.isNull(this.fak.summary)) {
            if (this.fal == null || StringUtils.isNull(this.fal.summary)) {
                return (this.fam == null || StringUtils.isNull(this.fam.summary)) ? false : true;
            }
            return true;
        }
        return true;
    }
}
