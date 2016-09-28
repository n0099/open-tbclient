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
    com.baidu.tieba.personPolymeric.event.a eLJ = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.eLK = tVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        UserData userData;
        com.baidu.tieba.view.m mVar2;
        mVar = this.eLK.eFl;
        if (mVar != null) {
            this.eLJ.bJq = 11;
            this.eLJ.bJr = new Bundle();
            Bundle bundle = this.eLJ.bJr;
            userData = this.eLK.mUserData;
            bundle.putSerializable(UserData.TYPE_USER, userData);
            mVar2 = this.eLK.eFl;
            mVar2.a(view, this.eLJ);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        Context context;
        int color;
        Context context2;
        if (z) {
            context2 = this.eLK.mContext;
            color = context2.getResources().getColor(r.d.cp_cont_i);
        } else {
            context = this.eLK.mContext;
            color = context.getResources().getColor(r.d.cp_bg_line_d_alpha70);
        }
        textPaint.setColor(color);
    }
}
