package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.o {
    public static final BdUniqueId ljJ = BdUniqueId.gen();
    public List<bk> ljK;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ljJ;
    }
}
