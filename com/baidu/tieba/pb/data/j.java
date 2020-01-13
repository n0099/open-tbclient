package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes7.dex */
public class j extends PostData {
    public static final BdUniqueId iAG = BdUniqueId.gen();
    public String iAH;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iAG;
    }
}
