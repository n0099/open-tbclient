package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class h extends BaseCardInfo {
    public static BdUniqueId mpG = BdUniqueId.gen();
    public String aJH;
    public int gtC;
    public int itemId;
    public boolean mpB;
    public boolean mpC;
    public boolean mpD = false;
    public j mpE;
    public Bundle mpF;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return mpG;
    }
}
