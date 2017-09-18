package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId feO = BdUniqueId.gen();
    public String aui;
    public long bIK;
    public String bIL;
    public int exa;
    public k feP;
    public long mUserId;
    public String mUserName;

    public void b(k kVar) {
        if (kVar != null) {
            this.bIK = kVar.aXb();
            this.bIL = kVar.getModuleName();
            UserData userData = kVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.exa = userData.getSex();
                this.aui = userData.getPortrait();
            }
            this.feP = kVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return feO;
    }
}
