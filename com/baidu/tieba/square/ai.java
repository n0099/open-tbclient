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
public class ai implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f2341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.f2341a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.au auVar;
        com.baidu.tieba.home.au auVar2;
        com.baidu.tieba.home.au auVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        com.baidu.tieba.home.au auVar4;
        com.baidu.tieba.home.au auVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        com.baidu.tieba.home.au auVar6;
        com.baidu.tieba.home.au auVar7;
        i2 = this.f2341a.F;
        if (i2 != 0) {
            auVar = this.f2341a.v;
            if (auVar.getItemId(i) == -1) {
                searchPostModel3 = this.f2341a.B;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.f2341a.B;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SquareSearchActivity squareSearchActivity = this.f2341a;
                        searchPostModel5 = this.f2341a.B;
                        str2 = this.f2341a.E;
                        squareSearchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        auVar6 = this.f2341a.v;
                        auVar6.a(1);
                        auVar7 = this.f2341a.v;
                        auVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            auVar2 = this.f2341a.v;
            if (auVar2.getItemId(i) == -2) {
                searchPostModel = this.f2341a.B;
                if (searchPostModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.f2341a;
                    searchPostModel2 = this.f2341a.B;
                    str = this.f2341a.E;
                    squareSearchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    auVar4 = this.f2341a.v;
                    auVar4.a(2);
                    auVar5 = this.f2341a.v;
                    auVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            auVar3 = this.f2341a.v;
            com.baidu.tieba.data.ax axVar = (com.baidu.tieba.data.ax) auVar3.getItem(i);
            if (axVar != null) {
                if (axVar.a()) {
                    NewPbActivity.a(this.f2341a, axVar.c(), null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.f2341a, axVar.c(), axVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f2341a, "search_bar_result_click", "click", 1);
        }
        FrsActivity.a(this.f2341a, str3, "tb_searchlist", 1);
        this.f2341a.finish();
    }
}
