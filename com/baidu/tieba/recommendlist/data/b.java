package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.List;
/* loaded from: classes4.dex */
public class b implements IAdapterData {
    public static BdUniqueId mQz = BdUniqueId.gen();
    public List<IAdapterData> mQA;

    public b(List<IAdapterData> list) {
        this.mQA = list;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mQz;
    }
}
