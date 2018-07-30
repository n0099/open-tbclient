package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gaW = BdUniqueId.gen();
    public String cCI;
    public String cCJ;
    public boolean cCP;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gaW;
    }
}
