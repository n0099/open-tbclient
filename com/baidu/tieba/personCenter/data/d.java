package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jgr = BdUniqueId.gen();
    public int jgn;
    public int jgo;
    public int jgp;
    public boolean jgq;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgr;
    }
}
