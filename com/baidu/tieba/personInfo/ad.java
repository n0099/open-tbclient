package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ UserData aRI;
    final /* synthetic */ z bJZ;
    private final /* synthetic */ EditText bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar, EditText editText, UserData userData) {
        this.bJZ = zVar;
        this.bKa = editText;
        this.aRI = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.bKa.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.aRI.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.aRI.getName_show());
            requestApplyLocalMessage.setPortrait(this.aRI.getPortrait());
            requestApplyLocalMessage.setId(this.aRI.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
