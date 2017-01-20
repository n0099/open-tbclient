package com.baidu.tieba.personCenter.f;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.view.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ezI;
    com.baidu.tieba.personCenter.d.a ezy = new com.baidu.tieba.personCenter.d.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ezI = aVar;
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
        mVar = this.ezI.ezb;
        if (mVar != null) {
            headPendantView = this.ezI.fDV;
            if (headPendantView != view) {
                imageView = this.ezI.ezG;
                if (imageView != view) {
                    bdExpandImageView = this.ezI.fDU;
                    if (bdExpandImageView != view) {
                        userIconBox = this.ezI.fDX;
                        if (userIconBox != view) {
                            userIconBox2 = this.ezI.fDY;
                            if (userIconBox2 != view) {
                                textView = this.ezI.ezH;
                                if (textView != view) {
                                    textView2 = this.ezI.fEa;
                                    if (textView2 == view) {
                                        this.ezy.bzY = 22;
                                    }
                                } else {
                                    this.ezy.bzY = 9;
                                }
                            } else {
                                this.ezy.bzY = 3;
                                this.ezy.bzZ = new Bundle();
                                Bundle bundle = this.ezy.bzZ;
                                userData = this.ezI.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.ezy.bzY = 2;
                            userData2 = this.ezI.mUserData;
                            if (userData2 != null) {
                                userData3 = this.ezI.mUserData;
                                if (!w.s(userData3.getTShowInfo())) {
                                    userData4 = this.ezI.mUserData;
                                    if (userData4.getTShowInfo().get(0) != null) {
                                        userData5 = this.ezI.mUserData;
                                        if (userData5.getTShowInfo().get(0).getUrl() != null) {
                                            this.ezy.bzZ = new Bundle();
                                            Bundle bundle2 = this.ezy.bzZ;
                                            userData6 = this.ezI.mUserData;
                                            bundle2.putString("vip_user_jump", userData6.getTShowInfo().get(0).getUrl());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                this.ezy.bzY = 8;
            } else {
                this.ezy.bzY = 1;
                this.ezy.bzZ = new Bundle();
                Bundle bundle3 = this.ezy.bzZ;
                userData7 = this.ezI.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData7);
            }
            mVar2 = this.ezI.ezb;
            mVar2.a(view, this.ezy);
        }
    }
}
