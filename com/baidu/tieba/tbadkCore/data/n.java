package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.util.i {
    final /* synthetic */ k fuh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(k kVar, Context context) {
        super(context);
        this.fuh = kVar;
    }

    @Override // com.baidu.tbadk.util.i, android.text.style.ClickableSpan
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        str = this.fuh.text;
        if (str != null) {
            str3 = this.fuh.text;
            str3.replace("@", "").replace(" ", "");
        }
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getContext());
        str2 = this.fuh.link;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, personPolymericActivityConfig.createNormalConfig(com.baidu.adp.lib.g.b.c(str2, 0L), false)));
    }
}
