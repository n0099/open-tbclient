package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1628a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonInfoActivity personInfoActivity) {
        this.f1628a = personInfoActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.tip_person_info_send_message, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}
