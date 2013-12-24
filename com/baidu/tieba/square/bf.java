package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.ay ayVar;
        com.baidu.tieba.home.ay ayVar2;
        com.baidu.tieba.home.ay ayVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        com.baidu.tieba.home.ay ayVar4;
        com.baidu.tieba.home.ay ayVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        com.baidu.tieba.home.ay ayVar6;
        com.baidu.tieba.home.ay ayVar7;
        i2 = this.a.C;
        if (i2 != 0) {
            ayVar = this.a.s;
            if (ayVar.getItemId(i) == -1) {
                searchPostModel3 = this.a.y;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.a.y;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SquareSearchActivity squareSearchActivity = this.a;
                        searchPostModel5 = this.a.y;
                        str2 = this.a.B;
                        squareSearchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        ayVar6 = this.a.s;
                        ayVar6.a(1);
                        ayVar7 = this.a.s;
                        ayVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            ayVar2 = this.a.s;
            if (ayVar2.getItemId(i) == -2) {
                searchPostModel = this.a.y;
                if (searchPostModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    searchPostModel2 = this.a.y;
                    str = this.a.B;
                    squareSearchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    ayVar4 = this.a.s;
                    ayVar4.a(2);
                    ayVar5 = this.a.s;
                    ayVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ayVar3 = this.a.s;
            com.baidu.tieba.data.au auVar = (com.baidu.tieba.data.au) ayVar3.getItem(i);
            if (auVar != null) {
                if (auVar.a()) {
                    NewPbActivity.a(this.a, auVar.c(), null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.a, auVar.c(), auVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.a, "search_bar_result_click", "click", 1);
        }
        FrsActivity.a(this.a, str3, "tb_searchlist", 1);
        this.a.finish();
    }
}
