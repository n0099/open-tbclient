package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes2.dex */
public class o implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lLq = BdUniqueId.gen();
    public static final BdUniqueId lLr = BdUniqueId.gen();
    public BdUniqueId Wm;
    public boolean isDynamic;
    public long lLs;
    public String lLt;
    public List<PbSortType> lLw;
    public boolean isNew = true;
    public int sortType = 0;
    public String lLu = "";
    public boolean lLv = false;

    public o(BdUniqueId bdUniqueId) {
        this.Wm = lLr;
        this.Wm = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return this.Wm;
    }
}
