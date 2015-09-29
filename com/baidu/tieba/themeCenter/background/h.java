package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalBackdropListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g deS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.deS = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BackgroundGroupActivity backgroundGroupActivity;
        TiebaStatic.log("c10283");
        backgroundGroupActivity = this.deS.deH;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropListActivityConfig(backgroundGroupActivity.getActivity())));
    }
}
