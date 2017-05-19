package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eDe = BdUniqueId.gen();
    public boolean bjW;
    public String bxY;
    public boolean byg;
    public String eDa;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDe;
    }
}
