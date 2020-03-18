package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class i extends PostData {
    public static final BdUniqueId iEo = BdUniqueId.gen();
    public String iEp;
    private int position = 0;

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return iEo;
    }
}
