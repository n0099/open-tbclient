package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class n implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lHi = BdUniqueId.gen();
    public static final BdUniqueId lHj = BdUniqueId.gen();
    public BdUniqueId Ws;
    public boolean isDynamic;
    public long lHk;
    public String lHl;
    public List<PbSortType> lHo;
    public boolean isNew = true;
    public int sortType = 0;
    public String lHm = "";
    public boolean lHn = false;

    public n(BdUniqueId bdUniqueId) {
        this.Ws = lHj;
        this.Ws = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Ws;
    }
}
