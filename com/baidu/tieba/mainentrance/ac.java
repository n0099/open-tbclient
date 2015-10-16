package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import com.baidu.tieba.postsearch.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x009b: IGET  (r4v12 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d0: IGET  (r5v3 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0101: IGET  (r3v1 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0110: IGET  (r4v6 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.pid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0142: IGET  (r5v0 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0151: IGET  (r6v1 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.j$a) com.baidu.tieba.postsearch.j.a.pid long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        j.a aVar;
        ListAdapter adapter;
        if (this.bVC.mMode != 0) {
            Object item = this.bVC.bUP.getItem(i);
            if ((item instanceof j.a) && (aVar = (j.a) item) != null) {
                if (aVar.is_floor != 1) {
                    if (aVar.thread_type == 33) {
                        TiebaStatic.log("c10257");
                        this.bVC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bVC.getPageContext().getPageActivity(), new StringBuilder().append(aVar.tid).toString()).rk()));
                        return;
                    }
                    this.bVC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bVC.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(aVar.tid).toString(), null, "search_post")));
                    return;
                } else if (aVar.thread_type == 33) {
                    this.bVC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(this.bVC.getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder().append(aVar.tid).toString(), new StringBuilder().append(aVar.pid).toString(), false)));
                    return;
                } else {
                    this.bVC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bVC.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(aVar.tid).toString(), new StringBuilder().append(aVar.pid).toString(), "search_post")));
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
                TiebaStatic.eventStat(this.bVC.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                this.bVC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bVC.getPageContext().getPageActivity()).createFlagCfg(str, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
            }
        }
    }
}
