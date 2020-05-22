package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kly = BdUniqueId.gen();
    public String auL;
    public int itemId;
    public int kls;
    public boolean klt;
    public boolean klu;
    public boolean klv = false;
    public i klw;
    public Bundle klx;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kly;
    }
}
