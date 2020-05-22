package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class l implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId jFi = BdUniqueId.gen();
    public static final BdUniqueId jFj = BdUniqueId.gen();
    public BdUniqueId TK;
    public boolean isDynamic;
    public long jFk;
    public String jFl;
    public List<PbSortType> jFo;
    public boolean isNew = true;
    public int sortType = 0;
    public String jFm = "";
    public boolean jFn = false;

    public l(BdUniqueId bdUniqueId) {
        this.TK = jFj;
        this.TK = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return this.TK;
    }
}
