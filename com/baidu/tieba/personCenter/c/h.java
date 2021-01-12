package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId mla = BdUniqueId.gen();
    public String aEU;
    public int goV;
    public int itemId;
    public boolean mkV;
    public boolean mkW;
    public boolean mkX = false;
    public j mkY;
    public Bundle mkZ;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mla;
    }
}
