package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmg = BdUniqueId.gen();
    public String bKR;
    public boolean bKY;
    public boolean buA;
    public String fmc;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmg;
    }
}
