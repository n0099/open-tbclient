package com.baidu.tieba.person.a;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    private final /* synthetic */ UserData bMM;
    final /* synthetic */ v cQW;
    private final /* synthetic */ EditText cQX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar, EditText editText, UserData userData) {
        this.cQW = vVar;
        this.cQX = editText;
        this.bMM = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.cQX.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.bMM.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.bMM.getName_show());
            requestApplyLocalMessage.setPortrait(this.bMM.getPortrait());
            requestApplyLocalMessage.setId(this.bMM.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
