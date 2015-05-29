package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] bsf;
    private PersonalChatActivity brY;
    private LinearLayout brZ;
    private LinearLayout bsa;
    private TextView bsb;
    private TextView bsc;
    private TextView bsd;
    private Button bse;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Vu() {
        int[] iArr = bsf;
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
            bsf = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.brY = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.t.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.q.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.brY.Vq()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.brZ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.q.stranger_person_add_friend_stub)).inflate();
            this.bsa = (LinearLayout) this.brZ.findViewById(com.baidu.tieba.q.add_friend_tip_full);
            this.bsb = (TextView) this.brZ.findViewById(com.baidu.tieba.q.add_friend_tip_title);
            this.bsc = (TextView) this.brZ.findViewById(com.baidu.tieba.q.add_friend_tip_content);
            this.bsd = (TextView) this.brZ.findViewById(com.baidu.tieba.q.add_friend_tip_center);
            this.bse = (Button) this.brZ.findViewById(com.baidu.tieba.q.add_friend_tip_button);
            this.bse.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgsendVoice(MsglistActivity msglistActivity) {
        super.initMsgsendVoice(msglistActivity);
        this.mBtnMsgSendSoftkey.setOnClickListener(new p(this));
        this.mBtnMsgSendMore1.setOnClickListener(new q(this));
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgsendText(TalkableActivity talkableActivity) {
        super.initMsgsendText(talkableActivity);
        this.mBtnMsgSendGovoice.setOnClickListener(new r(this));
        this.mBtnMsgSendMore2.setOnClickListener(new s(this));
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (Vu()[cardStatus.ordinal()]) {
            case 1:
                Vs();
                return;
            case 2:
                dj(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                dk(z);
                return;
            default:
                return;
        }
    }

    private void Vs() {
        this.bsa.setVisibility(0);
        this.bsd.setVisibility(8);
        this.bsb.setText(com.baidu.tieba.t.add_friend_title);
        this.bsc.setText(com.baidu.tieba.t.add_friend_content);
        this.bse.setText(com.baidu.tieba.t.add_friend_button);
    }

    private void dj(boolean z) {
        if (this.brY.Vn().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, translateAnimation));
            this.bsd.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new u(this, translateAnimation3));
            this.bsa.setVisibility(8);
            this.bsa.startAnimation(translateAnimation4);
        } else {
            this.bsa.setVisibility(8);
            this.bsd.setVisibility(0);
        }
        this.bsd.setText(com.baidu.tieba.t.add_friend_wait);
        this.bse.setText(com.baidu.tieba.t.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.brY.Vn().getUser().getUserName();
        this.bsd.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new v(this, userName, str, translateAnimation));
            this.bsa.setVisibility(0);
            this.bsa.startAnimation(translateAnimation2);
        } else {
            this.bsa.setVisibility(0);
            this.bsb.setText(this.brY.getResources().getString(com.baidu.tieba.t.add_friend_agree_title, userName));
            this.bsc.setText(str);
        }
        this.bse.setText(com.baidu.tieba.t.add_friend_agree_button);
    }

    private void dk(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new w(this));
            this.brZ.startAnimation(translateAnimation);
            return;
        }
        this.brZ.setVisibility(8);
    }

    public Button Vt() {
        return this.bse;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
