package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId mwt = BdUniqueId.gen();
    public String aIQ;
    public int gtB;
    public int itemId;
    public boolean mwo;
    public boolean mwp;
    public boolean mwq = false;
    public j mwr;
    public Bundle mws;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mwt;
    }
}
