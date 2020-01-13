package com.baidu.tieba.personCenter.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class m extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jgR = BdUniqueId.gen();
    public List<a> jgp = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jgR;
    }
}
