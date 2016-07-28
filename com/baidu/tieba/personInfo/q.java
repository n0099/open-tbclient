package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
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
            bdUniqueId = this.this$0.eAN;
            if (tag == bdUniqueId) {
                bVar = this.this$0.bvD;
                if (bVar != null) {
                    bVar2 = this.this$0.bvD;
                    bVar2.aE(false);
                }
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    hVar4 = this.this$0.ebo;
                    hVar5 = this.this$0.ebn;
                    hVar4.c(hVar5.getResources().getString(u.j.mute_success));
                    this.this$0.eAG = 1;
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        hVar3 = this.this$0.ebn;
                        errorString = hVar3.getResources().getString(u.j.mute_error_beyond_limit);
                    }
                    this.this$0.fF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.ba.isEmpty(errorString2)) {
                        hVar2 = this.this$0.ebn;
                        errorString2 = hVar2.getResources().getString(u.j.mute_fail);
                    }
                    hVar = this.this$0.ebo;
                    hVar.d(errorString2);
                } else {
                    this.this$0.aIr();
                }
            }
        }
    }
}
