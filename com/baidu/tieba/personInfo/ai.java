package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements a.b {
    private final /* synthetic */ UserData btZ;
    final /* synthetic */ ae cwe;
    private final /* synthetic */ EditText cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar, EditText editText, UserData userData) {
        this.cwe = aeVar;
        this.cwf = editText;
        this.btZ = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.cwf.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.btZ.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.btZ.getName_show());
            requestApplyLocalMessage.setPortrait(this.btZ.getPortrait());
            requestApplyLocalMessage.setId(this.btZ.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
