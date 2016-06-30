package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId ehP = BdUniqueId.gen();
    public ArrayList<e> ehQ = new ArrayList<>();

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ehP;
    }
}
