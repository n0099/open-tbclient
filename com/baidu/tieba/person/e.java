package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bl;
/* loaded from: classes.dex */
public class e extends bl {
    public static final BdUniqueId bFk = BdUniqueId.gen();
    public static final BdUniqueId ffJ = BdUniqueId.gen();
    public long ffH;
    public boolean ffK;

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.ffK ? ffJ : bFk;
    }
}
