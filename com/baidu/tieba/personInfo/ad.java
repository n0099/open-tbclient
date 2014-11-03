package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ UserData aQa;
    final /* synthetic */ z bGF;
    private final /* synthetic */ EditText bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, EditText editText, UserData userData) {
        this.bGF = zVar;
        this.bGG = editText;
        this.aQa = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.bGG.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.aQa.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.aQa.getName_show());
            requestApplyLocalMessage.setPortrait(this.aQa.getPortrait());
            requestApplyLocalMessage.setId(this.aQa.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
