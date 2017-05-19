package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eDi = BdUniqueId.gen();
    public boolean bdp;
    public boolean eDj;
    public List<v> eDk;
    public int mSex;
    public String mUid;
    public String wU;

    public boolean isValid() {
        return !x.r(this.eDk);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eDi;
    }
}
