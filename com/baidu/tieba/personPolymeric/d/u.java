package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlaPersonCenterActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eJs = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eJt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eJt = tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0179, code lost:
        if (r0.getIsFriend() != 1) goto L41;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tieba.view.m mVar;
        HeadPendantView headPendantView;
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        BdExpandImageView bdExpandImageView;
        ImageView imageView;
        TextView textView;
        View view2;
        UserData userData;
        UserData userData2;
        UserData userData3;
        Context context;
        Context context2;
        UserData userData4;
        UserData userData5;
        UserData userData6;
        Context context3;
        UserData userData7;
        UserData userData8;
        UserData userData9;
        UserData userData10;
        boolean z;
        UserData userData11;
        UserData userData12;
        UserData userData13;
        Context context4;
        UserData userData14;
        UserData userData15;
        Context context5;
        UserData userData16;
        UserData userData17;
        UserData userData18;
        UserData userData19;
        com.baidu.tieba.view.m mVar2;
        UserData userData20;
        mVar = this.eJt.eCN;
        if (mVar != null) {
            this.eJs.bJo = -1;
            headPendantView = this.eJt.fMB;
            if (headPendantView != view) {
                userIconBox = this.eJt.fMD;
                if (userIconBox != view) {
                    userIconBox2 = this.eJt.fME;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eJt.fMA;
                        if (bdExpandImageView != view) {
                            imageView = this.eJt.biP;
                            if (imageView != view) {
                                textView = this.eJt.fMG;
                                if (textView != view) {
                                    view2 = this.eJt.eJm;
                                    if (view2 == view) {
                                        if (!com.baidu.adp.lib.util.i.hk()) {
                                            context5 = this.eJt.mContext;
                                            com.baidu.adp.lib.util.k.showToast(context5, w.l.no_network_guide);
                                            return;
                                        }
                                        as asVar = new as("c11855");
                                        asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                        userData = this.eJt.mUserData;
                                        asVar.aa("click_uid", userData.getUserId());
                                        userData2 = this.eJt.mUserData;
                                        asVar.s("live_status", userData2.getLiveStatus());
                                        TiebaStatic.log(asVar);
                                        userData3 = this.eJt.mUserData;
                                        if (userData3.getPersonPrivate().CL() != 3) {
                                            userData5 = this.eJt.mUserData;
                                            if (userData5.getPersonPrivate().CL() == 2) {
                                                userData15 = this.eJt.mUserData;
                                            }
                                            userData6 = this.eJt.mUserData;
                                            if (userData6.getLiveStatus() != 1) {
                                                context3 = this.eJt.mContext;
                                                userData7 = this.eJt.mUserData;
                                                String userId = userData7.getUserId();
                                                userData8 = this.eJt.mUserData;
                                                String userName = userData8.getUserName();
                                                userData9 = this.eJt.mUserData;
                                                String portrait = userData9.getPortrait();
                                                userData10 = this.eJt.mUserData;
                                                int sex = userData10.getSex();
                                                z = this.eJt.bcY;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context3, userId, userName, portrait, sex, z)));
                                            } else {
                                                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                userData11 = this.eJt.mUserData;
                                                alaLiveInfoCoreData.setLiveID(Long.parseLong(userData11.getLiveId()));
                                                userData12 = this.eJt.mUserData;
                                                alaLiveInfoCoreData.setUserID(Long.parseLong(userData12.getUserId()));
                                                userData13 = this.eJt.mUserData;
                                                alaLiveInfoCoreData.setUserName(userData13.getUserName());
                                                context4 = this.eJt.mContext;
                                                userData14 = this.eJt.mUserData;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context4, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, userData14.getUserId(), false)));
                                            }
                                        }
                                        context = this.eJt.mContext;
                                        context2 = this.eJt.mContext;
                                        String string = context2.getString(w.l.person_privacy_toast);
                                        userData4 = this.eJt.mUserData;
                                        BdToast.b(context, String.format(string, au.cV(userData4.getSex())), w.g.icon_toast_game_error).tY();
                                        return;
                                    }
                                } else {
                                    this.eJs.bJo = 13;
                                }
                            } else {
                                this.eJs.bJo = 12;
                                this.eJs.bJp = new Bundle();
                                Bundle bundle = this.eJs.bJp;
                                userData16 = this.eJt.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData16);
                            }
                        } else {
                            this.eJs.bJo = 10;
                            this.eJs.bJp = new Bundle();
                            Bundle bundle2 = this.eJs.bJp;
                            userData17 = this.eJt.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData17);
                        }
                    } else {
                        this.eJs.bJo = 3;
                        this.eJs.bJp = new Bundle();
                        Bundle bundle3 = this.eJs.bJp;
                        userData18 = this.eJt.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData18);
                    }
                } else {
                    this.eJs.bJo = 2;
                    this.eJs.bJp = new Bundle();
                    Bundle bundle4 = this.eJs.bJp;
                    userData19 = this.eJt.mUserData;
                    bundle4.putString("vip_user_jump", userData19.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eJs.bJo = 1;
                this.eJs.bJp = new Bundle();
                Bundle bundle5 = this.eJs.bJp;
                userData20 = this.eJt.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData20);
            }
            mVar2 = this.eJt.eCN;
            mVar2.a(view, this.eJs);
        }
    }
}
