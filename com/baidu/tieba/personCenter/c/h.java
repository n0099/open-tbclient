package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lfv = BdUniqueId.gen();
    public String aDi;
    public int itemId;
    public int lfp;
    public boolean lfq;
    public boolean lfr;
    public boolean lfs = false;
    public j lft;
    public Bundle lfu;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lfv;
    }
}
