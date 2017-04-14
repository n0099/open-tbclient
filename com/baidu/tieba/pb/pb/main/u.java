package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(PbActivity pbActivity, int i) {
        super(i);
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ey eyVar;
        PbModel pbModel;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        com.baidu.tbadk.core.view.h hVar2;
        com.baidu.adp.base.g gVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.ejU.ejj;
            if (tag == bdUniqueId) {
                eyVar = this.ejU.eiS;
                eyVar.aIs();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                pbModel = this.ejU.eif;
                com.baidu.tieba.pb.data.f pbData = pbModel.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aJJ().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar2 = this.ejU.eji;
                    gVar3 = this.ejU.ejh;
                    hVar2.c(gVar3.getResources().getString(w.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        gVar2 = this.ejU.ejh;
                        errorString = gVar2.getResources().getString(w.l.mute_error_beyond_limit);
                    }
                    this.ejU.fD(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.au.isEmpty(errorString2)) {
                        gVar = this.ejU.ejh;
                        errorString2 = gVar.getResources().getString(w.l.mute_fail);
                    }
                    hVar = this.ejU.eji;
                    hVar.d(errorString2);
                } else {
                    this.ejU.aKT();
                }
            }
        }
    }
}
