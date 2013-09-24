package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.BarSuggestModel;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SquareSearchActivity f1820a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SquareSearchActivity squareSearchActivity) {
        this.f1820a = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        com.baidu.tieba.home.ao aoVar;
        com.baidu.tieba.home.ao aoVar2;
        com.baidu.tieba.home.ao aoVar3;
        com.baidu.tieba.data.ay ayVar;
        com.baidu.tieba.data.ay ayVar2;
        String str;
        com.baidu.tieba.home.ao aoVar4;
        com.baidu.tieba.home.ao aoVar5;
        com.baidu.tieba.data.ay ayVar3;
        com.baidu.tieba.data.ay ayVar4;
        com.baidu.tieba.data.ay ayVar5;
        String str2;
        com.baidu.tieba.home.ao aoVar6;
        com.baidu.tieba.home.ao aoVar7;
        i2 = this.f1820a.F;
        if (i2 != 0) {
            aoVar = this.f1820a.v;
            if (aoVar.getItemId(i) != -1) {
                aoVar2 = this.f1820a.v;
                if (aoVar2.getItemId(i) != -2) {
                    aoVar3 = this.f1820a.v;
                    com.baidu.tieba.data.ax axVar = (com.baidu.tieba.data.ax) aoVar3.getItem(i);
                    if (axVar != null) {
                        if (axVar.a()) {
                            NewPbActivity.a(this.f1820a, axVar.c(), null, "search_post");
                            return;
                        } else {
                            NewPbActivity.a(this.f1820a, axVar.c(), axVar.b(), "search_post");
                            return;
                        }
                    }
                    return;
                }
                ayVar = this.f1820a.B;
                if (ayVar != null) {
                    SquareSearchActivity squareSearchActivity = this.f1820a;
                    ayVar2 = this.f1820a.B;
                    str = this.f1820a.E;
                    squareSearchActivity.a(ayVar2.d() + 1, str);
                    aoVar4 = this.f1820a.v;
                    aoVar4.a(2);
                    aoVar5 = this.f1820a.v;
                    aoVar5.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ayVar3 = this.f1820a.B;
            if (ayVar3 != null) {
                ayVar4 = this.f1820a.B;
                if (ayVar4.d() > 1) {
                    SquareSearchActivity squareSearchActivity2 = this.f1820a;
                    ayVar5 = this.f1820a.B;
                    str2 = this.f1820a.E;
                    squareSearchActivity2.a(ayVar5.d() - 1, str2);
                    aoVar6 = this.f1820a.v;
                    aoVar6.a(1);
                    aoVar7 = this.f1820a.v;
                    aoVar7.notifyDataSetChanged();
                    return;
                }
                return;
            }
            return;
        }
        String str3 = ((BarSuggestModel.Forum) ((ListView) adapterView).getAdapter().getItem(i)).forum_name;
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.f1820a, "search_bar_result_click", "click", 1);
        }
        FrsActivity.a(this.f1820a, str3, "tb_searchlist", 1);
        this.f1820a.finish();
    }
}
