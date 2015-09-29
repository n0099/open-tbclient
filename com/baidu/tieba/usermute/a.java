package com.baidu.tieba.usermute;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.response.UserMuteAddResponseMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ UserMuteAddAndDelModel diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(UserMuteAddAndDelModel userMuteAddAndDelModel, int i) {
        super(i);
        this.diB = userMuteAddAndDelModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        com.baidu.tbadk.core.view.a aVar;
        com.baidu.tbadk.core.view.f fVar;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        com.baidu.tbadk.core.view.f fVar2;
        BaseActivity baseActivity3;
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        UserMuteAddAndDelModel.a aVar2;
        UserMuteAddAndDelModel.a aVar3;
        aVar = this.diB.aLD;
        aVar.av(false);
        if (httpResponsedMessage instanceof UserMuteAddResponseMessage) {
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) httpResponsedMessage;
            if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_USER_MUTE_LIST_NEED_REFRESH));
                fVar2 = this.diB.dix;
                baseActivity3 = this.diB.aRT;
                fVar2.dA(baseActivity3.getResources().getString(i.h.mute_success));
                from = this.diB.diu;
                if (from != UserMuteAddAndDelModel.From.PB) {
                    from2 = this.diB.diu;
                    if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                        TiebaStatic.log("c10043");
                    }
                } else {
                    TiebaStatic.log("c10034");
                }
                aVar2 = this.diB.div;
                if (aVar2 != null) {
                    aVar3 = this.diB.div;
                    aVar3.a(userMuteAddResponseMessage);
                }
            } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                String errorString = userMuteAddResponseMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    baseActivity2 = this.diB.aRT;
                    errorString = baseActivity2.getResources().getString(i.h.mute_error_beyond_limit);
                }
                this.diB.fd(errorString);
            } else if (userMuteAddResponseMessage.getMuteErrorCode() != 1990043) {
                String errorString2 = userMuteAddResponseMessage.getErrorString();
                if (ar.isEmpty(errorString2)) {
                    baseActivity = this.diB.aRT;
                    errorString2 = baseActivity.getResources().getString(i.h.mute_fail);
                }
                fVar = this.diB.dix;
                fVar.dB(errorString2);
            } else {
                this.diB.aAy();
            }
        }
    }
}
