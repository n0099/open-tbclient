package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements IAdapterData {
    public static BdUniqueId mRm = BdUniqueId.gen();
    public List<IAdapterData> mRn;

    public b(List<IAdapterData> list) {
        this.mRn = list;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mRm;
    }
}
