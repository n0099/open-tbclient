package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
public class x implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a bxk = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ w eNY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.eNY = wVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0168, code lost:
        if (r0.getIsFriend() != 1) goto L43;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tieba.view.r rVar;
        HeadPendantView headPendantView;
        UserIconBox userIconBox;
        UserIconBox userIconBox2;
        BdExpandImageView bdExpandImageView;
        TextView textView;
        TextView textView2;
        View view2;
        UserData userData;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        Context context;
        Context context2;
        UserData userData5;
        UserData userData6;
        UserData userData7;
        Context context3;
        UserData userData8;
        UserData userData9;
        UserData userData10;
        UserData userData11;
        boolean z;
        UserData userData12;
        UserData userData13;
        UserData userData14;
        Context context4;
        UserData userData15;
        UserData userData16;
        Context context5;
        UserData userData17;
        UserData userData18;
        UserData userData19;
        com.baidu.tieba.view.r rVar2;
        UserData userData20;
        rVar = this.eNY.bxW;
        if (rVar != null) {
            this.bxk.bOi = -1;
            headPendantView = this.eNY.fQU;
            if (headPendantView != view) {
                userIconBox = this.eNY.fQW;
                if (userIconBox != view) {
                    userIconBox2 = this.eNY.fQX;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eNY.fQT;
                        if (bdExpandImageView != view) {
                            textView = this.eNY.fQZ;
                            if (textView != view) {
                                textView2 = this.eNY.eNN;
                                if (textView2 != view) {
                                    view2 = this.eNY.eNQ;
                                    if (view2 == view) {
                                        userData = this.eNY.mUserData;
                                        if (userData != null) {
                                            if (!com.baidu.adp.lib.util.i.hk()) {
                                                context5 = this.eNY.mContext;
                                                com.baidu.adp.lib.util.k.showToast(context5, w.l.neterror);
                                                return;
                                            }
                                            as asVar = new as("c11855");
                                            asVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                            userData2 = this.eNY.mUserData;
                                            asVar.Z("click_uid", userData2.getUserId());
                                            userData3 = this.eNY.mUserData;
                                            asVar.r("live_status", userData3.getLiveStatus());
                                            TiebaStatic.log(asVar);
                                            userData4 = this.eNY.mUserData;
                                            if (userData4.getPersonPrivate().BK() != 3) {
                                                userData6 = this.eNY.mUserData;
                                                if (userData6.getPersonPrivate().BK() == 2) {
                                                    userData16 = this.eNY.mUserData;
                                                }
                                                userData7 = this.eNY.mUserData;
                                                if (userData7.getLiveStatus() != 1) {
                                                    context3 = this.eNY.mContext;
                                                    userData8 = this.eNY.mUserData;
                                                    String userId = userData8.getUserId();
                                                    userData9 = this.eNY.mUserData;
                                                    String userName = userData9.getUserName();
                                                    userData10 = this.eNY.mUserData;
                                                    String portrait = userData10.getPortrait();
                                                    userData11 = this.eNY.mUserData;
                                                    int sex = userData11.getSex();
                                                    z = this.eNY.beq;
                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context3, userId, userName, portrait, sex, z)));
                                                } else {
                                                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                    userData12 = this.eNY.mUserData;
                                                    alaLiveInfoCoreData.setLiveID(Long.parseLong(userData12.getLiveId()));
                                                    userData13 = this.eNY.mUserData;
                                                    alaLiveInfoCoreData.setUserID(Long.parseLong(userData13.getUserId()));
                                                    userData14 = this.eNY.mUserData;
                                                    alaLiveInfoCoreData.setUserName(userData14.getUserName());
                                                    context4 = this.eNY.mContext;
                                                    userData15 = this.eNY.mUserData;
                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context4, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, userData15.getUserId(), false, "")));
                                                }
                                            }
                                            context = this.eNY.mContext;
                                            context2 = this.eNY.mContext;
                                            String string = context2.getString(w.l.person_privacy_toast);
                                            userData5 = this.eNY.mUserData;
                                            BdToast.b(context, String.format(string, au.cS(userData5.getSex())), w.g.icon_toast_game_error).tk();
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    this.bxk.bOi = 14;
                                }
                            } else {
                                this.bxk.bOi = 13;
                            }
                        } else {
                            this.bxk.bOi = 10;
                            this.bxk.bOj = new Bundle();
                            Bundle bundle = this.bxk.bOj;
                            userData17 = this.eNY.mUserData;
                            bundle.putSerializable(UserData.TYPE_USER, userData17);
                        }
                    } else {
                        this.bxk.bOi = 3;
                        this.bxk.bOj = new Bundle();
                        Bundle bundle2 = this.bxk.bOj;
                        userData18 = this.eNY.mUserData;
                        bundle2.putSerializable(UserData.TYPE_USER, userData18);
                    }
                } else {
                    this.bxk.bOi = 2;
                    this.bxk.bOj = new Bundle();
                    Bundle bundle3 = this.bxk.bOj;
                    userData19 = this.eNY.mUserData;
                    bundle3.putString("vip_user_jump", userData19.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.bxk.bOi = 1;
                this.bxk.bOj = new Bundle();
                Bundle bundle4 = this.bxk.bOj;
                userData20 = this.eNY.mUserData;
                bundle4.putSerializable(UserData.TYPE_USER, userData20);
            }
            rVar2 = this.eNY.bxW;
            rVar2.a(view, this.bxk);
        }
    }
}
