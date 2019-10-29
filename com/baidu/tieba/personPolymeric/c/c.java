package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId isv = BdUniqueId.gen();
    public List<f> isw;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return isv;
    }
}
