package com.baidu.tieba.person.a;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* loaded from: classes.dex */
class aa implements a.b {
    private final /* synthetic */ UserData cHe;
    final /* synthetic */ w egx;
    private final /* synthetic */ EditText egy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, EditText editText, UserData userData) {
        this.egx = wVar;
        this.egy = editText;
        this.cHe = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.egy.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.cHe.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.cHe.getName_show());
            requestApplyLocalMessage.setPortrait(this.cHe.getPortrait());
            requestApplyLocalMessage.setId(this.cHe.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
