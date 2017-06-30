package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ePW = BdUniqueId.gen();
    public String ast;
    public long byZ;
    public String bza;
    public n ePX;
    public int edb;
    public long mUserId;
    public String mUserName;

    public void b(n nVar) {
        if (nVar != null) {
            this.byZ = nVar.aTU();
            this.bza = nVar.getModuleName();
            UserData userData = nVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.edb = userData.getSex();
                this.ast = userData.getPortrait();
            }
            this.ePX = nVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return ePW;
    }
}
