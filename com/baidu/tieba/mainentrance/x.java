package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import com.baidu.tieba.postsearch.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.bQZ = squareSearchActivity;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0094: IGET  (r5v3 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00c5: IGET  (r5v0 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d4: IGET  (r6v1 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.pid long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j.a aVar;
        ListAdapter adapter;
        if (this.bQZ.mMode != 0) {
            Object item = this.bQZ.bQn.getItem(i);
            if ((item instanceof j.a) && (aVar = (j.a) item) != null) {
                if (aVar.is_floor != 1) {
                    this.bQZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bQZ.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(aVar.tid).toString(), null, "search_post")));
                    return;
                } else {
                    this.bQZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bQZ.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(aVar.tid).toString(), new StringBuilder().append(aVar.pid).toString(), "search_post")));
                    return;
                }
            }
            return;
        }
        ListView listView = (ListView) adapterView;
        if (listView != null && (adapter = listView.getAdapter()) != null && adapter.getCount() != 0 && i < adapter.getCount()) {
            Object item2 = adapter.getItem(i);
            if (item2 instanceof ForumSuggestModel.Forum) {
                String str = ((ForumSuggestModel.Forum) item2).forum_name;
                TiebaStatic.eventStat(this.bQZ.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                this.bQZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bQZ.getPageContext().getPageActivity()).createFlagCfg(str, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
            }
        }
    }
}
