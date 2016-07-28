package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e implements v {
    public static final BdUniqueId erV = BdUniqueId.gen();
    public ArrayList<f> erW = new ArrayList<>();

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return erV;
    }
}
