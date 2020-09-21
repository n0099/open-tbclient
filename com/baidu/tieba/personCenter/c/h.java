package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes21.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId loq = BdUniqueId.gen();
    public String aEb;
    public int itemId;
    public int loj;
    public boolean lok;
    public boolean lol;
    public boolean lom = false;
    public j loo;
    public Bundle lop;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return loq;
    }
}
