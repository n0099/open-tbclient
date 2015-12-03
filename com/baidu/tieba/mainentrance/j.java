package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ SearchPageFocusBar cle;
    private final /* synthetic */ TbPageContext clf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SearchPageFocusBar searchPageFocusBar, TbPageContext tbPageContext) {
        this.cle = searchPageFocusBar;
        this.clf = tbPageContext;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.clf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.clf.getPageActivity()).createNormalCfg(1)));
    }
}
