package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonInfoActivity f1629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonInfoActivity personInfoActivity) {
        this.f1629a = personInfoActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.f1629a);
        imageView.setBackgroundResource(R.drawable.tips_center_chat);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 2;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return -15;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}
