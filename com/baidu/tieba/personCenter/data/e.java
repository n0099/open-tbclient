package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fFk = BdUniqueId.gen();
    public String dyc;
    public boolean fFh = false;
    public g fFi;
    public Bundle fFj;
    public UserData fcZ;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fFk;
    }
}
