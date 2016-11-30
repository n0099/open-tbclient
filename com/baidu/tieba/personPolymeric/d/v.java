package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.view.q {
    com.baidu.tieba.personPolymeric.event.a eSh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eSi = tVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        UserData userData;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eSi.eLK;
        if (mVar != null) {
            this.eSh.bMj = 11;
            this.eSh.bMk = new Bundle();
            Bundle bundle = this.eSh.bMk;
            userData = this.eSi.mUserData;
            bundle.putSerializable(UserData.TYPE_USER, userData);
            mVar2 = this.eSi.eLK;
            mVar2.a(view, this.eSh);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        Context context;
        int color;
        Context context2;
        if (z) {
            context2 = this.eSi.mContext;
            color = context2.getResources().getColor(r.d.cp_cont_i);
        } else {
            context = this.eSi.mContext;
            color = context.getResources().getColor(r.d.cp_bg_line_d_alpha70);
        }
        textPaint.setColor(color);
    }
}
