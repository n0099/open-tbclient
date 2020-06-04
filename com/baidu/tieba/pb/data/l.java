package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class l implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId jGo = BdUniqueId.gen();
    public static final BdUniqueId jGp = BdUniqueId.gen();
    public BdUniqueId TK;
    public boolean isDynamic;
    public long jGq;
    public String jGr;
    public List<PbSortType> jGu;
    public boolean isNew = true;
    public int sortType = 0;
    public String jGs = "";
    public boolean jGt = false;

    public l(BdUniqueId bdUniqueId) {
        this.TK = jGp;
        this.TK = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return this.TK;
    }
}
