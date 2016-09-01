package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* loaded from: classes.dex */
class v extends CustomMessageListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(PbActivity pbActivity, int i) {
        super(i);
        this.eob = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        ex exVar;
        dh dhVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.tbadk.core.view.h hVar4;
        com.baidu.adp.base.h hVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.eob.enx;
            if (tag == bdUniqueId) {
                exVar = this.eob.enh;
                exVar.aKF();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                dhVar = this.eob.emx;
                com.baidu.tieba.pb.data.h pbData = dhVar.getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.aLZ().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.eob.enw;
                    hVar5 = this.eob.env;
                    hVar4.c(hVar5.getResources().getString(t.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.eob.env;
                        errorString = hVar3.getResources().getString(t.j.mute_error_beyond_limit);
                    }
                    this.eob.fI(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ba.isEmpty(errorString2)) {
                        hVar2 = this.eob.env;
                        errorString2 = hVar2.getResources().getString(t.j.mute_fail);
                    }
                    hVar = this.eob.enw;
                    hVar.d(errorString2);
                } else {
                    this.eob.aNj();
                }
            }
        }
    }
}
