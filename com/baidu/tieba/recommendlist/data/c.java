package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes7.dex */
public class c implements IAdapterData {
    public static BdUniqueId lKR = BdUniqueId.gen();
    public int count;
    public int type;

    public c(int i) {
        this.type = i;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return lKR;
    }
}
