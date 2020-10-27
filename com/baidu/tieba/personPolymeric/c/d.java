package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes24.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId lXq = BdUniqueId.gen();
    public String hWh;
    public String hWi;
    public boolean hWo;
    public boolean isHost;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lXq;
    }
}
