package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar cvP;
    private final /* synthetic */ TbPageContext cvQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.cvP = searchPageFocusBar;
        this.cvQ = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cvQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.cvQ.getPageActivity()).createNormalCfg(1)));
    }
}
