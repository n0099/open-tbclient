package com.baidu.tieba.view;

import android.widget.ImageView;
import android.widget.PopupWindow;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ak implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aj f1815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.f1815a = ajVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ai aiVar;
        int i;
        ai aiVar2;
        ImageView imageView;
        ai aiVar3;
        ImageView imageView2;
        aiVar = this.f1815a.f1814a;
        i = aiVar.m;
        if (i == 1) {
            aiVar3 = this.f1815a.f1814a;
            imageView2 = aiVar3.d;
            imageView2.setBackgroundResource(R.drawable.icon_arrow_down_list_down_1);
            return;
        }
        aiVar2 = this.f1815a.f1814a;
        imageView = aiVar2.d;
        imageView.setBackgroundResource(R.drawable.icon_arrow_down_list_down);
    }
}
