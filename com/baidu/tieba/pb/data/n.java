package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes22.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId kVN = BdUniqueId.gen();
    public static final BdUniqueId kVO = BdUniqueId.gen();
    public BdUniqueId Vv;
    public boolean isDynamic;
    public long kVP;
    public String kVQ;
    public List<PbSortType> kVT;
    public boolean isNew = true;
    public int sortType = 0;
    public String kVR = "";
    public boolean kVS = false;

    public n(BdUniqueId bdUniqueId) {
        this.Vv = kVO;
        this.Vv = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.Vv;
    }
}
