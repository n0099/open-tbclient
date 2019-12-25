package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jki = BdUniqueId.gen();
    public String fIa;
    public String fIb;
    public boolean fIh;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jki;
    }
}
