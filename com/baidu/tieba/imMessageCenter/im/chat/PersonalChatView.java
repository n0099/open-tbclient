package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] cYJ;
    private TextView cEf;
    private PersonalChatActivity cYB;
    private LinearLayout cYC;
    private LinearLayout cYD;
    private TextView cYE;
    private TextView cYF;
    private TextView cYG;
    private Button cYH;
    private View.OnClickListener cYI;

    static /* synthetic */ int[] ars() {
        int[] iArr = cYJ;
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
            cYJ = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.cYI = new q(this);
        if (!this.cYB.arn() && this.mTool != null) {
            b(this.mTool.ej(6));
            b(this.mTool.ej(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.cYB = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(u.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.personal_info_btn, talkableActivity);
            this.cEf = (TextView) this.mBtnGroupInfo.findViewById(u.g.group_info_btn_txt);
            this.cEf.setText(string);
        }
        if (!this.cYB.arn()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.cYC = (LinearLayout) ((ViewStub) talkableActivity.findViewById(u.g.stranger_person_add_friend_stub)).inflate();
            this.cYD = (LinearLayout) this.cYC.findViewById(u.g.add_friend_tip_full);
            this.cYE = (TextView) this.cYC.findViewById(u.g.add_friend_tip_title);
            this.cYF = (TextView) this.cYC.findViewById(u.g.add_friend_tip_content);
            this.cYG = (TextView) this.cYC.findViewById(u.g.add_friend_tip_center);
            this.cYH = (Button) this.cYC.findViewById(u.g.add_friend_tip_button);
            this.cYH.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.cYC.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cEf != null) {
            av.c(this.cEf, u.d.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.cYI);
        }
    }

    private void arp() {
        if (this.mTool != null) {
            this.mTool.Bu();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (ars()[cardStatus.ordinal()]) {
            case 1:
                arq();
                return;
            case 2:
                fI(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                fJ(z);
                return;
            default:
                return;
        }
    }

    private void arq() {
        this.cYD.setVisibility(0);
        this.cYG.setVisibility(8);
        this.cYE.setText(u.j.add_friend_title);
        this.cYF.setText(u.j.add_friend_content);
        this.cYH.setText(u.j.add_friend_button);
    }

    private void fI(boolean z) {
        if (this.cYB.ark().atk() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.cYG.startAnimation(translateAnimation2);
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
            this.cYD.setVisibility(8);
            this.cYD.startAnimation(translateAnimation4);
        } else {
            this.cYD.setVisibility(8);
            this.cYG.setVisibility(0);
        }
        this.cYG.setText(u.j.add_friend_wait);
        this.cYH.setText(u.j.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.cYB.ark().getUser().getUserName();
        this.cYG.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.cYD.setVisibility(0);
            this.cYD.startAnimation(translateAnimation2);
        } else {
            this.cYD.setVisibility(0);
            this.cYE.setText(this.cYB.getResources().getString(u.j.add_friend_agree_title, userName));
            this.cYF.setText(str);
        }
        this.cYH.setText(u.j.add_friend_agree_button);
    }

    private void fJ(boolean z) {
        arp();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.cYC.startAnimation(translateAnimation);
            return;
        }
        this.cYC.setVisibility(8);
    }

    public Button arr() {
        return this.cYH;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
