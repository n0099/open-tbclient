package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes22.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lQa = BdUniqueId.gen();
    public String aHs;
    public int fVr;
    public int itemId;
    public boolean lPV;
    public boolean lPW;
    public boolean lPX = false;
    public j lPY;
    public Bundle lPZ;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lQa;
    }
}
