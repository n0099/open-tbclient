package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ThMainActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad dyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.dyh = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.dyh.mContext;
        if (bl.ac(context)) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dyh.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ThMainActivityConfig(context2)));
        }
    }
}
