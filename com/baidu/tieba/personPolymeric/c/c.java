package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eHy = BdUniqueId.gen();
    public boolean bhu;
    public String bvP;
    public boolean bvW;
    public String eHt;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eHy;
    }
}
