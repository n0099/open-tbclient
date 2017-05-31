package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eMr = BdUniqueId.gen();
    public String bDU;
    public boolean bEb;
    public boolean bld;
    public String eMn;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eMr;
    }
}
