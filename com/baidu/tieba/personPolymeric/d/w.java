package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {
    final /* synthetic */ t eFG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.eFG = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        Animation animation2;
        int i;
        View view2;
        TextView textView;
        TextView textView2;
        Context context;
        int i2;
        Animation animation3;
        UserData userData;
        View view3;
        TextView textView3;
        TextView textView4;
        Context context2;
        View view4;
        TextView textView5;
        TextView textView6;
        Context context3;
        view = this.eFG.eFz;
        animation2 = this.eFG.eFE;
        view.setAnimation(animation2);
        i = this.eFG.eFA;
        if (i % 2 == 1) {
            userData = this.eFG.mUserData;
            if (userData.getLiveStatus() == 1) {
                view4 = this.eFG.eFz;
                view4.findViewById(r.h.person_polymeric_header_livepoint).setVisibility(0);
                textView5 = this.eFG.eFC;
                textView5.setVisibility(8);
                textView6 = this.eFG.eFB;
                context3 = this.eFG.mContext;
                textView6.setText(context3.getResources().getString(r.l.person_polymeric_ala_entry_live));
            } else {
                view3 = this.eFG.eFz;
                view3.findViewById(r.h.person_polymeric_header_livepoint).setVisibility(8);
                textView3 = this.eFG.eFC;
                textView3.setVisibility(0);
                textView4 = this.eFG.eFB;
                context2 = this.eFG.mContext;
                textView4.setText(context2.getResources().getString(r.l.go_to_live_post_prefix));
            }
        } else {
            view2 = this.eFG.eFz;
            view2.findViewById(r.h.person_polymeric_header_livepoint).setVisibility(8);
            textView = this.eFG.eFC;
            textView.setVisibility(0);
            textView2 = this.eFG.eFB;
            context = this.eFG.mContext;
            textView2.setText(context.getResources().getString(r.l.person_polymeric_ala_live_title));
        }
        t tVar = this.eFG;
        i2 = tVar.eFA;
        tVar.eFA = i2 + 1;
        animation3 = this.eFG.eFE;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
