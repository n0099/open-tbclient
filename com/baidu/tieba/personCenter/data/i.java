package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId guR = BdUniqueId.gen();
    public List<a> guy = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return guR;
    }
}
