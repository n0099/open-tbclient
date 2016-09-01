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
    com.baidu.tieba.personPolymeric.event.a eJG = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eJH = tVar;
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
        mVar = this.eJH.eDi;
        if (mVar != null) {
            this.eJG.bJp = -1;
            headPendantView = this.eJH.fWJ;
            if (headPendantView != view) {
                userIconBox = this.eJH.fWL;
                if (userIconBox != view) {
                    userIconBox2 = this.eJH.fWM;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eJH.fWI;
                        if (bdExpandImageView != view) {
                            imageView = this.eJH.eJF;
                            if (imageView == view) {
                                this.eJG.bJp = 12;
                                this.eJG.bJq = new Bundle();
                                Bundle bundle = this.eJG.bJq;
                                userData = this.eJH.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eJG.bJp = 10;
                            this.eJG.bJq = new Bundle();
                            Bundle bundle2 = this.eJG.bJq;
                            userData2 = this.eJH.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData2);
                        }
                    } else {
                        this.eJG.bJp = 3;
                        this.eJG.bJq = new Bundle();
                        Bundle bundle3 = this.eJG.bJq;
                        userData3 = this.eJH.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData3);
                    }
                } else {
                    this.eJG.bJp = 2;
                    this.eJG.bJq = new Bundle();
                    Bundle bundle4 = this.eJG.bJq;
                    userData4 = this.eJH.mUserData;
                    bundle4.putString("vip_user_jump", userData4.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eJG.bJp = 1;
                this.eJG.bJq = new Bundle();
                Bundle bundle5 = this.eJG.bJq;
                userData5 = this.eJH.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData5);
            }
            mVar2 = this.eJH.eDi;
            mVar2.a(view, this.eJG);
        }
    }
}
