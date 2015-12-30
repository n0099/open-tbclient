package com.baidu.tieba.themeCenter.bubble.group;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.BubbleListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dNj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dNj = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BubbleGroupActivity bubbleGroupActivity;
        TiebaStatic.log("c10283");
        bubbleGroupActivity = this.dNj.dNf;
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleListActivityConfig(bubbleGroupActivity.getActivity())));
    }
}
