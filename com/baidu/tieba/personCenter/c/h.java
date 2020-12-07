package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId mkv = BdUniqueId.gen();
    public String aJj;
    public int gjb;
    public int itemId;
    public boolean mkq;
    public boolean mkr;
    public boolean mks = false;
    public j mkt;
    public Bundle mku;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mkv;
    }
}
