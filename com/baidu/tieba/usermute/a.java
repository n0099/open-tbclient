package com.baidu.tieba.usermute;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel eVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.eVj = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.b bVar;
        com.baidu.tbadk.core.view.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.adp.base.h hVar3;
        com.baidu.tbadk.core.view.h hVar4;
        com.baidu.adp.base.h hVar5;
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        UserMuteAddAndDelModel.a aVar;
        UserMuteAddAndDelModel.a aVar2;
        bVar = this.eVj.aXt;
        bVar.aD(false);
        if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
            if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH));
                hVar4 = this.eVj.eVf;
                hVar5 = this.eVj.eVb;
                hVar4.c(hVar5.getResources().getString(t.j.mute_success));
                from = this.eVj.eVc;
                if (from != UserMuteAddAndDelModel.From.PB) {
                    from2 = this.eVj.eVc;
                    if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                        TiebaStatic.log("c10043");
                    }
                } else {
                    TiebaStatic.log("c10034");
                }
                aVar = this.eVj.eVd;
                if (aVar != null) {
                    aVar2 = this.eVj.eVd;
                    aVar2.a(userMuteAddResponseMessage);
                }
            } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                String errorString = userMuteAddResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    hVar3 = this.eVj.eVb;
                    errorString = hVar3.getResources().getString(t.j.mute_error_beyond_limit);
                }
                this.eVj.fB(errorString);
            } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                String errorString2 = userMuteAddResponseMessage.getErrorString();
                if (ay.isEmpty(errorString2)) {
                    hVar2 = this.eVj.eVb;
                    errorString2 = hVar2.getResources().getString(t.j.mute_fail);
                }
                hVar = this.eVj.eVf;
                hVar.d(errorString2);
            } else {
                this.eVj.baN();
            }
        }
    }
}
