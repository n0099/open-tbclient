package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId aYz = BdUniqueId.gen();
    public long audienceCount;
    public String eGs;
    public String liveCover;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aYz;
    }
}
