package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lNH = BdUniqueId.gen();
    public static final BdUniqueId lNI = BdUniqueId.gen();
    public BdUniqueId XG;
    public boolean isDynamic;
    public long lNJ;
    public String lNK;
    public List<PbSortType> lNN;
    public boolean isNew = true;
    public int sortType = 0;
    public String lNL = "";
    public boolean lNM = false;

    public o(BdUniqueId bdUniqueId) {
        this.XG = lNI;
        this.XG = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.XG;
    }
}
