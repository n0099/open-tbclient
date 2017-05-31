package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eGp = BdUniqueId.gen();
    public String arq;
    public l bvk;
    public long bvn;
    public String bvo;
    public int bvp;
    public long mUserId;
    public String mUserName;

    public void c(l lVar) {
        if (lVar != null) {
            this.bvn = lVar.aPT();
            this.bvo = lVar.getModuleName();
            UserData userData = lVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.bvp = userData.getSex();
                this.arq = userData.getPortrait();
            }
            this.bvk = lVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return eGp;
    }
}
