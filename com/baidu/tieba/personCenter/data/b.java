package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gjx = BdUniqueId.gen();
    public UserData fHq;
    public int gjt;
    public int gju;
    public int gjv;
    public boolean gjw;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gjx;
    }
}
