package com.baidu.tieba.usermute;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel cOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.cOT = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.a aVar;
        n nVar;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        n nVar2;
        BaseActivity baseActivity3;
        UserMuteAddAndDelModel.a aVar2;
        UserMuteAddAndDelModel.a aVar3;
        aVar = this.cOT.aMv;
        aVar.av(false);
        if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
            if (userMuteAddResponseMessage.getMuteErrorCode() == UserMuteAddAndDelModel.cOL) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH));
                nVar2 = this.cOT.cOP;
                baseActivity3 = this.cOT.aSJ;
                nVar2.dp(baseActivity3.getResources().getString(i.C0057i.mute_success));
                if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                    aVar2 = this.cOT.cON;
                    if (aVar2 != null) {
                        aVar3 = this.cOT.cON;
                        aVar3.a(userMuteAddResponseMessage);
                    }
                }
            } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                String errorString = userMuteAddResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    baseActivity2 = this.cOT.aSJ;
                    errorString = baseActivity2.getResources().getString(i.C0057i.mute_error_beyond_limit);
                }
                this.cOT.eQ(errorString);
            } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                String errorString2 = userMuteAddResponseMessage.getErrorString();
                if (aq.isEmpty(errorString2)) {
                    baseActivity = this.cOT.aSJ;
                    errorString2 = baseActivity.getResources().getString(i.C0057i.mute_fail);
                }
                nVar = this.cOT.cOP;
                nVar.dq(errorString2);
            } else {
                this.cOT.atk();
            }
        }
    }
}
