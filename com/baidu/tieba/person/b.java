package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ffE = BdUniqueId.gen();
    public String auE;
    public long bEZ;
    public String bFa;
    public int epu;
    public k ffF;
    public long mUserId;
    public String mUserName;

    public void b(k kVar) {
        if (kVar != null) {
            this.bEZ = kVar.aXE();
            this.bFa = kVar.getModuleName();
            UserData userData = kVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.epu = userData.getSex();
                this.auE = userData.getPortrait();
            }
            this.ffF = kVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ffE;
    }
}
