package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bw;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId mcB = BdUniqueId.gen();
    public List<bw> mcC;
    public int mcD = -1;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return mcB;
    }
}
