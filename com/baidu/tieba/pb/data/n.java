package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes22.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lCc = BdUniqueId.gen();
    public static final BdUniqueId lCd = BdUniqueId.gen();
    public BdUniqueId Wv;
    public boolean isDynamic;
    public long lCe;
    public String lCf;
    public List<PbSortType> lCi;
    public boolean isNew = true;
    public int sortType = 0;
    public String lCg = "";
    public boolean lCh = false;

    public n(BdUniqueId bdUniqueId) {
        this.Wv = lCd;
        this.Wv = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Wv;
    }
}
