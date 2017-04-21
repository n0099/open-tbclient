package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {
    final /* synthetic */ t eJt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.eJt = tVar;
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
        view = this.eJt.eJm;
        animation2 = this.eJt.eJr;
        view.setAnimation(animation2);
        i = this.eJt.eJn;
        if (i % 2 == 1) {
            userData = this.eJt.mUserData;
            if (userData.getLiveStatus() == 1) {
                view4 = this.eJt.eJm;
                view4.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(0);
                textView5 = this.eJt.eJp;
                textView5.setVisibility(8);
                textView6 = this.eJt.eJo;
                context3 = this.eJt.mContext;
                textView6.setText(context3.getResources().getString(w.l.person_polymeric_ala_entry_live));
            } else {
                view3 = this.eJt.eJm;
                view3.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(8);
                textView3 = this.eJt.eJp;
                textView3.setVisibility(0);
                textView4 = this.eJt.eJo;
                context2 = this.eJt.mContext;
                textView4.setText(context2.getResources().getString(w.l.go_to_live_post_prefix));
            }
        } else {
            view2 = this.eJt.eJm;
            view2.findViewById(w.h.person_polymeric_header_livepoint).setVisibility(8);
            textView = this.eJt.eJp;
            textView.setVisibility(0);
            textView2 = this.eJt.eJo;
            context = this.eJt.mContext;
            textView2.setText(context.getResources().getString(w.l.person_polymeric_ala_live_title));
        }
        t tVar = this.eJt;
        i2 = tVar.eJn;
        tVar.eJn = i2 + 1;
        animation3 = this.eJt.eJr;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
