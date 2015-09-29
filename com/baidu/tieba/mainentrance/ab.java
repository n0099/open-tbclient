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
    final /* synthetic */ SquareSearchActivity bVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.bVr = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        com.baidu.adp.lib.util.k.c(this.bVr.getPageContext().getPageActivity(), this.bVr.bUp);
        if (this.bVr.mMode == 0 && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            bVar = this.bVr.bUw;
            c item = bVar.getItem(intValue);
            long j = 0;
            if (item != null) {
                j = item.getForumId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10364").ae(ImageViewerConfig.FORUM_ID, new StringBuilder(String.valueOf(j)).toString()));
            if (item != null) {
                String forumName = item.getForumName();
                TiebaStatic.eventStat(this.bVr.getPageContext().getPageActivity(), "search_hot_word", "click", 1, "loc", Integer.valueOf(intValue));
                this.bVr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bVr.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }
}
