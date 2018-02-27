package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gpw = BdUniqueId.gen();
    public List<f> gpx;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gpw;
    }
}
