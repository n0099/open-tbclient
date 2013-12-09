package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f1902a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.f1902a.i;
        headImageView = this.f1902a.d;
        validateItemData = this.f1902a.j;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
