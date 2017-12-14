package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fsL = BdUniqueId.gen();
    public UserData ePs;
    public int fsH;
    public int fsI;
    public int fsJ;
    public boolean fsK;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fsL;
    }
}
