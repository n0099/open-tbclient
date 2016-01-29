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
import com.baidu.tieba.postsearch.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.cwZ = squareSearchActivity;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00a0: IGET  (r4v12 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k$a) com.baidu.tieba.postsearch.k.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x00d5: IGET  (r5v3 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k$a) com.baidu.tieba.postsearch.k.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0106: IGET  (r3v1 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k$a) com.baidu.tieba.postsearch.k.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0115: IGET  (r4v6 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k$a) com.baidu.tieba.postsearch.k.a.pid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0147: IGET  (r5v0 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k$a) com.baidu.tieba.postsearch.k.a.tid long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0156: IGET  (r6v1 long A[REMOVE]) = (r0v5 com.baidu.tieba.postsearch.k$a) com.baidu.tieba.postsearch.k.a.pid long)] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k.a aVar;
        ListAdapter adapter;
        if (this.cwZ.mMode != 0) {
            Object item = this.cwZ.cwl.getItem(i);
            if ((item instanceof k.a) && (aVar = (k.a) item) != null) {
                if (aVar.is_floor != 1) {
                    if (aVar.thread_type == 33) {
                        TiebaStatic.log("c10257");
                        this.cwZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.cwZ.getPageContext().getPageActivity(), new StringBuilder().append(aVar.tid).toString()).rC()));
                        return;
                    }
                    this.cwZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cwZ.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(aVar.tid).toString(), null, "search_post")));
                    return;
                } else if (aVar.thread_type == 33) {
                    this.cwZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(this.cwZ.getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(new StringBuilder().append(aVar.tid).toString(), new StringBuilder().append(aVar.pid).toString(), false)));
                    return;
                } else {
                    this.cwZ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.cwZ.getPageContext().getPageActivity()).createNormalCfg(new StringBuilder().append(aVar.tid).toString(), new StringBuilder().append(aVar.pid).toString(), "search_post")));
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
                TiebaStatic.eventStat(this.cwZ.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
                this.cwZ.cwr = true;
                this.cwZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.cwZ.getPageContext().getPageActivity()).createFlagCfg(str, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
            }
        }
    }
}
