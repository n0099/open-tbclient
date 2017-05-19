package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class y implements Animation.AnimationListener {
    final /* synthetic */ w eFi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.eFi = wVar;
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
        view = this.eFi.eFb;
        animation2 = this.eFi.eFg;
        view.setAnimation(animation2);
        i = this.eFi.eFc;
        if (i % 2 == 1) {
            userData = this.eFi.mUserData;
            if (userData.getLiveStatus() == 1) {
                view4 = this.eFi.eFb;
                view4.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(0);
                textView5 = this.eFi.eFe;
                textView5.setVisibility(8);
                textView6 = this.eFi.eFd;
                context3 = this.eFi.mContext;
                textView6.setText(context3.getResources().getString(w.l.person_polymeric_ala_entry_live));
            } else {
                view3 = this.eFi.eFb;
                view3.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(8);
                textView3 = this.eFi.eFe;
                textView3.setVisibility(0);
                textView4 = this.eFi.eFd;
                context2 = this.eFi.mContext;
                textView4.setText(context2.getResources().getString(w.l.go_to_live_post_prefix));
            }
        } else {
            view2 = this.eFi.eFb;
            view2.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(8);
            textView = this.eFi.eFe;
            textView.setVisibility(0);
            textView2 = this.eFi.eFd;
            context = this.eFi.mContext;
            textView2.setText(context.getResources().getString(w.l.person_polymeric_ala_live_title));
        }
        w wVar = this.eFi;
        i2 = wVar.eFc;
        wVar.eFc = i2 + 1;
        animation3 = this.eFi.eFg;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
