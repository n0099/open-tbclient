package com.baidu.tieba.personPolymeric.d;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eLJ = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eLK = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        HeadPendantView headPendantView;
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        BdExpandImageView bdExpandImageView;
        ImageView imageView;
        UserData userData;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        com.baidu.tieba.view.m mVar2;
        UserData userData5;
        mVar = this.eLK.eFl;
        if (mVar != null) {
            this.eLJ.bJq = -1;
            headPendantView = this.eLK.fYO;
            if (headPendantView != view) {
                userIconBox = this.eLK.fYQ;
                if (userIconBox != view) {
                    userIconBox2 = this.eLK.fYR;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eLK.fYN;
                        if (bdExpandImageView != view) {
                            imageView = this.eLK.eLI;
                            if (imageView == view) {
                                this.eLJ.bJq = 12;
                                this.eLJ.bJr = new Bundle();
                                Bundle bundle = this.eLJ.bJr;
                                userData = this.eLK.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eLJ.bJq = 10;
                            this.eLJ.bJr = new Bundle();
                            Bundle bundle2 = this.eLJ.bJr;
                            userData2 = this.eLK.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData2);
                        }
                    } else {
                        this.eLJ.bJq = 3;
                        this.eLJ.bJr = new Bundle();
                        Bundle bundle3 = this.eLJ.bJr;
                        userData3 = this.eLK.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData3);
                    }
                } else {
                    this.eLJ.bJq = 2;
                    this.eLJ.bJr = new Bundle();
                    Bundle bundle4 = this.eLJ.bJr;
                    userData4 = this.eLK.mUserData;
                    bundle4.putString("vip_user_jump", userData4.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eLJ.bJq = 1;
                this.eLJ.bJr = new Bundle();
                Bundle bundle5 = this.eLJ.bJr;
                userData5 = this.eLK.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData5);
            }
            mVar2 = this.eLK.eFl;
            mVar2.a(view, this.eLJ);
        }
    }
}
