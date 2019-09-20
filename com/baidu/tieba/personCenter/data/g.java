package com.baidu.tieba.personCenter.data;

import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static BdUniqueId inp = BdUniqueId.gen();
    public String bEl;
    public int ink;
    public boolean inl;
    public boolean inm = false;
    public i inn;
    public Bundle ino;
    public int itemId;
    public String title;
    public int type;
    public UserData userData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return inp;
    }
}
