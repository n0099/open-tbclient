package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId kgb = BdUniqueId.gen();
    public List<bj> kgc;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kgb;
    }
}
