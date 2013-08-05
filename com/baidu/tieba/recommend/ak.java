package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FindInterestFragment findInterestFragment) {
        this.f1641a = findInterestFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        aq aqVar;
        Activity activity;
        Activity activity2;
        aqVar = this.f1641a.b;
        com.baidu.tieba.data.af b = aqVar.b(i);
        if (b != null && b.e() != null) {
            String e = b.e();
            activity = this.f1641a.d;
            NewPbActivity.a(activity, e, null, null);
            activity2 = this.f1641a.d;
            StatService.onEvent(activity2, "findinterest_to_pb", "enter_pb");
        }
    }
}
