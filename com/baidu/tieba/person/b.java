package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdV = BdUniqueId.gen();
    public String aul;
    public long bHT;
    public String bHU;
    public int ewg;
    public k fdW;
    public long mUserId;
    public String mUserName;

    public void b(k kVar) {
        if (kVar != null) {
            this.bHT = kVar.aWQ();
            this.bHU = kVar.getModuleName();
            UserData userData = kVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.ewg = userData.getSex();
                this.aul = userData.getPortrait();
            }
            this.fdW = kVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fdV;
    }
}
