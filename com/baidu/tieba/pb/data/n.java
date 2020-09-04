package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes16.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kyf = BdUniqueId.gen();
    public static final BdUniqueId kyg = BdUniqueId.gen();
    public BdUniqueId UM;
    public boolean isDynamic;
    public long kyh;
    public String kyi;
    public List<PbSortType> kyl;
    public boolean isNew = true;
    public int sortType = 0;
    public String kyj = "";
    public boolean kyk = false;

    public n(BdUniqueId bdUniqueId) {
        this.UM = kyg;
        this.UM = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.UM;
    }
}
