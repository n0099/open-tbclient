package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements IAdapterData {
    public static BdUniqueId mwa = BdUniqueId.gen();
    public List<IAdapterData> mwb;

    public b(List<IAdapterData> list) {
        this.mwb = list;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mwa;
    }
}
