package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eIb = BdUniqueId.gen();
    public boolean bcA;
    public String bcr;
    public boolean bcy;
    public String eHW;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eIb;
    }
}
