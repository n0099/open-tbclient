package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BdUniqueId bdUniqueId;
        com.baidu.tbadk.core.view.b bVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.tbadk.core.view.h hVar4;
        com.baidu.adp.base.h hVar5;
        com.baidu.tbadk.core.view.b bVar2;
        if (customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null) {
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            bdUniqueId = this.this$0.eoX;
            if (tag == bdUniqueId) {
                bVar = this.this$0.btp;
                if (bVar != null) {
                    bVar2 = this.this$0.btp;
                    bVar2.aB(false);
                }
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.this$0.dPb;
                    hVar5 = this.this$0.dPa;
                    hVar4.c(hVar5.getResources().getString(u.j.mute_success));
                    this.this$0.eoQ = 1;
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.this$0.dPa;
                        errorString = hVar3.getResources().getString(u.j.mute_error_beyond_limit);
                    }
                    this.this$0.fH(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ba.isEmpty(errorString2)) {
                        hVar2 = this.this$0.dPa;
                        errorString2 = hVar2.getResources().getString(u.j.mute_fail);
                    }
                    hVar = this.this$0.dPb;
                    hVar.d(errorString2);
                } else {
                    this.this$0.aFg();
                }
            }
        }
    }
}
