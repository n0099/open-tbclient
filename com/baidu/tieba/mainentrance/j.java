package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar cpi;
    private final /* synthetic */ TbPageContext cpj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.cpi = searchPageFocusBar;
        this.cpj = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cpj.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.cpj.getPageActivity()).createNormalCfg(1)));
    }
}
