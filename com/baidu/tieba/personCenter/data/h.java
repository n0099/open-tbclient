package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes7.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId jgG = BdUniqueId.gen();
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgG;
    }
}
