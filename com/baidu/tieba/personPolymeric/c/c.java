package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jkg = BdUniqueId.gen();
    public List<f> jkh;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return jkg;
    }
}
