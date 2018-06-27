package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bc;
import java.util.List;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId gJH = BdUniqueId.gen();
    public List<bc> gJI;
    public int gJJ = -1;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return gJH;
    }
}
