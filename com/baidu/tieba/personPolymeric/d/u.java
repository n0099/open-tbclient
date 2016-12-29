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
    com.baidu.tieba.personPolymeric.event.a evG = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t evH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.evH = tVar;
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
        mVar = this.evH.epg;
        if (mVar != null) {
            this.evG.bsn = -1;
            headPendantView = this.evH.fvb;
            if (headPendantView != view) {
                userIconBox = this.evH.fvd;
                if (userIconBox != view) {
                    userIconBox2 = this.evH.fve;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.evH.fva;
                        if (bdExpandImageView != view) {
                            imageView = this.evH.evF;
                            if (imageView != view) {
                                textView = this.evH.fvg;
                                if (textView == view) {
                                    this.evG.bsn = 13;
                                }
                            } else {
                                this.evG.bsn = 12;
                                this.evG.bso = new Bundle();
                                Bundle bundle = this.evG.bso;
                                userData = this.evH.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.evG.bsn = 10;
                            this.evG.bso = new Bundle();
                            Bundle bundle2 = this.evG.bso;
                            userData2 = this.evH.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData2);
                        }
                    } else {
                        this.evG.bsn = 3;
                        this.evG.bso = new Bundle();
                        Bundle bundle3 = this.evG.bso;
                        userData3 = this.evH.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData3);
                    }
                } else {
                    this.evG.bsn = 2;
                    this.evG.bso = new Bundle();
                    Bundle bundle4 = this.evG.bso;
                    userData4 = this.evH.mUserData;
                    bundle4.putString("vip_user_jump", userData4.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.evG.bsn = 1;
                this.evG.bso = new Bundle();
                Bundle bundle5 = this.evG.bso;
                userData5 = this.evH.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData5);
            }
            mVar2 = this.evH.epg;
            mVar2.a(view, this.evG);
        }
    }
}
