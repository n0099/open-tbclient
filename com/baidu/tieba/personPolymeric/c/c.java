package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eQD = BdUniqueId.gen();
    public String bfK;
    public boolean bfR;
    public boolean bfT;
    public String eQy;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eQD;
    }
}
