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
    private static /* synthetic */ int[] bsg;
    private PersonalChatActivity brZ;
    private LinearLayout bsa;
    private LinearLayout bsb;
    private TextView bsc;
    private TextView bsd;
    private TextView bse;
    private Button bsf;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Vv() {
        int[] iArr = bsg;
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
            bsg = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.brZ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(com.baidu.tieba.t.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.q.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.brZ.Vr()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bsa = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.q.stranger_person_add_friend_stub)).inflate();
            this.bsb = (LinearLayout) this.bsa.findViewById(com.baidu.tieba.q.add_friend_tip_full);
            this.bsc = (TextView) this.bsa.findViewById(com.baidu.tieba.q.add_friend_tip_title);
            this.bsd = (TextView) this.bsa.findViewById(com.baidu.tieba.q.add_friend_tip_content);
            this.bse = (TextView) this.bsa.findViewById(com.baidu.tieba.q.add_friend_tip_center);
            this.bsf = (Button) this.bsa.findViewById(com.baidu.tieba.q.add_friend_tip_button);
            this.bsf.setOnClickListener(talkableActivity);
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
        switch (Vv()[cardStatus.ordinal()]) {
            case 1:
                Vt();
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

    private void Vt() {
        this.bsb.setVisibility(0);
        this.bse.setVisibility(8);
        this.bsc.setText(com.baidu.tieba.t.add_friend_title);
        this.bsd.setText(com.baidu.tieba.t.add_friend_content);
        this.bsf.setText(com.baidu.tieba.t.add_friend_button);
    }

    private void dj(boolean z) {
        if (this.brZ.Vo().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, translateAnimation));
            this.bse.startAnimation(translateAnimation2);
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
            this.bsb.setVisibility(8);
            this.bsb.startAnimation(translateAnimation4);
        } else {
            this.bsb.setVisibility(8);
            this.bse.setVisibility(0);
        }
        this.bse.setText(com.baidu.tieba.t.add_friend_wait);
        this.bsf.setText(com.baidu.tieba.t.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.brZ.Vo().getUser().getUserName();
        this.bse.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new v(this, userName, str, translateAnimation));
            this.bsb.setVisibility(0);
            this.bsb.startAnimation(translateAnimation2);
        } else {
            this.bsb.setVisibility(0);
            this.bsc.setText(this.brZ.getResources().getString(com.baidu.tieba.t.add_friend_agree_title, userName));
            this.bsd.setText(str);
        }
        this.bsf.setText(com.baidu.tieba.t.add_friend_agree_button);
    }

    private void dk(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new w(this));
            this.bsa.startAnimation(translateAnimation);
            return;
        }
        this.bsa.setVisibility(8);
    }

    public Button Vu() {
        return this.bsf;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
