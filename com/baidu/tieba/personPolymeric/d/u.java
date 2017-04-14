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
    com.baidu.tieba.personPolymeric.event.a eHc = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ t eHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eHd = tVar;
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
        mVar = this.eHd.eAx;
        if (mVar != null) {
            this.eHc.bGX = -1;
            headPendantView = this.eHd.fKf;
            if (headPendantView != view) {
                userIconBox = this.eHd.fKh;
                if (userIconBox != view) {
                    userIconBox2 = this.eHd.fKi;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eHd.fKe;
                        if (bdExpandImageView != view) {
                            imageView = this.eHd.bgK;
                            if (imageView != view) {
                                textView = this.eHd.fKk;
                                if (textView != view) {
                                    view2 = this.eHd.eGW;
                                    if (view2 == view) {
                                        as asVar = new as("c11855");
                                        asVar.aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                        userData = this.eHd.mUserData;
                                        asVar.aa("click_uid", userData.getUserId());
                                        userData2 = this.eHd.mUserData;
                                        asVar.s("live_status", userData2.getLiveStatus());
                                        TiebaStatic.log(asVar);
                                        userData3 = this.eHd.mUserData;
                                        if (userData3.getPersonPrivate().CL() != 3) {
                                            userData5 = this.eHd.mUserData;
                                            if (userData5.getPersonPrivate().CL() == 2) {
                                                userData15 = this.eHd.mUserData;
                                            }
                                            userData6 = this.eHd.mUserData;
                                            if (userData6.getLiveStatus() != 1) {
                                                context3 = this.eHd.mContext;
                                                userData7 = this.eHd.mUserData;
                                                String userId = userData7.getUserId();
                                                userData8 = this.eHd.mUserData;
                                                String userName = userData8.getUserName();
                                                userData9 = this.eHd.mUserData;
                                                String portrait = userData9.getPortrait();
                                                userData10 = this.eHd.mUserData;
                                                int sex = userData10.getSex();
                                                z = this.eHd.bca;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context3, userId, userName, portrait, sex, z)));
                                            } else {
                                                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                userData11 = this.eHd.mUserData;
                                                alaLiveInfoCoreData.setLiveID(Long.parseLong(userData11.getLiveId()));
                                                userData12 = this.eHd.mUserData;
                                                alaLiveInfoCoreData.setUserID(Long.parseLong(userData12.getUserId()));
                                                userData13 = this.eHd.mUserData;
                                                alaLiveInfoCoreData.setUserName(userData13.getUserName());
                                                context4 = this.eHd.mContext;
                                                userData14 = this.eHd.mUserData;
                                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context4, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, userData14.getUserId(), false)));
                                            }
                                        }
                                        context = this.eHd.mContext;
                                        context2 = this.eHd.mContext;
                                        String string = context2.getString(w.l.person_privacy_toast);
                                        userData4 = this.eHd.mUserData;
                                        BdToast.b(context, String.format(string, au.cV(userData4.getSex())), w.g.icon_toast_game_error).tY();
                                        return;
                                    }
                                } else {
                                    this.eHc.bGX = 13;
                                }
                            } else {
                                this.eHc.bGX = 12;
                                this.eHc.bGY = new Bundle();
                                Bundle bundle = this.eHc.bGY;
                                userData16 = this.eHd.mUserData;
                                bundle.putSerializable(UserData.TYPE_USER, userData16);
                            }
                        } else {
                            this.eHc.bGX = 10;
                            this.eHc.bGY = new Bundle();
                            Bundle bundle2 = this.eHc.bGY;
                            userData17 = this.eHd.mUserData;
                            bundle2.putSerializable(UserData.TYPE_USER, userData17);
                        }
                    } else {
                        this.eHc.bGX = 3;
                        this.eHc.bGY = new Bundle();
                        Bundle bundle3 = this.eHc.bGY;
                        userData18 = this.eHd.mUserData;
                        bundle3.putSerializable(UserData.TYPE_USER, userData18);
                    }
                } else {
                    this.eHc.bGX = 2;
                    this.eHc.bGY = new Bundle();
                    Bundle bundle4 = this.eHc.bGY;
                    userData19 = this.eHd.mUserData;
                    bundle4.putString("vip_user_jump", userData19.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eHc.bGX = 1;
                this.eHc.bGY = new Bundle();
                Bundle bundle5 = this.eHc.bGY;
                userData20 = this.eHd.mUserData;
                bundle5.putSerializable(UserData.TYPE_USER, userData20);
            }
            mVar2 = this.eHd.eAx;
            mVar2.a(view, this.eHc);
        }
    }
}
