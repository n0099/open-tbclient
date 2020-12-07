package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes22.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lCa = BdUniqueId.gen();
    public static final BdUniqueId lCb = BdUniqueId.gen();
    public BdUniqueId Wv;
    public boolean isDynamic;
    public long lCc;
    public String lCd;
    public List<PbSortType> lCg;
    public boolean isNew = true;
    public int sortType = 0;
    public String lCe = "";
    public boolean lCf = false;

    public n(BdUniqueId bdUniqueId) {
        this.Wv = lCb;
        this.Wv = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Wv;
    }
}
