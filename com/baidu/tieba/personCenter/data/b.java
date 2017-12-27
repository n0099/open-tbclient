package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static BdUniqueId gfL = BdUniqueId.gen();
    public UserData fBT;
    public int gfH;
    public int gfI;
    public int gfJ;
    public boolean gfK;
    public int threadNum;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gfL;
    }
}
