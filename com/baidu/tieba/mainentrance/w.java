package com.baidu.tieba.mainentrance;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.at;
import com.baidu.tieba.model.BarSuggestModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        e eVar;
        e eVar2;
        e eVar3;
        SearchPostModel searchPostModel;
        SearchPostModel searchPostModel2;
        String str;
        e eVar4;
        e eVar5;
        SearchPostModel searchPostModel3;
        SearchPostModel searchPostModel4;
        SearchPostModel searchPostModel5;
        String str2;
        e eVar6;
        e eVar7;
        i2 = this.a.z;
        if (i2 != 0) {
            eVar = this.a.o;
            if (eVar.getItemId(i) != -1) {
                eVar2 = this.a.o;
                if (eVar2.getItemId(i) != -2) {
                    eVar3 = this.a.o;
                    at atVar = (at) eVar3.getItem(i);
                    if (atVar != null) {
                        if (atVar.a()) {
                            this.a.sendMessage(new CustomMessage(2004001, new bc(this.a).a(atVar.c(), null, "search_post")));
                            return;
                        } else {
                            this.a.sendMessage(new CustomMessage(2004001, new bc(this.a).a(atVar.c(), atVar.b(), "search_post")));
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
                    eVar4 = this.a.o;
                    eVar4.a(2);
                    eVar5 = this.a.o;
                    eVar5.notifyDataSetChanged();
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
                    eVar6 = this.a.o;
                    eVar6.a(1);
                    eVar7 = this.a.o;
                    eVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        TiebaStatic.eventStat(this.a, "search_bar_result_click", "click", 1, new Object[0]);
        this.a.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.a).a(str3, "tb_searchlist", 1)));
    }
}
