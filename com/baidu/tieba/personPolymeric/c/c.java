package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gyc = BdUniqueId.gen();
    public List<f> gyd;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gyc;
    }
}
