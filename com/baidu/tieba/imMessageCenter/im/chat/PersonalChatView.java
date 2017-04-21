package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] djM;
    private TextView cPa;
    private PersonalChatActivity djE;
    private LinearLayout djF;
    private LinearLayout djG;
    private TextView djH;
    private TextView djI;
    private TextView djJ;
    private Button djK;
    private View.OnClickListener djL;

    static /* synthetic */ int[] avi() {
        int[] iArr = djM;
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
            djM = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.djL = new q(this);
        if (!this.djE.avd() && this.mTool != null) {
            b(this.mTool.ez(6));
            b(this.mTool.ez(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.djE = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(w.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.personal_info_btn, talkableActivity);
            this.cPa = (TextView) this.mBtnGroupInfo.findViewById(w.h.group_info_btn_txt);
            this.cPa.setText(string);
        }
        if (!this.djE.avd()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.djF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(w.h.stranger_person_add_friend_stub)).inflate();
            this.djG = (LinearLayout) this.djF.findViewById(w.h.add_friend_tip_full);
            this.djH = (TextView) this.djF.findViewById(w.h.add_friend_tip_title);
            this.djI = (TextView) this.djF.findViewById(w.h.add_friend_tip_content);
            this.djJ = (TextView) this.djF.findViewById(w.h.add_friend_tip_center);
            this.djK = (Button) this.djF.findViewById(w.h.add_friend_tip_button);
            this.djK.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.djF.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cPa != null) {
            aq.c(this.cPa, w.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.djL);
        }
    }

    private void avf() {
        if (this.mTool != null) {
            this.mTool.Du();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (avi()[cardStatus.ordinal()]) {
            case 1:
                avg();
                return;
            case 2:
                gs(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case 4:
                gt(z);
                return;
            default:
                return;
        }
    }

    private void avg() {
        this.djG.setVisibility(0);
        this.djJ.setVisibility(8);
        this.djH.setText(w.l.add_friend_title);
        this.djI.setText(w.l.add_friend_content);
        this.djK.setText(w.l.add_friend_button);
    }

    private void gs(boolean z) {
        if (this.djE.ava().avX() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.djJ.startAnimation(translateAnimation2);
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
            this.djG.setVisibility(8);
            this.djG.startAnimation(translateAnimation4);
        } else {
            this.djG.setVisibility(8);
            this.djJ.setVisibility(0);
        }
        this.djJ.setText(w.l.add_friend_wait);
        this.djK.setText(w.l.add_friend_button);
    }

    private void h(boolean z, String str) {
        String userName = this.djE.ava().getUser().getUserName();
        this.djJ.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.djG.setVisibility(0);
            this.djG.startAnimation(translateAnimation2);
        } else {
            this.djG.setVisibility(0);
            this.djH.setText(this.djE.getResources().getString(w.l.add_friend_agree_title, userName));
            this.djI.setText(str);
        }
        this.djK.setText(w.l.add_friend_agree_button);
    }

    private void gt(boolean z) {
        avf();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.djF.startAnimation(translateAnimation);
            return;
        }
        this.djF.setVisibility(8);
    }

    public Button avh() {
        return this.djK;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
