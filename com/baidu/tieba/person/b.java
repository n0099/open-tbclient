package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdJ = BdUniqueId.gen();
    public String auC;
    public long bEp;
    public String bEq;
    public int enx;
    public k fdK;
    public long mUserId;
    public String mUserName;

    public void b(k kVar) {
        if (kVar != null) {
            this.bEp = kVar.aXc();
            this.bEq = kVar.getModuleName();
            UserData userData = kVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.enx = userData.getSex();
                this.auC = userData.getPortrait();
            }
            this.fdK = kVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fdJ;
    }
}
