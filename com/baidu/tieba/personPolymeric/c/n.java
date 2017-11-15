package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fpS = BdUniqueId.gen();
    public List<com.baidu.adp.widget.ListView.f> fpT;
    public long uid;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fpS;
    }
}
