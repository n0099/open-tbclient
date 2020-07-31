package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kiE = BdUniqueId.gen();
    public static final BdUniqueId kiF = BdUniqueId.gen();
    public BdUniqueId Uh;
    public boolean isDynamic;
    public long kiG;
    public String kiH;
    public List<PbSortType> kiK;
    public boolean isNew = true;
    public int sortType = 0;
    public String kiI = "";
    public boolean kiJ = false;

    public n(BdUniqueId bdUniqueId) {
        this.Uh = kiF;
        this.Uh = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Uh;
    }
}
