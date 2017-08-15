package com.baidu.tieba.person;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ffC = BdUniqueId.gen();
    public String auD;
    public long bEY;
    public String bEZ;
    public int ept;
    public k ffD;
    public long mUserId;
    public String mUserName;

    public void b(k kVar) {
        if (kVar != null) {
            this.bEY = kVar.aXJ();
            this.bEZ = kVar.getModuleName();
            UserData userData = kVar.getUserData();
            if (userData != null) {
                this.mUserId = com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L);
                this.mUserName = userData.getUserName();
                this.ept = userData.getSex();
                this.auD = userData.getPortrait();
            }
            this.ffD = kVar;
        }
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return ffC;
    }
}
