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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        k kVar;
        k kVar2;
        k kVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        k kVar4;
        k kVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        k kVar6;
        k kVar7;
        i2 = this.a.D;
        if (i2 != 0) {
            kVar = this.a.t;
            if (kVar.getItemId(i) != -1) {
                kVar2 = this.a.t;
                if (kVar2.getItemId(i) != -2) {
                    kVar3 = this.a.t;
                    au auVar = (au) kVar3.getItem(i);
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
                    kVar4 = this.a.t;
                    kVar4.a(2);
                    kVar5 = this.a.t;
                    kVar5.notifyDataSetChanged();
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
                    kVar6 = this.a.t;
                    kVar6.a(1);
                    kVar7 = this.a.t;
                    kVar7.notifyDataSetChanged();
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
