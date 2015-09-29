package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] bJH;
    private LinearLayout bJA;
    private LinearLayout bJB;
    private TextView bJC;
    private TextView bJD;
    private TextView bJE;
    private Button bJF;
    private View.OnClickListener bJG;
    private PersonalChatActivity bJz;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] XN() {
        int[] iArr = bJH;
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
            bJH = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.bJG = new p(this);
        if (!this.bJz.XI() && this.mTool != null) {
            b(this.mTool.dS(6));
            b(this.mTool.dS(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bJz = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(i.h.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(i.f.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bJz.XI()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bJA = (LinearLayout) ((ViewStub) talkableActivity.findViewById(i.f.stranger_person_add_friend_stub)).inflate();
            this.bJB = (LinearLayout) this.bJA.findViewById(i.f.add_friend_tip_full);
            this.bJC = (TextView) this.bJA.findViewById(i.f.add_friend_tip_title);
            this.bJD = (TextView) this.bJA.findViewById(i.f.add_friend_tip_content);
            this.bJE = (TextView) this.bJA.findViewById(i.f.add_friend_tip_center);
            this.bJF = (Button) this.bJA.findViewById(i.f.add_friend_tip_button);
            this.bJF.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.bJG);
        }
    }

    private void XK() {
        if (this.mTool != null) {
            this.mTool.AE();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (XN()[cardStatus.ordinal()]) {
            case 1:
                XL();
                return;
            case 2:
                ds(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                dt(z);
                return;
            default:
                return;
        }
    }

    private void XL() {
        this.bJB.setVisibility(0);
        this.bJE.setVisibility(8);
        this.bJC.setText(i.h.add_friend_title);
        this.bJD.setText(i.h.add_friend_content);
        this.bJF.setText(i.h.add_friend_button);
    }

    private void ds(boolean z) {
        if (this.bJz.XF().ZF() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.bJE.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new r(this, translateAnimation3));
            this.bJB.setVisibility(8);
            this.bJB.startAnimation(translateAnimation4);
        } else {
            this.bJB.setVisibility(8);
            this.bJE.setVisibility(0);
        }
        this.bJE.setText(i.h.add_friend_wait);
        this.bJF.setText(i.h.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.bJz.XF().getUser().getUserName();
        this.bJE.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.bJB.setVisibility(0);
            this.bJB.startAnimation(translateAnimation2);
        } else {
            this.bJB.setVisibility(0);
            this.bJC.setText(this.bJz.getResources().getString(i.h.add_friend_agree_title, userName));
            this.bJD.setText(str);
        }
        this.bJF.setText(i.h.add_friend_agree_button);
    }

    private void dt(boolean z) {
        XK();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.bJA.startAnimation(translateAnimation);
            return;
        }
        this.bJA.setVisibility(8);
    }

    public Button XM() {
        return this.bJF;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
