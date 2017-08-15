package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.u;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fmk = BdUniqueId.gen();
    public boolean blR;
    public boolean fml;
    public String fmm;
    public List<com.baidu.adp.widget.ListView.f> fmn;
    public int mSex;
    public String mUid;
    public String yx;

    public boolean isValid() {
        return !u.v(this.fmn);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fmk;
    }
}
