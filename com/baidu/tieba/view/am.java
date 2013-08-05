package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1819a;
    private final /* synthetic */ com.baidu.tieba.data.bl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar, com.baidu.tieba.data.bl blVar) {
        this.f1819a = alVar;
        this.b = blVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai aiVar;
        ao aoVar;
        ai aiVar2;
        int i;
        ai aiVar3;
        ImageView imageView;
        ai aiVar4;
        PopupWindow popupWindow;
        ai aiVar5;
        ImageView imageView2;
        ai aiVar6;
        ao aoVar2;
        ai aiVar7;
        TextView textView;
        ai aiVar8;
        Context context;
        aiVar = this.f1819a.f1818a;
        aoVar = aiVar.l;
        if (aoVar != null) {
            aiVar6 = this.f1819a.f1818a;
            aoVar2 = aiVar6.l;
            aoVar2.a(this.b);
            aiVar7 = this.f1819a.f1818a;
            textView = aiVar7.g;
            textView.setText(this.b.b());
            if (TiebaApplication.f().t()) {
                aiVar8 = this.f1819a.f1818a;
                context = aiVar8.f1815a;
                StatService.onEvent(context, "recommend_menu", "click", 1);
            }
        }
        aiVar2 = this.f1819a.f1818a;
        i = aiVar2.m;
        if (i == 1) {
            aiVar5 = this.f1819a.f1818a;
            imageView2 = aiVar5.d;
            imageView2.setBackgroundResource(R.drawable.icon_arrow_down_list_down_1);
        } else {
            aiVar3 = this.f1819a.f1818a;
            imageView = aiVar3.d;
            imageView.setBackgroundResource(R.drawable.icon_arrow_down_list_down);
        }
        aiVar4 = this.f1819a.f1818a;
        popupWindow = aiVar4.f;
        popupWindow.dismiss();
    }
}
