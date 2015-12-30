package com.baidu.tieba.themeCenter.theme.top;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DownloadedThemeListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h dOS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dOS = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TopThemeListActivity topThemeListActivity;
        TiebaStatic.log("c10273");
        topThemeListActivity = this.dOS.dOQ;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DownloadedThemeListActivityConfig(topThemeListActivity.getActivity())));
    }
}
