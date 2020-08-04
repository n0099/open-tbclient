package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kPy = BdUniqueId.gen();
    public String aye;
    public int itemId;
    public int kPs;
    public boolean kPt;
    public boolean kPu;
    public boolean kPv = false;
    public j kPw;
    public Bundle kPx;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kPy;
    }
}
