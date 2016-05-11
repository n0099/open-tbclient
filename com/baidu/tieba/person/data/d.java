package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d implements v {
    public static final BdUniqueId dzl = BdUniqueId.gen();
    public ArrayList<e> dzm = new ArrayList<>();

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return dzl;
    }
}
