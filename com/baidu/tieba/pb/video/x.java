package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class x extends PostData {
    public static final BdUniqueId etm = BdUniqueId.gen();

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return etm;
    }
}
