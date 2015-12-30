package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.k.c(this.cqu.getPageContext().getPageActivity(), this.cqu.cpr);
        if (view.getTag() instanceof g) {
            g gVar = (g) view.getTag();
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10363").aa("obj_name", gVar.getName()));
            this.cqu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.cqu.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(gVar.getId()), gVar.getName(), "")));
        }
    }
}
