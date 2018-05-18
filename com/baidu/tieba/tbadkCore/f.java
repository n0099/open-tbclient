package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bd;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gut = BdUniqueId.gen();
    public List<bd> guu;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gut;
    }
}
