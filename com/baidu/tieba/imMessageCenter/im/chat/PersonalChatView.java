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
    private static /* synthetic */ int[] bJS;
    private PersonalChatActivity bJK;
    private LinearLayout bJL;
    private LinearLayout bJM;
    private TextView bJN;
    private TextView bJO;
    private TextView bJP;
    private Button bJQ;
    private View.OnClickListener bJR;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] XJ() {
        int[] iArr = bJS;
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
            bJS = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.bJR = new p(this);
        if (!this.bJK.XE() && this.mTool != null) {
            b(this.mTool.dS(6));
            b(this.mTool.dS(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bJK = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(i.h.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(i.f.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bJK.XE()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bJL = (LinearLayout) ((ViewStub) talkableActivity.findViewById(i.f.stranger_person_add_friend_stub)).inflate();
            this.bJM = (LinearLayout) this.bJL.findViewById(i.f.add_friend_tip_full);
            this.bJN = (TextView) this.bJL.findViewById(i.f.add_friend_tip_title);
            this.bJO = (TextView) this.bJL.findViewById(i.f.add_friend_tip_content);
            this.bJP = (TextView) this.bJL.findViewById(i.f.add_friend_tip_center);
            this.bJQ = (Button) this.bJL.findViewById(i.f.add_friend_tip_button);
            this.bJQ.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.bJR);
        }
    }

    private void XG() {
        if (this.mTool != null) {
            this.mTool.AB();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (XJ()[cardStatus.ordinal()]) {
            case 1:
                XH();
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

    private void XH() {
        this.bJM.setVisibility(0);
        this.bJP.setVisibility(8);
        this.bJN.setText(i.h.add_friend_title);
        this.bJO.setText(i.h.add_friend_content);
        this.bJQ.setText(i.h.add_friend_button);
    }

    private void ds(boolean z) {
        if (this.bJK.XB().ZB() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.bJP.startAnimation(translateAnimation2);
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
            this.bJM.setVisibility(8);
            this.bJM.startAnimation(translateAnimation4);
        } else {
            this.bJM.setVisibility(8);
            this.bJP.setVisibility(0);
        }
        this.bJP.setText(i.h.add_friend_wait);
        this.bJQ.setText(i.h.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.bJK.XB().getUser().getUserName();
        this.bJP.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.bJM.setVisibility(0);
            this.bJM.startAnimation(translateAnimation2);
        } else {
            this.bJM.setVisibility(0);
            this.bJN.setText(this.bJK.getResources().getString(i.h.add_friend_agree_title, userName));
            this.bJO.setText(str);
        }
        this.bJQ.setText(i.h.add_friend_agree_button);
    }

    private void dt(boolean z) {
        XG();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.bJL.startAnimation(translateAnimation);
            return;
        }
        this.bJL.setVisibility(8);
    }

    public Button XI() {
        return this.bJQ;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
