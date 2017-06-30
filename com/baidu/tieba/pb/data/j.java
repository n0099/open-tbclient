package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class j implements v {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public MetaData erZ;
    public boolean esa = false;
    public boolean esb = true;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
