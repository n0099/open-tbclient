package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId gXv = BdUniqueId.gen();
    public List<bd> gXw;
    public int gXx = -1;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return gXv;
    }
}
