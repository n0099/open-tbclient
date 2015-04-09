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
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        i iVar;
        i2 = this.bzT.mMode;
        if (i2 != 0) {
            iVar = this.bzT.bzt;
            k kVar = (k) iVar.getItem(i);
            if (kVar != null) {
                if (kVar.WQ()) {
                    this.bzT.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bzT.getPageContext().getPageActivity()).createNormalCfg(kVar.getTid(), null, "search_post")));
                    return;
                } else {
                    this.bzT.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bzT.getPageContext().getPageActivity()).createNormalCfg(kVar.getTid(), kVar.getPid(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof ForumSuggestModel.Forum) {
            String str = ((ForumSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.bzT.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            this.bzT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzT.getPageContext().getPageActivity()).createFlagCfg(str, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
