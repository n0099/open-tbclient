package com.baidu.tieba.pb.video;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ae extends PostData {
    public static final BdUniqueId eKG = BdUniqueId.gen();

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eKG;
    }
}
