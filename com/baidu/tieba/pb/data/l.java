package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class l implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId jZY = BdUniqueId.gen();
    public static final BdUniqueId jZZ = BdUniqueId.gen();
    public BdUniqueId Un;
    public boolean isDynamic;
    public long kaa;
    public String kab;
    public List<PbSortType> kae;
    public boolean isNew = true;
    public int sortType = 0;
    public String kac = "";
    public boolean kad = false;

    public l(BdUniqueId bdUniqueId) {
        this.Un = jZZ;
        this.Un = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Un;
    }
}
