package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static BdUniqueId far = BdUniqueId.gen();
    public String cRn;
    public UserData eyj;
    public boolean fao = false;
    public g fap;
    public Bundle faq;
    public int iconId;
    public String title;
    public int type;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return far;
    }
}
