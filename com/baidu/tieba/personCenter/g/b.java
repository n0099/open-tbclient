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
    com.baidu.tieba.personCenter.d.a eMd = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a eMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eMp = aVar;
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
        mVar = this.eMp.eLK;
        if (mVar != null) {
            headPendantView = this.eMp.ggj;
            if (headPendantView != view) {
                imageView = this.eMp.eMn;
                if (imageView != view) {
                    bdExpandImageView = this.eMp.ggi;
                    if (bdExpandImageView != view) {
                        userIconBox = this.eMp.ggl;
                        if (userIconBox != view) {
                            userIconBox2 = this.eMp.ggm;
                            if (userIconBox2 != view) {
                                textView = this.eMp.eMo;
                                if (textView != view) {
                                    textView2 = this.eMp.ggo;
                                    if (textView2 == view) {
                                        this.eMd.bMj = 21;
                                    }
                                } else {
                                    this.eMd.bMj = 9;
                                }
                            } else {
                                this.eMd.bMj = 3;
                                this.eMd.bMk = new Bundle();
                                Bundle bundle = this.eMd.bMk;
                                userData = this.eMp.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eMd.bMj = 2;
                            userData2 = this.eMp.mUserData;
                            if (userData2 != null) {
                                userData3 = this.eMp.mUserData;
                                if (!x.t(userData3.getTShowInfo())) {
                                    userData4 = this.eMp.mUserData;
                                    if (userData4.getTShowInfo().get(0) != null) {
                                        userData5 = this.eMp.mUserData;
                                        if (userData5.getTShowInfo().get(0).getUrl() != null) {
                                            this.eMd.bMk = new Bundle();
                                            Bundle bundle2 = this.eMd.bMk;
                                            userData6 = this.eMp.mUserData;
                                            bundle2.putString("vip_user_jump", userData6.getTShowInfo().get(0).getUrl());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.eMd.bMj = 8;
            } else {
                this.eMd.bMj = 1;
                this.eMd.bMk = new Bundle();
                Bundle bundle3 = this.eMd.bMk;
                userData7 = this.eMp.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData7);
            }
            mVar2 = this.eMp.eLK;
            mVar2.a(view, this.eMd);
        }
    }
}
