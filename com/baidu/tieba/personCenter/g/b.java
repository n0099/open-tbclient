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
    com.baidu.tieba.personCenter.d.a eDB = new com.baidu.tieba.personCenter.d.a();
    final /* synthetic */ a eDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eDM = aVar;
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
        mVar = this.eDM.eDi;
        if (mVar != null) {
            headPendantView = this.eDM.fWJ;
            if (headPendantView != view) {
                imageView = this.eDM.eDK;
                if (imageView != view) {
                    bdExpandImageView = this.eDM.fWI;
                    if (bdExpandImageView != view) {
                        userIconBox = this.eDM.fWL;
                        if (userIconBox != view) {
                            userIconBox2 = this.eDM.fWM;
                            if (userIconBox2 != view) {
                                textView = this.eDM.eDL;
                                if (textView == view) {
                                    this.eDB.bJp = 9;
                                }
                            } else {
                                this.eDB.bJp = 3;
                                this.eDB.bJq = new Bundle();
                                Bundle bundle = this.eDB.bJq;
                                userData = this.eDM.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData);
                            }
                        } else {
                            this.eDB.bJp = 2;
                            this.eDB.bJq = new Bundle();
                            Bundle bundle2 = this.eDB.bJq;
                            userData2 = this.eDM.mUserData;
                            bundle2.putString("vip_user_jump", userData2.getTShowInfo().get(0).getUrl());
                        }
                    }
                }
                this.eDB.bJp = 8;
            } else {
                this.eDB.bJp = 1;
                this.eDB.bJq = new Bundle();
                Bundle bundle3 = this.eDB.bJq;
                userData3 = this.eDM.mUserData;
                bundle3.putSerializable(UserData.TYPE_USER, userData3);
            }
            mVar2 = this.eDM.eDi;
            mVar2.a(view, this.eDB);
        }
    }
}
