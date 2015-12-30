package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity cqu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.cqu = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        com.baidu.adp.lib.util.k.c(this.cqu.getPageContext().getPageActivity(), this.cqu.cpr);
        if (this.cqu.mMode == 0 && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            bVar = this.cqu.cpy;
            c item = bVar.getItem(intValue);
            long j = 0;
            if (item != null) {
                j = item.getForumId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10364").aa(ImageViewerConfig.FORUM_ID, new StringBuilder(String.valueOf(j)).toString()));
            if (item != null) {
                String forumName = item.getForumName();
                TiebaStatic.eventStat(this.cqu.getPageContext().getPageActivity(), "search_hot_word", "click", 1, "loc", Integer.valueOf(intValue));
                this.cqu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cqu.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }
}
