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
    private static /* synthetic */ int[] csw;
    private TextView bYq;
    private PersonalChatActivity cso;
    private LinearLayout csp;
    private LinearLayout csq;
    private TextView csr;
    private TextView css;
    private TextView cst;
    private Button csu;
    private View.OnClickListener csv;

    static /* synthetic */ int[] aiV() {
        int[] iArr = csw;
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
            csw = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.csv = new q(this);
        if (!this.cso.aiQ() && this.mTool != null) {
            b(this.mTool.eA(6));
            b(this.mTool.eA(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.cso = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(t.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.personal_info_btn, talkableActivity);
            this.bYq = (TextView) this.mBtnGroupInfo.findViewById(t.g.group_info_btn_txt);
            this.bYq.setText(string);
        }
        if (!this.cso.aiQ()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.csp = (LinearLayout) ((ViewStub) talkableActivity.findViewById(t.g.stranger_person_add_friend_stub)).inflate();
            this.csq = (LinearLayout) this.csp.findViewById(t.g.add_friend_tip_full);
            this.csr = (TextView) this.csp.findViewById(t.g.add_friend_tip_title);
            this.css = (TextView) this.csp.findViewById(t.g.add_friend_tip_content);
            this.cst = (TextView) this.csp.findViewById(t.g.add_friend_tip_center);
            this.csu = (Button) this.csp.findViewById(t.g.add_friend_tip_button);
            this.csu.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.csp.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.csv);
        }
    }

    private void aiS() {
        if (this.mTool != null) {
            this.mTool.Dq();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (aiV()[cardStatus.ordinal()]) {
            case 1:
                aiT();
                return;
            case 2:
                es(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                et(z);
                return;
            default:
                return;
        }
    }

    private void aiT() {
        this.csq.setVisibility(0);
        this.cst.setVisibility(8);
        this.csr.setText(t.j.add_friend_title);
        this.css.setText(t.j.add_friend_content);
        this.csu.setText(t.j.add_friend_button);
    }

    private void es(boolean z) {
        if (this.cso.aiN().akP() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.cst.startAnimation(translateAnimation2);
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
            this.csq.setVisibility(8);
            this.csq.startAnimation(translateAnimation4);
        } else {
            this.csq.setVisibility(8);
            this.cst.setVisibility(0);
        }
        this.cst.setText(t.j.add_friend_wait);
        this.csu.setText(t.j.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.cso.aiN().getUser().getUserName();
        this.cst.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.csq.setVisibility(0);
            this.csq.startAnimation(translateAnimation2);
        } else {
            this.csq.setVisibility(0);
            this.csr.setText(this.cso.getResources().getString(t.j.add_friend_agree_title, userName));
            this.css.setText(str);
        }
        this.csu.setText(t.j.add_friend_agree_button);
    }

    private void et(boolean z) {
        aiS();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.csp.startAnimation(translateAnimation);
            return;
        }
        this.csp.setVisibility(8);
    }

    public Button aiU() {
        return this.csu;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
