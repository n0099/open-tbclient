package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.au;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.cb;
/* loaded from: classes.dex */
final class r implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        h hVar;
        h hVar2;
        h hVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        h hVar4;
        h hVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        h hVar6;
        h hVar7;
        i2 = this.a.D;
        if (i2 != 0) {
            hVar = this.a.t;
            if (hVar.getItemId(i) != -1) {
                hVar2 = this.a.t;
                if (hVar2.getItemId(i) != -2) {
                    hVar3 = this.a.t;
                    au auVar = (au) hVar3.getItem(i);
                    if (auVar != null) {
                        if (auVar.a()) {
                            NewPbActivity.a(this.a, auVar.c(), (String) null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.a, auVar.c(), auVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                searchPostModel = this.a.z;
                if (searchPostModel != null) {
                    SquareSearchActivity squareSearchActivity = this.a;
                    searchPostModel2 = this.a.z;
                    str = this.a.C;
                    squareSearchActivity.a(searchPostModel2.getCurrentPage() + 1, str);
                    hVar4 = this.a.t;
                    hVar4.a(2);
                    hVar5 = this.a.t;
                    hVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            searchPostModel3 = this.a.z;
            if (searchPostModel3 != null) {
                searchPostModel4 = this.a.z;
                if (searchPostModel4.getCurrentPage() > 1) {
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    searchPostModel5 = this.a.z;
                    str2 = this.a.C;
                    squareSearchActivity2.a(searchPostModel5.getCurrentPage() - 1, str2);
                    hVar6 = this.a.t;
                    hVar6.a(1);
                    hVar7 = this.a.t;
                    hVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        cb.a(this.a, "search_bar_result_click", "click", 1, new Object[0]);
        FrsActivity.a(this.a, str3, "tb_searchlist", 1);
        this.a.finish();
    }
}
