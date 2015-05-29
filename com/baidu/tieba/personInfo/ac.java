package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ z bWQ;
    private final /* synthetic */ EditText bWR;
    private final /* synthetic */ UserData bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar, EditText editText, UserData userData) {
        this.bWQ = zVar;
        this.bWR = editText;
        this.bbT = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String trim = this.bWR.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkCoreApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.bbT.getUserIdLong());
            requestApplyLocalMessage.setMessage(trim);
            requestApplyLocalMessage.setContent(trim);
            requestApplyLocalMessage.setName(this.bbT.getName_show());
            requestApplyLocalMessage.setPortrait(this.bbT.getPortrait());
            requestApplyLocalMessage.setId(this.bbT.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.dismiss();
        }
    }
}
