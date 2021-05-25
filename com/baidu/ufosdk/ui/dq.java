package com.baidu.ufosdk.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class dq implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f22763a;

    public dq(FeedbackListActivity feedbackListActivity) {
        this.f22763a = feedbackListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j) {
        List list;
        List list2;
        View a2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        PopupWindow popupWindow4;
        RelativeLayout relativeLayout;
        list = this.f22763a.f22602e;
        list2 = this.f22763a.f22602e;
        FeedbackListActivity feedbackListActivity = this.f22763a;
        a2 = feedbackListActivity.a(feedbackListActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("3"), (String) ((Map) list.get(i2)).get("id"), (String) ((Map) list2.get(i2)).get("appid"));
        this.f22763a.z = new PopupWindow(a2, com.baidu.ufosdk.f.i.a(this.f22763a.getApplicationContext(), 79.0f), com.baidu.ufosdk.f.i.a(this.f22763a.getApplicationContext(), 68.0f));
        popupWindow = this.f22763a.z;
        popupWindow.setFocusable(false);
        popupWindow2 = this.f22763a.z;
        popupWindow2.setOutsideTouchable(true);
        popupWindow3 = this.f22763a.z;
        popupWindow3.setBackgroundDrawable(new BitmapDrawable());
        a2.getLocationOnScreen(new int[2]);
        popupWindow4 = this.f22763a.z;
        relativeLayout = this.f22763a.f22598a;
        popupWindow4.showAtLocation(relativeLayout, 17, 0, 0);
        return true;
    }
}
