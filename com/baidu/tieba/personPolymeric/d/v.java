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
    com.baidu.tieba.personPolymeric.event.a evG = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t evH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.evH = tVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        UserData userData;
        com.baidu.tieba.view.m mVar2;
        mVar = this.evH.epg;
        if (mVar != null) {
            this.evG.bsn = 11;
            this.evG.bso = new Bundle();
            Bundle bundle = this.evG.bso;
            userData = this.evH.mUserData;
            bundle.putSerializable(UserData.TYPE_USER, userData);
            mVar2 = this.evH.epg;
            mVar2.a(view, this.evG);
        }
    }

    @Override // com.baidu.tieba.view.q
    public void a(TextPaint textPaint, boolean z) {
        Context context;
        int color;
        Context context2;
        if (z) {
            context2 = this.evH.mContext;
            color = context2.getResources().getColor(r.d.cp_cont_i);
        } else {
            context = this.evH.mContext;
            color = context.getResources().getColor(r.d.cp_bg_line_d_alpha70);
        }
        textPaint.setColor(color);
    }
}
