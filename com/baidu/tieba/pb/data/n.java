package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes21.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId loE = BdUniqueId.gen();
    public static final BdUniqueId loF = BdUniqueId.gen();
    public BdUniqueId Vx;
    public boolean isDynamic;
    public long loG;
    public String loH;
    public List<PbSortType> loK;
    public boolean isNew = true;
    public int sortType = 0;
    public String loI = "";
    public boolean loJ = false;

    public n(BdUniqueId bdUniqueId) {
        this.Vx = loF;
        this.Vx = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vx;
    }
}
