package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jgm = BdUniqueId.gen();
    public int jgi;
    public int jgj;
    public int jgk;
    public boolean jgl;
    public int threadNum;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgm;
    }
}
