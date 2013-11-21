package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f1801a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.f1801a.i;
        headImageView = this.f1801a.d;
        validateItemData = this.f1801a.j;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
