package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {
    final /* synthetic */ t eJi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.eJi = tVar;
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
        view = this.eJi.eJb;
        animation2 = this.eJi.eJg;
        view.setAnimation(animation2);
        i = this.eJi.eJc;
        if (i % 2 == 1) {
            userData = this.eJi.mUserData;
            if (userData.getLiveStatus() == 1) {
                view4 = this.eJi.eJb;
                view4.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(0);
                textView5 = this.eJi.eJe;
                textView5.setVisibility(8);
                textView6 = this.eJi.eJd;
                context3 = this.eJi.mContext;
                textView6.setText(context3.getResources().getString(w.l.person_polymeric_ala_entry_live));
            } else {
                view3 = this.eJi.eJb;
                view3.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(8);
                textView3 = this.eJi.eJe;
                textView3.setVisibility(0);
                textView4 = this.eJi.eJd;
                context2 = this.eJi.mContext;
                textView4.setText(context2.getResources().getString(w.l.go_to_live_post_prefix));
            }
        } else {
            view2 = this.eJi.eJb;
            view2.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(8);
            textView = this.eJi.eJe;
            textView.setVisibility(0);
            textView2 = this.eJi.eJd;
            context = this.eJi.mContext;
            textView2.setText(context.getResources().getString(w.l.person_polymeric_ala_live_title));
        }
        t tVar = this.eJi;
        i2 = tVar.eJc;
        tVar.eJc = i2 + 1;
        animation3 = this.eJi.eJg;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
