package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId mkx = BdUniqueId.gen();
    public String aJj;
    public int gjd;
    public int itemId;
    public boolean mks;
    public boolean mkt;
    public boolean mku = false;
    public j mkv;
    public Bundle mkw;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mkx;
    }
}
