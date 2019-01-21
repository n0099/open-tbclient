package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gBY = BdUniqueId.gen();
    public List<f> gBZ;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gBY;
    }
}
