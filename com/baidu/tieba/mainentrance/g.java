package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar bPU;
    private final /* synthetic */ TbPageContext bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.bPU = searchPageFocusBar;
        this.bPV = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bPV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.bPV.getPageActivity()).createNormalCfg(1)));
    }
}
