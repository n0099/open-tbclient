package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cLU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SquareSearchActivity squareSearchActivity) {
        this.cLU = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.k.c(this.cLU.getPageContext().getPageActivity(), this.cLU.cKS);
        if (view.getTag() instanceof g) {
            g gVar = (g) view.getTag();
            TiebaStatic.log(new aw("c10363").ac("obj_name", gVar.getName()));
            this.cLU.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(this.cLU.getPageContext().getPageActivity()).createNormalConfig(String.valueOf(gVar.getId()), gVar.getName(), "")));
        }
    }
}
