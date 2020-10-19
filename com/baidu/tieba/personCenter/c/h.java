package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes22.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lDE = BdUniqueId.gen();
    public String aHf;
    public int itemId;
    public boolean lDA;
    public boolean lDB = false;
    public j lDC;
    public Bundle lDD;
    public int lDy;
    public boolean lDz;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lDE;
    }
}
