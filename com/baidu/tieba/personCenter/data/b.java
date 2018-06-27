package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fUr = BdUniqueId.gen();
    public int fUn;
    public int fUo;
    public int fUp;
    public boolean fUq;
    public UserData fso;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fUr;
    }
}
