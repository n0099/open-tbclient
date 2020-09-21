package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.List;
import java.util.Map;
/* loaded from: classes21.dex */
final class dp implements AdapterView.OnItemClickListener {
    final /* synthetic */ FeedbackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(FeedbackListActivity feedbackListActivity) {
        this.a = feedbackListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        List list;
        du duVar;
        List list2;
        List list3;
        list = this.a.e;
        ((Map) list.get(i)).put("newmsg", "0");
        duVar = this.a.u;
        duVar.notifyDataSetChanged();
        Intent intent = new Intent();
        intent.setClass(this.a, FeedbackInputActivity.class);
        list2 = this.a.e;
        intent.putExtra("msgid", (String) ((Map) list2.get(i)).get("id"));
        list3 = this.a.e;
        intent.putExtra("appid", (String) ((Map) list3.get(i)).get("appid"));
        intent.putExtra("fromList", true);
        intent.putExtra("fromEdit", false);
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        this.a.startActivity(intent);
    }
}
