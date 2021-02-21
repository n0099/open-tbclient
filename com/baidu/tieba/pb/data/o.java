package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lLF = BdUniqueId.gen();
    public static final BdUniqueId lLG = BdUniqueId.gen();
    public BdUniqueId Wm;
    public boolean isDynamic;
    public long lLH;
    public String lLI;
    public List<PbSortType> lLL;
    public boolean isNew = true;
    public int sortType = 0;
    public String lLJ = "";
    public boolean lLK = false;

    public o(BdUniqueId bdUniqueId) {
        this.Wm = lLG;
        this.Wm = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wm;
    }
}
