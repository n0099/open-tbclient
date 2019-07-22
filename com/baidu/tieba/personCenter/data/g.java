package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId ikm = BdUniqueId.gen();
    public String bDN;
    public int iki;
    public boolean ikj = false;
    public i ikk;
    public Bundle ikl;
    public int itemId;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ikm;
    }
}
