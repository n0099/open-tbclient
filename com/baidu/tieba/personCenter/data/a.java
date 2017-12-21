package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static BdUniqueId fsQ = BdUniqueId.gen();
    public UserData ePx;
    public int fsM;
    public int fsN;
    public int fsO;
    public boolean fsP;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fsQ;
    }
}
