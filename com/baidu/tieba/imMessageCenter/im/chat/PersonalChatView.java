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
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] bGC;
    private Button bGA;
    private View.OnClickListener bGB;
    private PersonalChatActivity bGu;
    private LinearLayout bGv;
    private LinearLayout bGw;
    private TextView bGx;
    private TextView bGy;
    private TextView bGz;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Xf() {
        int[] iArr = bGC;
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
            bGC = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.bGB = new p(this);
        if (!this.bGu.Xa() && this.mTool != null) {
            b(this.mTool.dR(6));
            b(this.mTool.dR(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bGu = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(i.h.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(i.f.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bGu.Xa()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bGv = (LinearLayout) ((ViewStub) talkableActivity.findViewById(i.f.stranger_person_add_friend_stub)).inflate();
            this.bGw = (LinearLayout) this.bGv.findViewById(i.f.add_friend_tip_full);
            this.bGx = (TextView) this.bGv.findViewById(i.f.add_friend_tip_title);
            this.bGy = (TextView) this.bGv.findViewById(i.f.add_friend_tip_content);
            this.bGz = (TextView) this.bGv.findViewById(i.f.add_friend_tip_center);
            this.bGA = (Button) this.bGv.findViewById(i.f.add_friend_tip_button);
            this.bGA.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.bGB);
        }
    }

    private void Xc() {
        if (this.mTool != null) {
            this.mTool.AR();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (Xf()[cardStatus.ordinal()]) {
            case 1:
                Xd();
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

    private void Xd() {
        this.bGw.setVisibility(0);
        this.bGz.setVisibility(8);
        this.bGx.setText(i.h.add_friend_title);
        this.bGy.setText(i.h.add_friend_content);
        this.bGA.setText(i.h.add_friend_button);
    }

    private void ds(boolean z) {
        if (this.bGu.WX().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.bGz.startAnimation(translateAnimation2);
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
            this.bGw.setVisibility(8);
            this.bGw.startAnimation(translateAnimation4);
        } else {
            this.bGw.setVisibility(8);
            this.bGz.setVisibility(0);
        }
        this.bGz.setText(i.h.add_friend_wait);
        this.bGA.setText(i.h.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.bGu.WX().getUser().getUserName();
        this.bGz.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.bGw.setVisibility(0);
            this.bGw.startAnimation(translateAnimation2);
        } else {
            this.bGw.setVisibility(0);
            this.bGx.setText(this.bGu.getResources().getString(i.h.add_friend_agree_title, userName));
            this.bGy.setText(str);
        }
        this.bGA.setText(i.h.add_friend_agree_button);
    }

    private void dt(boolean z) {
        Xc();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.bGv.startAnimation(translateAnimation);
            return;
        }
        this.bGv.setVisibility(8);
    }

    public Button Xe() {
        return this.bGA;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
