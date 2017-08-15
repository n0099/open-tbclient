package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class e extends bl {
    public static final BdUniqueId bFj = BdUniqueId.gen();
    public static final BdUniqueId ffH = BdUniqueId.gen();
    public long ffF;
    public boolean ffI;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.ffI ? ffH : bFj;
    }
}
