package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar cKK;
    private final /* synthetic */ TbPageContext cKL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.cKK = searchPageFocusBar;
        this.cKL = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cKL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.cKL.getPageActivity()).createNormalCfg(1)));
    }
}
