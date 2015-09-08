package com.baidu.tieba.usermute;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel cXA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.cXA = userMuteAddAndDelModel;
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
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        UserMuteAddAndDelModel.a aVar2;
        UserMuteAddAndDelModel.a aVar3;
        aVar = this.cXA.aMI;
        aVar.av(false);
        if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
            if (userMuteAddResponseMessage.getMuteErrorCode() == UserMuteAddAndDelModel.cXs) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH));
                nVar2 = this.cXA.cXw;
                baseActivity3 = this.cXA.aSX;
                nVar2.dw(baseActivity3.getResources().getString(i.h.mute_success));
                from = this.cXA.cXt;
                if (from != UserMuteAddAndDelModel.From.PB) {
                    from2 = this.cXA.cXt;
                    if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                        TiebaStatic.log(m.cXR);
                    }
                } else {
                    TiebaStatic.log(m.cXM);
                }
                aVar2 = this.cXA.cXu;
                if (aVar2 != null) {
                    aVar3 = this.cXA.cXu;
                    aVar3.a(userMuteAddResponseMessage);
                }
            } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                String errorString = userMuteAddResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    baseActivity2 = this.cXA.aSX;
                    errorString = baseActivity2.getResources().getString(i.h.mute_error_beyond_limit);
                }
                this.cXA.eY(errorString);
            } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                String errorString2 = userMuteAddResponseMessage.getErrorString();
                if (aq.isEmpty(errorString2)) {
                    baseActivity = this.cXA.aSX;
                    errorString2 = baseActivity.getResources().getString(i.h.mute_fail);
                }
                nVar = this.cXA.cXw;
                nVar.dx(errorString2);
            } else {
                this.cXA.axD();
            }
        }
    }
}
