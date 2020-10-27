package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes22.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lim = BdUniqueId.gen();
    public static final BdUniqueId lin = BdUniqueId.gen();
    public BdUniqueId Vw;
    public boolean isDynamic;
    public long lio;
    public String lip;
    public List<PbSortType> lis;
    public boolean isNew = true;
    public int sortType = 0;
    public String liq = "";
    public boolean lir = false;

    public n(BdUniqueId bdUniqueId) {
        this.Vw = lin;
        this.Vw = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vw;
    }
}
