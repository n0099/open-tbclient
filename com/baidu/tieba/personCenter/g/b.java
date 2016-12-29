package com.baidu.tieba.personCenter.g;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.view.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    com.baidu.tieba.personCenter.d.a epB = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a epL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.epL = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        HeadPendantView headPendantView;
        ImageView imageView;
        BdExpandImageView bdExpandImageView;
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        TextView textView;
        TextView textView2;
        UserData userData;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        UserData userData5;
        UserData userData6;
        m mVar2;
        UserData userData7;
        mVar = this.epL.epg;
        if (mVar != null) {
            headPendantView = this.epL.fvb;
            if (headPendantView != view) {
                imageView = this.epL.epJ;
                if (imageView != view) {
                    bdExpandImageView = this.epL.fva;
                    if (bdExpandImageView != view) {
                        userIconBox = this.epL.fvd;
                        if (userIconBox != view) {
                            userIconBox2 = this.epL.fve;
                            if (userIconBox2 != view) {
                                textView = this.epL.epK;
                                if (textView != view) {
                                    textView2 = this.epL.fvg;
                                    if (textView2 == view) {
                                        this.epB.bsn = 22;
                                    }
                                } else {
                                    this.epB.bsn = 9;
                                }
                            } else {
                                this.epB.bsn = 3;
                                this.epB.bso = new Bundle();
                                Bundle bundle = this.epB.bso;
                                userData = this.epL.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.epB.bsn = 2;
                            userData2 = this.epL.mUserData;
                            if (userData2 != null) {
                                userData3 = this.epL.mUserData;
                                if (!x.t(userData3.getTShowInfo())) {
                                    userData4 = this.epL.mUserData;
                                    if (userData4.getTShowInfo().get(0) != null) {
                                        userData5 = this.epL.mUserData;
                                        if (userData5.getTShowInfo().get(0).getUrl() != null) {
                                            this.epB.bso = new Bundle();
                                            Bundle bundle2 = this.epB.bso;
                                            userData6 = this.epL.mUserData;
                                            bundle2.putString("vip_user_jump", userData6.getTShowInfo().get(0).getUrl());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.epB.bsn = 8;
            } else {
                this.epB.bsn = 1;
                this.epB.bso = new Bundle();
                Bundle bundle3 = this.epB.bso;
                userData7 = this.epL.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData7);
            }
            mVar2 = this.epL.epg;
            mVar2.a(view, this.epB);
        }
    }
}
