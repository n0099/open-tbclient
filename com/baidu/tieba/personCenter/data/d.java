package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jcJ = BdUniqueId.gen();
    public int jcF;
    public int jcG;
    public int jcH;
    public boolean jcI;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jcJ;
    }
}
