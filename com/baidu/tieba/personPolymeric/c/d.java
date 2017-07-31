package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fkn = BdUniqueId.gen();
    public String bKi;
    public boolean bKp;
    public boolean buk;
    public String fkj;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fkn;
    }
}
