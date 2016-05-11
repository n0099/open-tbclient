package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar cLG;
    private final /* synthetic */ TbPageContext cLH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.cLG = searchPageFocusBar;
        this.cLH = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cLH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.cLH.getPageActivity()).createNormalCfg(1)));
    }
}
