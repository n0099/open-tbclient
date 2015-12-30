package com.baidu.tieba.themeCenter.theme.all;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.DownloadedThemeListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h dOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dOc = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AllThemeListActivity allThemeListActivity;
        TiebaStatic.log("c10273");
        allThemeListActivity = this.dOc.dNZ;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new DownloadedThemeListActivityConfig(allThemeListActivity.getActivity())));
    }
}
