package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c implements u {
    public static final BdUniqueId dwh = BdUniqueId.gen();
    public ArrayList<d> dwi = new ArrayList<>();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return dwh;
    }
}
