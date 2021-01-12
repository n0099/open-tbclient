package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lCC = BdUniqueId.gen();
    public static final BdUniqueId lCD = BdUniqueId.gen();
    public BdUniqueId Wq;
    public boolean isDynamic;
    public long lCE;
    public String lCF;
    public List<PbSortType> lCI;
    public boolean isNew = true;
    public int sortType = 0;
    public String lCG = "";
    public boolean lCH = false;

    public n(BdUniqueId bdUniqueId) {
        this.Wq = lCD;
        this.Wq = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wq;
    }
}
