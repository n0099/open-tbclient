package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.u;
import java.util.List;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fjf = BdUniqueId.gen();
    public boolean bkz;
    public boolean fjg;
    public String fjh;
    public List<com.baidu.adp.widget.ListView.f> fji;
    public int mSex;
    public String mUid;
    public String wV;

    public boolean isValid() {
        return !u.v(this.fji);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fjf;
    }
}
