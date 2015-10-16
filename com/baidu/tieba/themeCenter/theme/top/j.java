package com.baidu.tieba.themeCenter.theme.top;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AllThemeListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h dhB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.dhB = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TopThemeListActivity topThemeListActivity;
        TiebaStatic.log("c10272");
        topThemeListActivity = this.dhB.dhz;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AllThemeListActivityConfig(topThemeListActivity.getActivity())));
    }
}
