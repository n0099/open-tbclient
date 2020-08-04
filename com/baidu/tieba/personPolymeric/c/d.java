package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes18.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId kWJ = BdUniqueId.gen();
    public String haQ;
    public String haR;
    public boolean haX;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kWJ;
    }
}
