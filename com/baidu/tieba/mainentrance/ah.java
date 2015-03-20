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
public class ah implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        PostSuggestModel postSuggestModel;
        i iVar5;
        i iVar6;
        PostSuggestModel postSuggestModel2;
        String str;
        i iVar7;
        PostSuggestModel postSuggestModel3;
        PostSuggestModel postSuggestModel4;
        i iVar8;
        i iVar9;
        PostSuggestModel postSuggestModel5;
        String str2;
        i2 = this.bzG.mMode;
        if (i2 != 0) {
            iVar = this.bzG.bzg;
            if (iVar.getItemId(i) == -1) {
                iVar7 = this.bzG.bzg;
                if (iVar7.WD() == 0) {
                    postSuggestModel3 = this.bzG.bzj;
                    if (postSuggestModel3 != null) {
                        postSuggestModel4 = this.bzG.bzj;
                        if (postSuggestModel4.getCurrentPage() > 1) {
                            iVar8 = this.bzG.bzg;
                            iVar8.setRefreshing(1);
                            iVar9 = this.bzG.bzg;
                            iVar9.notifyDataSetChanged();
                            SquareSearchActivity squareSearchActivity = this.bzG;
                            postSuggestModel5 = this.bzG.bzj;
                            str2 = this.bzG.bzm;
                            squareSearchActivity.y(postSuggestModel5.getCurrentPage() - 1, str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            iVar2 = this.bzG.bzg;
            if (iVar2.getItemId(i) == -2) {
                iVar4 = this.bzG.bzg;
                if (iVar4.WD() == 0) {
                    postSuggestModel = this.bzG.bzj;
                    if (postSuggestModel != null) {
                        iVar5 = this.bzG.bzg;
                        iVar5.setRefreshing(2);
                        iVar6 = this.bzG.bzg;
                        iVar6.notifyDataSetChanged();
                        SquareSearchActivity squareSearchActivity2 = this.bzG;
                        postSuggestModel2 = this.bzG.bzj;
                        str = this.bzG.bzm;
                        squareSearchActivity2.y(postSuggestModel2.getCurrentPage() + 1, str);
                        return;
                    }
                    return;
                }
                return;
            }
            iVar3 = this.bzG.bzg;
            l lVar = (l) iVar3.getItem(i);
            if (lVar != null) {
                if (lVar.WG()) {
                    this.bzG.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bzG.getPageContext().getPageActivity()).createNormalCfg(lVar.getTid(), null, "search_post")));
                    return;
                } else {
                    this.bzG.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bzG.getPageContext().getPageActivity()).createNormalCfg(lVar.getTid(), lVar.getPid(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof ForumSuggestModel.Forum) {
            String str3 = ((ForumSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.bzG.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            this.bzG.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzG.getPageContext().getPageActivity()).createFlagCfg(str3, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
