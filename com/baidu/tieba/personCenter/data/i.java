package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId gci = BdUniqueId.gen();
    public List<a> gbP = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gci;
    }
}
