package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class j implements v {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public MetaData ejc;
    public boolean ejd = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
