package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.bCE = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        c cVar;
        i2 = this.bCE.mMode;
        if (i2 == 0) {
            cVar = this.bCE.bBT;
            e item = cVar.getItem(i);
            if (item != null) {
                String forumName = item.getForumName();
                TiebaStatic.eventStat(this.bCE.getPageContext().getPageActivity(), "search_hot_word", "click", 1, "loc", Integer.valueOf(i));
                this.bCE.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bCE.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }
}
