package com.baidu.tieba.personCenter.c;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class m extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static BdUniqueId jhR = BdUniqueId.gen();
    public List<a> jhp = new ArrayList();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jhR;
    }
}
