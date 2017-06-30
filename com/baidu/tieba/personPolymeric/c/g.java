package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.z;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWE = BdUniqueId.gen();
    public boolean bhl;
    public boolean eWF;
    public List<v> eWG;
    public int mSex;
    public String mUid;
    public String wU;

    public boolean isValid() {
        return !z.t(this.eWG);
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eWE;
    }
}
