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
    com.baidu.tieba.personCenter.d.a eDk = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a eDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eDu = aVar;
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
        mVar = this.eDu.eCN;
        if (mVar != null) {
            headPendantView = this.eDu.fMB;
            if (headPendantView != view) {
                imageView = this.eDu.eDs;
                if (imageView != view) {
                    bdExpandImageView = this.eDu.fMA;
                    if (bdExpandImageView != view) {
                        userIconBox = this.eDu.fMD;
                        if (userIconBox != view) {
                            userIconBox2 = this.eDu.fME;
                            if (userIconBox2 != view) {
                                textView = this.eDu.eDt;
                                if (textView != view) {
                                    textView2 = this.eDu.fMG;
                                    if (textView2 == view) {
                                        this.eDk.bJo = 23;
                                    }
                                } else {
                                    this.eDk.bJo = 9;
                                }
                            } else {
                                this.eDk.bJo = 3;
                                this.eDk.bJp = new Bundle();
                                Bundle bundle = this.eDk.bJp;
                                userData = this.eDu.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eDk.bJo = 2;
                            userData2 = this.eDu.mUserData;
                            if (userData2 != null) {
                                userData3 = this.eDu.mUserData;
                                if (!x.q(userData3.getTShowInfo())) {
                                    userData4 = this.eDu.mUserData;
                                    if (userData4.getTShowInfo().get(0) != null) {
                                        userData5 = this.eDu.mUserData;
                                        if (userData5.getTShowInfo().get(0).getUrl() != null) {
                                            this.eDk.bJp = new Bundle();
                                            Bundle bundle2 = this.eDk.bJp;
                                            userData6 = this.eDu.mUserData;
                                            bundle2.putString("vip_user_jump", userData6.getTShowInfo().get(0).getUrl());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.eDk.bJo = 8;
            } else {
                this.eDk.bJo = 1;
                this.eDk.bJp = new Bundle();
                Bundle bundle3 = this.eDk.bJp;
                userData7 = this.eDu.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData7);
            }
            mVar2 = this.eDu.eCN;
            mVar2.a(view, this.eDk);
        }
    }
}
