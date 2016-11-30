package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] duu;
    private TextView cZC;
    private PersonalChatActivity dum;
    private LinearLayout dun;
    private LinearLayout duo;
    private TextView dup;
    private TextView duq;
    private TextView dur;
    private Button dus;
    private View.OnClickListener dut;

    static /* synthetic */ int[] azo() {
        int[] iArr = duu;
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
            duu = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dut = new q(this);
        if (!this.dum.azj() && this.mTool != null) {
            b(this.mTool.ez(6));
            b(this.mTool.ez(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dum = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(r.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.personal_info_btn, talkableActivity);
            this.cZC = (TextView) this.mBtnGroupInfo.findViewById(r.g.group_info_btn_txt);
            this.cZC.setText(string);
        }
        if (!this.dum.azj()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dun = (LinearLayout) ((ViewStub) talkableActivity.findViewById(r.g.stranger_person_add_friend_stub)).inflate();
            this.duo = (LinearLayout) this.dun.findViewById(r.g.add_friend_tip_full);
            this.dup = (TextView) this.dun.findViewById(r.g.add_friend_tip_title);
            this.duq = (TextView) this.dun.findViewById(r.g.add_friend_tip_content);
            this.dur = (TextView) this.dun.findViewById(r.g.add_friend_tip_center);
            this.dus = (Button) this.dun.findViewById(r.g.add_friend_tip_button);
            this.dus.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dun.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cZC != null) {
            at.c(this.cZC, r.d.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.dut);
        }
    }

    private void azl() {
        if (this.mTool != null) {
            this.mTool.CX();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (azo()[cardStatus.ordinal()]) {
            case 1:
                azm();
                return;
            case 2:
                gE(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                gF(z);
                return;
            default:
                return;
        }
    }

    private void azm() {
        this.duo.setVisibility(0);
        this.dur.setVisibility(8);
        this.dup.setText(r.j.add_friend_title);
        this.duq.setText(r.j.add_friend_content);
        this.dus.setText(r.j.add_friend_button);
    }

    private void gE(boolean z) {
        if (this.dum.azg().aBf() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.dur.startAnimation(translateAnimation2);
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
            this.duo.setVisibility(8);
            this.duo.startAnimation(translateAnimation4);
        } else {
            this.duo.setVisibility(8);
            this.dur.setVisibility(0);
        }
        this.dur.setText(r.j.add_friend_wait);
        this.dus.setText(r.j.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.dum.azg().getUser().getUserName();
        this.dur.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.duo.setVisibility(0);
            this.duo.startAnimation(translateAnimation2);
        } else {
            this.duo.setVisibility(0);
            this.dup.setText(this.dum.getResources().getString(r.j.add_friend_agree_title, userName));
            this.duq.setText(str);
        }
        this.dus.setText(r.j.add_friend_agree_button);
    }

    private void gF(boolean z) {
        azl();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.dun.startAnimation(translateAnimation);
            return;
        }
        this.dun.setVisibility(8);
    }

    public Button azn() {
        return this.dus;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
