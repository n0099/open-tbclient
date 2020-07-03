package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes9.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kGv = BdUniqueId.gen();
    public String awR;
    public int itemId;
    public int kGp;
    public boolean kGq;
    public boolean kGr;
    public boolean kGs = false;
    public j kGt;
    public Bundle kGu;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kGv;
    }
}
