package com.baidu.tieba.personPolymeric.d;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eSh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eSi = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        HeadPendantView headPendantView;
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        BdExpandImageView bdExpandImageView;
        ImageView imageView;
        TextView textView;
        UserData userData;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        com.baidu.tieba.view.m mVar2;
        UserData userData5;
        mVar = this.eSi.eLK;
        if (mVar != null) {
            this.eSh.bMj = -1;
            headPendantView = this.eSi.ggj;
            if (headPendantView != view) {
                userIconBox = this.eSi.ggl;
                if (userIconBox != view) {
                    userIconBox2 = this.eSi.ggm;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eSi.ggi;
                        if (bdExpandImageView != view) {
                            imageView = this.eSi.eSg;
                            if (imageView != view) {
                                textView = this.eSi.ggo;
                                if (textView == view) {
                                    this.eSh.bMj = 13;
                                }
                            } else {
                                this.eSh.bMj = 12;
                                this.eSh.bMk = new Bundle();
                                Bundle bundle = this.eSh.bMk;
                                userData = this.eSi.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eSh.bMj = 10;
                            this.eSh.bMk = new Bundle();
                            Bundle bundle2 = this.eSh.bMk;
                            userData2 = this.eSi.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData2);
                        }
                    } else {
                        this.eSh.bMj = 3;
                        this.eSh.bMk = new Bundle();
                        Bundle bundle3 = this.eSh.bMk;
                        userData3 = this.eSi.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData3);
                    }
                } else {
                    this.eSh.bMj = 2;
                    this.eSh.bMk = new Bundle();
                    Bundle bundle4 = this.eSh.bMk;
                    userData4 = this.eSi.mUserData;
                    bundle4.putString("vip_user_jump", userData4.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eSh.bMj = 1;
                this.eSh.bMk = new Bundle();
                Bundle bundle5 = this.eSh.bMk;
                userData5 = this.eSi.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData5);
            }
            mVar2 = this.eSi.eLK;
            mVar2.a(view, this.eSh);
        }
    }
}
