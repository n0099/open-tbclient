package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes21.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kGC = BdUniqueId.gen();
    public static final BdUniqueId kGD = BdUniqueId.gen();
    public BdUniqueId Vf;
    public boolean isDynamic;
    public long kGE;
    public String kGF;
    public List<PbSortType> kGI;
    public boolean isNew = true;
    public int sortType = 0;
    public String kGG = "";
    public boolean kGH = false;

    public n(BdUniqueId bdUniqueId) {
        this.Vf = kGD;
        this.Vf = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vf;
    }
}
