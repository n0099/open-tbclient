package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eMv = BdUniqueId.gen();
    public boolean beq;
    public boolean eMw;
    public List<v> eMx;
    public int mSex;
    public String mUid;
    public String wU;

    public boolean isValid() {
        return !x.r(this.eMx);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eMv;
    }
}
