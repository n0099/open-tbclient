package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.cmr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.k.c(this.cmr.getPageContext().getPageActivity(), this.cmr.cln);
        if (view.getTag() instanceof g) {
            g gVar = (g) view.getTag();
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10363").ab("obj_name", gVar.getName()));
            this.cmr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.cmr.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(gVar.getId()), gVar.getName(), "")));
        }
    }
}
