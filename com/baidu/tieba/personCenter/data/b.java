package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fQp = BdUniqueId.gen();
    public int fQl;
    public int fQm;
    public int fQn;
    public boolean fQo;
    public UserData fov;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return fQp;
    }
}
