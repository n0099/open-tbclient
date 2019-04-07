package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class i extends com.baidu.tieba.card.data.b implements m {
    public static BdUniqueId hLS = BdUniqueId.gen();
    public List<a> hLA = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hLS;
    }
}
