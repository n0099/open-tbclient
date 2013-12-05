package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f1901a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.f1901a.i;
        headImageView = this.f1901a.d;
        validateItemData = this.f1901a.j;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
