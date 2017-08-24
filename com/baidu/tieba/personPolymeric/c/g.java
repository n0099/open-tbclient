package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.u;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmm = BdUniqueId.gen();
    public boolean blT;
    public boolean fmn;
    public String fmo;
    public List<com.baidu.adp.widget.ListView.f> fmp;
    public int mSex;
    public String mUid;
    public String yx;

    public boolean isValid() {
        return !u.v(this.fmp);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmm;
    }
}
