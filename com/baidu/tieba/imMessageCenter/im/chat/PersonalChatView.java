package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] dno;
    private TextView cSA;
    private PersonalChatActivity dng;
    private LinearLayout dnh;
    private LinearLayout dni;
    private TextView dnj;
    private TextView dnk;
    private TextView dnl;
    private Button dnm;
    private View.OnClickListener dnn;

    static /* synthetic */ int[] awS() {
        int[] iArr = dno;
        if (iArr == null) {
            iArr = new int[PersonalMsglistModel.CardStatus.valuesCustom().length];
            try {
                iArr[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            dno = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dnn = new q(this);
        if (!this.dng.awN() && this.mTool != null) {
            b(this.mTool.ex(6));
            b(this.mTool.ex(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dng = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(t.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.personal_info_btn, talkableActivity);
            this.cSA = (TextView) this.mBtnGroupInfo.findViewById(t.g.group_info_btn_txt);
            this.cSA.setText(string);
        }
        if (!this.dng.awN()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dnh = (LinearLayout) ((ViewStub) talkableActivity.findViewById(t.g.stranger_person_add_friend_stub)).inflate();
            this.dni = (LinearLayout) this.dnh.findViewById(t.g.add_friend_tip_full);
            this.dnj = (TextView) this.dnh.findViewById(t.g.add_friend_tip_title);
            this.dnk = (TextView) this.dnh.findViewById(t.g.add_friend_tip_content);
            this.dnl = (TextView) this.dnh.findViewById(t.g.add_friend_tip_center);
            this.dnm = (Button) this.dnh.findViewById(t.g.add_friend_tip_button);
            this.dnm.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dnh.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cSA != null) {
            av.c(this.cSA, t.d.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.dnn);
        }
    }

    private void awP() {
        if (this.mTool != null) {
            this.mTool.CP();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (awS()[cardStatus.ordinal()]) {
            case 1:
                awQ();
                return;
            case 2:
                gh(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case 4:
                gi(z);
                return;
            default:
                return;
        }
    }

    private void awQ() {
        this.dni.setVisibility(0);
        this.dnl.setVisibility(8);
        this.dnj.setText(t.j.add_friend_title);
        this.dnk.setText(t.j.add_friend_content);
        this.dnm.setText(t.j.add_friend_button);
    }

    private void gh(boolean z) {
        if (this.dng.awK().ayK() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.dnl.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new s(this, translateAnimation3));
            this.dni.setVisibility(8);
            this.dni.startAnimation(translateAnimation4);
        } else {
            this.dni.setVisibility(8);
            this.dnl.setVisibility(0);
        }
        this.dnl.setText(t.j.add_friend_wait);
        this.dnm.setText(t.j.add_friend_button);
    }

    private void h(boolean z, String str) {
        String userName = this.dng.awK().getUser().getUserName();
        this.dnl.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.dni.setVisibility(0);
            this.dni.startAnimation(translateAnimation2);
        } else {
            this.dni.setVisibility(0);
            this.dnj.setText(this.dng.getResources().getString(t.j.add_friend_agree_title, userName));
            this.dnk.setText(str);
        }
        this.dnm.setText(t.j.add_friend_agree_button);
    }

    private void gi(boolean z) {
        awP();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.dnh.startAnimation(translateAnimation);
            return;
        }
        this.dnh.setVisibility(8);
    }

    public Button awR() {
        return this.dnm;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
