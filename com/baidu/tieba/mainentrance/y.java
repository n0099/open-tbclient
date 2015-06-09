package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bCF = squareSearchActivity;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0080: IGET  (r5v3 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k) com.baidu.tieba.postsearch.k.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00b0: IGET  (r5v0 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k) com.baidu.tieba.postsearch.k.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00bf: IGET  (r6v1 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k) com.baidu.tieba.postsearch.k.pid long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.postsearch.w wVar;
        i2 = this.bCF.mMode;
        if (i2 != 0) {
            wVar = this.bCF.bCa;
            com.baidu.tieba.postsearch.k kVar = (com.baidu.tieba.postsearch.k) wVar.getItem(i);
            if (kVar != null) {
                if (kVar.is_floor != 1) {
                    this.bCF.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bCF.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(kVar.tid).toString(), null, "search_post")));
                    return;
                } else {
                    this.bCF.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bCF.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(kVar.tid).toString(), new StringBuilder().append(kVar.pid).toString(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof ForumSuggestModel.Forum) {
            String str = ((ForumSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.bCF.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            this.bCF.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bCF.getPageContext().getPageActivity()).createFlagCfg(str, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
