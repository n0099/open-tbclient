package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.cMQ = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        com.baidu.adp.lib.util.k.a(this.cMQ.getPageContext().getPageActivity(), this.cMQ.cLO);
        if (this.cMQ.mMode == 0 && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            bVar = this.cMQ.cLV;
            c item = bVar.getItem(intValue);
            long j = 0;
            if (item != null) {
                j = item.getForumId();
            }
            TiebaStatic.log(new aw("c10364").ac("fid", new StringBuilder(String.valueOf(j)).toString()));
            if (item != null) {
                String forumName = item.getForumName();
                TiebaStatic.eventStat(this.cMQ.getPageContext().getPageActivity(), "search_hot_word", "click", 1, "loc", Integer.valueOf(intValue));
                this.cMQ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cMQ.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }
}
