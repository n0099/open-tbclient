package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId muc = BdUniqueId.gen();
    public String aHq;
    public int grE;
    public int itemId;
    public boolean mtX;
    public boolean mtY;
    public boolean mtZ = false;
    public j mua;
    public Bundle mub;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return muc;
    }
}
