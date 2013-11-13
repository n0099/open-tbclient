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
public class bh implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(SquareSearchActivity squareSearchActivity) {
        this.f2402a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.bd bdVar;
        com.baidu.tieba.home.bd bdVar2;
        com.baidu.tieba.home.bd bdVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        com.baidu.tieba.home.bd bdVar4;
        com.baidu.tieba.home.bd bdVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        com.baidu.tieba.home.bd bdVar6;
        com.baidu.tieba.home.bd bdVar7;
        i2 = this.f2402a.C;
        if (i2 != 0) {
            bdVar = this.f2402a.s;
            if (bdVar.getItemId(i) == -1) {
                searchPostModel3 = this.f2402a.y;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.f2402a.y;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SquareSearchActivity squareSearchActivity = this.f2402a;
                        searchPostModel5 = this.f2402a.y;
                        str2 = this.f2402a.B;
                        squareSearchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        bdVar6 = this.f2402a.s;
                        bdVar6.a(1);
                        bdVar7 = this.f2402a.s;
                        bdVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            bdVar2 = this.f2402a.s;
            if (bdVar2.getItemId(i) == -2) {
                searchPostModel = this.f2402a.y;
                if (searchPostModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.f2402a;
                    searchPostModel2 = this.f2402a.y;
                    str = this.f2402a.B;
                    squareSearchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    bdVar4 = this.f2402a.s;
                    bdVar4.a(2);
                    bdVar5 = this.f2402a.s;
                    bdVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            bdVar3 = this.f2402a.s;
            com.baidu.tieba.data.av avVar = (com.baidu.tieba.data.av) bdVar3.getItem(i);
            if (avVar != null) {
                if (avVar.a()) {
                    NewPbActivity.a(this.f2402a, avVar.c(), null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.f2402a, avVar.c(), avVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2402a, "search_bar_result_click", "click", 1);
        }
        FrsActivity.a(this.f2402a, str3, "tb_searchlist", 1);
        this.f2402a.finish();
    }
}
