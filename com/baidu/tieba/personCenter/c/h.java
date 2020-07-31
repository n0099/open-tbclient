package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId kPw = BdUniqueId.gen();
    public String aye;
    public int itemId;
    public int kPq;
    public boolean kPr;
    public boolean kPs;
    public boolean kPt = false;
    public j kPu;
    public Bundle kPv;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kPw;
    }
}
