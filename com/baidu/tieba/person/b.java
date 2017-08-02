package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fcx = BdUniqueId.gen();
    public String atk;
    public long bDf;
    public String bDg;
    public int emf;
    public k fcy;
    public long mUserId;
    public String mUserName;

    public void b(k kVar) {
        if (kVar != null) {
            this.bDf = kVar.aWR();
            this.bDg = kVar.getModuleName();
            UserData userData = kVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.emf = userData.getSex();
                this.atk = userData.getPortrait();
            }
            this.fcy = kVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return fcx;
    }
}
