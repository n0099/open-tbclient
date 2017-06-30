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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    com.baidu.tieba.personPolymeric.event.a eYi = new com.baidu.tieba.personPolymeric.event.a();
    final /* synthetic */ w eYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.eYj = wVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0168, code lost:
        if (r0.getIsFriend() != 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0259, code lost:
        if (r0 == r9) goto L50;
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
        TextView textView3;
        boolean z;
        UserData userData;
        com.baidu.tieba.personPolymeric.c.a aVar;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        com.baidu.tieba.personPolymeric.c.a aVar3;
        TextView textView4;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        UserData userData5;
        Context context;
        Context context2;
        UserData userData6;
        UserData userData7;
        UserData userData8;
        Context context3;
        UserData userData9;
        UserData userData10;
        UserData userData11;
        UserData userData12;
        boolean z2;
        UserData userData13;
        UserData userData14;
        UserData userData15;
        Context context4;
        UserData userData16;
        UserData userData17;
        Context context5;
        UserData userData18;
        UserData userData19;
        UserData userData20;
        com.baidu.tieba.view.r rVar2;
        UserData userData21;
        rVar = this.eYj.eRa;
        if (rVar != null) {
            this.eYi.bVd = -1;
            headPendantView = this.eYj.gaV;
            if (headPendantView != view) {
                userIconBox = this.eYj.gaX;
                if (userIconBox != view) {
                    userIconBox2 = this.eYj.gaY;
                    if (userIconBox2 != view) {
                        bdExpandImageView = this.eYj.gaU;
                        if (bdExpandImageView != view) {
                            textView = this.eYj.gba;
                            if (textView != view) {
                                textView2 = this.eYj.eXX;
                                if (textView2 != view) {
                                    view2 = this.eYj.eYa;
                                    if (view2 == view) {
                                        userData2 = this.eYj.mUserData;
                                        if (userData2 != null) {
                                            if (!com.baidu.adp.lib.util.i.hj()) {
                                                context5 = this.eYj.mContext;
                                                com.baidu.adp.lib.util.k.showToast(context5, w.l.neterror);
                                                return;
                                            }
                                            au auVar = new au("c11855");
                                            auVar.Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
                                            userData3 = this.eYj.mUserData;
                                            auVar.Z("click_uid", userData3.getUserId());
                                            userData4 = this.eYj.mUserData;
                                            auVar.r("live_status", userData4.getLiveStatus());
                                            TiebaStatic.log(auVar);
                                            userData5 = this.eYj.mUserData;
                                            if (userData5.getPersonPrivate().Ce() != 3) {
                                                userData7 = this.eYj.mUserData;
                                                if (userData7.getPersonPrivate().Ce() == 2) {
                                                    userData17 = this.eYj.mUserData;
                                                }
                                                userData8 = this.eYj.mUserData;
                                                if (userData8.getLiveStatus() != 1) {
                                                    context3 = this.eYj.mContext;
                                                    userData9 = this.eYj.mUserData;
                                                    String userId = userData9.getUserId();
                                                    userData10 = this.eYj.mUserData;
                                                    String userName = userData10.getUserName();
                                                    userData11 = this.eYj.mUserData;
                                                    String portrait = userData11.getPortrait();
                                                    userData12 = this.eYj.mUserData;
                                                    int sex = userData12.getSex();
                                                    z2 = this.eYj.bhl;
                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCenterActivityConfig(context3, userId, userName, portrait, sex, z2)));
                                                } else {
                                                    AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                                                    userData13 = this.eYj.mUserData;
                                                    alaLiveInfoCoreData.setLiveID(Long.parseLong(userData13.getLiveId()));
                                                    userData14 = this.eYj.mUserData;
                                                    alaLiveInfoCoreData.setUserID(Long.parseLong(userData14.getUserId()));
                                                    userData15 = this.eYj.mUserData;
                                                    alaLiveInfoCoreData.setUserName(userData15.getUserName());
                                                    context4 = this.eYj.mContext;
                                                    userData16 = this.eYj.mUserData;
                                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(context4, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_PERSON_PLAY, userData16.getUserId(), false, "")));
                                                }
                                            }
                                            context = this.eYj.mContext;
                                            context2 = this.eYj.mContext;
                                            String string = context2.getString(w.l.person_privacy_toast);
                                            userData6 = this.eYj.mUserData;
                                            BdToast.b(context, String.format(string, aw.cU(userData6.getSex())), w.g.icon_toast_game_error).ti();
                                            return;
                                        }
                                        return;
                                    }
                                    textView3 = this.eYj.anw;
                                    if (textView3 != view) {
                                        textView4 = this.eYj.eXW;
                                    }
                                    z = this.eYj.bhl;
                                    if (z) {
                                        this.eYi.bVe = new Bundle();
                                        Bundle bundle = this.eYi.bVe;
                                        userData = this.eYj.mUserData;
                                        bundle.putSerializable(UserData.TYPE_USER, userData);
                                        aVar = this.eYj.gbc;
                                        if (aVar != null) {
                                            aVar2 = this.eYj.gbc;
                                            if (aVar2.eWu != null) {
                                                Bundle bundle2 = this.eYi.bVe;
                                                aVar3 = this.eYj.gbc;
                                                bundle2.putInt(UserData.TYPE_USER_NICKNAME_LEFT_DAYS, aVar3.eWu.left_days.intValue());
                                            }
                                        }
                                        this.eYi.bVd = 11;
                                    }
                                } else {
                                    this.eYi.bVd = 14;
                                }
                            } else {
                                this.eYi.bVd = 13;
                            }
                        } else {
                            this.eYi.bVd = 10;
                            this.eYi.bVe = new Bundle();
                            Bundle bundle3 = this.eYi.bVe;
                            userData18 = this.eYj.mUserData;
                            bundle3.putSerializable(UserData.TYPE_USER, userData18);
                        }
                    } else {
                        this.eYi.bVd = 3;
                        this.eYi.bVe = new Bundle();
                        Bundle bundle4 = this.eYi.bVe;
                        userData19 = this.eYj.mUserData;
                        bundle4.putSerializable(UserData.TYPE_USER, userData19);
                    }
                } else {
                    this.eYi.bVd = 2;
                    this.eYi.bVe = new Bundle();
                    Bundle bundle5 = this.eYi.bVe;
                    userData20 = this.eYj.mUserData;
                    bundle5.putString("vip_user_jump", userData20.getTShowInfo().get(0).getUrl());
                }
            } else {
                this.eYi.bVd = 1;
                this.eYi.bVe = new Bundle();
                Bundle bundle6 = this.eYi.bVe;
                userData21 = this.eYj.mUserData;
                bundle6.putSerializable(UserData.TYPE_USER, userData21);
            }
            rVar2 = this.eYj.eRa;
            rVar2.a(view, this.eYi);
        }
    }
}
