package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bj;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId kez = BdUniqueId.gen();
    public List<bj> keA;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return kez;
    }
}
