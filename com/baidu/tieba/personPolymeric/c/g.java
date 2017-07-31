package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.u;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fkr = BdUniqueId.gen();
    public boolean blJ;
    public boolean fks;
    public String fkt;
    public List<com.baidu.adp.widget.ListView.f> fku;
    public int mSex;
    public String mUid;
    public String yv;

    public boolean isValid() {
        return !u.v(this.fku);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fkr;
    }
}
