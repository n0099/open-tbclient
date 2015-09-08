package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar bQA;
    private final /* synthetic */ TbPageContext bQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.bQA = searchPageFocusBar;
        this.bQB = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bQB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.bQB.getPageActivity()).createNormalCfg(1)));
    }
}
