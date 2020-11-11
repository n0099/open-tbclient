package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes22.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId lol = BdUniqueId.gen();
    public static final BdUniqueId lom = BdUniqueId.gen();
    public BdUniqueId Vw;
    public boolean isDynamic;
    public long loo;
    public String lop;
    public List<PbSortType> los;
    public boolean isNew = true;
    public int sortType = 0;
    public String loq = "";
    public boolean lor = false;

    public n(BdUniqueId bdUniqueId) {
        this.Vw = lom;
        this.Vw = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vw;
    }
}
