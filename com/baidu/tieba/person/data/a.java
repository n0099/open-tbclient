package com.baidu.tieba.person.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public class a implements f {
    public static final BdUniqueId fen = BdUniqueId.gen();
    private int feo = 0;

    public int aXd() {
        return this.feo;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fen;
    }
}
