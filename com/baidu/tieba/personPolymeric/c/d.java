package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId msy = BdUniqueId.gen();
    public boolean isHost;
    public String ivG;
    public String ivH;
    public boolean ivN;
    public int sex;
    public List<UserData> users;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return msy;
    }
}
