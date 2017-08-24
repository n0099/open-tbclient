package com.baidu.tieba.pb.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public MetaData eGr;
    public boolean eGs = false;
    public boolean eGt = true;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
