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
    com.baidu.tieba.personPolymeric.event.a eJh = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eJi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eJi = tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0166, code lost:
        if (r0.getIsFriend() != 1) goto L37;
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
        UserData userData16;
        UserData userData17;
        UserData userData18;
        UserData userData19;
        com.baidu.tieba.view.m mVar2;
        UserData userData20;
        mVar = this.eJi.eCA;
        if (mVar != null) {
            this.eJh.bHe = -1;
            headPendantView = this.eJi.fIw;
            if (headPendantView != view) {
                userIconBox = this.eJi.fIy;
                if (userIconBox != view) {
                    userIconBox2 = this.eJi.fIz;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eJi.fIv;
                        if (bdExpandImageView != view) {
                            imageView = this.eJi.bgQ;
                            if (imageView != view) {
                                textView = this.eJi.fIB;
                                if (textView != view) {
                                    view2 = this.eJi.eJb;
                                    if (view2 == view) {
                                        as asVar = new as("c11855");
                                        asVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                        userData = this.eJi.mUserData;
                                        asVar.Z("click_uid", userData.getUserId());
                                        userData2 = this.eJi.mUserData;
                                        asVar.s("live_status", userData2.getLiveStatus());
                                        TiebaStatic.log(asVar);
                                        userData3 = this.eJi.mUserData;
                                        if (userData3.getPersonPrivate().Cn() != 3) {
                                            userData5 = this.eJi.mUserData;
                                            if (userData5.getPersonPrivate().Cn() == 2) {
                                                userData15 = this.eJi.mUserData;
                                            }
                                            userData6 = this.eJi.mUserData;
                                            if (userData6.getLiveStatus() != 1) {
                                                context3 = this.eJi.mContext;
                                                userData7 = this.eJi.mUserData;
                                                String userId = userData7.getUserId();
                                                userData8 = this.eJi.mUserData;
                                                String userName = userData8.getUserName();
                                                userData9 = this.eJi.mUserData;
                                                String portrait = userData9.getPortrait();
                                                userData10 = this.eJi.mUserData;
                                                int sex = userData10.getSex();
                                                z = this.eJi.bch;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context3, userId, userName, portrait, sex, z)));
                                            } else {
                                                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                userData11 = this.eJi.mUserData;
                                                alaLiveInfoCoreData.setLiveID(Long.parseLong(userData11.getLiveId()));
                                                userData12 = this.eJi.mUserData;
                                                alaLiveInfoCoreData.setUserID(Long.parseLong(userData12.getUserId()));
                                                userData13 = this.eJi.mUserData;
                                                alaLiveInfoCoreData.setUserName(userData13.getUserName());
                                                context4 = this.eJi.mContext;
                                                userData14 = this.eJi.mUserData;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context4, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, userData14.getUserId(), false)));
                                            }
                                        }
                                        context = this.eJi.mContext;
                                        context2 = this.eJi.mContext;
                                        String string = context2.getString(w.l.person_privacy_toast);
                                        userData4 = this.eJi.mUserData;
                                        BdToast.b(context, String.format(string, au.cS(userData4.getSex())), w.g.icon_toast_game_error).tA();
                                        return;
                                    }
                                } else {
                                    this.eJh.bHe = 13;
                                }
                            } else {
                                this.eJh.bHe = 12;
                                this.eJh.bHf = new Bundle();
                                Bundle bundle = this.eJh.bHf;
                                userData16 = this.eJi.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData16);
                            }
                        } else {
                            this.eJh.bHe = 10;
                            this.eJh.bHf = new Bundle();
                            Bundle bundle2 = this.eJh.bHf;
                            userData17 = this.eJi.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData17);
                        }
                    } else {
                        this.eJh.bHe = 3;
                        this.eJh.bHf = new Bundle();
                        Bundle bundle3 = this.eJh.bHf;
                        userData18 = this.eJi.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData18);
                    }
                } else {
                    this.eJh.bHe = 2;
                    this.eJh.bHf = new Bundle();
                    Bundle bundle4 = this.eJh.bHf;
                    userData19 = this.eJi.mUserData;
                    bundle4.putString("vip_user_jump", userData19.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eJh.bHe = 1;
                this.eJh.bHf = new Bundle();
                Bundle bundle5 = this.eJh.bHf;
                userData20 = this.eJi.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData20);
            }
            mVar2 = this.eJi.eCA;
            mVar2.a(view, this.eJh);
        }
    }
}
