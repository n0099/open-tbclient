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
    private static /* synthetic */ int[] bFV;
    private PersonalChatActivity bFN;
    private LinearLayout bFO;
    private LinearLayout bFP;
    private TextView bFQ;
    private TextView bFR;
    private TextView bFS;
    private Button bFT;
    private View.OnClickListener bFU;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Xd() {
        int[] iArr = bFV;
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
            bFV = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.bFU = new p(this);
        if (!this.bFN.WY() && this.mTool != null) {
            b(this.mTool.dJ(6));
            b(this.mTool.dJ(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bFN = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(i.C0057i.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(i.f.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bFN.WY()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bFO = (LinearLayout) ((ViewStub) talkableActivity.findViewById(i.f.stranger_person_add_friend_stub)).inflate();
            this.bFP = (LinearLayout) this.bFO.findViewById(i.f.add_friend_tip_full);
            this.bFQ = (TextView) this.bFO.findViewById(i.f.add_friend_tip_title);
            this.bFR = (TextView) this.bFO.findViewById(i.f.add_friend_tip_content);
            this.bFS = (TextView) this.bFO.findViewById(i.f.add_friend_tip_center);
            this.bFT = (Button) this.bFO.findViewById(i.f.add_friend_tip_button);
            this.bFT.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.bFU);
        }
    }

    private void Xa() {
        if (this.mTool != null) {
            this.mTool.AE();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (Xd()[cardStatus.ordinal()]) {
            case 1:
                Xb();
                return;
            case 2:
                dm(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                dn(z);
                return;
            default:
                return;
        }
    }

    private void Xb() {
        this.bFP.setVisibility(0);
        this.bFS.setVisibility(8);
        this.bFQ.setText(i.C0057i.add_friend_title);
        this.bFR.setText(i.C0057i.add_friend_content);
        this.bFT.setText(i.C0057i.add_friend_button);
    }

    private void dm(boolean z) {
        if (this.bFN.WV().getCardStatus() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.bFS.startAnimation(translateAnimation2);
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
            this.bFP.setVisibility(8);
            this.bFP.startAnimation(translateAnimation4);
        } else {
            this.bFP.setVisibility(8);
            this.bFS.setVisibility(0);
        }
        this.bFS.setText(i.C0057i.add_friend_wait);
        this.bFT.setText(i.C0057i.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.bFN.WV().getUser().getUserName();
        this.bFS.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.bFP.setVisibility(0);
            this.bFP.startAnimation(translateAnimation2);
        } else {
            this.bFP.setVisibility(0);
            this.bFQ.setText(this.bFN.getResources().getString(i.C0057i.add_friend_agree_title, userName));
            this.bFR.setText(str);
        }
        this.bFT.setText(i.C0057i.add_friend_agree_button);
    }

    private void dn(boolean z) {
        Xa();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.bFO.startAnimation(translateAnimation);
            return;
        }
        this.bFO.setVisibility(8);
    }

    public Button Xc() {
        return this.bFT;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
