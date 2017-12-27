package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class i extends PostData {
    public static final BdUniqueId fCz = BdUniqueId.gen();
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return fCz;
    }
}
