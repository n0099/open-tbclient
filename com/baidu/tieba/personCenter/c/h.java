package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes16.dex */
public class h extends com.baidu.tieba.card.data.b {
    public static BdUniqueId lfo = BdUniqueId.gen();
    public String aDg;
    public int itemId;
    public int lfi;
    public boolean lfj;
    public boolean lfk;
    public boolean lfl = false;
    public j lfm;
    public Bundle lfn;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return lfo;
    }
}
