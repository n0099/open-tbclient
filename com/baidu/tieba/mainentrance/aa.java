package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        boolean z;
        c cVar;
        i2 = this.bzG.mMode;
        if (i2 == 0) {
            z = this.bzG.bzt;
            if (z) {
                cVar = this.bzG.bzd;
                e item = cVar.getItem(i);
                if (item != null) {
                    String forumName = item.getForumName();
                    TiebaStatic.eventStat(this.bzG.getPageContext().getPageActivity(), "search_hot_word", "click", 1, "loc", Integer.valueOf(i));
                    this.bzG.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzG.getPageContext().getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SEARCH)));
                }
            }
        }
    }
}
