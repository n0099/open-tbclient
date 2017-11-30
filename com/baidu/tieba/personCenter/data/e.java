package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fsd = BdUniqueId.gen();
    public String djf;
    public UserData eOp;
    public boolean fsa = false;
    public g fsb;
    public Bundle fsc;
    public int iconId;
    public int itemId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fsd;
    }
}
