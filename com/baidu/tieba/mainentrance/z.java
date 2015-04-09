package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        boolean z;
        c cVar;
        i2 = this.bzT.mMode;
        if (i2 == 0) {
            z = this.bzT.bzG;
            if (z) {
                cVar = this.bzT.bzp;
                e item = cVar.getItem(i);
                if (item != null) {
                    String forumName = item.getForumName();
                    TiebaStatic.eventStat(this.bzT.getPageContext().getPageActivity(), "search_hot_word", "click", 1, "loc", Integer.valueOf(i));
                    this.bzT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzT.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SEARCH)));
                }
            }
        }
    }
}
