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
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] bpj;
    private PersonalChatActivity bpc;
    private LinearLayout bpd;
    private LinearLayout bpe;
    private TextView bpf;
    private TextView bpg;
    private TextView bph;
    private Button bpi;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] TT() {
        int[] iArr = bpj;
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
            bpj = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bpc = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(y.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bpc.TP()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bpd = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.stranger_person_add_friend_stub)).inflate();
            this.bpe = (LinearLayout) this.bpd.findViewById(com.baidu.tieba.v.add_friend_tip_full);
            this.bpf = (TextView) this.bpd.findViewById(com.baidu.tieba.v.add_friend_tip_title);
            this.bpg = (TextView) this.bpd.findViewById(com.baidu.tieba.v.add_friend_tip_content);
            this.bph = (TextView) this.bpd.findViewById(com.baidu.tieba.v.add_friend_tip_center);
            this.bpi = (Button) this.bpd.findViewById(com.baidu.tieba.v.add_friend_tip_button);
            this.bpi.setOnClickListener(talkableActivity);
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
        switch (TT()[cardStatus.ordinal()]) {
            case 1:
                TR();
                return;
            case 2:
                da(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                db(z);
                return;
            default:
                return;
        }
    }

    private void TR() {
        this.bpe.setVisibility(0);
        this.bph.setVisibility(8);
        this.bpf.setText(y.add_friend_title);
        this.bpg.setText(y.add_friend_content);
        this.bpi.setText(y.add_friend_button);
    }

    private void da(boolean z) {
        if (this.bpc.TM().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, translateAnimation));
            this.bph.startAnimation(translateAnimation2);
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
            this.bpe.setVisibility(8);
            this.bpe.startAnimation(translateAnimation4);
        } else {
            this.bpe.setVisibility(8);
            this.bph.setVisibility(0);
        }
        this.bph.setText(y.add_friend_wait);
        this.bpi.setText(y.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.bpc.TM().getUser().getUserName();
        this.bph.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new v(this, userName, str, translateAnimation));
            this.bpe.setVisibility(0);
            this.bpe.startAnimation(translateAnimation2);
        } else {
            this.bpe.setVisibility(0);
            this.bpf.setText(this.bpc.getResources().getString(y.add_friend_agree_title, userName));
            this.bpg.setText(str);
        }
        this.bpi.setText(y.add_friend_agree_button);
    }

    private void db(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new w(this));
            this.bpd.startAnimation(translateAnimation);
            return;
        }
        this.bpd.setVisibility(8);
    }

    public Button TS() {
        return this.bpi;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
