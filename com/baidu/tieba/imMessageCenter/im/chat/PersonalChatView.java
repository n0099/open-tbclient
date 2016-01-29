package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] chR;
    private TextView bNY;
    private PersonalChatActivity chJ;
    private LinearLayout chK;
    private LinearLayout chL;
    private TextView chM;
    private TextView chN;
    private TextView chO;
    private Button chP;
    private View.OnClickListener chQ;

    static /* synthetic */ int[] afB() {
        int[] iArr = chR;
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
            chR = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.chQ = new q(this);
        if (!this.chJ.afw() && this.mTool != null) {
            b(this.mTool.ev(6));
            b(this.mTool.ev(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.chJ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(t.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.personal_info_btn, talkableActivity);
            this.bNY = (TextView) this.mBtnGroupInfo.findViewById(t.g.group_info_btn_txt);
            this.bNY.setText(string);
        }
        if (!this.chJ.afw()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.chK = (LinearLayout) ((ViewStub) talkableActivity.findViewById(t.g.stranger_person_add_friend_stub)).inflate();
            this.chL = (LinearLayout) this.chK.findViewById(t.g.add_friend_tip_full);
            this.chM = (TextView) this.chK.findViewById(t.g.add_friend_tip_title);
            this.chN = (TextView) this.chK.findViewById(t.g.add_friend_tip_content);
            this.chO = (TextView) this.chK.findViewById(t.g.add_friend_tip_center);
            this.chP = (Button) this.chK.findViewById(t.g.add_friend_tip_button);
            this.chP.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.chK.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.r rVar) {
        if (rVar != null && rVar != null && (rVar instanceof View)) {
            ((View) rVar).setOnClickListener(this.chQ);
        }
    }

    private void afy() {
        if (this.mTool != null) {
            this.mTool.CI();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (afB()[cardStatus.ordinal()]) {
            case 1:
                afz();
                return;
            case 2:
                dW(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                dX(z);
                return;
            default:
                return;
        }
    }

    private void afz() {
        this.chL.setVisibility(0);
        this.chO.setVisibility(8);
        this.chM.setText(t.j.add_friend_title);
        this.chN.setText(t.j.add_friend_content);
        this.chP.setText(t.j.add_friend_button);
    }

    private void dW(boolean z) {
        if (this.chJ.aft().ahv() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.chO.startAnimation(translateAnimation2);
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
            this.chL.setVisibility(8);
            this.chL.startAnimation(translateAnimation4);
        } else {
            this.chL.setVisibility(8);
            this.chO.setVisibility(0);
        }
        this.chO.setText(t.j.add_friend_wait);
        this.chP.setText(t.j.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.chJ.aft().getUser().getUserName();
        this.chO.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.chL.setVisibility(0);
            this.chL.startAnimation(translateAnimation2);
        } else {
            this.chL.setVisibility(0);
            this.chM.setText(this.chJ.getResources().getString(t.j.add_friend_agree_title, userName));
            this.chN.setText(str);
        }
        this.chP.setText(t.j.add_friend_agree_button);
    }

    private void dX(boolean z) {
        afy();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.chK.startAnimation(translateAnimation);
            return;
        }
        this.chK.setVisibility(8);
    }

    public Button afA() {
        return this.chP;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
