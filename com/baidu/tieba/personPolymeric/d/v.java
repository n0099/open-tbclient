package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.view.q {
    com.baidu.tieba.personPolymeric.event.a eJG = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eJH = tVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        UserData userData;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eJH.eDi;
        if (mVar != null) {
            this.eJG.bJp = 11;
            this.eJG.bJq = new Bundle();
            Bundle bundle = this.eJG.bJq;
            userData = this.eJH.mUserData;
            bundle.putSerializable(UserData.TYPE_USER, userData);
            mVar2 = this.eJH.eDi;
            mVar2.a(view, this.eJG);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        Context context;
        int color;
        Context context2;
        if (z) {
            context2 = this.eJH.mContext;
            color = context2.getResources().getColor(t.d.cp_cont_i);
        } else {
            context = this.eJH.mContext;
            color = context.getResources().getColor(t.d.cp_bg_line_d_alpha70);
        }
        textPaint.setColor(color);
    }
}
