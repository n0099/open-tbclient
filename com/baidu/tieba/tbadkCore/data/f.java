package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.h {
    final /* synthetic */ c csb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c cVar, Context context) {
        super(context);
        this.csb = cVar;
    }

    @Override // com.baidu.tbadk.util.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        str = this.csb.text;
        if (str != null) {
            str3 = this.csb.text;
            str4 = str3.replace("@", "").replace(" ", "");
        }
        MessageManager messageManager = MessageManager.getInstance();
        Context context = getContext();
        str2 = this.csb.link;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, str2, str4)));
    }
}
