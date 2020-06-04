package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kmE = BdUniqueId.gen();
    public String auL;
    public int itemId;
    public boolean kmA;
    public boolean kmB = false;
    public i kmC;
    public Bundle kmD;
    public int kmy;
    public boolean kmz;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return kmE;
    }
}
