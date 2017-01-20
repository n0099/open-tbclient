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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eFF = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eFG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eFG = tVar;
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
        mVar = this.eFG.ezb;
        if (mVar != null) {
            this.eFF.bzY = -1;
            headPendantView = this.eFG.fDV;
            if (headPendantView != view) {
                userIconBox = this.eFG.fDX;
                if (userIconBox != view) {
                    userIconBox2 = this.eFG.fDY;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eFG.fDU;
                        if (bdExpandImageView != view) {
                            imageView = this.eFG.baf;
                            if (imageView != view) {
                                textView = this.eFG.fEa;
                                if (textView != view) {
                                    view2 = this.eFG.eFz;
                                    if (view2 == view) {
                                        ar arVar = new ar("c11855");
                                        arVar.ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                        userData = this.eFG.mUserData;
                                        arVar.ab("click_uid", userData.getUserId());
                                        userData2 = this.eFG.mUserData;
                                        arVar.s("live_status", userData2.getLiveStatus());
                                        TiebaStatic.log(arVar);
                                        userData3 = this.eFG.mUserData;
                                        if (userData3.getPersonPrivate().BU() != 3) {
                                            userData5 = this.eFG.mUserData;
                                            if (userData5.getPersonPrivate().BU() == 2) {
                                                userData15 = this.eFG.mUserData;
                                            }
                                            userData6 = this.eFG.mUserData;
                                            if (userData6.getLiveStatus() != 1) {
                                                context3 = this.eFG.mContext;
                                                userData7 = this.eFG.mUserData;
                                                String userId = userData7.getUserId();
                                                userData8 = this.eFG.mUserData;
                                                String userName = userData8.getUserName();
                                                userData9 = this.eFG.mUserData;
                                                String portrait = userData9.getPortrait();
                                                userData10 = this.eFG.mUserData;
                                                int sex = userData10.getSex();
                                                z = this.eFG.aVU;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context3, userId, userName, portrait, sex, z)));
                                            } else {
                                                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                userData11 = this.eFG.mUserData;
                                                alaLiveInfoCoreData.setLiveID(Long.parseLong(userData11.getLiveId()));
                                                userData12 = this.eFG.mUserData;
                                                alaLiveInfoCoreData.setUserID(Long.parseLong(userData12.getUserId()));
                                                userData13 = this.eFG.mUserData;
                                                alaLiveInfoCoreData.setUserName(userData13.getUserName());
                                                context4 = this.eFG.mContext;
                                                userData14 = this.eFG.mUserData;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context4, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, userData14.getUserId(), false)));
                                            }
                                        }
                                        context = this.eFG.mContext;
                                        context2 = this.eFG.mContext;
                                        String string = context2.getString(r.l.person_privacy_toast);
                                        userData4 = this.eFG.mUserData;
                                        BdToast.b(context, String.format(string, at.cW(userData4.getSex())), r.g.icon_toast_game_error).td();
                                        return;
                                    }
                                } else {
                                    this.eFF.bzY = 13;
                                }
                            } else {
                                this.eFF.bzY = 12;
                                this.eFF.bzZ = new Bundle();
                                Bundle bundle = this.eFF.bzZ;
                                userData16 = this.eFG.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData16);
                            }
                        } else {
                            this.eFF.bzY = 10;
                            this.eFF.bzZ = new Bundle();
                            Bundle bundle2 = this.eFF.bzZ;
                            userData17 = this.eFG.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData17);
                        }
                    } else {
                        this.eFF.bzY = 3;
                        this.eFF.bzZ = new Bundle();
                        Bundle bundle3 = this.eFF.bzZ;
                        userData18 = this.eFG.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData18);
                    }
                } else {
                    this.eFF.bzY = 2;
                    this.eFF.bzZ = new Bundle();
                    Bundle bundle4 = this.eFF.bzZ;
                    userData19 = this.eFG.mUserData;
                    bundle4.putString("vip_user_jump", userData19.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eFF.bzY = 1;
                this.eFF.bzZ = new Bundle();
                Bundle bundle5 = this.eFF.bzZ;
                userData20 = this.eFG.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData20);
            }
            mVar2 = this.eFG.ezb;
            mVar2.a(view, this.eFF);
        }
    }
}
