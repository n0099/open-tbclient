package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.BarSuggestModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        SearchPostModel searchPostModel;
        e eVar5;
        e eVar6;
        SearchPostModel searchPostModel2;
        String str;
        e eVar7;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        e eVar8;
        e eVar9;
        SearchPostModel searchPostModel5;
        String str2;
        i2 = this.brF.mMode;
        if (i2 != 0) {
            eVar = this.brF.brk;
            if (eVar.getItemId(i) == -1) {
                eVar7 = this.brF.brk;
                if (eVar7.TD() == 0) {
                    searchPostModel3 = this.brF.bro;
                    if (searchPostModel3 != null) {
                        searchPostModel4 = this.brF.bro;
                        if (searchPostModel4.getCurrentPage() > 1) {
                            eVar8 = this.brF.brk;
                            eVar8.setRefreshing(1);
                            eVar9 = this.brF.brk;
                            eVar9.notifyDataSetChanged();
                            SquareSearchActivity squareSearchActivity = this.brF;
                            searchPostModel5 = this.brF.bro;
                            str2 = this.brF.brr;
                            squareSearchActivity.y(searchPostModel5.getCurrentPage() - 1, str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            eVar2 = this.brF.brk;
            if (eVar2.getItemId(i) == -2) {
                eVar4 = this.brF.brk;
                if (eVar4.TD() == 0) {
                    searchPostModel = this.brF.bro;
                    if (searchPostModel != null) {
                        eVar5 = this.brF.brk;
                        eVar5.setRefreshing(2);
                        eVar6 = this.brF.brk;
                        eVar6.notifyDataSetChanged();
                        SquareSearchActivity squareSearchActivity2 = this.brF;
                        searchPostModel2 = this.brF.bro;
                        str = this.brF.brr;
                        squareSearchActivity2.y(searchPostModel2.getCurrentPage() + 1, str);
                        return;
                    }
                    return;
                }
                return;
            }
            eVar3 = this.brF.brk;
            h hVar = (h) eVar3.getItem(i);
            if (hVar != null) {
                if (hVar.TG()) {
                    this.brF.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.brF.getPageContext().getPageActivity()).createNormalCfg(hVar.getTid(), null, "search_post")));
                    return;
                } else {
                    this.brF.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.brF.getPageContext().getPageActivity()).createNormalCfg(hVar.getTid(), hVar.getPid(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof BarSuggestModel.Forum) {
            String str3 = ((BarSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.brF.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            this.brF.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.brF.getPageContext().getPageActivity()).createFlagCfg(str3, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
