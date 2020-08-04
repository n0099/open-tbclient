package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kiG = BdUniqueId.gen();
    public static final BdUniqueId kiH = BdUniqueId.gen();
    public BdUniqueId Uh;
    public boolean isDynamic;
    public long kiI;
    public String kiJ;
    public List<PbSortType> kiM;
    public boolean isNew = true;
    public int sortType = 0;
    public String kiK = "";
    public boolean kiL = false;

    public n(BdUniqueId bdUniqueId) {
        this.Uh = kiH;
        this.Uh = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Uh;
    }
}
