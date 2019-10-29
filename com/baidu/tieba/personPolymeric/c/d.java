package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId isx = BdUniqueId.gen();
    public String eQW;
    public String eQX;
    public boolean eRd;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return isx;
    }
}
