package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.model.BarSuggestModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
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
        i2 = this.bmO.mMode;
        if (i2 != 0) {
            eVar = this.bmO.bmt;
            if (eVar.getItemId(i) == -1) {
                eVar7 = this.bmO.bmt;
                if (eVar7.Sx() == 0) {
                    searchPostModel3 = this.bmO.bmx;
                    if (searchPostModel3 != null) {
                        searchPostModel4 = this.bmO.bmx;
                        if (searchPostModel4.getCurrentPage() > 1) {
                            eVar8 = this.bmO.bmt;
                            eVar8.setRefreshing(1);
                            eVar9 = this.bmO.bmt;
                            eVar9.notifyDataSetChanged();
                            SquareSearchActivity squareSearchActivity = this.bmO;
                            searchPostModel5 = this.bmO.bmx;
                            str2 = this.bmO.bmA;
                            squareSearchActivity.o(searchPostModel5.getCurrentPage() - 1, str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            eVar2 = this.bmO.bmt;
            if (eVar2.getItemId(i) == -2) {
                eVar4 = this.bmO.bmt;
                if (eVar4.Sx() == 0) {
                    searchPostModel = this.bmO.bmx;
                    if (searchPostModel != null) {
                        eVar5 = this.bmO.bmt;
                        eVar5.setRefreshing(2);
                        eVar6 = this.bmO.bmt;
                        eVar6.notifyDataSetChanged();
                        SquareSearchActivity squareSearchActivity2 = this.bmO;
                        searchPostModel2 = this.bmO.bmx;
                        str = this.bmO.bmA;
                        squareSearchActivity2.o(searchPostModel2.getCurrentPage() + 1, str);
                        return;
                    }
                    return;
                }
                return;
            }
            eVar3 = this.bmO.bmt;
            aq aqVar = (aq) eVar3.getItem(i);
            if (aqVar != null) {
                if (aqVar.Ap()) {
                    this.bmO.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bmO).createNormalCfg(aqVar.getTid(), null, "search_post")));
                    return;
                } else {
                    this.bmO.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bmO).createNormalCfg(aqVar.getTid(), aqVar.getPid(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof BarSuggestModel.Forum) {
            String str3 = ((BarSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.bmO, "search_bar_result_click", "click", 1, new Object[0]);
            this.bmO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bmO).createFlagCfg(str3, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
