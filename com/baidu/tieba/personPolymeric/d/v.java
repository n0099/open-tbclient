package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.view.q {
    com.baidu.tieba.personPolymeric.event.a eJh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eJi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eJi = tVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        UserData userData;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eJi.eCA;
        if (mVar != null) {
            this.eJh.bHe = 11;
            this.eJh.bHf = new Bundle();
            Bundle bundle = this.eJh.bHf;
            userData = this.eJi.mUserData;
            bundle.putSerializable(UserData.TYPE_USER, userData);
            mVar2 = this.eJi.eCA;
            mVar2.a(view, this.eJh);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        Context context;
        int color;
        Context context2;
        if (z) {
            context2 = this.eJi.mContext;
            color = context2.getResources().getColor(w.e.cp_cont_i);
        } else {
            context = this.eJi.mContext;
            color = context.getResources().getColor(w.e.cp_bg_line_d_alpha70);
        }
        textPaint.setColor(color);
    }
}
