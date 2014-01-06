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
        com.baidu.tieba.home.az azVar;
        com.baidu.tieba.home.az azVar2;
        com.baidu.tieba.home.az azVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        com.baidu.tieba.home.az azVar4;
        com.baidu.tieba.home.az azVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        com.baidu.tieba.home.az azVar6;
        com.baidu.tieba.home.az azVar7;
        i2 = this.a.D;
        if (i2 != 0) {
            azVar = this.a.t;
            if (azVar.getItemId(i) == -1) {
                searchPostModel3 = this.a.z;
                if (searchPostModel3 != null) {
                    searchPostModel4 = this.a.z;
                    if (searchPostModel4.getCurrentPage() > 1) {
                        SquareSearchActivity squareSearchActivity = this.a;
                        searchPostModel5 = this.a.z;
                        str2 = this.a.C;
                        squareSearchActivity.a(searchPostModel5.getCurrentPage() - 1, str2);
                        azVar6 = this.a.t;
                        azVar6.a(1);
                        azVar7 = this.a.t;
                        azVar7.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                return;
            }
            azVar2 = this.a.t;
            if (azVar2.getItemId(i) == -2) {
                searchPostModel = this.a.z;
                if (searchPostModel != null) {
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    searchPostModel2 = this.a.z;
                    str = this.a.C;
                    squareSearchActivity2.a(searchPostModel2.getCurrentPage() + 1, str);
                    azVar4 = this.a.t;
                    azVar4.a(2);
                    azVar5 = this.a.t;
                    azVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            azVar3 = this.a.t;
            com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) azVar3.getItem(i);
            if (awVar != null) {
                if (awVar.a()) {
                    NewPbActivity.a(this.a, awVar.c(), (String) null, "search_post");
                    return;
                } else {
                    NewPbActivity.a(this.a, awVar.c(), awVar.b(), "search_post");
                    return;
                }
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.a, "search_bar_result_click", "click", 1);
        }
        FrsActivity.a(this.a, str3, "tb_searchlist", 1);
        this.a.finish();
    }
}
