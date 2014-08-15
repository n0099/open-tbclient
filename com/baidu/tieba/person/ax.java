package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.newFriends.RequestApplyLocalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ as a;
    private final /* synthetic */ EditText b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(as asVar, EditText editText, UserData userData) {
        this.a = asVar;
        this.b = editText;
        this.c = userData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String str;
        String str2;
        String str3;
        this.a.e = this.b.getText().toString().trim();
        str = this.a.e;
        if (!TextUtils.isEmpty(str)) {
            RequestApplyLocalMessage requestApplyLocalMessage = new RequestApplyLocalMessage();
            requestApplyLocalMessage.setUid(Long.valueOf(TbadkApplication.getCurrentAccount()).longValue());
            requestApplyLocalMessage.setFriendId(this.c.getUserIdLong());
            str2 = this.a.e;
            requestApplyLocalMessage.setMessage(str2);
            str3 = this.a.e;
            requestApplyLocalMessage.setContent(str3);
            requestApplyLocalMessage.setName(this.c.getName_show());
            requestApplyLocalMessage.setPortrait(this.c.getPortrait());
            requestApplyLocalMessage.setId(this.c.getUserIdLong());
            MessageManager.getInstance().dispatchResponsedMessageToUI(requestApplyLocalMessage);
            aVar.c();
        }
    }
}
