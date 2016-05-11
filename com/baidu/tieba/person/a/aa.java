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
    private final /* synthetic */ UserData cbI;
    final /* synthetic */ w dyb;
    private final /* synthetic */ EditText dyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar, EditText editText, UserData userData) {
        this.dyb = wVar;
        this.dyc = editText;
        this.cbI = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.dyc.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.cbI.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.cbI.getName_show());
            requestApplyLocalMessage.setPortrait(this.cbI.getPortrait());
            requestApplyLocalMessage.setId(this.cbI.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
