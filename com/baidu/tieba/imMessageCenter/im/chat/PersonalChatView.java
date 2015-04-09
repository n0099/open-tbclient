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
    private static /* synthetic */ int[] bpz;
    private PersonalChatActivity bps;
    private LinearLayout bpt;
    private LinearLayout bpu;
    private TextView bpv;
    private TextView bpw;
    private TextView bpx;
    private Button bpy;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Ug() {
        int[] iArr = bpz;
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
            bpz = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bps = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(y.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bps.Uc()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bpt = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.stranger_person_add_friend_stub)).inflate();
            this.bpu = (LinearLayout) this.bpt.findViewById(com.baidu.tieba.v.add_friend_tip_full);
            this.bpv = (TextView) this.bpt.findViewById(com.baidu.tieba.v.add_friend_tip_title);
            this.bpw = (TextView) this.bpt.findViewById(com.baidu.tieba.v.add_friend_tip_content);
            this.bpx = (TextView) this.bpt.findViewById(com.baidu.tieba.v.add_friend_tip_center);
            this.bpy = (Button) this.bpt.findViewById(com.baidu.tieba.v.add_friend_tip_button);
            this.bpy.setOnClickListener(talkableActivity);
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
        switch (Ug()[cardStatus.ordinal()]) {
            case 1:
                Ue();
                return;
            case 2:
                cY(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                cZ(z);
                return;
            default:
                return;
        }
    }

    private void Ue() {
        this.bpu.setVisibility(0);
        this.bpx.setVisibility(8);
        this.bpv.setText(y.add_friend_title);
        this.bpw.setText(y.add_friend_content);
        this.bpy.setText(y.add_friend_button);
    }

    private void cY(boolean z) {
        if (this.bps.TZ().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, translateAnimation));
            this.bpx.startAnimation(translateAnimation2);
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
            this.bpu.setVisibility(8);
            this.bpu.startAnimation(translateAnimation4);
        } else {
            this.bpu.setVisibility(8);
            this.bpx.setVisibility(0);
        }
        this.bpx.setText(y.add_friend_wait);
        this.bpy.setText(y.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.bps.TZ().getUser().getUserName();
        this.bpx.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new v(this, userName, str, translateAnimation));
            this.bpu.setVisibility(0);
            this.bpu.startAnimation(translateAnimation2);
        } else {
            this.bpu.setVisibility(0);
            this.bpv.setText(this.bps.getResources().getString(y.add_friend_agree_title, userName));
            this.bpw.setText(str);
        }
        this.bpy.setText(y.add_friend_agree_button);
    }

    private void cZ(boolean z) {
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new w(this));
            this.bpt.startAnimation(translateAnimation);
            return;
        }
        this.bpt.setVisibility(8);
    }

    public Button Uf() {
        return this.bpy;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
