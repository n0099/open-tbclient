package com.baidu.ufosdk.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
final class dq implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FeedbackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(FeedbackListActivity feedbackListActivity) {
        this.a = feedbackListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        List list;
        List list2;
        View a;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        PopupWindow popupWindow4;
        RelativeLayout relativeLayout;
        list = this.a.e;
        list2 = this.a.e;
        a = this.a.a(this.a.getApplicationContext(), com.baidu.ufosdk.f.s.a("3"), (String) ((Map) list.get(i)).get("id"), (String) ((Map) list2.get(i)).get("appid"));
        this.a.z = new PopupWindow(a, com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 79.0f), com.baidu.ufosdk.f.i.a(this.a.getApplicationContext(), 68.0f));
        popupWindow = this.a.z;
        popupWindow.setFocusable(false);
        popupWindow2 = this.a.z;
        popupWindow2.setOutsideTouchable(true);
        popupWindow3 = this.a.z;
        popupWindow3.setBackgroundDrawable(new BitmapDrawable());
        a.getLocationOnScreen(new int[2]);
        popupWindow4 = this.a.z;
        relativeLayout = this.a.a;
        popupWindow4.showAtLocation(relativeLayout, 17, 0, 0);
        return true;
    }
}
