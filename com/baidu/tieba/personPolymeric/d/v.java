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
    com.baidu.tieba.personPolymeric.event.a eJs = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eJt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eJt = tVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        UserData userData;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eJt.eCN;
        if (mVar != null) {
            this.eJs.bJo = 11;
            this.eJs.bJp = new Bundle();
            Bundle bundle = this.eJs.bJp;
            userData = this.eJt.mUserData;
            bundle.putSerializable(UserData.TYPE_USER, userData);
            mVar2 = this.eJt.eCN;
            mVar2.a(view, this.eJs);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        Context context;
        int color;
        Context context2;
        if (z) {
            context2 = this.eJt.mContext;
            color = context2.getResources().getColor(w.e.cp_cont_i);
        } else {
            context = this.eJt.mContext;
            color = context.getResources().getColor(w.e.cp_bg_line_d_alpha70);
        }
        textPaint.setColor(color);
    }
}
