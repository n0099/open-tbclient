package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.e {
    final /* synthetic */ b cIB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(b bVar, Context context) {
        super(context);
        this.cIB = bVar;
    }

    @Override // com.baidu.tbadk.util.e, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        str = this.cIB.text;
        if (str != null) {
            str3 = this.cIB.text;
            str4 = str3.replace("@", "").replace(" ", "");
        }
        MessageManager messageManager = MessageManager.getInstance();
        Context context = getContext();
        str2 = this.cIB.link;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, str2, str4)));
    }
}
