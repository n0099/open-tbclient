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
    com.baidu.tieba.personCenter.d.a eCX = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a eDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eDh = aVar;
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
        mVar = this.eDh.eCA;
        if (mVar != null) {
            headPendantView = this.eDh.fIw;
            if (headPendantView != view) {
                imageView = this.eDh.eDf;
                if (imageView != view) {
                    bdExpandImageView = this.eDh.fIv;
                    if (bdExpandImageView != view) {
                        userIconBox = this.eDh.fIy;
                        if (userIconBox != view) {
                            userIconBox2 = this.eDh.fIz;
                            if (userIconBox2 != view) {
                                textView = this.eDh.eDg;
                                if (textView != view) {
                                    textView2 = this.eDh.fIB;
                                    if (textView2 == view) {
                                        this.eCX.bHe = 22;
                                    }
                                } else {
                                    this.eCX.bHe = 9;
                                }
                            } else {
                                this.eCX.bHe = 3;
                                this.eCX.bHf = new Bundle();
                                Bundle bundle = this.eCX.bHf;
                                userData = this.eDh.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eCX.bHe = 2;
                            userData2 = this.eDh.mUserData;
                            if (userData2 != null) {
                                userData3 = this.eDh.mUserData;
                                if (!x.q(userData3.getTShowInfo())) {
                                    userData4 = this.eDh.mUserData;
                                    if (userData4.getTShowInfo().get(0) != null) {
                                        userData5 = this.eDh.mUserData;
                                        if (userData5.getTShowInfo().get(0).getUrl() != null) {
                                            this.eCX.bHf = new Bundle();
                                            Bundle bundle2 = this.eCX.bHf;
                                            userData6 = this.eDh.mUserData;
                                            bundle2.putString("vip_user_jump", userData6.getTShowInfo().get(0).getUrl());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.eCX.bHe = 8;
            } else {
                this.eCX.bHe = 1;
                this.eCX.bHf = new Bundle();
                Bundle bundle3 = this.eCX.bHf;
                userData7 = this.eDh.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData7);
            }
            mVar2 = this.eDh.eCA;
            mVar2.a(view, this.eCX);
        }
    }
}
