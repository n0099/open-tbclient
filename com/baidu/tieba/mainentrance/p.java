package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.aw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.as;
import com.baidu.tieba.model.BarSuggestModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        c cVar;
        c cVar2;
        c cVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        c cVar4;
        c cVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        c cVar6;
        c cVar7;
        i2 = this.a.z;
        if (i2 != 0) {
            cVar = this.a.p;
            if (cVar.getItemId(i) != -1) {
                cVar2 = this.a.p;
                if (cVar2.getItemId(i) != -2) {
                    cVar3 = this.a.p;
                    as asVar = (as) cVar3.getItem(i);
                    if (asVar != null) {
                        if (asVar.a()) {
                            this.a.sendMessage(new CustomMessage(2004001, new aw(this.a).a(asVar.c(), null, "search_post")));
                            return;
                        } else {
                            this.a.sendMessage(new CustomMessage(2004001, new aw(this.a).a(asVar.c(), asVar.b(), "search_post")));
                            return;
                        }
                    }
                    return;
                }
                searchPostModel = this.a.v;
                if (searchPostModel != null) {
                    SquareSearchActivity squareSearchActivity = this.a;
                    searchPostModel2 = this.a.v;
                    str = this.a.y;
                    squareSearchActivity.a(searchPostModel2.getCurrentPage() + 1, str);
                    cVar4 = this.a.p;
                    cVar4.a(2);
                    cVar5 = this.a.p;
                    cVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            searchPostModel3 = this.a.v;
            if (searchPostModel3 != null) {
                searchPostModel4 = this.a.v;
                if (searchPostModel4.getCurrentPage() > 1) {
                    SquareSearchActivity squareSearchActivity2 = this.a;
                    searchPostModel5 = this.a.v;
                    str2 = this.a.y;
                    squareSearchActivity2.a(searchPostModel5.getCurrentPage() - 1, str2);
                    cVar6 = this.a.p;
                    cVar6.a(1);
                    cVar7 = this.a.p;
                    cVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        TiebaStatic.eventStat(this.a, "search_bar_result_click", "click", 1, new Object[0]);
        this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this.a).a(str3, "tb_searchlist", 1)));
    }
}
