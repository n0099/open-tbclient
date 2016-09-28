package com.baidu.tieba.personCenter.g;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.view.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    com.baidu.tieba.personCenter.d.a eFE = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a eFQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eFQ = aVar;
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
        UserData userData;
        UserData userData2;
        m mVar2;
        UserData userData3;
        mVar = this.eFQ.eFl;
        if (mVar != null) {
            headPendantView = this.eFQ.fYO;
            if (headPendantView != view) {
                imageView = this.eFQ.eFO;
                if (imageView != view) {
                    bdExpandImageView = this.eFQ.fYN;
                    if (bdExpandImageView != view) {
                        userIconBox = this.eFQ.fYQ;
                        if (userIconBox != view) {
                            userIconBox2 = this.eFQ.fYR;
                            if (userIconBox2 != view) {
                                textView = this.eFQ.eFP;
                                if (textView == view) {
                                    this.eFE.bJq = 9;
                                }
                            } else {
                                this.eFE.bJq = 3;
                                this.eFE.bJr = new Bundle();
                                Bundle bundle = this.eFE.bJr;
                                userData = this.eFQ.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eFE.bJq = 2;
                            this.eFE.bJr = new Bundle();
                            Bundle bundle2 = this.eFE.bJr;
                            userData2 = this.eFQ.mUserData;
                            bundle2.putString("vip_user_jump", userData2.getTShowInfo().get(0).getUrl());
                        }
                    }
                }
                this.eFE.bJq = 8;
            } else {
                this.eFE.bJq = 1;
                this.eFE.bJr = new Bundle();
                Bundle bundle3 = this.eFE.bJr;
                userData3 = this.eFQ.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData3);
            }
            mVar2 = this.eFQ.eFl;
            mVar2.a(view, this.eFE);
        }
    }
}
