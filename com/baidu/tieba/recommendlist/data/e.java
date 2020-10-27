package com.baidu.tieba.recommendlist.data;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.widget.listview.IAdapterData;
/* loaded from: classes4.dex */
public class e implements IAdapterData {
    public static BdUniqueId mwf = BdUniqueId.gen();
    public String title;
    public int type;

    public e(int i) {
        this.type = i;
    }

    @Override // com.baidu.live.adp.widget.listview.IAdapterData
    public BdUniqueId getType() {
        return mwf;
    }
}
