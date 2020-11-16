package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId lWo = BdUniqueId.gen();
    public String aGz;
    public int gaP;
    public int itemId;
    public boolean lWj;
    public boolean lWk;
    public boolean lWl = false;
    public j lWm;
    public Bundle lWn;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lWo;
    }
}
