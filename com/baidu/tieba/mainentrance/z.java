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
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
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
        i2 = this.bta.mMode;
        if (i2 != 0) {
            eVar = this.bta.bsG;
            if (eVar.getItemId(i) == -1) {
                eVar7 = this.bta.bsG;
                if (eVar7.TU() == 0) {
                    searchPostModel3 = this.bta.bsK;
                    if (searchPostModel3 != null) {
                        searchPostModel4 = this.bta.bsK;
                        if (searchPostModel4.getCurrentPage() > 1) {
                            eVar8 = this.bta.bsG;
                            eVar8.setRefreshing(1);
                            eVar9 = this.bta.bsG;
                            eVar9.notifyDataSetChanged();
                            SquareSearchActivity squareSearchActivity = this.bta;
                            searchPostModel5 = this.bta.bsK;
                            str2 = this.bta.bsN;
                            squareSearchActivity.y(searchPostModel5.getCurrentPage() - 1, str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            eVar2 = this.bta.bsG;
            if (eVar2.getItemId(i) == -2) {
                eVar4 = this.bta.bsG;
                if (eVar4.TU() == 0) {
                    searchPostModel = this.bta.bsK;
                    if (searchPostModel != null) {
                        eVar5 = this.bta.bsG;
                        eVar5.setRefreshing(2);
                        eVar6 = this.bta.bsG;
                        eVar6.notifyDataSetChanged();
                        SquareSearchActivity squareSearchActivity2 = this.bta;
                        searchPostModel2 = this.bta.bsK;
                        str = this.bta.bsN;
                        squareSearchActivity2.y(searchPostModel2.getCurrentPage() + 1, str);
                        return;
                    }
                    return;
                }
                return;
            }
            eVar3 = this.bta.bsG;
            h hVar = (h) eVar3.getItem(i);
            if (hVar != null) {
                if (hVar.TX()) {
                    this.bta.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bta.getPageContext().getPageActivity()).createNormalCfg(hVar.getTid(), null, "search_post")));
                    return;
                } else {
                    this.bta.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bta.getPageContext().getPageActivity()).createNormalCfg(hVar.getTid(), hVar.getPid(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof BarSuggestModel.Forum) {
            String str3 = ((BarSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.bta.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            this.bta.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bta.getPageContext().getPageActivity()).createFlagCfg(str3, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
