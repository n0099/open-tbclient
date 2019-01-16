package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId gvV = BdUniqueId.gen();
    public List<a> gvC = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gvV;
    }
}
