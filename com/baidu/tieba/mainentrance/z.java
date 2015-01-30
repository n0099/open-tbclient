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
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
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
        i2 = this.btb.mMode;
        if (i2 != 0) {
            eVar = this.btb.bsH;
            if (eVar.getItemId(i) == -1) {
                eVar7 = this.btb.bsH;
                if (eVar7.TZ() == 0) {
                    searchPostModel3 = this.btb.bsL;
                    if (searchPostModel3 != null) {
                        searchPostModel4 = this.btb.bsL;
                        if (searchPostModel4.getCurrentPage() > 1) {
                            eVar8 = this.btb.bsH;
                            eVar8.setRefreshing(1);
                            eVar9 = this.btb.bsH;
                            eVar9.notifyDataSetChanged();
                            SquareSearchActivity squareSearchActivity = this.btb;
                            searchPostModel5 = this.btb.bsL;
                            str2 = this.btb.bsO;
                            squareSearchActivity.y(searchPostModel5.getCurrentPage() - 1, str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            eVar2 = this.btb.bsH;
            if (eVar2.getItemId(i) == -2) {
                eVar4 = this.btb.bsH;
                if (eVar4.TZ() == 0) {
                    searchPostModel = this.btb.bsL;
                    if (searchPostModel != null) {
                        eVar5 = this.btb.bsH;
                        eVar5.setRefreshing(2);
                        eVar6 = this.btb.bsH;
                        eVar6.notifyDataSetChanged();
                        SquareSearchActivity squareSearchActivity2 = this.btb;
                        searchPostModel2 = this.btb.bsL;
                        str = this.btb.bsO;
                        squareSearchActivity2.y(searchPostModel2.getCurrentPage() + 1, str);
                        return;
                    }
                    return;
                }
                return;
            }
            eVar3 = this.btb.bsH;
            h hVar = (h) eVar3.getItem(i);
            if (hVar != null) {
                if (hVar.Uc()) {
                    this.btb.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.btb.getPageContext().getPageActivity()).createNormalCfg(hVar.getTid(), null, "search_post")));
                    return;
                } else {
                    this.btb.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.btb.getPageContext().getPageActivity()).createNormalCfg(hVar.getTid(), hVar.getPid(), "search_post")));
                    return;
                }
            }
            return;
        }
        Object item = ((ListView) adapterView).getAdapter().getItem(i);
        if (item instanceof BarSuggestModel.Forum) {
            String str3 = ((BarSuggestModel.Forum) item).forum_name;
            TiebaStatic.eventStat(this.btb.getPageContext().getPageActivity(), "search_bar_result_click", "click", 1, new Object[0]);
            this.btb.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.btb.getPageContext().getPageActivity()).createFlagCfg(str3, FrsActivityConfig.FRS_FROM_SEARCH, 1)));
        }
    }
}
