package com.baidu.ufosdk.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
final class dq implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackListActivity f3743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(FeedbackListActivity feedbackListActivity) {
        this.f3743a = feedbackListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        List list;
        List list2;
        View a2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        PopupWindow popupWindow4;
        RelativeLayout relativeLayout;
        list = this.f3743a.e;
        list2 = this.f3743a.e;
        a2 = this.f3743a.a(this.f3743a.getApplicationContext(), com.baidu.ufosdk.f.s.a("3"), (String) ((Map) list.get(i)).get("id"), (String) ((Map) list2.get(i)).get("appid"));
        this.f3743a.z = new PopupWindow(a2, com.baidu.ufosdk.f.i.a(this.f3743a.getApplicationContext(), 79.0f), com.baidu.ufosdk.f.i.a(this.f3743a.getApplicationContext(), 68.0f));
        popupWindow = this.f3743a.z;
        popupWindow.setFocusable(false);
        popupWindow2 = this.f3743a.z;
        popupWindow2.setOutsideTouchable(true);
        popupWindow3 = this.f3743a.z;
        popupWindow3.setBackgroundDrawable(new BitmapDrawable());
        a2.getLocationOnScreen(new int[2]);
        popupWindow4 = this.f3743a.z;
        relativeLayout = this.f3743a.f3644a;
        popupWindow4.showAtLocation(relativeLayout, 17, 0, 0);
        return true;
    }
}
