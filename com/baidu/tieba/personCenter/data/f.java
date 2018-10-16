package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes5.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjE = BdUniqueId.gen();
    public String akf;
    public UserData fHF;
    public boolean gjB = false;
    public h gjC;
    public Bundle gjD;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gjE;
    }
}
