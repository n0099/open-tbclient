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
    private final /* synthetic */ UserData btz;
    final /* synthetic */ ae cuI;
    private final /* synthetic */ EditText cuJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar, EditText editText, UserData userData) {
        this.cuI = aeVar;
        this.cuJ = editText;
        this.btz = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.cuJ.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.btz.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.btz.getName_show());
            requestApplyLocalMessage.setPortrait(this.btz.getPortrait());
            requestApplyLocalMessage.setId(this.btz.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
