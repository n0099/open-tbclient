package com.baidu.tieba.usermute;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.dIS = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.b bVar;
        com.baidu.tbadk.core.view.g gVar;
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        com.baidu.tbadk.core.view.g gVar2;
        com.baidu.adp.base.h hVar3;
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        UserMuteAddAndDelModel.a aVar;
        UserMuteAddAndDelModel.a aVar2;
        bVar = this.dIS.aQC;
        bVar.ay(false);
        if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
            if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH));
                gVar2 = this.dIS.dIO;
                hVar3 = this.dIS.dIK;
                gVar2.d(hVar3.getResources().getString(n.i.mute_success));
                from = this.dIS.dIL;
                if (from != UserMuteAddAndDelModel.From.PB) {
                    from2 = this.dIS.dIL;
                    if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                        TiebaStatic.log("c10043");
                    }
                } else {
                    TiebaStatic.log("c10034");
                }
                aVar = this.dIS.dIM;
                if (aVar != null) {
                    aVar2 = this.dIS.dIM;
                    aVar2.a(userMuteAddResponseMessage);
                }
            } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                String errorString = userMuteAddResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    hVar2 = this.dIS.dIK;
                    errorString = hVar2.getResources().getString(n.i.mute_error_beyond_limit);
                }
                this.dIS.fu(errorString);
            } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                String errorString2 = userMuteAddResponseMessage.getErrorString();
                if (ax.isEmpty(errorString2)) {
                    hVar = this.dIS.dIK;
                    errorString2 = hVar.getResources().getString(n.i.mute_fail);
                }
                gVar = this.dIS.dIO;
                gVar.e(errorString2);
            } else {
                this.dIS.aGF();
            }
        }
    }
}
