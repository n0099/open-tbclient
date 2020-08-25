package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kxY = BdUniqueId.gen();
    public static final BdUniqueId kxZ = BdUniqueId.gen();
    public BdUniqueId UM;
    public boolean isDynamic;
    public long kya;
    public String kyb;
    public List<PbSortType> kye;
    public boolean isNew = true;
    public int sortType = 0;
    public String kyc = "";
    public boolean kyd = false;

    public n(BdUniqueId bdUniqueId) {
        this.UM = kxZ;
        this.UM = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.UM;
    }
}
