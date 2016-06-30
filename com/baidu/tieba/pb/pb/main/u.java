package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(PbActivity pbActivity, int i) {
        super(i);
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        es esVar;
        dg dgVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.tbadk.core.view.h hVar4;
        com.baidu.adp.base.h hVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.dPF.dPc;
            if (tag == bdUniqueId) {
                esVar = this.dPF.dOO;
                esVar.aHL();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                dgVar = this.dPF.dOf;
                com.baidu.tieba.pb.data.h pbData = dgVar.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aDW().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.dPF.dPb;
                    hVar5 = this.dPF.dPa;
                    hVar4.c(hVar5.getResources().getString(u.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.dPF.dPa;
                        errorString = hVar3.getResources().getString(u.j.mute_error_beyond_limit);
                    }
                    this.dPF.fH(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ba.isEmpty(errorString2)) {
                        hVar2 = this.dPF.dPa;
                        errorString2 = hVar2.getResources().getString(u.j.mute_fail);
                    }
                    hVar = this.dPF.dPb;
                    hVar.d(errorString2);
                } else {
                    this.dPF.aFg();
                }
            }
        }
    }
}
