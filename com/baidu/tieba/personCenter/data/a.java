package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fis = BdUniqueId.gen();
    public UserData eGm;
    public int fio;
    public int fip;
    public int fiq;
    public boolean fir;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fis;
    }
}
