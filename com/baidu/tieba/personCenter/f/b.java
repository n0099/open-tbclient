package com.baidu.tieba.personCenter.f;

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
    com.baidu.tieba.personCenter.d.a eAU = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a eBe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eBe = aVar;
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
        mVar = this.eBe.eAx;
        if (mVar != null) {
            headPendantView = this.eBe.fKf;
            if (headPendantView != view) {
                imageView = this.eBe.eBc;
                if (imageView != view) {
                    bdExpandImageView = this.eBe.fKe;
                    if (bdExpandImageView != view) {
                        userIconBox = this.eBe.fKh;
                        if (userIconBox != view) {
                            userIconBox2 = this.eBe.fKi;
                            if (userIconBox2 != view) {
                                textView = this.eBe.eBd;
                                if (textView != view) {
                                    textView2 = this.eBe.fKk;
                                    if (textView2 == view) {
                                        this.eAU.bGX = 23;
                                    }
                                } else {
                                    this.eAU.bGX = 9;
                                }
                            } else {
                                this.eAU.bGX = 3;
                                this.eAU.bGY = new Bundle();
                                Bundle bundle = this.eAU.bGY;
                                userData = this.eBe.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eAU.bGX = 2;
                            userData2 = this.eBe.mUserData;
                            if (userData2 != null) {
                                userData3 = this.eBe.mUserData;
                                if (!x.q(userData3.getTShowInfo())) {
                                    userData4 = this.eBe.mUserData;
                                    if (userData4.getTShowInfo().get(0) != null) {
                                        userData5 = this.eBe.mUserData;
                                        if (userData5.getTShowInfo().get(0).getUrl() != null) {
                                            this.eAU.bGY = new Bundle();
                                            Bundle bundle2 = this.eAU.bGY;
                                            userData6 = this.eBe.mUserData;
                                            bundle2.putString("vip_user_jump", userData6.getTShowInfo().get(0).getUrl());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.eAU.bGX = 8;
            } else {
                this.eAU.bGX = 1;
                this.eAU.bGY = new Bundle();
                Bundle bundle3 = this.eAU.bGY;
                userData7 = this.eBe.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData7);
            }
            mVar2 = this.eBe.eAx;
            mVar2.a(view, this.eAU);
        }
    }
}
